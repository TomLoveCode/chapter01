
-- login表
create table login if not exists
(
 id int(12) auto_increment not null primary key
 username varchar(12) not null
 password  varchar(12) not null
)

-- 汽车信息表
Create table car(
#汽车表id
   cno nvarchar(10),
   cname nvarchar(50) not null,
   state int check(state=0 or state=1),
   remarks nvarchar(100),
   parkposition nvarchar(10),
	  primary key(cno),
	 CONSTRAINT foreign key (parkposition) references park(position)
);

-- 停车点表
Create table park(
  #停车点编号
  position nvarchar(10) primary key,
  address nvarchar(10) not null
);

select * from park;
-- 停车点录入
insert into park(position,address) values ('100','常德市湖南文理学院');
insert into park(position,address) values ('101','常德市万达广场');
insert into park(position,address) values ('102','常德市火车站');
insert into park(position,address) values ('103','常德市常南汽车总站');
insert into park(position,address) values ('104','常德市应用技术学院');
insert into park(position,address) values ('105','常德市教育局');
insert into park(position,address) values ('106','常德市职业技术学院');
insert into park(position,address) values ('107','常德市博物馆');

 select * from car;
/*给汽车信息表录入信息*/
insert into car(cno,cname,state,remarks,parkposition) values('湘J1000','宝马',0,'','100');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1001','保时捷',0,'','101');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1002','布加迪威龙',0,'','102');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1003','兰博基尼',0,'','103');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1004','法拉利',0,'','104');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1005','奥迪',0,'','105');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1006','奔驰',0,'','106');
insert into car(cno,cname,state,remarks,parkposition) values('湘J1007','红旗',0,'','107');

