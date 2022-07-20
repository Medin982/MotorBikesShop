package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.view.AnnouncementViewModel;
import com.motorbikesshop.service.AnnouncementService;
import com.motorbikesshop.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    private final BrandService brandService;

    public AnnouncementController(AnnouncementService announcementService, BrandService brandService) {
        this.announcementService = announcementService;
        this.brandService = brandService;
    }


    @GetMapping("/add")
    public String announcement(Model model) {
        if (!model.containsAttribute("announcementDTO")) {
            model.addAttribute("announcementDTO", new AddAnnouncementDTO());
        }
        model.addAttribute("brands", this.brandService.getAll());
        return "add-announcement";
    }

    @PostMapping("/add")
    public String announcement(@Valid AddAnnouncementDTO announcementDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Principal principal) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("announcementDTO", announcementDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.announcementDTO", bindingResult);
            return "redirect:add";
        }
        this.announcementService.createAnnouncement(announcementDTO, principal);
        return "redirect:/";
    }

    @GetMapping("/present")
    public String present(Model model) {
        model.addAttribute("allAnnouncement", this.announcementService.getAll());
        return "all-announcement";
    }
}
