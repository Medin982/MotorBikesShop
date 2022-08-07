package com.motorbikesshop.seeder;

import com.motorbikesshop.model.entity.PartSubCategory;
import com.motorbikesshop.model.enums.*;
import com.motorbikesshop.repository.PartCategoryRepository;
import com.motorbikesshop.repository.PartSubCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class PartSubCategorySeeder implements CommandLineRunner {

    private final PartSubCategoryRepository partSubCAtegoryRepository;

    private final PartCategoryRepository partCategoryRepository;

    public PartSubCategorySeeder(PartSubCategoryRepository partSubCAtegoryRepository, PartCategoryRepository partCategoryRepository) {
        this.partSubCAtegoryRepository = partSubCAtegoryRepository;
        this.partCategoryRepository = partCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partSubCAtegoryRepository.count() <= 0) {
            this.partSubCAtegoryRepository.
                    saveAll(Arrays.stream(EngineSubCategoryType.
                            values()).
                            map(enginePartsType -> {
                                PartSubCategory subCategory = new PartSubCategory(enginePartsType.toString());
                                subCategory.setPartCategory(this.partCategoryRepository.findByName(PartCategoryType.ENGINE).get());
                                return subCategory;
                            }).
                            toList());

            this.partSubCAtegoryRepository.
                    saveAll(Arrays.stream(TyresSubCategoryType.
                                    values()).
                            map(tyresSubCategoryType -> {
                                PartSubCategory subCategory = new PartSubCategory(tyresSubCategoryType.toString());
                                subCategory.setPartCategory(this.partCategoryRepository.findByName(PartCategoryType.TYRES).get());
                                return subCategory;
                            }).
                            toList());

            this.partSubCAtegoryRepository.
                    saveAll(Arrays.stream(SuspensionSubCategoryType.
                                    values()).
                            map(suspensionSubCategoryType -> {
                                PartSubCategory subCategory = new PartSubCategory(suspensionSubCategoryType.toString());
                                subCategory.setPartCategory(this.partCategoryRepository.findByName(PartCategoryType.SUSPENSION).get());
                                return subCategory;
                            }).
                            toList());

            this.partSubCAtegoryRepository.
                    saveAll(Arrays.stream(OilSubCategoryType.
                                    values()).
                            map(oilSubCategoryType -> {
                                PartSubCategory subCategory = new PartSubCategory(oilSubCategoryType.toString());
                                subCategory.setPartCategory(this.partCategoryRepository.findByName(PartCategoryType.OIL).get());
                                return subCategory;
                            }).
                            toList());

            this.partSubCAtegoryRepository.
                    saveAll(Arrays.stream(BrakeSystemSubCategoryType.
                                    values()).
                            map(brakeSystemSubCategoryType -> {
                                PartSubCategory subCategory = new PartSubCategory(brakeSystemSubCategoryType.toString());
                                subCategory.setPartCategory(this.partCategoryRepository.findByName(PartCategoryType.BRAKESYSTEM).get());
                                return subCategory;
                            }).
                            toList());
        }
    }
}
