package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.CreateDiscussionDto;
import com.motorbikesshop.model.entity.Discussion;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.repository.DiscussionRepository;
import com.motorbikesshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    public DiscussionService(DiscussionRepository discussionRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.discussionRepository = discussionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void createDiscussion(CreateDiscussionDto dto, Principal principal) {
        Optional<UserEntity> creator = this.userRepository.findByEmail(principal.getName());
        Discussion discussion = this.modelMapper.map(dto, Discussion.class);
        discussion.setCreator(creator.get());
        discussion.setCreated(LocalDateTime.now());
        this.discussionRepository.save(discussion);
    }
}
