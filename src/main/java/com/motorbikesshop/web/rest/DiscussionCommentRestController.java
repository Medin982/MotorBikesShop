package com.motorbikesshop.web.rest;

import com.motorbikesshop.model.dtos.CommentCreationDto;
import com.motorbikesshop.model.dtos.CommentMessageDto;
import com.motorbikesshop.model.view.CommentsViewModel;
import com.motorbikesshop.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/discussion")
public class DiscussionCommentRestController {

    private final CommentsService commentsService;

    public DiscussionCommentRestController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<List<CommentsViewModel>> getComments(@PathVariable String id) {
        return ResponseEntity.ok(this.commentsService.getAllCommentsForDiscussion(id));
    }

    @PostMapping(value = "/details/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentsViewModel> createComments(@PathVariable String id,
                                                            Principal principal,
                                                            @RequestBody CommentMessageDto commentDto) {

        CommentCreationDto commentCreationDto = new CommentCreationDto();
        commentCreationDto.setAuthorEmail(principal.getName());
        commentCreationDto.setDiscussionId(id);
        commentCreationDto.setMessage(commentDto.getMessage());

        CommentsViewModel comment = commentsService.createComment(commentCreationDto);

        return ResponseEntity.
                created(URI.create(String.format("/api/%s/comments/%s", id, comment.getId()))).
                body(comment);
    }
}
