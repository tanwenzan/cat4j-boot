INSERT INTO cat4j_user (id, login_id, login_pwd, user_name, org_id, salt, avatar, phone_number, email, introduction, lock_flag, create_by, create_time, update_by, update_time, re_version, hide) VALUES (3904233767069696, 'admin', 'E276DD3CBC7DFE2F34A2620BCB68A959', 'zeroable', 3904233767069697, '34fe345f-16f1-4529-85d3-33c0f2bd4ac7', null, null, null, null, 0, 3904233767069696, '2024-01-07 00:18:45', null, null, 0, 0);

INSERT INTO cat4j_role (id, role_name, role_code, role_desc, create_by, create_time, update_by, update_time, re_version, hide) VALUES (3932521684953091, '超级管理员', 'admin', '超级管理员 拥有所有权限，开发接口与联调时禁用', 3904233767069696, '2024-01-11 16:27:56', null, null, 0, 0);

INSERT INTO cat4j_user_role (user_id, role_id) VALUES (3904233767069696, 3932521684953091);

INSERT INTO cat4j_menu (id, parent_id, tree_path, code, name, permission, path, icon, sort_order, keep_alive, type, menu_type, menu_config, create_by, create_time, update_by, update_time, re_version, hide) VALUES (3932521684953088, '0', '3932521684953088
', 'admin', 'router.base.baseSetting', null, '/Admin', 'code:Setting', '-1', '1', 0, null, null, 3904233767069696, '2024-01-11 16:16:58', null, null, 0, 0);
INSERT INTO cat4j_menu (id, parent_id, tree_path, code, name, permission, path, icon, sort_order, keep_alive, type, menu_type, menu_config, create_by, create_time, update_by, update_time, re_version, hide) VALUES (3932521684953089, '3932521684953088', '3932521684953089/3932521684953089', 'menu', 'router.base.menu', 'menu.view', '/Admin/menu/menu', 'code:Menu', '1000', '1', 0, 1, null, 3904233767069696, '2024-01-11 16:20:46', null, null, 0, 0);


INSERT INTO cat4j_role_menu (role_id, menu_id) VALUES (3932521684953091, 3932521684953088);
INSERT INTO cat4j_role_menu (role_id, menu_id) VALUES (3932521684953091, 3932521684953089);


INSERT INTO cat4j_role_menu (role_id, menu_id) VALUES (3932521684953091, 3932521684953088);
INSERT INTO cat4j_role_menu (role_id, menu_id) VALUES (3932521684953091, 3932521684953089);

