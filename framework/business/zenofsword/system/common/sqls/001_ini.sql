-- privilege_manage.privilege definition

CREATE TABLE `privilege` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `remark` text COLLATE utf8mb4_general_ci,
  `parent_id` bigint unsigned DEFAULT NULL,
  `code` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `privilege_code_IDX` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.privilege_group definition

CREATE TABLE `privilege_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  `code` varchar(100) NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `privilege_group_code_IDX` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- privilege_manage.privilege_privilege_group definition

CREATE TABLE `privilege_privilege_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `group_id` bigint unsigned NOT NULL,
  `privi_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_privilege_group_id_IDX` (`group_id`,`privi_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- privilege_manage.`role` definition

CREATE TABLE `role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  `count` int unsigned NOT NULL DEFAULT '0',
  `count_limit` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code_IDX` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.role_privilege definition

CREATE TABLE `role_privilege` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint unsigned NOT NULL,
  `privi_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_privilege_role_id_IDX` (`role_id`,`privi_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.role_privilege_group definition

CREATE TABLE `role_privilege_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `privi_group_id` bigint unsigned NOT NULL,
  `role_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_privilege_group_privilege_group_id_IDX` (`privi_group_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- privilege_manage.role_repulsion definition

CREATE TABLE `role_repulsion` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `role_id_a` bigint unsigned NOT NULL,
  `role_id_b` bigint unsigned NOT NULL,
  `remark` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_repulsion_un` (`role_id_a`,`role_id_b`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.role_user_group definition

CREATE TABLE `role_user_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint unsigned NOT NULL,
  `user_group_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_role_role_id_IDX` (`role_id`,`user_group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- privilege_manage.`user` definition

CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `account` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `count` bigint unsigned NOT NULL,
  `count_limit` bigint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_account_IDX` (`account`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.user_group definition

CREATE TABLE `user_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `ordering` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.user_role definition

CREATE TABLE `user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `role_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_user_id_IDX` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- privilege_manage.user_user_group definition

CREATE TABLE `user_user_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `user_group_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_group_user_id_IDX` (`user_id`,`user_group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;