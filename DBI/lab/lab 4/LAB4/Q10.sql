
SELECT Courses.CourseID,
		Courses.Name ,
		Students.LastName + ' ' + Students.FirstName as BestStudentFullName,
		Results.Mark
		FROM Courses 
INNER JOIN Results on Results.CourseID = Courses.CourseID
INNER JOIN Students on Students.StudentID =  Results.StudentID
inner JOIN (SELECT
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name  ) as a on a.CourseID = Courses.CourseID
WHERE Results.Mark = a.maxMark
GROUP BY  Courses.CourseID,
	    	Courses.Name ,
			Students.LastName + ' ' + Students.FirstName,
				Results.Mark

