-- `five-and-eight`.rent_house_info definition

CREATE TABLE `rent_house_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `rent` int DEFAULT NULL,
  `house_size` decimal(7,2) NOT NULL,
  `client_id` bigint unsigned NOT NULL,
  `agent_id` bigint unsigned DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `picture` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `bedroom` tinyint unsigned DEFAULT '0',
  `livingroom` tinyint unsigned DEFAULT '0',
  `washroom` tinyint unsigned DEFAULT '0',
  `level` tinyint DEFAULT '0',
  `status` tinyint DEFAULT '0',
  `house_description` text,
  `property_price` decimal(7,2) DEFAULT '0.00',
  `community_info_id` bigint unsigned DEFAULT NULL,
  `deposittype_id` bigint unsigned DEFAULT NULL,
  `commission_id` bigint unsigned DEFAULT NULL,
  `renthousetype_id` bigint unsigned DEFAULT NULL,
  `decoratetype_id` bigint unsigned DEFAULT NULL,
  `orientation_id` bigint unsigned DEFAULT NULL,
  `storey_id` bigint unsigned DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rent_house_info_title_IDX` (`title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.house_dictionary definition

CREATE TABLE `house_dictionary` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `key` varchar(32) NOT NULL,
  `value` text NOT NULL,
  `sort_value` int unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dictionary_type_IDX` (`type`,`key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.picture definition

CREATE TABLE `picture` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(32) DEFAULT NULL,
  `rent_house_info_id` bigint unsigned DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.area_info definition

CREATE TABLE `area_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent_id` bigint unsigned DEFAULT NULL,
  `level` tinyint unsigned DEFAULT '0',
  `code` varchar(100) DEFAULT NULL,
  `key` varchar(32) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.community_info definition

CREATE TABLE `community_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `build_years` int unsigned DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `property_company` varchar(100) DEFAULT NULL,
  `business_area` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.house_device_type definition

CREATE TABLE `house_device_type` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `key` varchar(32) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '方便找到数据并维护',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.house_device definition

CREATE TABLE `house_device` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `rent_house_info_id` bigint unsigned NOT NULL,
  `house_device_type_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `house_device_rent_house_info_id_IDX` (`rent_house_info_id`,`house_device_type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.house_highlight_info definition

CREATE TABLE `house_highlight_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `five-and-eight`.house_highlight definition

CREATE TABLE `house_highlight` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `rent_house_info_id` bigint unsigned NOT NULL,
  `highlight_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `house_highlight_rent_house_info_id_IDX` (`rent_house_info_id`,`highlight_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.rent_house_request_info definition

CREATE TABLE `rent_house_request_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.area_product_details definition

CREATE TABLE `area_product_details` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `target_id` bigint unsigned NOT NULL,
  `area_info_id` bigint unsigned NOT NULL,
  `target_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述target_id是哪张表，什么种类信息',
  `area_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '城市类型，方便查找，知道cityid代表什么',
  `area_level` tinyint unsigned DEFAULT '0' COMMENT '城市等级，方便查找，知道level代表什么',
  PRIMARY KEY (`id`),
  UNIQUE KEY `city_info_details_target_id_IDX` (`target_id`,`area_info_id`,`target_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.commission definition

CREATE TABLE `commission` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `value` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `five-and-eight`.rent_house_request definition

CREATE TABLE `rent_house_request` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `rent_house_request_info_id` bigint unsigned NOT NULL,
  `rent_house_info_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rent_house_request_rent_house_request_info_id_IDX` (`rent_house_request_info_id`,`rent_house_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;