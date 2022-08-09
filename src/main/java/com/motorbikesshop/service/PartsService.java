package com.motorbikesshop.service;

import com.motorbikesshop.model.entity.Part;
import com.motorbikesshop.model.view.PartsViewModel;
import com.motorbikesshop.repository.PartsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    private final PartsRepository partsRepository;

    private final ModelMapper modelMapper;

    public PartsService(PartsRepository partsRepository, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PartsViewModel> getAll(Pageable pageable) {

        return this.partsRepository.
                findAll(pageable).
                map(part -> this.modelMapper.map(part, PartsViewModel.class));
    }
}
