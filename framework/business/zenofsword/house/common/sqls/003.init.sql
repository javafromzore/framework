ALTER TABLE `five-eight`.area_info CHANGE `key` `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL;
ALTER TABLE `five-eight`.rent_house_info ADD storey TINYINT UNSIGNED NULL;
ALTER TABLE `five-eight`.rent_house_info MODIFY COLUMN storey tinyint unsigned DEFAULT 0 NULL;
ALTER TABLE `five-eight`.rent_house_info ADD bedroom_type_id BIGINT(20) UNSIGNED NULL;
ALTER TABLE `five-eight`.community_info ADD community_id BIGINT(20) UNSIGNED NULL;
ALTER TABLE `five-eight`.community_info MODIFY COLUMN build_years int unsigned DEFAULT 0 NULL;


