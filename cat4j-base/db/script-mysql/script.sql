create table if not exists cat4j_dict
(
    id          bigint                               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    dict_key    varchar(255)                         not null comment '标识',
    description varchar(255)                         null comment '描述',
    sys_flag    tinyint(1)                           not null comment '是否是系统内置',
    create_by   bigint                               not null comment '创建人',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                               null comment '更新人',
    update_time datetime                             null comment '更新时间',
    re_version  int                                  null comment '乐观锁',
    hide        tinyint(1) default 0                 null comment '逻辑删除'
)
    comment '字典表';

create table if not exists cat4j_dict_item
(
    id          bigint                               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    dict_id     varchar(255)                         not null comment '字典ID',
    dict_key    varchar(255)                         not null comment '字典标识',
    value       varchar(255)                         not null comment '值',
    label       varchar(255)                         not null comment '标签',
    type        varchar(255)                         null comment '字典类型',
    description varchar(255)                         null comment '描述',
    sort_order  int                                  null comment '排序（升序）',
    remark      varchar(255)                         null comment '备注',
    create_by   bigint                               not null comment '创建人',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                               null comment '更新人',
    update_time datetime                             null comment '更新时间',
    re_version  int                                  null comment '乐观锁',
    hide        tinyint(1) default 0                 null comment '逻辑删除'
)
    comment '字典明细';

create index cat4j_dict_label
    on cat4j_dict_item (label);

create index cat4j_dict_value
    on cat4j_dict_item (value);

create table if not exists cat4j_log
(
    id          bigint                               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    type        int        default 1                 null comment '日志类型',
    title       varchar(255)                         null comment '日志标题',
    service_id  varchar(255)                         null comment '服务ID',
    remote_addr varchar(255)                         null comment 'ip地址',
    user_agent  varchar(255)                         null comment '用户代理',
    request_uri varchar(255)                         null comment '请求URI',
    method      varchar(255)                         null comment '操作方式',
    params      varchar(255)                         null comment '操作提交的数据',
    time        int                                  null comment '执行时间',
    create_by   bigint                               not null comment '创建人',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                               null comment '更新人',
    update_time datetime                             null comment '更新时间',
    re_version  int                                  null comment '乐观锁',
    hide        tinyint(1) default 0                 null comment '逻辑删除'
)
    comment '系统日志';

create index cat4j_log_create_by
    on cat4j_log (create_by);

create index cat4j_log_create_date
    on cat4j_log (create_time);

create index cat4j_log_request_uri
    on cat4j_log (request_uri);

create index cat4j_log_type
    on cat4j_log (type);

create table if not exists cat4j_menu
(
    id          bigint                                 not null comment '菜单id'
        constraint `PRIMARY`
        primary key,
    parent_id   varchar(255)                           not null comment '父菜单ID',
    tree_path   varchar(255)                           null comment '菜单路径',
    code        varchar(255)                           not null,
    name        varchar(255)                           not null comment '菜单名称',
    permission  varchar(255)                           null comment '菜单权限标识',
    path        varchar(255)                           null comment '前端UI路径',
    icon        varchar(255)                           null comment '图标',
    sort_order  varchar(255)                           null comment '排序值',
    keep_alive  varchar(255) default '1'               null comment '0-开启，1- 关闭',
    type        int                                    null comment '类型 （0菜单 1按钮）',
    menu_type   int                                    null comment '菜单类型（0 元对象 1 代码）',
    menu_config text                                   null comment '菜单配置',
    create_by   bigint                                 not null comment '创建人',
    create_time datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                                 null comment '更新人',
    update_time datetime                               null comment '更新时间',
    re_version  int                                    null comment '乐观锁',
    hide        tinyint(1)   default 0                 null comment '逻辑删除'
)
    comment '菜单表';

create table if not exists cat4j_organization
(
    id          bigint                               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    parent_id   bigint                               not null comment '父节点',
    org_name    varchar(255)                         not null comment '组织架构名称',
    path        varchar(900)                         not null comment '路径',
    create_by   bigint                               not null comment '创建人',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                               null comment '更新人',
    update_time datetime                             null comment '更新时间',
    re_version  int                                  null comment '乐观锁',
    hide        tinyint(1) default 0                 null comment '逻辑删除'
)
    comment '组织架构';

create table if not exists cat4j_role
(
    id          bigint                               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    role_name   varchar(255)                         not null comment '角色名称',
    role_code   varchar(255)                         not null comment '角色代码',
    role_desc   varchar(255)                         null comment '角色描述',
    create_by   bigint                               not null comment '创建人',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                               null comment '更新人',
    update_time datetime                             null comment '更新时间',
    re_version  int                                  null comment '乐观锁',
    hide        tinyint(1) default 0                 null comment '逻辑删除',
    constraint role_idx1_role_code
        unique (role_code)
)
    comment '角色表';

create table if not exists cat4j_role_menu
(
    role_id bigint not null comment '角色ID',
    menu_id bigint not null comment '菜单ID',
    constraint `PRIMARY`
        primary key (role_id, menu_id)
)
    comment '角色权限表';

create table if not exists cat4j_user
(
    id           bigint               not null comment '主键'
        constraint `PRIMARY`
        primary key,
    login_id     varchar(255)         not null comment '账号',
    login_pwd    varchar(255)         not null comment '密码',
    user_name    varchar(64)          not null comment '用户名',
    org_id       bigint               not null comment '所属组织',
    salt         varchar(255)         null comment '随机盐',
    avatar       varchar(255)         null comment '头像',
    phone_number varchar(255)         null comment '手机号码',
    email        varchar(255)         null comment '邮箱',
    introduction varchar(255)         null comment '简介',
    lock_flag    int        default 0 not null comment '锁定标识:0=正常,1=锁定',
    create_by    bigint               not null comment '创建人',
    create_time  datetime             not null comment '创建时间',
    update_by    bigint               null comment '更新人',
    update_time  datetime             null comment '更新时间',
    re_version   int                  null comment '乐观锁',
    hide         tinyint(1) default 0 null comment '逻辑删除'
)
    comment '用户表';

create table if not exists cat4j_user_role
(
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色id',
    constraint `PRIMARY`
        primary key (user_id, role_id)
)
    comment '用户角色表';


-- ================================================== 初始化表 end ==================================================