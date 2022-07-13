create table Teachers(
	TeacherID int primary key,
	Name nvarchar(50),
	Gender char(1),
	Address nvarchar(200)
)

create table Classes(
	ClassID int primary key,
	year int,
	Semester char(10),
	NoCredits int,
	courseID char(6),
	GroupID char(6),
	TeacherID int foreign key references Teachers(TeacherID)
)

create table Students(
	StudentID int primary key,
	Name nvarchar(50),
	Address nvarchar(200),
	Gender char(1) check (Gender in ('F','M')),
)

create table Attend(
	Date date,
	Slot bit,
	Attend bit,
	StudentID int foreign key references Students(StudentID),
	ClassID int foreign key references Classes(ClassID),
	primary key(Date, Slot, StudentID, ClassID)
)
