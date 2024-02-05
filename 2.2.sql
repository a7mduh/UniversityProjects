---------------------------------2.2A------------------------------------------------
--This query assumes that the grading letters are the same as KU's grading system.
SELECT
  students.FirstName|| ' ' || students.LastName AS FullName,
  students.GPA
FROM students
JOIN enrollments ON students.StudentID = enrollments.StudentID
JOIN courses ON enrollments.CourseID = courses.CourseID
WHERE (courses.CourseID = 101 AND enrollments.Grade = 'A')
OR (courses.CourseID = 101 AND enrollments.Grade = 'A-')
OR  (courses.CourseID = 101 AND enrollments.Grade = 'B+');

---------------------------------2.2B------------------------------------------------
--This query assumes that the grading letters are the same as KU's grading system.
SELECT
    c.CourseName,
    AVG(CASE
        WHEN e.Grade = 'A' THEN 4.0
        WHEN e.Grade = 'A-' THEN 3.7
        WHEN e.Grade = 'B+' THEN 3.3
        WHEN e.Grade = 'B' THEN 3.0
        WHEN e.Grade = 'B-' THEN 2.7
        WHEN e.Grade = 'C+' THEN 2.3
        WHEN e.Grade = 'C' THEN 2.0
    	WHEN e.Grade = 'C-' THEN 1.7
    END) AS AverageGrade
FROM
    Courses c
JOIN
    Enrollments e ON c.CourseID = e.CourseID
GROUP BY
    c.CourseName
ORDER BY
    AverageGrade DESC
FETCH FIRST 1 ROWS ONLY;
---------------------------------2.2C------------------------------------------------
SELECT FirstName, LastName
FROM Students
WHERE StudentID NOT IN (SELECT DISTINCT StudentID FROM Enrollments);

---------------------------------2.2D------------------------------------------------
UPDATE Students s
SET s.GPA = (SELECT AVG(
                    CASE e.Grade
                        WHEN 'A' THEN 4.0
                        WHEN 'A-' THEN 3.7
                        WHEN 'B+' THEN 3.3
                        WHEN 'B' THEN 3.0
                        WHEN 'B-' THEN 2.7
                        WHEN 'C+' THEN 2.3
                        WHEN 'C' THEN 2.0
                        WHEN 'C-' THEN 1.7
                        WHEN 'D' THEN 1.0
                        ELSE 0.0
                    END)
          FROM Enrollments e
          WHERE e.CourseID = 101)
WHERE s.StudentID IN (SELECT StudentID FROM Enrollments WHERE CourseID = 101);


select * from students;

---------------------------------2.2E------------------------------------------------
--In this query, we followed Dr. Nouf instruction to put one more column in the table that is named MaxEnrollment
ALTER TABLE Courses ADD MaxEnrollment INT;
INSERT INTO Courses (CourseID, CourseName, Instructor, MaxEnrollment)
VALUES (106, 'Physics', 'Dr. Fisher',30);

---------------------------------2.2F------------------------------------------------
DELETE FROM Enrollments
WHERE CourseID = 105;
DELETE FROM Courses
WHERE CourseID = 105;

---------------------------------2.2G------------------------------------------------
SELECT StudentID, FirstName, LastName, GPA
FROM (
    SELECT s.StudentID, s.FirstName, s.LastName, s.GPA
    FROM Students s
    ORDER BY s.GPA DESC
)
WHERE ROWNUM <= 3;

---------------------------------2.2G------------------------------------------------
SELECT c.CourseID, c.CourseName, COUNT(e.StudentID) AS EnrollmentCount
FROM Courses c
JOIN Enrollments e ON c.CourseID = e.CourseID
GROUP BY c.CourseID, c.CourseName
ORDER BY EnrollmentCount DESC
FETCH FIRST 1 ROW ONLY;

---------------------------------2.2I------------------------------------------------
WITH enrolled_in_multiple_courses AS (
    SELECT
        e.StudentID,
        COUNT(*) AS NumberOfCoursesEnrolledIn
    FROM Enrollments e
    GROUP BY e.StudentID
    HAVING COUNT(*) > 1
)

SELECT
    AVG(CAST(s.Age AS NUMBER)) AS AvgAge
FROM Students s
JOIN enrolled_in_multiple_courses m ON s.StudentID = m.StudentID;

