package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.dtos.EmailRequestDTO;
import com.motorbikesshop.model.view.AnnouncementDetailsViewModel;
import com.motorbikesshop.model.view.UserViewModel;
import com.motorbikesshop.service.AnnouncementService;
import com.motorbikesshop.service.BrandService;
import com.motorbikesshop.service.EmailService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import java.util.List;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final BrandService brandService;
    private final EmailService emailService;

    public AnnouncementController(AnnouncementService announcementService, BrandService brandService, EmailService emailService) {
        this.announcementService = announcementService;
        this.brandService = brandService;
        this.emailService = emailService;
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
    public RedirectView announcement(@RequestParam("images") List<MultipartFile> multipartFile,
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
    public String present(Model model,
                          @PageableDefault(size = 15)
                          Pageable pageable) {
        model.addAttribute("allAnnouncement", this.announcementService.getAll(pageable));
        return "all-announcement";
    }

    @GetMapping("/details/{id}")
    public String announcementDetails(@PathVariable String id,
                                      Model model) {
        if (!model.containsAttribute("emailRequestDTO")) {
            model.addAttribute("emailRequestDTO", new EmailRequestDTO());
        }
        model.addAttribute("detailsViewModel" ,this.announcementService.getAnnouncement(id));
        return "announcement-details";
    }

    @PostMapping("/details/{id}")
    public String emailSendRequest(@Valid EmailRequestDTO emailRequestDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("emailRequestDTO", emailRequestDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.emailRequestDTO", bindingResult);
            return "redirect:/announcement/details/{id}";
        }
        AnnouncementDetailsViewModel announcement = this.announcementService.getAnnouncement(id);
        UserViewModel seller = announcement.getSeller();
        this.emailService.sendRequestEmailToSeller(seller, emailRequestDTO);
        return "redirect:/announcement/details/{id}";
    }
}
