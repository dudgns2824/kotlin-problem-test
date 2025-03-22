CREATE TABLE `prescription_code` (
    `id` VARCHAR(8) NOT NULL COMMENT '처방 코드 = id 대문자 알파벳 4개, 숫자 4개로 이루어짐.' COLLATE 'utf8mb4_unicode_ci',
    `hospital_id` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '병원 id' COLLATE 'utf8mb4_unicode_ci',
    `is_activate` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '활성화 여부',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    `expired_at` TIMESTAMP COMMENT '만료 일시',
    `updated_at` TIMESTAMP COMMENT '수정 일시',
    `deleted_at` TIMESTAMP COMMENT '삭제 일시',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_hospital_id` (`hospital_id`) USING BTREE,
    INDEX `idx_is_activate` (`is_activate`) USING BTREE,
    INDEX `idx_expired_at` (`expired_at`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
