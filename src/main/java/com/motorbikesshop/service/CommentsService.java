package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.CommentCreationDto;
import com.motorbikesshop.model.entity.Comments;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.view.CommentsViewModel;
import com.motorbikesshop.repository.CommentsRepository;
import com.motorbikesshop.repository.DiscussionRepository;
import com.motorbikesshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentsService {

    private final DiscussionRepository discussionRepository;

    private final UserRepository userRepository;

    private final CommentsRepository commentsRepository;

    public CommentsService(DiscussionRepository discussionRepository, UserRepository userRepository, CommentsRepository commentsRepository) {
        this.discussionRepository = discussionRepository;
        this.userRepository = userRepository;
        this.commentsRepository = commentsRepository;
    }

    public CommentsViewModel createComment(CommentCreationDto commentDto) {
        UserEntity author = this.userRepository.findByEmail(commentDto.getAuthorEmail()).get();
        Comments comment = new Comments();
        comment.setCreated(LocalDateTime.now());
        comment.setDiscussions(this.discussionRepository.findById(commentDto.getDiscussionId()).get());
        comment.setAuthor(author);
        comment.setComment(commentDto.getMessage());
        this.commentsRepository.save(comment);
        return new CommentsViewModel(comment.getId() ,author.getFirstName() + " " + author.getLastName(), comment.getComment());
    }
}
