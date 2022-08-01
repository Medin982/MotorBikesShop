package com.motorbikesshop.web;

import com.motorbikesshop.service.AnnouncementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final AnnouncementService announcementService;

    public HomeController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("latestAnnouncement", this.announcementService.getLatest(LocalDateTime.now()));
        return "index";
    }
}
