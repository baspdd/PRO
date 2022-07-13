
SELECT a.DeptID,a.Name,a.NumberOfFemaleStudents,b.NumberOfMaleStudents FROM (SELECT Departments.DeptID,
		Departments.Name,
		count(Students.StudentID) as NumberOfFemaleStudents
		 FROM Departments
INNER  JOIN Students on Students.DeptID = Departments.DeptID
WHERE Students.Sex = 'F'
group by Departments.DeptID,
		Departments.Name ) as a 
left join (SELECT Departments.DeptID,
		Departments.Name,
		count(Students.StudentID) as NumberOfMaleStudents
		 FROM Departments
INNER JOIN Students on Students.DeptID = Departments.DeptID
WHERE Students.Sex = 'M'
group by Departments.DeptID,
		Departments.Name ) as b on a.DeptID = b.DeptID
