create table web
(
    id       int auto_increment comment 'id'
        primary key,
    username varchar(64)  not null comment '用户名',
    password varchar(64)  not null comment '密码',
    nickname varchar(64)  not null comment '昵称',
    web_name varchar(64)  not null comment '网站名',
    domain   varchar(64)  not null comment '域名',
    avatar   varchar(255) not null comment ' 头像',
    keywords varchar(255) not null comment '关键词',
    motto    varchar(64)  not null comment '座右铭',
    cover    varchar(255) not null comment '网站封面图'
)
    comment '网站信息表';

INSERT INTO blog.web (id, username, password, nickname, web_name, domain, avatar, keywords, motto, cover)
 VALUES (1, 'admin', '******', 'ScorpioDong', 'ScorpioDong的个人小站', 'http://www.scorpiodong.cn',
  '/assets/img/pika.jpeg', 'ScorpioDong', '从忙碌中挤出时间，只为让自己更强大', '/assets/img/cover/cover9.jpg');

create table sort
(
    id          int auto_increment comment 'id'
        primary key,
    name        varchar(64)  not null comment '分类名',
    description varchar(255) not null comment '分类描述'
)
    comment '分类表';

INSERT INTO blog.sort (id, name, description) VALUES (1, '杂项', '未分类');
INSERT INTO blog.sort (id, name, description) VALUES (2, 'Java', 'Java学习笔记');
INSERT INTO blog.sort (id, name, description) VALUES (3, 'MySQL', 'MySQL学习笔记');
INSERT INTO blog.sort (id, name, description) VALUES (4, '杂记', '记录生活');

create table blog
(
    id          int auto_increment comment 'id'
        primary key,
    sort_id     int          not null comment '分类id',
    title       varchar(64)  not null comment '题目',
    description varchar(255) not null comment '描述',
    content     text         not null comment '内容',
    cover       varchar(255) not null comment '封面图',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '更新时间'
)
    comment '博客表';
