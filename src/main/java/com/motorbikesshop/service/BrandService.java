package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.BrandDTO;
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

    public List<BrandDTO> getAll() {
        return this.brandRepository.findAll().
                stream().
                map(brand -> this.modelMapper.map(brand, BrandDTO.class)).
                collect(Collectors.toList());
    }
}
