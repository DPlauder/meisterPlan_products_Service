-- Add article_num column if missing
ALTER TABLE products
    ADD COLUMN IF NOT EXISTS article_num VARCHAR(255);

-- Backfill existing rows with a deterministic value based on id
UPDATE products
SET article_num = 'ART-' || id
WHERE article_num IS NULL;

-- Ensure article_num is required
ALTER TABLE products
    ALTER COLUMN article_num SET NOT NULL;

-- Enforce uniqueness at the database level
CREATE UNIQUE INDEX IF NOT EXISTS ux_products_article_num
    ON products (article_num);
