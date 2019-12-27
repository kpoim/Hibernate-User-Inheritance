CREATE SCHEMA hibernate_inheritance DEFAULT CHAR SET utf8mb4;
USE hibernate_inheritance;

CREATE TABLE user (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(68)
);
INSERT INTO user(username, password) VALUES
('admin', '$2y$12$IsEt/FjyQw3f9JSQZueodOFlbhviHMh9rIgbCycLXe3.5NUbcyf8W');
# above password == 1234

CREATE TABLE client (
	id INT UNSIGNED PRIMARY KEY,
    clientid INT UNSIGNED NOT NULL
);

CREATE TABLE admin (
	id INT UNSIGNED PRIMARY KEY,
	adminfname VARCHAR(50),
    adminlname VARCHAR(50),
    adminphone VARCHAR(20)
);
INSERT INTO admin VALUES
(1, 'Nick', 'Nickolson', '08286027');

CREATE TABLE employee (
	id INT UNSIGNED PRIMARY KEY,
	empfname VARCHAR(50),
    emplname VARCHAR(50),
    empphone VARCHAR(20)
);

CREATE TABLE role(
    rid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    rname VARCHAR(30),
    UNIQUE(rname)
);

INSERT INTO role(rname) VALUES
('ROLE_CLIENT'),
('ROLE_EMPLOYEE'),
('ROLE_ADMIN');

CREATE TABLE user_role(
    uid INT UNSIGNED,
    rid INT UNSIGNED,
    PRIMARY KEY(uid, rid),
    CONSTRAINT userrolefk1 FOREIGN KEY (uid) REFERENCES user(id),
    CONSTRAINT userrolefk2 FOREIGN KEY (rid) REFERENCES role(rid)
);
INSERT INTO user_role VALUES
(1, 3);

-- SELECT * FROM user;
-- SELECT * FROM client;
-- SELECT * FROM employee;
-- SELECT * FROM admin;
-- SELECT * FROM role;
-- SELECT * FROM user_role;
-- SELECT * FROM user u, role r, user_role ur
-- WHERE u.id = ur.uid AND r.rid = ur.rid;