update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S001'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S001'


update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S002'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S002'





update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S003'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S003'



update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S004'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S004'




update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S005'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S005'

update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S006'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S006'

update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S007'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S007'

update Students
set AverageScore = (SELECT 
		avg(a.maxMark) as avgMark FROM (SELECT	
		Results.StudentID,
		Courses.CourseID,
		Courses.Name,
		max (Results.Mark) as maxMark
		FROM Courses
INNER JOIN Results on Results.CourseID = Courses.CourseID
GROUP BY  Courses.CourseID,
	    	Courses.Name,
			Results.StudentID) as a 
WHERE StudentID = 'S008'
GROUP BY a.StudentID 
)
WHERE StudentID = 'S008'

