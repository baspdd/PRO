select s.StudentID, (s.FirstName+' '+s.LastName) as FullName, s.DateOfBirth,s.PlaceOfBirth,s.DeptID,s.Scholarship from Students s 
WHERE Scholarship <=160000
order by Scholarship desc
