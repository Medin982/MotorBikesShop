package com.motorbikesshop.web;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.dtos.EmailRequestDTO;
import com.motorbikesshop.model.dtos.SearchAnnouncementDTO;
import com.motorbikesshop.model.view.AnnouncementDetailsViewModel;
import com.motorbikesshop.model.view.UserViewModel;
import com.motorbikesshop.service.AnnouncementService;
import com.motorbikesshop.service.BrandService;
import com.motorbikesshop.service.EmailService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public RedirectView announcement(@Valid AddAnnouncementDTO announcementDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes,
                                     Principal principal) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("announcementDTO", announcementDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.announcementDTO", bindingResult);
            return new RedirectView("/announcement/add", true);
        }
        this.announcementService.createAnnouncement(announcementDTO, principal);
        return new RedirectView("/", true);
    }

    @GetMapping("/search")
    public String searchQuery(Model model,
                              @Valid SearchAnnouncementDTO searchAnnouncementDTO,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("searchAnnouncement", searchAnnouncementDTO);
            model.addAttribute(
                    "org.springframework.validation.BindingResult.searchAnnouncement",
                    bindingResult);
            return "search-announcement";
        }

        if (!model.containsAttribute("searchAnnouncement")) {
            model.addAttribute("searchAnnouncement", new SearchAnnouncementDTO());
        }

        if (!searchAnnouncementDTO.isEmpty()) {
            model.addAttribute("present", this.announcementService.searchAnnouncements(searchAnnouncementDTO));
        }
        model.addAttribute("brands", this.brandService.getAll());
        return "search-announcement";
    }

    @GetMapping("/all")
    public String present(Model model,
                          @PageableDefault(size = 15)
                          Pageable pageable) {
        model.addAttribute("allAnnouncement", this.announcementService.getAll(pageable));
        return "all-announcement";
    }

    @PreAuthorize("@announcementService.isOwner(#principal.name, #id)")
    @DeleteMapping("/delete/{id}")
    public String deleteAnnouncement(@PathVariable String id, Principal principal) {
        this.announcementService.deleteAnnouncementById(id);
        return "redirect:/announcement/all";
    }

    @GetMapping("/details/{id}")
    public String announcementDetails(@PathVariable String id,
                                      Model model, Principal principal) {
        if (!model.containsAttribute("emailRequestDTO")) {
            model.addAttribute("emailRequestDTO", new EmailRequestDTO());
        }

        model.addAttribute("detailsViewModel", this.announcementService.getAnnouncement(id));
        model.addAttribute("user", principal.getName());
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
