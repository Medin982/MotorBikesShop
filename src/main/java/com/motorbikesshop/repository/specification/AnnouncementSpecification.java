package com.motorbikesshop.repository.specification;

import com.motorbikesshop.model.dtos.SearchAnnouncementDTO;
import com.motorbikesshop.model.entity.Announcement;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AnnouncementSpecification implements Specification<Announcement> {

    private final SearchAnnouncementDTO dto;

    public AnnouncementSpecification(SearchAnnouncementDTO searchAnnouncementDTO) {
        this.dto = searchAnnouncementDTO;
    }

    @Override
    public Predicate toPredicate(Root<Announcement> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        if (dto.getModelId() != null && !dto.getModelId().isEmpty()) {
            predicate.getExpressions().add(
                    cb.and(cb.equal(root.join("model").get("id"), dto.getModelId()))
            );
        }

        if (dto.getMinPrice() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("price"), dto.getMinPrice()))
            );
        }

        if (dto.getMaxPrice() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("price"), dto.getMaxPrice()))
            );
        }

        if (dto.getMinMileage() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("mileage"), dto.getMinMileage()))
            );
        }

        if (dto.getMaxMileage() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("mileage"), dto.getMaxMileage()))
            );
        }

        if (dto.getCategory() != null) {
            predicate.getExpressions().add(
                    cb.equal(root.get("category"), dto.getCategory())
            );
        }

        if (dto.getAfter() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("dateOfManufacture"),dto.getAfter()))
            );
        }

        if (dto.getBefore() != null) {
            predicate.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("dateOfManufacture"),dto.getBefore()))
            );
        }
        return predicate;
    }
}
