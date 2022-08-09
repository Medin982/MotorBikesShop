package com.motorbikesshop.web;

import com.motorbikesshop.service.PartsService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts")
public class PartsController {

    private final PartsService partsService;

    public PartsController(PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping("/present")
    public String present(Model model,
                          @PageableDefault(size = 10)
                          Pageable pageable) {
        model.addAttribute("parts", this.partsService.getAll(pageable));
        return "parts-present";
    }
}
