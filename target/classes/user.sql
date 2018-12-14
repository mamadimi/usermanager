CREATE TABLE users(
   id   INT NOT NULL AUTO_INCREMENT,
   fullname VARCHAR(50) NOT NULL,
   email  VARCHAR(50) NOT NULL UNIQUE,
   phone VARCHAR(50),
   company VARCHAR(50),
   password VARCHAR(50) NOT NULL,
   enabled tinyint(1),
   role varchar(20),
   
   PRIMARY KEY (id)
);

CREATE USER 'dimi' IDENTIFIED BY 'dimi@';
GRANT ALL PRIVILEGES ON usermanager.* TO 'dimi'@'localhost' IDENTIFIED BY 'dimi@';

