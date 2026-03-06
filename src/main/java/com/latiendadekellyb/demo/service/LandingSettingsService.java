package com.latiendadekellyb.demo.service;

import com.latiendadekellyb.demo.api.dto.LandingSettingsRequest;
import com.latiendadekellyb.demo.api.dto.LandingSettingsResponse;
import com.latiendadekellyb.demo.domain.model.LandingSettingsEntity;
import com.latiendadekellyb.demo.domain.repository.LandingSettingsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class LandingSettingsService {

    private static final String MAIN_SLUG = "main";

    private final LandingSettingsRepository landingSettingsRepository;

    public LandingSettingsService(LandingSettingsRepository landingSettingsRepository) {
        this.landingSettingsRepository = landingSettingsRepository;
    }

    @Transactional(readOnly = true)
    public LandingSettingsResponse getMain() {
        return landingSettingsRepository.findBySlug(MAIN_SLUG)
            .map(this::toResponse)
            .orElseGet(() -> toResponse(newMainEntity()));
    }

    @Transactional
    public LandingSettingsResponse updateMain(LandingSettingsRequest request) {
        LandingSettingsEntity entity = landingSettingsRepository.findBySlug(MAIN_SLUG)
            .orElseGet(this::newMainEntity);
        applyRequest(entity, request);
        return toResponse(landingSettingsRepository.save(entity));
    }

    private LandingSettingsEntity newMainEntity() {
        LandingSettingsEntity entity = new LandingSettingsEntity();
        entity.setSlug(MAIN_SLUG);
        return entity;
    }

    private void applyRequest(LandingSettingsEntity entity, LandingSettingsRequest request) {
        String brandName = normalizeIfPresent(request.brandName(), "brandName");
        if (brandName != null) {
            entity.setBrandName(brandName);
        }
        String logoUrl = normalizeIfPresent(request.logoUrl(), "logoUrl");
        if (logoUrl != null) {
            entity.setLogoUrl(logoUrl);
        }
        String navCatalogLabel = normalizeIfPresent(request.navCatalogLabel(), "navCatalogLabel");
        if (navCatalogLabel != null) {
            entity.setNavCatalogLabel(navCatalogLabel);
        }
        String navCategoriesLabel = normalizeIfPresent(request.navCategoriesLabel(), "navCategoriesLabel");
        if (navCategoriesLabel != null) {
            entity.setNavCategoriesLabel(navCategoriesLabel);
        }
        String navContactLabel = normalizeIfPresent(request.navContactLabel(), "navContactLabel");
        if (navContactLabel != null) {
            entity.setNavContactLabel(navContactLabel);
        }
        String heroBadge = normalizeIfPresent(request.heroBadge(), "heroBadge");
        if (heroBadge != null) {
            entity.setHeroBadge(heroBadge);
        }
        String heroTitle = normalizeIfPresent(request.heroTitle(), "heroTitle");
        if (heroTitle != null) {
            entity.setHeroTitle(heroTitle);
        }
        String heroTitleHighlight = normalizeIfPresent(request.heroTitleHighlight(), "heroTitleHighlight");
        if (heroTitleHighlight != null) {
            entity.setHeroTitleHighlight(heroTitleHighlight);
        }
        String heroDescription = normalizeIfPresent(request.heroDescription(), "heroDescription");
        if (heroDescription != null) {
            entity.setHeroDescription(heroDescription);
        }
        String heroPrimaryCtaLabel = normalizeIfPresent(request.heroPrimaryCtaLabel(), "heroPrimaryCtaLabel");
        if (heroPrimaryCtaLabel != null) {
            entity.setHeroPrimaryCtaLabel(heroPrimaryCtaLabel);
        }
        String heroSecondaryCtaLabel = normalizeIfPresent(request.heroSecondaryCtaLabel(), "heroSecondaryCtaLabel");
        if (heroSecondaryCtaLabel != null) {
            entity.setHeroSecondaryCtaLabel(heroSecondaryCtaLabel);
        }
        String catalogTitle = normalizeIfPresent(request.catalogTitle(), "catalogTitle");
        if (catalogTitle != null) {
            entity.setCatalogTitle(catalogTitle);
        }
        String catalogDescription = normalizeIfPresent(request.catalogDescription(), "catalogDescription");
        if (catalogDescription != null) {
            entity.setCatalogDescription(catalogDescription);
        }
        String footerDescription = normalizeIfPresent(request.footerDescription(), "footerDescription");
        if (footerDescription != null) {
            entity.setFooterDescription(footerDescription);
        }
        String footerContactText = normalizeIfPresent(request.footerContactText(), "footerContactText");
        if (footerContactText != null) {
            entity.setFooterContactText(footerContactText);
        }
        String whatsappButtonLabel = normalizeIfPresent(request.whatsappButtonLabel(), "whatsappButtonLabel");
        if (whatsappButtonLabel != null) {
            entity.setWhatsappButtonLabel(whatsappButtonLabel);
        }
        String whatsappNumber = normalizeIfPresent(request.whatsappNumber(), "whatsappNumber");
        if (whatsappNumber != null) {
            entity.setWhatsappNumber(whatsappNumber);
        }
        String whatsappDefaultMessage = normalizeIfPresent(request.whatsappDefaultMessage(), "whatsappDefaultMessage");
        if (whatsappDefaultMessage != null) {
            entity.setWhatsappDefaultMessage(whatsappDefaultMessage);
        }
        String productInquiryTemplate = normalizeIfPresent(request.productInquiryTemplate(), "productInquiryTemplate");
        if (productInquiryTemplate != null) {
            entity.setProductInquiryTemplate(productInquiryTemplate);
        }
        String copyrightText = normalizeIfPresent(request.copyrightText(), "copyrightText");
        if (copyrightText != null) {
            entity.setCopyrightText(copyrightText);
        }
    }

    private String normalizeIfPresent(String value, String fieldName) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new ResponseStatusException(BAD_REQUEST, fieldName + " cannot be blank");
        }
        return normalized;
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
