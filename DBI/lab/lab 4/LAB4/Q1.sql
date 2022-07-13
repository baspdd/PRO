--Tạo bảng Students
drop table Students
create table Students
(
StudentID varchar(4),
LastName Nvarchar(30),
FirstName Nvarchar(20),
Sex varchar(1) check (Sex in ('F','M')),
DateOfBirth date,
PlaceOfBirth Nvarchar(30),
DeptID varchar(4) references Departments(DeptID),
Scholarship float,
AverageScore numeric (4,2),
constraint PK_Stud primary key (StudentID)
)

create table Courses
(
CourseID varchar(4),
Name Nvarchar(35),
Credits tinyint
constraint PK_Cour primary key (CourseID) 
)

--Tạo bảng Deptpartments
create table Departments
(
DeptID varchar(4),
Name Nvarchar(50) not null,
NoOfStudents int,
constraint PK_Dept primary key (DeptID)
)

--Tạo bảng Results

create table Results
(
StudentID varchar(4),
CourseID varchar(4),
[Year] int,
Semester int,
Mark float,
Grade varchar(6)
constraint PK_Results primary key (StudentID,CourseID,[Year],Semester)
)

-- Nhập liệu cho bảng Depts
insert into Departments(DeptID,Name) values ('IS','Information System');
insert into Departments(DeptID,Name) values ('NC','Network and Communication');
insert into Departments(DeptID,Name) values ('SE','Software Engineering');
insert into Departments(DeptID,Name) values ('CE','Computer Engineering');
insert into Departments(DeptID,Name) values ('CS','Computer Science');

--Nhập liệu cho bảng Students
insert into Students values ('S001',N'Lê',N'Kim Lan','F','1990/02/23',N'Hà Nội','IS','130000',null);
insert into Students values ('S002',N'Trần',N'Minh Chánh','M','1992/12/24',N'Bình Định','NC','150000',null);
insert into Students values ('S003',N'Lê',N'An Tuyết','F','1991/02/21',N'Hải Phòng','IS','170000',null);
insert into Students values ('S004',N'Trần',N'Anh Tuấn','F','1993/12/20',N'TpHCM','NC','80000',null);
insert into Students values ('S005',N'Trần',N'Thị Mai','F','1991/08/12',N'TpHCM','SE','0',null);
insert into Students values ('S006',N'Lê',N'Thị Thu Thủy','F','1991/01/02',N'An Giang','IS','0',null);
insert into Students values ('S007',N'Nguyễn',N'Kim Thư','F','1990/02/02',N'Hà Nội','SE','180000',null);
insert into Students values ('S008',N'Lê',N'Văn Long','M','1992/12/08',N'TpHCM','IS','190000',null);


--Nhập liệu cho bảng Courses
insert into Courses values('DS01','Database System','3');
insert into Courses values('AI01','Artificial Intellitence','3');
insert into Courses values('CN01','Computer Network','3');
insert into Courses values('CG01','Computer Graphics','4');
insert into Courses values('DSA1','Data Structures and Algorithms','4');

--Nhập liệu cho bảng Results
--Phần này dùng lệnh thì sẽ nhanh hơn gõ tay
insert into Results values('S001','DS01','2017','1','3',null);
insert into Results values('S001','DS01','2017','2','6',null);
insert into Results values('S001','AI01','2017','1','4.5',null);
insert into Results values('S001','AI01','2017','2','6',null);
insert into Results values('S001','CN01','2017','3','5',null);
insert into Results values('S002','DS01','2016','1','4.5',null);
insert into Results values('S002','DS01','2017','1','7',null);
insert into Results values('S002','CN01','2016','3','10',null);
insert into Results values('S002','DSA1','2016','3','9',null);
insert into Results values('S003','DS01','2017','1','2',null);
insert into Results values('S003','DS01','2017','3','5',null);
insert into Results values('S003','CN01','2017','2','2.5',null);
insert into Results values('S003','CN01','2017','3','4',null);
insert into Results values('S004','DS01','2017','3','4.5',null);
insert into Results values('S004','DSA1','2018','1','10',null);
insert into Results values('S005','DS01','2017','2','7',null);
insert into Results values('S005','CN01','2017','2','2.5',null);
insert into Results values('S005','DS01','2018','1','5',null);
insert into Results values('S006','AI01','2018','1','6',null);
insert into Results values('S006','CN01','2018','2','10',null);