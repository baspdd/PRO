-- C4:
update results
set Grade= 'Passed'
where (Mark>=5 and Mark<=10)
update results
set Grade= 'Failed'
WHERE(Mark<5)
