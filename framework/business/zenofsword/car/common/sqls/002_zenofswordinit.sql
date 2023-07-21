ALTER TABLE dictionary CHANGE `values` value varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;

ALTER TABLE dictionary MODIFY COLUMN value varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;

ALTER TABLE used_car_config CHANGE type_car_map_key config_key varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个属性类型在car_map中的key值';

ALTER TABLE used_car_config MODIFY COLUMN config_key varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '这个属性类型在car_map中的key值';

ALTER TABLE used_car_config CHANGE value_type value_type_key tinyint unsigned NOT NULL COMMENT '这个属性的值的类型在car_dictionary中对应的key值，可选项：key或者是数值';

ALTER TABLE used_car_config MODIFY COLUMN value_type_key varchar(100) NOT NULL COMMENT '这个属性的值的类型在car_dictionary中对应的key值，可选项：key或者是数值';
