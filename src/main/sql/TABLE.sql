CREATE TABLE IF NOT EXISTS sys_role
(
  sys_role_id varchar(20) NOT NULL
    PRIMARY KEY,
  name        varchar(30) NULL
);

CREATE TABLE IF NOT EXISTS sys_user
(
  sys_user_id varchar(20) NOT NULL
    PRIMARY KEY,
  name        varchar(40) NOT NULL COMMENT '用户名'
)
  COMMENT '用户表';

CREATE TABLE IF NOT EXISTS sys_user_role_rel
(
  sys_user_id varchar(20) NOT NULL,
  sys_role_id varchar(20) NOT NULL,
  PRIMARY KEY (sys_user_id, sys_role_id)
);

