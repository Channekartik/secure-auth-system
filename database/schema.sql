-- ============================================
-- Secure Auth System — MySQL Schema
-- ============================================

CREATE DATABASE IF NOT EXISTS secure_auth_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE secure_auth_db;

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100)        NOT NULL,
    email      VARCHAR(150)        NOT NULL UNIQUE,
    password   VARCHAR(255)        NOT NULL,       -- BCrypt hash
    role       ENUM('USER','ADMIN') NOT NULL DEFAULT 'USER',
    enabled    BOOLEAN             NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
                                   ON UPDATE CURRENT_TIMESTAMP
);

-- Optional: seed an admin account (password = "Admin@1234")
INSERT INTO users (name, email, password, role)
VALUES (
  'Super Admin',
  'admin@example.com',
  '$2a$12$KIXwS1r0qBsBsK8mFqLfpua8i4NdBu9U/HSmJlF2bNgr6mzJ0x7bW',
  'ADMIN'
);