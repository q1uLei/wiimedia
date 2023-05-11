-- 注意：该页面对应的前台目录为views/wiimedia文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023050901494970490', NULL, '单点登录-应用管理', '/wiimedia/wiimediaApplicationManageList', 'wiimedia/WiimediaApplicationManageList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980491', '2023050901494970490', '添加单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980492', '2023050901494970490', '编辑单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980493', '2023050901494970490', '删除单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980494', '2023050901494970490', '批量删除单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980495', '2023050901494970490', '导出excel_单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901494980496', '2023050901494970490', '导入excel_单点登录-应用管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_manage:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:49:49', NULL, NULL, 0, 0, '1', 0);