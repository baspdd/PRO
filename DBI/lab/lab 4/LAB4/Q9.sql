
SELECT  
		Distinct
		Students.[StudentID]
      ,[LastName]
      ,[FirstName]
      ,[Sex]
      ,[DateOfBirth]
      ,[PlaceOfBirth]
      , Students.[DeptID]
      ,[Scholarship]
      ,[AverageScore] FROM Students
INNER JOIN Departments on Departments.DeptID = Students.DeptID
INNER JOIN Results on Results.StudentID = Students.StudentID
WHERE Departments.Name <> 'Information System' and Results.Mark > any (SELECT Results.Mark FROM Students
INNER JOIN Departments on Departments.DeptID = Students.DeptID
INNER JOIN Results on Results.StudentID = Students.StudentID
WHERE Departments.Name  = 'Information System')
