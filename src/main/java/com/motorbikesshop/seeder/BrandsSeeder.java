package com.motorbikesshop.seeder;

import com.motorbikesshop.model.entity.Brand;
import com.motorbikesshop.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BrandsSeeder implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public BrandsSeeder(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       if (brandRepository.count() == 0) {
           List<String> brands = Arrays.asList("KTM", "Beta", "Kawasaki", "Honda", "BMW", "Suzuki", "Aprilia", "Balkan", "Ducati",
                   "GASGAS", "Harley-Davidson", "Husqvarna", "Kymco", "MV Agusta", "Piaggio", "Peugeot", "Simson");
           brands.forEach(e -> this.brandRepository.save(new Brand(e)));
       }
    }
}
