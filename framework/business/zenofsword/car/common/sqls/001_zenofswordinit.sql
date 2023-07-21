ALTER TABLE car_pattern DROP INDEX car_pattern_car_pattern_IDX;
ALTER TABLE car_pattern ADD CONSTRAINT car_pattern_pk PRIMARY KEY (id);
ALTER TABLE car_pattern MODIFY COLUMN id bigint unsigned auto_increment NOT NULL;
