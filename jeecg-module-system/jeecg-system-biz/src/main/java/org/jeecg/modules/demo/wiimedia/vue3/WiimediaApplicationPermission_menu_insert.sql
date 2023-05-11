-- 注意：该页面对应的前台目录为views/wiimedia文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023050901482080350', NULL, '单点登录-权限管理', '/wiimedia/wiimediaApplicationPermissionList', 'wiimedia/WiimediaApplicationPermissionList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482080351', '2023050901482080350', '添加单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482080352', '2023050901482080350', '编辑单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482080353', '2023050901482080350', '删除单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482090354', '2023050901482080350', '批量删除单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482090355', '2023050901482080350', '导出excel_单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023050901482090356', '2023050901482080350', '导入excel_单点登录-权限管理', NULL, NULL, 0, NULL, NULL, 2, 'wiimedia:wiimedia_application_permission:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-05-09 13:48:35', NULL, NULL, 0, 0, '1', 0);