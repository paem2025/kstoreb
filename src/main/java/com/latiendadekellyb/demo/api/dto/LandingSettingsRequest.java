package com.latiendadekellyb.demo.api.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LandingSettingsRequest(
    @Size(max = 255, message = "brandName max length is 255")
    String brandName,

    @Size(max = 2000, message = "logoUrl max length is 2000")
    String logoUrl,

    @Size(max = 120, message = "navCatalogLabel max length is 120")
    String navCatalogLabel,

    @Size(max = 120, message = "navCategoriesLabel max length is 120")
    String navCategoriesLabel,

    @Size(max = 120, message = "navContactLabel max length is 120")
    String navContactLabel,

    @Size(max = 255, message = "heroBadge max length is 255")
    String heroBadge,

    @Size(max = 255, message = "heroTitle max length is 255")
    String heroTitle,

    @Size(max = 255, message = "heroTitleHighlight max length is 255")
    String heroTitleHighlight,

    @Size(max = 5000, message = "heroDescription max length is 5000")
    String heroDescription,

    @Size(max = 120, message = "heroPrimaryCtaLabel max length is 120")
    String heroPrimaryCtaLabel,

    @Size(max = 120, message = "heroSecondaryCtaLabel max length is 120")
    String heroSecondaryCtaLabel,

    @Size(max = 255, message = "catalogTitle max length is 255")
    String catalogTitle,

    @Size(max = 5000, message = "catalogDescription max length is 5000")
    String catalogDescription,

    @Size(max = 5000, message = "footerDescription max length is 5000")
    String footerDescription,

    @Size(max = 5000, message = "footerContactText max length is 5000")
    String footerContactText,

    @Size(max = 120, message = "whatsappButtonLabel max length is 120")
    String whatsappButtonLabel,

    @Pattern(regexp = "^\\d{8,40}$", message = "whatsappNumber must contain only digits and be 8-40 chars")
    String whatsappNumber,

    @Size(max = 2000, message = "whatsappDefaultMessage max length is 2000")
    String whatsappDefaultMessage,

    @Size(max = 2000, message = "productInquiryTemplate max length is 2000")
    String productInquiryTemplate,

    @Size(max = 255, message = "copyrightText max length is 255")
    String copyrightText
) {
}
