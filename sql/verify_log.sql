CREATE TABLE `verify_log`
(
    `idx` BIGINT UNSIGNED NOT NULL COMMENT 'idx number' AUTO_INCREMENT,
    `version`    VARCHAR(32) NOT NULL COMMENT '버전 정보' COLLATE 'utf8mb4_unicode_ci',
    `os`             VARCHAR(16) NOT NULL COMMENT 'os 정보' COLLATE 'utf8mb4_unicode_ci',
    `mode`           VARCHAR(16) NOT NULL COMMENT 'mode 정보' COLLATE 'utf8mb4_unicode_ci',
    `hash`           VARCHAR(64) NOT NULL COMMENT 'hash 정보' COLLATE 'utf8mb4_unicode_ci',
    `request_at`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '요청 일시',
    PRIMARY KEY (`idx`) USING BTREE
) COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
