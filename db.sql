drop database if exists qlsv;
create database  qlsv;
use  qlsv;
create table Student(
                        id int primary key  auto_increment,
                        name varchar(255),
                        age int,
                        gen bit,
                        address varchar(255)
);
insert into Student(name,age,gen, address) values
                                               ('Chã đẹp chai',19,0,'Hà Lội'),
                                               ('Hùng hx',18,1,'Nghệ An'),
                                               ('Tuấn Anh',90,1,'Hà Lội');
delimiter //
create procedure PROC_GETALL()
begin
select * from Student;
end //;
delimiter //
create procedure PROC_CREATESTUDENT(nameNew varchar(255),ageNew int, genNew bit, addressNew varchar(255))
begin
INSERT INTO Student ( name, age, gen, address) values (nameNew,ageNew,genNew,addressNew);
end //;
delimiter //
create procedure PROC_DELETESTUDENT(idDel int)
begin
delete  from  Student where  id =idDel;
end //;
delimiter //
create procedure PROC_UPDATESTUDENT(idUp int,nameUp varchar(255),ageUp int, genUp bit, addressUp varchar(255))
begin
UPDATE Student set name =nameUp, age=ageUp,gen =genUp,address=addressUp where  id =idUp;
end //;
create procedure PROC_FINDBYID(idSearch int )
begin
select * from Student where id = idSearch;
end //;
create procedure PROC_SEARCHBYNAME(nameSearch varchar(255) )
begin
select * from Student where name like concat('%',nameSearch,'%');
end //;
create table Accounts(
                         id int primary key auto_increment,
                         username varchar(255) unique ,
                         password varchar(100),
                         role tinyint default(0)
);
insert into Accounts(username, password,role) values
                                                  ('admin123','123456',1),
                                                  ('hung123','123456',0);

delimiter //
create procedure PROC_LOGIN(user varchar(255),pass varchar(100))
begin
SELECT * from Accounts where username like user and password like pass;
end //;
create procedure PROC_REGISTER(user varchar(255),pass varchar(100))
begin
INSERT INTO Accounts(username, password) value (user,pass);
end //;
create procedure PROC_FINDBYUSERNAME(user varchar(255))
begin
select * from Accounts where username like user;
end //;