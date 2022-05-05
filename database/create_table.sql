use newservlet_t3_2022;

create table role(
                     id bigint not null primary key auto_increment,
                     name varchar(255) not null,
                     code varchar(255) not null,
                     createddate timestamp null,
                     modifieddate timestamp null,
                     createdby varchar(255) null,
                     modifiedby varchar(255) null
) ;

create table user(
                     id bigint not null primary key auto_increment,
                     userName varchar(255) not null,
                     password varchar(255) not null,
                     fullname varchar(255) not null,
                     status int not null,
                     role_id bigint not null,
                     createddate timestamp null,
                     modifieddate timestamp null,
                     createdby varchar(255) null,
                     modifiedby varchar(255) null
);

alter table user add constraint fk_role_user foreign key (role_id) references role(id);

create table news(
                     id bigint not null primary key auto_increment,
                     title varchar (255) null,
                     thumbnail varchar(255) null,
                     sort_descri text null,
                     content text null,
                     category_id bigint not null,
                     createddate timestamp null,
                     modifieddate timestamp null,
                     createdby varchar(255) null,
                     modifiedby varchar(255) null
);
create table category(
                         id bigint not null primary key auto_increment,
                         name varchar(255) not null,
                         code varchar(255) not null,
                         createddate timestamp null,
                         modifieddate timestamp null,
                         createdby varchar(255) null,
                         modifiedby varchar(255) null
);
alter table news add constraint fk_news_category foreign key (category_id) references category(id);

create table comment(
                        id bigint not null primary key auto_increment,
                        content text null,
                        user_id bigint not null,
                        news_id bigint not null,
                        createddate timestamp null,
                        modifieddate timestamp null,
                        createdby varchar(255) null,
                        modifiedby varchar(255) null
);
alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);

alter table comment add constraint fk_comment_news foreign key (news_id) references news(id);

insert into news(title,category_id)
values ('Bài viết 1',1),
       ('Bài viết 2',2),
       ('Bài viết 3',3);
select * from news where category_id = 1;
select * from category;
delete  from news where category_id = 1;
alter table news AUTO_INCREMENT = 1;
update news set title = 'hello 123';


