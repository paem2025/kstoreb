package com.latiendadekellyb.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "landing_settings")
public class LandingSettingsEntity extends AuditableEntity {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "slug", nullable = false, unique = true, length = 80)
    private String slug = "main";

    @Column(name = "brand_name", nullable = false, length = 255)
    private String brandName = "Kelly Store";

    @Lob
    @Column(name = "logo_url", nullable = false, columnDefinition = "TEXT")
    private String logoUrl = "/images/logo.jpg";

    @Column(name = "nav_catalog_label", nullable = false, length = 120)
    private String navCatalogLabel = "Catalogo";

    @Column(name = "nav_categories_label", nullable = false, length = 120)
    private String navCategoriesLabel = "Categorias";

    @Column(name = "nav_contact_label", nullable = false, length = 120)
    private String navContactLabel = "Contacto";

    @Column(name = "hero_badge", nullable = false, length = 255)
    private String heroBadge = "Productos de cocina premium";

    @Column(name = "hero_title", nullable = false, length = 255)
    private String heroTitle = "Cocina con lo mejor,";

    @Column(name = "hero_title_highlight", nullable = false, length = 255)
    private String heroTitleHighlight = "disfruta cada momento";

    @Lob
    @Column(name = "hero_description", nullable = false, columnDefinition = "TEXT")
    private String heroDescription = "Descubri nuestra linea completa de ollas, sartenes y accesorios. Calidad que se siente en cada receta.";

    @Column(name = "hero_primary_cta_label", nullable = false, length = 120)
    private String heroPrimaryCtaLabel = "Ver catalogo";

    @Column(name = "hero_secondary_cta_label", nullable = false, length = 120)
    private String heroSecondaryCtaLabel = "Contactanos";

    @Column(name = "catalog_title", nullable = false, length = 255)
    private String catalogTitle = "Nuestro catalogo";

    @Lob
    @Column(name = "catalog_description", nullable = false, columnDefinition = "TEXT")
    private String catalogDescription = "Explora todos nuestros productos y encontra lo que necesitas para tu cocina.";

    @Lob
    @Column(name = "footer_description", nullable = false, columnDefinition = "TEXT")
    private String footerDescription = "Productos de cocina premium para quienes disfrutan cocinar. Calidad, durabilidad y diseno en cada pieza.";

    @Lob
    @Column(name = "footer_contact_text", nullable = false, columnDefinition = "TEXT")
    private String footerContactText = "Escribinos por WhatsApp para consultas, pedidos o asesoramiento personalizado.";

    @Column(name = "whatsapp_button_label", nullable = false, length = 120)
    private String whatsappButtonLabel = "Escribinos por WhatsApp";

    @Column(name = "whatsapp_number", nullable = false, length = 40)
    private String whatsappNumber = "5491124848417";

    @Lob
    @Column(name = "whatsapp_default_message", nullable = false, columnDefinition = "TEXT")
    private String whatsappDefaultMessage = "Hola! Quiero consultar por productos Kelly Store.";

    @Lob
    @Column(name = "product_inquiry_template", nullable = false, columnDefinition = "TEXT")
    private String productInquiryTemplate = "Hola! Me interesa el producto: {product}. Me podrias dar mas info?";

    @Column(name = "copyright_text", nullable = false, length = 255)
    private String copyrightText = "Kelly Store - Todos los derechos reservados.";

    @PrePersist
    private void ensureIdAndSlug() {
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }
        if (slug == null || slug.isBlank()) {
            slug = "main";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getNavCatalogLabel() {
        return navCatalogLabel;
    }

    public void setNavCatalogLabel(String navCatalogLabel) {
        this.navCatalogLabel = navCatalogLabel;
    }

    public String getNavCategoriesLabel() {
        return navCategoriesLabel;
    }

    public void setNavCategoriesLabel(String navCategoriesLabel) {
        this.navCategoriesLabel = navCategoriesLabel;
    }

    public String getNavContactLabel() {
        return navContactLabel;
    }

    public void setNavContactLabel(String navContactLabel) {
        this.navContactLabel = navContactLabel;
    }

    public String getHeroBadge() {
        return heroBadge;
    }

    public void setHeroBadge(String heroBadge) {
        this.heroBadge = heroBadge;
    }

    public String getHeroTitle() {
        return heroTitle;
    }

    public void setHeroTitle(String heroTitle) {
        this.heroTitle = heroTitle;
    }

    public String getHeroTitleHighlight() {
        return heroTitleHighlight;
    }

    public void setHeroTitleHighlight(String heroTitleHighlight) {
        this.heroTitleHighlight = heroTitleHighlight;
    }

    public String getHeroDescription() {
        return heroDescription;
    }

    public void setHeroDescription(String heroDescription) {
        this.heroDescription = heroDescription;
    }

    public String getHeroPrimaryCtaLabel() {
        return heroPrimaryCtaLabel;
    }

    public void setHeroPrimaryCtaLabel(String heroPrimaryCtaLabel) {
        this.heroPrimaryCtaLabel = heroPrimaryCtaLabel;
    }

    public String getHeroSecondaryCtaLabel() {
        return heroSecondaryCtaLabel;
    }

    public void setHeroSecondaryCtaLabel(String heroSecondaryCtaLabel) {
        this.heroSecondaryCtaLabel = heroSecondaryCtaLabel;
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public String getFooterDescription() {
        return footerDescription;
    }

    public void setFooterDescription(String footerDescription) {
        this.footerDescription = footerDescription;
    }

    public String getFooterContactText() {
        return footerContactText;
    }

    public void setFooterContactText(String footerContactText) {
        this.footerContactText = footerContactText;
    }

    public String getWhatsappButtonLabel() {
        return whatsappButtonLabel;
    }

    public void setWhatsappButtonLabel(String whatsappButtonLabel) {
        this.whatsappButtonLabel = whatsappButtonLabel;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getWhatsappDefaultMessage() {
        return whatsappDefaultMessage;
    }

    public void setWhatsappDefaultMessage(String whatsappDefaultMessage) {
        this.whatsappDefaultMessage = whatsappDefaultMessage;
    }

    public String getProductInquiryTemplate() {
        return productInquiryTemplate;
    }

    public void setProductInquiryTemplate(String productInquiryTemplate) {
        this.productInquiryTemplate = productInquiryTemplate;
    }

    public String getCopyrightText() {
        return copyrightText;
    }

    public void setCopyrightText(String copyrightText) {
        this.copyrightText = copyrightText;
    }
}
