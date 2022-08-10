package com.motorbikesshop.web;

import com.motorbikesshop.model.enums.PartCategoryType;
import com.motorbikesshop.model.exeption.PartsNotFoundOrNullException;
import com.motorbikesshop.model.view.PartsViewModel;
import com.motorbikesshop.service.PartsService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/{category}")
    public String partsByCategory(@PathVariable String category,
                                  Model model) {
        List<PartsViewModel> partsByCategory = switch (category) {
            case "Engine" -> this.partsService.findByCategory(PartCategoryType.ENGINE);
            case "BrakeSystem" -> this.partsService.findByCategory(PartCategoryType.BRAKESYSTEM);
            case "Tyres" -> this.partsService.findByCategory(PartCategoryType.TYRES);
            case "Suspension" -> this.partsService.findByCategory(PartCategoryType.SUSPENSION);
            case "Oil" -> this.partsService.findByCategory(PartCategoryType.OIL);
            case "Accessories" -> this.partsService.findByCategory(PartCategoryType.ACCESSORIES);
            case "Plastics" -> this.partsService.findByCategory(PartCategoryType.PLASTICS);
            default -> throw new PartsNotFoundOrNullException();
        };
            model.addAttribute("parts", partsByCategory);

        return "parts-present";
    }

    @ExceptionHandler({PartsNotFoundOrNullException.class})
    public ModelAndView notFoundOrNull() {
        return new ModelAndView("part-not-found-or-null");
    }

}
