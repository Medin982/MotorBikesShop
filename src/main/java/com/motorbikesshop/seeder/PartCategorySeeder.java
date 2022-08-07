package com.motorbikesshop.seeder;

import com.motorbikesshop.model.entity.PartCategory;
import com.motorbikesshop.model.enums.PartCategoryType;
import com.motorbikesshop.repository.PartCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PartCategorySeeder implements CommandLineRunner {

    private final PartCategoryRepository partCategoryRepository;

    public PartCategorySeeder(PartCategoryRepository partCategoryRepository) {
        this.partCategoryRepository = partCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partCategoryRepository.count() <= 0) {
            this.partCategoryRepository.
                    saveAll(Arrays.stream(PartCategoryType.
                                    values()).
                            map(PartCategory::new).
                            toList());
        }
    }
}
