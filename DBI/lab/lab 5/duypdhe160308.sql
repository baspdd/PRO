create Database Lab5
go
Use Lab5

CREATE TABLE PHONGBAN(
TENPHG NVARCHAR(30),
MAPH VARCHAR(1) PRIMARY KEY,
TRPHG VARCHAR(9),
NG_NHANCHUC DATE
)

CREATE TABLE NHANVIEN(
HONV NVARCHAR(10) NOT NULL,
TENLOT NVARCHAR(10) NOT NULL,
TEN NVARCHAR(10) NOT NULL,
MANV VARCHAR(9) PRIMARY KEY,
NGSINH  DATE,
DCHI NVARCHAR(50),
PHAI VARCHAR(3),
LUONG INT,
MA_NQL VARCHAR(9) REFERENCES NHANVIEN(MANV),
PHG VARCHAR(1) REFERENCES PHONGBAN(MAPH)
)
--ALTER TABLE NHANVIEN ADD CONSTRAINT A FOREIGN KEY MA_NQL REFERENCES NHANVIEN(MANV)
CREATE TABLE DIADIEM_PHG(
MAPHG VARCHAR(1),
DIADIEM NVARCHAR(50),
primary key (MAPHG, DIADIEM)
)

CREATE TABLE THANNHAN(
MA_NVIEN VARCHAR(9) REFERENCES NHANVIEN(MANV),
TENTN NVARCHAR(10),
PHAI VARCHAR(3),
NGSINH DATE,
QUANHE NVARCHAR(10)
PRIMARY KEY(MA_NVIEN, TENTN)
)

CREATE TABLE DEAN(
TENDEAN NVARCHAR(30),
MADA VARCHAR(5) PRIMARY KEY,
DDIEM_DA NVARCHAR(50),
PHONG VARCHAR(1)
)

CREATE TABLE PHANCONG(
MA_NVIEN VARCHAR(9) REFERENCES NHANVIEN(MANV),
SODA VARCHAR(5) REFERENCES DEAN(MADA),
THOIGIAN FLOAT
PRIMARY KEY(MA_NVIEN, SODA)
)


INSERT INTO PHONGBAN(TENPHG, MAPH, TRPHG, NG_NHANCHUC) VALUES ('Nghien cuu', '5', '333445555', '1978/05/22')
INSERT INTO PHONGBAN(TENPHG, MAPH, TRPHG, NG_NHANCHUC) VALUES ('Dieu hanh', '4', '987987987', '1985/01/01')
INSERT INTO PHONGBAN(TENPHG, MAPH, TRPHG, NG_NHANCHUC) VALUES ('Quan ly', '1', '888665555', '1971/06/19')


INSERT INTO NHANVIEN(HONV, TENLOT, TEN, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG) VALUES ('Dinh', 'Ba', 'Tien', '123456789', '1955/01/09', '731 Tran Hung Dao,Q1,TPHCM', 'Nam', '30000', '333445555', '5')
, ('Nguyen', 'Thanh', 'Tung', '333445555', '1945/12/08', '638 Nguyen Van Cu,Q5,TPHCM', 'Nam', '40000', '888665555', '5')
, ('Bui', 'Thuy', 'Vu', '999887777', '1958/07/19', '332 Nguyen Thai Hoc,Q1,TPHCM', 'Nam', '25000', '987654321', '4')
, ('Le', 'Thi', 'Nhan', '987654321', '1931/06/20', '291 Ho Van Hue,QPN,TPHCM', 'Nu', '43000', '888665555', '4')
, ('Nguyen', 'Manh', 'Hung', '666884444', '1952/09/15', '975 Ba Ria, Vung Tau', 'Nam', '38000', '333445555', '5')
, ('Tran', 'Thanh', 'Tam', '453453453', '1962/07/31', '534 Mai Thi Luu,Q1,TPHCM', 'Nam', '25000', '333445555', '5')
, ('Tran', 'Hong', 'Quan', '987987987', '1959/03/29', '980Le Hong Phong,Q10,TPHCM', 'Nam', '25000', '987654321', '4')
, ('Vuong', 'Ngoc', 'Quyen', '888665555', '1927/10/10', '450 Trung Vuong, HaNoi', 'Nu', '55000', null, '1')

INSERT INTO DIADIEM_PHG(MAPHG, DIADIEM) VALUES ('1', 'TP HCM')
INSERT INTO DIADIEM_PHG(MAPHG, DIADIEM) VALUES ('4', 'HA NOI')
INSERT INTO DIADIEM_PHG(MAPHG, DIADIEM) VALUES ('5', 'VUNG TAU')
INSERT INTO DIADIEM_PHG(MAPHG, DIADIEM) VALUES ('5', 'NHA TRANG')
INSERT INTO DIADIEM_PHG(MAPHG, DIADIEM) VALUES ('5', 'TP HCM')

INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('333445555', 'Quang', 'Nu', '1976/04/05', 'Con gai')
INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('333445555', 'Khang', 'Nam', '1973/10/25', 'Con trai')
INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('333445555', 'Duong', 'Nu', '1948/05/03', 'Vo chong')
INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('987654321', 'Dang', 'Nam', '1932/02/29', 'Vo chong')
INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('123456789', 'Duy', 'Nam', '1978/01/01', 'Con trai')
INSERT INTO THANNHAN(MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE) VALUES ('123456789', 'Chau', 'Nu', '1978/12/31', 'Con gai')

INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('San pham X', '1', 'Vung Tau', '5')
INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('San pham Y', '2', 'Nha Trang', '5')
INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('San pham Z', '3', 'TP HCM', '5')
INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('Tin hoc hoa', '10', 'Ha Noi', '4')
INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('Cap quang', '20', 'TP HCM', '1')
INSERT INTO DEAN(TENDEAN, MADA, DDIEM_DA, PHONG) VALUES ('Dao tao', '30', 'Ha Noi', '4')

INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('123456789', '1', '32.5')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('123456789', '2', '7.5')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('666884444', '3', '40.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('453453453', '1', '20.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('453453453', '2', '20.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('333445555', '3', '10.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('333445555', '10', '10.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('333445555', '20', '10.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('999887777', '30', '30.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('999887777', '10', '10.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('987987987', '10', '35.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('987987987', '30', '5.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('987654321', '30', '20.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('987654321', '20', '15.0')
INSERT INTO PHANCONG(MA_NVIEN, SODA, THOIGIAN) VALUES ('888665555', '20', null)

-- P1

--Q1
create proc q1 @s date, @f date
as 
select *  from NHANVIEN where NGSINH between @s and @f
/**/exec q1 '1955-01-08', '1962-08-03'

--Q2
create proc q2
as 
select MANV, (HONV+' '+Tenlot+' '+Ten) as Ten, Luong from NHANVIEN join (SELECT AVG(Luong) avgS, PHG FROM dbo.NhanVien group by PHG) as new
on Nhanvien.PHG= new.phg
WHERE Luong > avgS
/**/exec q2

--Q3
create proc q3 @n int
as
select top(@n) * from Nhanvien
order by luong desc
/**/exec q3 5

--Q4
create proc q4 @city nvarchar(50)
as
begin
	update nhanvien set luong = luong*1.1 where phg in (select distinct maphg from diadiem_phg where diadiem=@city)
end
/**/exec q4 'TPHCM'


--q5
create proc q5
as
begin
	delete from diadiem_phg
	where diadiem_phg.maphg not in 
	(select distinct (nhanvien.phg) from nhanvien)
	delete from phongban
	where phongban.maphg not in 
	(select distinct (nhanvien.phg) from nhanvien)
end
/**/exec q5
------------P2------------

--Q1
create trigger trg_1
on nhanvien
after insert, update, delete
as
begin
	if
		(select AVG(luong) from nhanvien where nhanvien.phg=(select inserted.phg from inserted) or nhanvien.phg = (select deleted.phg from deleted)) >=50000
	begin
		rollback transaction
	end
end

--Q2
create trigger trg_2
on nhanvien
after insert, update
as
begin
	if (select luong from inserted) > (select luong from nhanvien where manv = (select trphg from phongban where maph= (select phg from inserted))) 
	begin
		rollback transaction
	end
end

--Q3
create trigger trg_3 on NhanVien
after delete, insert, update
as
begin
	if((select dchi from inserted) like '%Ha Noi%') or (select dchi from deleted) like '%Ha Noi%'
	begin 
		declare @salaryHN int
		select @salaryHN = avg(Luong) from NhanVien where Dchi like '%Ha Noi%'
		declare @salaryHCM int
		select @salaryHCM = avg(Luong) from NhanVien where Dchi like '%TPHCM%'
		if abs(@salaryHN - @salaryHCM) > 10000
		begin
			rollback transaction
		end
	end
	if((select dchi from inserted) like '%TPHCM%') or (select dchi from deleted) like '%TPHCM%'
	begin 
		declare @salaryHN1 int
		select @salaryHN1 = avg(Luong) from NhanVien where Dchi like '%Ha Noi%'
		declare @salaryHCM1 int
		select @salaryHCM1 = avg(Luong) from NhanVien where Dchi like '%TPHCM%'
		if abs(@salaryHN1 - @salaryHCM1) > 10000
		begin
			rollback transaction
		end
	end
end

--Q4
create trigger Insertemployee
on nhanvien
after insert
as
begin
	select CONCAT(honv,' ',tenlot,' ',ten) as 'Full Name', TENPHG from inserted join phongban on inserted.phg=phongban.maph
end
drop trigger Insertemployee
--Q5
create trigger trig_5 on NhanVien
after delete, insert, update
as
begin
	declare @male int
	select @male = count(phai) from NhanVien where phai='Nam'
	declare @female int
	select @female = count(phai) from NhanVien where phai='Nu'
	if @male / @female > = 0.1 or @female / @male > = 0.1
	begin
		rollback transaction
		end
end

