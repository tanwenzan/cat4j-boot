DROP TABLE IF EXISTS cat4j_user;
CREATE TABLE cat4j_user(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `login_id` VARCHAR(255) NOT NULL   COMMENT '账号' ,
    `login_pwd` VARCHAR(255) NOT NULL   COMMENT '密码' ,
    `user_name` VARCHAR(64) NOT NULL   COMMENT '用户名' ,
    `org_id` bigint(64) NOT NULL   COMMENT '所属组织' ,
    `salt` VARCHAR(255)    COMMENT '随机盐' ,
    `avatar` VARCHAR(255)    COMMENT '头像' ,
    `phone_number` VARCHAR(255)    COMMENT '手机号码' ,
    `email` VARCHAR(255)    COMMENT '邮箱' ,
    `introduction` VARCHAR(255)    COMMENT '简介' ,
    `lock_flag` INT(10) NOT NULL  DEFAULT 0 COMMENT '锁定标识:0=正常,1=锁定' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建时间' ,
    `create_time` DATETIME NOT NULL   COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '用户表';

DROP TABLE IF EXISTS cat4j_organization;
CREATE TABLE cat4j_organization(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `parent_id` bigint(64) NOT NULL   COMMENT '父节点' ,
    `org_name` VARCHAR(255) NOT NULL   COMMENT '组织架构名称' ,
    `path` VARCHAR(900) NOT NULL   COMMENT '路径' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '组织架构';

DROP TABLE IF EXISTS cat4j_role;
CREATE TABLE cat4j_role(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `role_name` VARCHAR(255) NOT NULL   COMMENT '角色名称' ,
    `role_code` VARCHAR(255) NOT NULL   COMMENT '角色代码' ,
    `role_desc` VARCHAR(255)    COMMENT '角色描述' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '角色表';


CREATE UNIQUE INDEX role_idx1_role_code ON cat4j_role(role_code);

DROP TABLE IF EXISTS cat4j_role_menu;
CREATE TABLE cat4j_role_menu(
    `role_id` bigint(64) NOT NULL   COMMENT '角色ID' ,
    `menu_id` bigint(64) NOT NULL   COMMENT '菜单ID' ,
    PRIMARY KEY (role_id,menu_id)
)  COMMENT = '角色权限表';

DROP TABLE IF EXISTS cat4j_dict;
CREATE TABLE cat4j_dict(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `dict_key` VARCHAR(255) NOT NULL   COMMENT '标识' ,
    `description` VARCHAR(255)    COMMENT '描述' ,
    `sys_flag` tinyint(1) NOT NULL   COMMENT '是否是系统内置' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '字典表';

DROP TABLE IF EXISTS cat4j_dict_item;
CREATE TABLE cat4j_dict_item(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `dict_id` VARCHAR(255) NOT NULL   COMMENT '字典ID' ,
    `dict_key` VARCHAR(255) NOT NULL   COMMENT '字典标识' ,
    `value` VARCHAR(255) NOT NULL   COMMENT '值' ,
    `label` VARCHAR(255) NOT NULL   COMMENT '标签' ,
    `type` VARCHAR(255)    COMMENT '字典类型' ,
    `description` VARCHAR(255)    COMMENT '描述' ,
    `sort_order` INT(10)    COMMENT '排序（升序）' ,
    `remark` VARCHAR(255)    COMMENT '备注' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '字典明细';


CREATE INDEX cat4j_dict_value ON cat4j_dict_item(value);
CREATE INDEX cat4j_dict_label ON cat4j_dict_item(label);

DROP TABLE IF EXISTS cat4j_log;
CREATE TABLE cat4j_log(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `type` INT(10)   DEFAULT 1 COMMENT '日志类型' ,
    `title` VARCHAR(255)    COMMENT '日志标题' ,
    `service_id` VARCHAR(255)    COMMENT '服务ID' ,
    `remote_addr` VARCHAR(255)    COMMENT 'ip地址' ,
    `user_agent` VARCHAR(255)    COMMENT '用户代理' ,
    `request_uri` VARCHAR(255)    COMMENT '请求URI' ,
    `method` VARCHAR(255)    COMMENT '操作方式' ,
    `params` VARCHAR(255)    COMMENT '操作提交的数据' ,
    `time` INT(20)    COMMENT '执行时间' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '系统日志';


CREATE INDEX cat4j_log_create_by ON cat4j_log(create_by);
CREATE INDEX cat4j_log_request_uri ON cat4j_log(request_uri);
CREATE INDEX cat4j_log_type ON cat4j_log(type);
CREATE INDEX cat4j_log_create_date ON cat4j_log(create_time);

DROP TABLE IF EXISTS cat4j_menu;
CREATE TABLE cat4j_menu(
    `id` bigint(64) NOT NULL   COMMENT '菜单id' ,
    `parent_id` VARCHAR(255) NOT NULL   COMMENT '父菜单ID' ,
    `tree_path` VARCHAR(255)    COMMENT '菜单路径' ,
    `name` VARCHAR(255) NOT NULL   COMMENT '菜单名称' ,
    `permission` VARCHAR(255)    COMMENT '菜单权限标识' ,
    `path` VARCHAR(255)    COMMENT '前端UI路径' ,
    `icon` VARCHAR(255)    COMMENT '图标' ,
    `sort_order` VARCHAR(255)    COMMENT '排序值' ,
    `keep_alive` VARCHAR(255)   DEFAULT 1 COMMENT '0-开启，1- 关闭' ,
    `type` INT(10)    COMMENT '类型 （0菜单 1按钮）' ,
    `menu_type` INT(10)    COMMENT '菜单类型（0 元对象 1 代码）' ,
    `menu_config` TEXT    COMMENT '菜单配置' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '菜单表';

DROP TABLE IF EXISTS cat4j_user_role;
CREATE TABLE cat4j_user_role(
    `user_id` bigint(64) NOT NULL   COMMENT '用户id' ,
    `role_id` bigint(64) NOT NULL   COMMENT '角色id' ,
    PRIMARY KEY (user_id,role_id)
)  COMMENT = '用户角色表';

DROP TABLE IF EXISTS cat4j_icon;
CREATE TABLE cat4j_icon(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `type` INT(10)    COMMENT '类型' ,
    `key` VARCHAR(255)    COMMENT '图标标识' ,
    `value` TEXT    COMMENT '图标名称' ,
    `created_time` DATETIME    COMMENT '创建时间' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '图标表';
-- ================================================== 初始化表 end ==================================================


/* --------------- 创建表 --------------- */
DROP TABLE IF EXISTS cat4j_meta_object;
CREATE TABLE cat4j_meta_object(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `name` VARCHAR(255) NOT NULL   COMMENT '元对象名称' ,
    `code` VARCHAR(255) NOT NULL   COMMENT '元对象编码' ,
    `pk_name` VARCHAR(255)    COMMENT '主键值' ,
    `type` INT(10) NOT NULL  DEFAULT 1 COMMENT '类型:0=视图,1=表' ,
    `data_source` VARCHAR(255) NOT NULL   COMMENT '数据源' ,
    `single_flag` tinyint(1) NOT NULL  DEFAULT 1 COMMENT '是否单选' ,
    `first_load_flag` tinyint(1) NOT NULL  DEFAULT 0 COMMENT '是否初始加载' ,
    `show_line_number_flag` tinyint(1) NOT NULL  DEFAULT 1 COMMENT '是否显示行号' ,
    `detail_model_flag` tinyint(1) NOT NULL  DEFAULT 0 COMMENT '是否详细模式' ,
    `filter` VARCHAR(255)    COMMENT '初始数据过滤条件' ,
    `default_order` VARCHAR(255)    COMMENT '默认排序字段(desc)' ,
    `table_name` VARCHAR(255) NOT NULL   COMMENT '表名称' ,
    `interceptor` VARCHAR(255)    COMMENT '拦截器' ,
    `config` TEXT   DEFAULT NULL COMMENT '元对象配置' ,
    `created_time` DATETIME    COMMENT '创建时间' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '元对象';
DROP TABLE IF EXISTS cat4j_meta_field;
CREATE TABLE cat4j_meta_field(
    `id` bigint(64) NOT NULL   COMMENT '主键' ,
    `meta_object_id` bigint(64) NOT NULL   COMMENT '所属元对象' ,
    `meta_object_code` VARCHAR(255) NOT NULL   COMMENT '所属元对象编码' ,
    `order` INT(10) NOT NULL  DEFAULT 0 COMMENT '序号' ,
    `code` VARCHAR(255) NOT NULL   COMMENT '字段' ,
    `name` VARCHAR(255) NOT NULL   COMMENT '字段名称' ,
    `filed_type` VARCHAR(255) NOT NULL   COMMENT '字段类型' ,
    `show_flag` tinyint(1) NOT NULL  DEFAULT 1 COMMENT '是否显示' ,
    `query_flag` tinyint(1) NOT NULL  DEFAULT 0 COMMENT '是否查询' ,
    `add_status` VARCHAR(255) NOT NULL  DEFAULT 0 COMMENT '新增状态:0=正常,10=只读,20=隐藏,50=禁用' ,
    `update_status` VARCHAR(255) NOT NULL  DEFAULT 0 COMMENT '修改状态:0=正常,10=只读,20=隐藏,50=禁用' ,
    `order_flag` tinyint(1) NOT NULL  DEFAULT 0 COMMENT '是否可排序' ,
    `disable_flag` tinyint(1) NOT NULL  DEFAULT 0 COMMENT '是否禁用' ,
    `required_flag` tinyint(1) NOT NULL  DEFAULT 1 COMMENT '是否必填' ,
    `multiple_flag` VARCHAR(255) NOT NULL  DEFAULT 0 COMMENT '是否多选项' ,
    `exp` VARCHAR(255)    COMMENT '组件表达式' ,
    `placeholder` VARCHAR(255)    COMMENT '输入提示' ,
    `tips` TEXT    COMMENT '点击小提示' ,
    `validator` VARCHAR(255)    COMMENT 'UI校验器' ,
    `default` VARCHAR(255)    COMMENT '默认值' ,
    `format` TEXT    COMMENT '格式化' ,
    `width` VARCHAR(255) NOT NULL  DEFAULT 120 COMMENT '宽度' ,
    `height` VARCHAR(255) NOT NULL  DEFAULT 30 COMMENT '高度' ,
    `config` VARCHAR(255)    COMMENT '扩展配置' ,
    `created_time` DATETIME    COMMENT '创建时间' ,
    `create_by` bigint(64) NOT NULL   COMMENT '创建人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_by` bigint(64)    COMMENT '更新人' ,
    `re_version` INT(10)   DEFAULT 0 COMMENT '乐观锁' ,
    `hide` tinyint(1)   DEFAULT 0 COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
)  COMMENT = '元字段';
/* --------------- 修改表 --------------- */
-- 修改表：cat4j_menu[菜单表]
-- 添加字段：
ALTER TABLE cat4j_menu
    ADD COLUMN `code` VARCHAR(255) NOT NULL COMMENT '菜单编码;' AFTER name;
