CREATE TABLE categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    sector_id UUID NOT NULL,
    FOREIGN KEY (sector_id) REFERENCES sectors(id) ON DELETE RESTRICT
);
