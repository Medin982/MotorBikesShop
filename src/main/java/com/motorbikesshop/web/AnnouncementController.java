package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.service.AnnouncementService;
import com.motorbikesshop.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;
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
    public RedirectView announcement(@RequestParam("images") MultipartFile multipartFile,
                               @Valid AddAnnouncementDTO announcementDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Principal principal) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("announcementDTO", announcementDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.announcementDTO", bindingResult);
            return new RedirectView("/announcement/add", true);
        }
        this.announcementService.createAnnouncement(announcementDTO, principal, multipartFile);
        return new RedirectView("/", true);
    }

    @GetMapping("/present")
    public String present(Model model) {
        model.addAttribute("allAnnouncement", this.announcementService.getAll());
        return "all-announcement";
    }
}
