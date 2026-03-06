CREATE TABLE IF NOT EXISTS landing_settings (
  id VARCHAR(36) PRIMARY KEY,
  slug VARCHAR(80) NOT NULL,
  brand_name VARCHAR(255) NOT NULL,
  logo_url TEXT NOT NULL,
  nav_catalog_label VARCHAR(120) NOT NULL,
  nav_categories_label VARCHAR(120) NOT NULL,
  nav_contact_label VARCHAR(120) NOT NULL,
  hero_badge VARCHAR(255) NOT NULL,
  hero_title VARCHAR(255) NOT NULL,
  hero_title_highlight VARCHAR(255) NOT NULL,
  hero_description TEXT NOT NULL,
  hero_primary_cta_label VARCHAR(120) NOT NULL,
  hero_secondary_cta_label VARCHAR(120) NOT NULL,
  catalog_title VARCHAR(255) NOT NULL,
  catalog_description TEXT NOT NULL,
  footer_description TEXT NOT NULL,
  footer_contact_text TEXT NOT NULL,
  whatsapp_button_label VARCHAR(120) NOT NULL,
  whatsapp_number VARCHAR(40) NOT NULL,
  whatsapp_default_message TEXT NOT NULL,
  product_inquiry_template TEXT NOT NULL,
  copyright_text VARCHAR(255) NOT NULL,
  created_at DATETIME(6) NOT NULL,
  updated_at DATETIME(6) NOT NULL,
  CONSTRAINT uk_landing_settings_slug UNIQUE (slug)
);

CREATE TABLE IF NOT EXISTS products (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price_ars INT NOT NULL,
  description VARCHAR(3000) NOT NULL,
  category VARCHAR(120) NOT NULL,
  image_url VARCHAR(2000) NOT NULL,
  featured BIT(1) NOT NULL,
  sort_order INT NOT NULL DEFAULT 0,
  created_at DATETIME(6) NOT NULL,
  updated_at DATETIME(6) NOT NULL
);

CREATE INDEX idx_products_category ON products(category);
CREATE INDEX idx_products_featured ON products(featured);
CREATE INDEX idx_products_sort_order ON products(sort_order);
