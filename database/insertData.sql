use newservlet_t3_2022;
insert into role (code, name) values ('ADMIN', 'Quản trị hệ thống');
insert into role (code, name) values ('USER', 'người dùng');
select * from role;
insert into user (userName,password, fullname,role_id, status) values ('admin', '123456', 'admin',1,1);
insert into user (userName, password, fullname,role_id, status) values ('nguyenvana','123456', 'Nguyễn văn A',2,1);
insert into user (userName, password, fullname,role_id, status) values ('nguyenvanb','123456', 'Nguyễn văn B',2,1);
select * from user where userName = ? and password = ?;
select * from news;
select * from comment;
select * from category;
insert into comment(content, user_id, news_id)
values ('công trường',2,7);
select * from news LIMIT 5,2;
select * from news order by title DESC  ;

select * from news  order by title desc  limit 0,2 ;
select * from user as u inner join role as r on u.role_id = r.id where userName = 'admin' and password = '123456' and status = 1;