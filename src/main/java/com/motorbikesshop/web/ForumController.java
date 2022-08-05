package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.CreateDiscussionDto;
import com.motorbikesshop.service.DiscussionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private final DiscussionService discussionService;

    public ForumController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    @GetMapping("/discussion")
    public String forum(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("allDiscussion", this.discussionService.getAll(pageable));
        return "forum";
    }

    @GetMapping("/discussion/create")
    public String createDiscussion(Model model) {
        if (!model.containsAttribute("discussion")) {
            model.addAttribute("discussion", new CreateDiscussionDto());
        }
        return "create-discussion";
    }

    @PostMapping("/discussion/create")
    public String createDiscussion(@Valid CreateDiscussionDto createDiscussionDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("discussion", createDiscussionDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.discussion", bindingResult);
            return "redirect:/forum/discussion/create";
        }
        this.discussionService.createDiscussion(createDiscussionDto, principal);
        return "redirect:/forum/discussion";
    }

    @GetMapping("/discussion/details/{id}")
    public String discussionDetails(@PathVariable String id, Model model) {
        model.addAttribute("discussion", this.discussionService.getDiscussion(id));
        return "discussion-details";
    }
}
