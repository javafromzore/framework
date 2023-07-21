-- zenofsword_car.advantage definition

CREATE TABLE `advantage` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` bigint unsigned DEFAULT NULL,
  `config_id` bigint unsigned NOT NULL,
  `value_str` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `value_max` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_advantage_attrib_key_IDX` (`config_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.annual_model definition

CREATE TABLE `annual_model` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `year` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `series_id` bigint unsigned NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_version_car_id_IDX` (`series_id`,`year`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.brand definition

CREATE TABLE `brand` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `company_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.car_config definition

CREATE TABLE `car_config` (
  `target_id` bigint unsigned NOT NULL,
  `config_id` bigint unsigned NOT NULL,
  `value` bigint unsigned DEFAULT NULL COMMENT '一个具体的值',
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `value_str` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '这辆车的配置的key',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '目标类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_configuration_target_id_IDX` (`target_id`,`type`,`config_id`,`value`,`value_str`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.car_dict definition

CREATE TABLE `car_dict` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordering` int unsigned NOT NULL COMMENT '顺序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_dictionary_key_IDX` (`key`,`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='车这一个业务的字典';
-- zenofsword_car.company definition

CREATE TABLE `company` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_company_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.config definition

CREATE TABLE `config` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `remark` text COLLATE utf8mb4_general_ci,
  `icon` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `value_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `introduction` text COLLATE utf8mb4_general_ci,
  `ordering` int unsigned NOT NULL,
  `car_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'series,annual_model,pattern',
  `config_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置所属类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_attrib_attrib_key_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.dict definition

CREATE TABLE `dict` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dictionary_type_IDX` (`type`,`key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.modification definition

CREATE TABLE `modification` (
  `used_car_id` bigint unsigned NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` bigint unsigned DEFAULT NULL COMMENT 'value的值表示属性的值在car_map中对应的key值，或者就是一个值',
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `value_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '对于这一项的介绍',
  `ordering` int unsigned NOT NULL,
  `value_str` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `modification_name_IDX` (`name`,`value`,`value_str`,`used_car_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.pattern definition

CREATE TABLE `pattern` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `annual_id` bigint unsigned NOT NULL,
  `guide_price` bigint unsigned DEFAULT NULL COMMENT '单位：元',
  `quoted_price` bigint unsigned DEFAULT NULL COMMENT '单位：元',
  `ordering` int unsigned NOT NULL,
  `series_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `car_pattern_name_IDX` (`name`,`annual_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='车的款式';
-- zenofsword_car.pattern_photo definition

CREATE TABLE `pattern_photo` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `pattern_id` bigint unsigned NOT NULL,
  `photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- zenofsword_car.series definition

CREATE TABLE `series` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `brand_id` bigint unsigned NOT NULL,
  `ordering` int unsigned NOT NULL,
  `company_id` bigint unsigned NOT NULL COMMENT '厂商',
  PRIMARY KEY (`id`),
  UNIQUE KEY `series_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='车系';
-- zenofsword_car.used_car definition

CREATE TABLE `used_car` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `pattern_id` bigint unsigned NOT NULL,
  `account_id` bigint unsigned NOT NULL COMMENT '账户id',
  `post_date` date NOT NULL COMMENT '该二手车售卖信息发布时间',
  `building_id` bigint unsigned NOT NULL COMMENT '该二手车地点建筑id（提车地点、试车地点等）',
  `license_date` date NOT NULL COMMENT '首次上牌时间',
  `contacted_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人名字',
  `contacted_phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人电话',
  `status` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '表示是否售卖，0代表未售卖，1代表已售卖',
  `photo_count` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '照片数量',
  `nature_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `insurance_date` date DEFAULT NULL COMMENT '商业险到期时间',
  `annual_inspection_date` date DEFAULT NULL COMMENT '年检到期时间',
  `maintenance_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '维修保养种类',
  `compulsory_insurance_date` date DEFAULT NULL COMMENT '强险到期时间',
  `vin` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆vin码',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '对于该车描述',
  `transfer_fee` tinyint unsigned NOT NULL COMMENT '是否包含过户费',
  `anxuan` tinyint unsigned NOT NULL COMMENT '1代表是，0代表否',
  `price` bigint unsigned NOT NULL COMMENT '单位：元',
  `mileage` bigint unsigned NOT NULL COMMENT '单位：米',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='关于二手车';
-- zenofsword_car.used_car_photo definition

CREATE TABLE `used_car_photo` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `used_car_id` bigint unsigned NOT NULL,
  `photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;