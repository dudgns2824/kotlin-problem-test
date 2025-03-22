CREATE TABLE `beyond_medicine_user`
(
    `user_id`           VARCHAR(32) NOT NULL COMMENT '유저 id' COLLATE 'utf8mb4_unicode_ci',
    `prescription_code` VARCHAR(8)  NOT NULL DEFAULT '' COMMENT '처방 코드 id' COLLATE 'utf8mb4_unicode_ci',
    `created_at`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    `updated_at`        TIMESTAMP COMMENT '수정 일시',
    `deleted_at`        TIMESTAMP COMMENT '삭제 일시',
    PRIMARY KEY (`user_id`) USING BTREE,
    INDEX               `idx_prescription_code` (`prescription_code`) USING BTREE
) COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
