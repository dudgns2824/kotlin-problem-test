CREATE TABLE `version`
(
    `recent_version` VARCHAR(32) NOT NULL COMMENT '최근 버전 정보' COLLATE 'utf8mb4_unicode_ci',
    `min_version`    VARCHAR(32)  NOT NULL COMMENT '최소 버전 정보' COLLATE 'utf8mb4_unicode_ci',
    `os`             VARCHAR(16)  NOT NULL COMMENT 'os 정보' COLLATE 'utf8mb4_unicode_ci',
    `mode`           VARCHAR(16)  NOT NULL COMMENT 'mode 정보' COLLATE 'utf8mb4_unicode_ci',
    `hash`           VARCHAR(64)  NOT NULL COMMENT 'hash 정보' COLLATE 'utf8mb4_unicode_ci',
    PRIMARY KEY (`recent_version`, `min_version`, `os`, `mode`, `hash`) USING BTREE
) COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
