package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.CommentCreationDto;
import com.motorbikesshop.model.entity.Comments;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.view.CommentsViewModel;
import com.motorbikesshop.repository.CommentsRepository;
import com.motorbikesshop.repository.DiscussionRepository;
import com.motorbikesshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService {

    private final DiscussionRepository discussionRepository;

    private final UserRepository userRepository;

    private final CommentsRepository commentsRepository;

    private final ModelMapper modelMapper;

    public CommentsService(DiscussionRepository discussionRepository, UserRepository userRepository,
                           CommentsRepository commentsRepository, ModelMapper modelMapper) {
        this.discussionRepository = discussionRepository;
        this.userRepository = userRepository;
        this.commentsRepository = commentsRepository;
        this.modelMapper = modelMapper;
    }

    public CommentsViewModel createComment(CommentCreationDto commentDto) {
        UserEntity author = this.userRepository.findByEmail(commentDto.getAuthorEmail()).get();
        Comments comment = new Comments();
        comment.setCreated(LocalDateTime.now());
        comment.setDiscussions(this.discussionRepository.findById(commentDto.getDiscussionId()).get());
        comment.setAuthor(author);
        comment.setMessage(commentDto.getMessage());
        this.commentsRepository.save(comment);

        return new CommentsViewModel(comment.getId() ,author.getFirstName() + " " + author.getLastName(),
                comment.getMessage(), localDateTimeToString(comment.getCreated()));
    }

    public List<CommentsViewModel> getAllCommentsForDiscussion(String id) {
        return this.commentsRepository.findAllByDiscussionsId(id).
                stream().
                map(com -> {
                    CommentsViewModel viewModel = this.modelMapper.map(com, CommentsViewModel.class);
                    viewModel.setAuthor(com.getAuthor().getFirstName() + " " + com.getAuthor().getLastName());
                    String dateToString = localDateTimeToString(com.getCreated());
                    viewModel.setCreated(dateToString);
                    return viewModel;
                }).
                collect(Collectors.toList());
    }

    private String localDateTimeToString(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void deleteComment(Comments com) {
        this.commentsRepository.delete(com);
    }
}
