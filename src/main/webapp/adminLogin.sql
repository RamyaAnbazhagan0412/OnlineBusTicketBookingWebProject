CREATE TABLE admin_login1
(
admin_id INT AUTO_INCREMENT PRIMARY KEY,
admin_emailId VARCHAR(100) NOT NULL UNIQUE,
PASSWORD VARCHAR(100)NOT NULL UNIQUE

);
INSERT INTO admin_login1(admin_emailId,PASSWORD)VALUES('ramya@gmail.com','123ramya');
DROP TABLE admin_login1;
SELECT *FROM admin_login1;
