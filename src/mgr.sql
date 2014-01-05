show variables like "character%";
show variables like "collation_%";

set character_set_client = utf8;
set character_set_connection = utf8;
set character_set_database = utf8;
set character_set_results = utf8;
set character_set_server = utf8;

create database mgr;
use mgr;

create table user (
	id int auto_increment primary key,
	userid varchar(32),
	userpwd varchar(32),
	username varchar(32),
	userphone bigint,
	userdesc varchar(128)
)engine=InnoDB default charset=utf8;

insert into user(userid, userpwd, username, userphone, userdesc) values("zouxiang", "000000", "邹翔", 0, null);

create table emp (
	id int auto_increment primary key,
	empid varchar(32),
	empname varchar(32),
	empsex varchar(32),
	icid varchar(32),
	eplace varchar(8),
	empphone varchar(32),
	empbirth varchar(16),
	empedu varchar(32),
	empqq varchar(32),
	emptech varchar(32),
	deptid varchar(16),
	emppost varchar(32),
	elinkman varchar(32),
	elinkphone varchar(32),
	empaddr varchar(32),
	empin varchar(32),
	empout varchar(32)
)engine=InnoDB default charset=utf8;

create table dept (
	id int auto_increment primary key,
	deptid varchar(32),
	deptparent varchar(32),
	deptname varchar(32),
	deptmgr varchar(32)
)engine=InnoDB default charset=utf8;

create table post (
	id int auto_increment primary key,
	postid varchar(32),
	postname varchar(32),
	postctn varchar(128),
	deptid varchar(32)
)engine=InnoDB default charset=utf8;

show tables;
desc user;
desc emp;
select * from user;
select * from emp;

