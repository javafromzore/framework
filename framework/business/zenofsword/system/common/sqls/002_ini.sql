ALTER TABLE privilege_manage.privilege DROP INDEX privilege_code_IDX;
CREATE UNIQUE INDEX privilege_code_IDX USING BTREE ON privilege_manage.privilege (code,parent_id);
