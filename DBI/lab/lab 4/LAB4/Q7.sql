SELECT Students.StudentID,
		Students.LastName,
		Students.FirstName,
		count (Results.CourseID) as NumberOfCourses
		 FROM Students
INNER JOIN Results on Results.StudentID = Students.StudentID
GROUP BY Students.StudentID,
		Students.LastName,
		Students.FirstName
ORDER BY NumberOfCourses asc
