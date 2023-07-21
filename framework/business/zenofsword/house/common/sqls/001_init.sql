ALTER TABLE `five-and-eight`.house_dictionary ADD sort_value INT UNSIGNED DEFAULT 0 NULL;

RENAME TABLE `five-and-eight`.dictionary TO `five-and-eight`.house_dictionary;

ALTER TABLE `five-and-eight`.house_highlight MODIFY COLUMN highlight_id bigint unsigned NOT NULL;
ALTER TABLE `five-and-eight`.house_highlight MODIFY COLUMN rent_house_info_id bigint unsigned NOT NULL;

CREATE UNIQUE INDEX house_highlight_rent_house_info_id_IDX USING BTREE ON `five-and-eight`.house_highlight (rent_house_info_id,highlight_id);
