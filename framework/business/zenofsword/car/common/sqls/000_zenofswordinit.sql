CREATE TABLE `car_advantage` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个优势类型在car_dictionary中对应的key值。可选项：是、否、这个优势存在最大值、这个优势存在最小值',
  `value` bigint unsigned DEFAULT NULL COMMENT '这个属性的值为最大值或者最小值',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个属性名称在car_map中的key值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_advantage_config_key_IDX` (`config_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `car_brand` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `car_company_id` bigint unsigned NOT NULL COMMENT '所属公司id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_brand_car_company_id_IDX` (`car_company_id`,`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `car_company` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL COMMENT '集团地址',
  `email` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `icon` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_company_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `car_dictionary` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `key` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `ordering` tinyint unsigned NOT NULL COMMENT '顺序',
  PRIMARY KEY (`id`),
  KEY `car_map_values_IDX` (`value`,`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='车这一个业务的字典';

    CREATE TABLE `car_infor` (
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `guide_price` bigint unsigned NOT NULL COMMENT '指导价,单位：元',
      `car_pattern_id` bigint unsigned NOT NULL,
      `quoted_price` bigint unsigned NOT NULL,
      PRIMARY KEY (`id`),
      UNIQUE KEY `car_infor_car_pattern_id_IDX` (`car_pattern_id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关于一种类型的车的信息（如江淮 瑞风M3 这就是一种车）';

    CREATE TABLE `car_infor_config` (
      `car_infor_id` bigint unsigned NOT NULL,
      `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个属性类型在car_dictionary中的key值',
      `value` bigint unsigned DEFAULT '0' COMMENT '这个值的大小',
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `remark` text,
      `icon` varchar(100) DEFAULT NULL,
      `value_type_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个属性的值的类型在car_dictionary中对应的key值，可选项：key或者是数值',
      `introduction` varchar(200) DEFAULT NULL COMMENT '对于这一项的介绍',
      PRIMARY KEY (`id`),
      UNIQUE KEY `car_config_un` (`car_infor_id`,`config_key`,`value`)
    ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    CREATE TABLE `car_infor_photo` (
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `car_infor_id` bigint unsigned NOT NULL,
      `photo` varchar(100) NOT NULL,
      `ordering` tinyint unsigned NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    CREATE TABLE `car_pattern` (
      `id` bigint unsigned NOT NULL,
      `car_pattern` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车型(是奥迪的x3?宝马的q5?)',
      `car_brand_id` bigint unsigned NOT NULL,
      `time_pattern` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年份款式（如2020款）',
      `pattern_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '款式key（运动？时尚？）',
      UNIQUE KEY `car_pattern_car_pattern_IDX` (`car_pattern`,`car_brand_id`,`time_pattern`,`pattern_key`) USING BTREE,
      KEY `car_pattern_car_brand_id_IDX` (`car_brand_id`,`car_pattern`,`time_pattern`,`pattern_key`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='车的款式';

    CREATE TABLE `dictionary` (
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
      `key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
      `values` varchar(200) DEFAULT NULL,
      `ordering` tinyint unsigned NOT NULL,
      PRIMARY KEY (`id`),
      UNIQUE KEY `dictionary_type_IDX` (`type`,`key`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `car_infor_id` bigint unsigned NOT NULL,
      `account_id` bigint unsigned NOT NULL COMMENT '账户id',
      `post_date` date NOT NULL COMMENT '该二手车售卖信息发布时间',
      `building_id` bigint unsigned NOT NULL COMMENT '该二手车地点建筑id（提车地点、试车地点等）',
      `license_date` date NOT NULL COMMENT '首次上牌时间',
      `contacted_name` varchar(50) NOT NULL COMMENT '联系人名字',
      `contacted_phone` varchar(30) NOT NULL COMMENT '联系人电话',
      `status` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '表示是否售卖，0代表未售卖，1代表已售卖',
      `photo_count` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '照片数量',
      `nature_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'dictionary中车辆性质的id',
      `insurance_date` date DEFAULT NULL COMMENT '商业险到期时间',
      `annual_inspection_date` date DEFAULT NULL COMMENT '年检到期时间',
      `maintenance_key` varchar(32) NOT NULL COMMENT 'dictionary中维修保养种类key',
      `compulsory_insurance_date` date DEFAULT NULL COMMENT '强险到期时间',
      `vin` varchar(30) NOT NULL COMMENT '车辆vin码',
      `description` text COMMENT '对于该车描述',
      `transfer_fee_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '过户费在car_dictionary中对应的类型（包含、不包含）',
      `anxuan_key` varchar(32) NOT NULL COMMENT '安选在car_dictionary中对应的key（是，否）',
      `price` bigint unsigned NOT NULL COMMENT '单位：元',
      `mileage` bigint unsigned NOT NULL COMMENT '里程数（单位：万公里）',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关于二手车';

    CREATE TABLE `used_car_config` (
      `used_car_id` bigint unsigned NOT NULL,
      `type_car_map_key` varchar(19) NOT NULL COMMENT '这个属性类型在car_map中的key值',
      `value` bigint unsigned DEFAULT NULL COMMENT 'value的值表示属性的值在car_map中对应的key值，或者就是一个值',
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `remark` text,
      `icon` varchar(100) DEFAULT NULL,
      `value_type` tinyint unsigned NOT NULL COMMENT '0表示value 的值为一个 key值，1表示value的值为一个数字',
      `introduction` varchar(200) DEFAULT NULL COMMENT '对于这一项的介绍',
      PRIMARY KEY (`id`),
      UNIQUE KEY `car_config_un` (`used_car_id`,`type_car_map_key`,`value`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    CREATE TABLE `used_car_photo` (
      `id` bigint unsigned NOT NULL AUTO_INCREMENT,
      `used_car_id` bigint unsigned NOT NULL,
      `photo` varchar(100) NOT NULL,
      `ordering` tinyint unsigned NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;