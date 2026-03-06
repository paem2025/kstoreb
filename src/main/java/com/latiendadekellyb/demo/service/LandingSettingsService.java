package com.latiendadekellyb.demo.service;

import com.latiendadekellyb.demo.api.dto.LandingSettingsRequest;
import com.latiendadekellyb.demo.api.dto.LandingSettingsResponse;
import com.latiendadekellyb.demo.domain.model.LandingSettingsEntity;
import com.latiendadekellyb.demo.domain.repository.LandingSettingsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LandingSettingsService {

    private static final String MAIN_SLUG = "main";

    private final LandingSettingsRepository landingSettingsRepository;

    public LandingSettingsService(LandingSettingsRepository landingSettingsRepository) {
        this.landingSettingsRepository = landingSettingsRepository;
    }

    @Transactional(readOnly = true)
    public LandingSettingsResponse getMain() {
        return toResponse(getOrCreateMainEntity());
    }

    @Transactional
    public LandingSettingsResponse updateMain(LandingSettingsRequest request) {
        LandingSettingsEntity entity = getOrCreateMainEntity();
        applyRequest(entity, request);
        return toResponse(landingSettingsRepository.save(entity));
    }

    private LandingSettingsEntity getOrCreateMainEntity() {
        return landingSettingsRepository.findBySlug(MAIN_SLUG)
            .orElseGet(() -> {
                LandingSettingsEntity entity = new LandingSettingsEntity();
                entity.setSlug(MAIN_SLUG);
                return landingSettingsRepository.save(entity);
            });
    }

    private void applyRequest(LandingSettingsEntity entity, LandingSettingsRequest request) {
        if (request.brandName() != null) {
            entity.setBrandName(request.brandName().trim());
        }
        if (request.logoUrl() != null) {
            entity.setLogoUrl(request.logoUrl().trim());
        }
        if (request.navCatalogLabel() != null) {
            entity.setNavCatalogLabel(request.navCatalogLabel().trim());
        }
        if (request.navCategoriesLabel() != null) {
            entity.setNavCategoriesLabel(request.navCategoriesLabel().trim());
        }
        if (request.navContactLabel() != null) {
            entity.setNavContactLabel(request.navContactLabel().trim());
        }
        if (request.heroBadge() != null) {
            entity.setHeroBadge(request.heroBadge().trim());
        }
        if (request.heroTitle() != null) {
            entity.setHeroTitle(request.heroTitle().trim());
        }
        if (request.heroTitleHighlight() != null) {
            entity.setHeroTitleHighlight(request.heroTitleHighlight().trim());
        }
        if (request.heroDescription() != null) {
            entity.setHeroDescription(request.heroDescription().trim());
        }
        if (request.heroPrimaryCtaLabel() != null) {
            entity.setHeroPrimaryCtaLabel(request.heroPrimaryCtaLabel().trim());
        }
        if (request.heroSecondaryCtaLabel() != null) {
            entity.setHeroSecondaryCtaLabel(request.heroSecondaryCtaLabel().trim());
        }
        if (request.catalogTitle() != null) {
            entity.setCatalogTitle(request.catalogTitle().trim());
        }
        if (request.catalogDescription() != null) {
            entity.setCatalogDescription(request.catalogDescription().trim());
        }
        if (request.footerDescription() != null) {
            entity.setFooterDescription(request.footerDescription().trim());
        }
        if (request.footerContactText() != null) {
            entity.setFooterContactText(request.footerContactText().trim());
        }
        if (request.whatsappButtonLabel() != null) {
            entity.setWhatsappButtonLabel(request.whatsappButtonLabel().trim());
        }
        if (request.whatsappNumber() != null) {
            entity.setWhatsappNumber(request.whatsappNumber().trim());
        }
        if (request.whatsappDefaultMessage() != null) {
            entity.setWhatsappDefaultMessage(request.whatsappDefaultMessage().trim());
        }
        if (request.productInquiryTemplate() != null) {
            entity.setProductInquiryTemplate(request.productInquiryTemplate().trim());
        }
        if (request.copyrightText() != null) {
            entity.setCopyrightText(request.copyrightText().trim());
        }
    }

    private LandingSettingsResponse toResponse(LandingSettingsEntity entity) {
        return new LandingSettingsResponse(
            entity.getBrandName(),
            entity.getLogoUrl(),
            entity.getNavCatalogLabel(),
            entity.getNavCategoriesLabel(),
            entity.getNavContactLabel(),
            entity.getHeroBadge(),
            entity.getHeroTitle(),
            entity.getHeroTitleHighlight(),
            entity.getHeroDescription(),
            entity.getHeroPrimaryCtaLabel(),
            entity.getHeroSecondaryCtaLabel(),
            entity.getCatalogTitle(),
            entity.getCatalogDescription(),
            entity.getFooterDescription(),
            entity.getFooterContactText(),
            entity.getWhatsappButtonLabel(),
            entity.getWhatsappNumber(),
            entity.getWhatsappDefaultMessage(),
            entity.getProductInquiryTemplate(),
            entity.getCopyrightText(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
