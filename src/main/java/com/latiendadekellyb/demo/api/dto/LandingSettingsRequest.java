package com.latiendadekellyb.demo.api.dto;

public record LandingSettingsRequest(
    String brandName,
    String logoUrl,
    String navCatalogLabel,
    String navCategoriesLabel,
    String navContactLabel,
    String heroBadge,
    String heroTitle,
    String heroTitleHighlight,
    String heroDescription,
    String heroPrimaryCtaLabel,
    String heroSecondaryCtaLabel,
    String catalogTitle,
    String catalogDescription,
    String footerDescription,
    String footerContactText,
    String whatsappButtonLabel,
    String whatsappNumber,
    String whatsappDefaultMessage,
    String productInquiryTemplate,
    String copyrightText
) {
}
