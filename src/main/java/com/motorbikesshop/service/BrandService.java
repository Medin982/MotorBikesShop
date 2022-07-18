package com.motorbikesshop.service;

import com.motorbikesshop.model.view.BrandViewModel;
import com.motorbikesshop.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    public BrandService(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    public List<BrandViewModel> getAll() {
        return this.brandRepository.findAll().
                stream().
                map(brand -> this.modelMapper.map(brand, BrandViewModel.class)).
                collect(Collectors.toList());
    }
}
