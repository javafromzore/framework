ALTER TABLE car_dictionary DROP INDEX car_map_values_IDX;

CREATE UNIQUE INDEX car_dictionary_key_IDX USING BTREE ON car_dictionary (`key`,`type`);

ALTER TABLE dictionary DROP INDEX dictionary_type_IDX;

CREATE UNIQUE INDEX dictionary_type_IDX USING BTREE ON dictionary (`type`,`key`);

