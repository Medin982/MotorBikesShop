package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.CreateDiscussionDto;
import com.motorbikesshop.model.entity.Discussion;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.enums.UserRoleEnum;
import com.motorbikesshop.model.view.DiscussionViewModel;
import com.motorbikesshop.repository.DiscussionRepository;
import com.motorbikesshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    private final CommentsService commentsService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public DiscussionService(DiscussionRepository discussionRepository, CommentsService commentsService, ModelMapper modelMapper, UserRepository userRepository) {
        this.discussionRepository = discussionRepository;
        this.commentsService = commentsService;
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

    public Page<DiscussionViewModel> getAll(Pageable pageable) {
        return this.discussionRepository.
                findAll(pageable).
                map(disc -> {
                    DiscussionViewModel model = this.modelMapper.map(disc, DiscussionViewModel.class);
                    String dateToString = disc.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    model.setCreated(dateToString);
                    return model;
                });
    }

    public DiscussionViewModel getDiscussion(String id) {
        return this.discussionRepository.
                findById(id).
                map(discussion -> this.modelMapper.map(discussion, DiscussionViewModel.class)).
                orElse(null);
    }

    public void deleteById(String id) {
        Optional<Discussion> discussion = this.discussionRepository.findById(id);
        discussion.get().
                getComments().
                forEach(this.commentsService::deleteComment);
        this.discussionRepository.delete(discussion.get());
    }

    public boolean isCreatorOrAdmin(String email, String id) {
        boolean isCreator = discussionRepository.
                findById(id).
                filter(dis -> dis.getCreator().getEmail().equals(email)).
                isPresent();

        if (isCreator) {
            return true;
        }

        return userRepository.
                findByEmail(email).
                stream().
                anyMatch(u -> u.getRole().getName().equals(UserRoleEnum.ADMIN));

    }
}
