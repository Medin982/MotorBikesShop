package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.service.AnnouncementService;
import com.motorbikesshop.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    private final BrandService brandService;

    public AnnouncementController(AnnouncementService announcementService, BrandService brandService) {
        this.announcementService = announcementService;
        this.brandService = brandService;
    }


    @GetMapping("/announcement")
    public String announcement(Model model) {
        if (!model.containsAttribute("announcementDTO")) {
            model.addAttribute("announcementDTO", new AddAnnouncementDTO());
        }
        model.addAttribute("brands", this.brandService.getAll());
        return "add-announcement";
    }

    @PostMapping("/announcement")
    public String announcement(@Valid AddAnnouncementDTO announcementDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("announcementDTO", announcementDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.announcementDTO", bindingResult);
            return "redirect:announcement";
        }
        this.announcementService.createAnnouncement(announcementDTO);
        return "redirect:/";
    }
}
