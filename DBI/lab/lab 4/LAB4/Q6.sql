
SELECT Departments.DeptID,
		Departments.Name,
		Students.StudentID,
		Students.LastName,
		Students.FirstName
		 FROM Departments
LEFT JOIN Students on Students.DeptID = Departments.DeptID

