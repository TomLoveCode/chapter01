
-- login表
create table login if not exists
(
 id int(12) auto_increment not null primary key
 username varchar(12) not null
 password  varchar(12) not null
)