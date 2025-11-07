CREATE DATABASE team_management;
USE team_management;
CREATE TABLE task (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  status VARCHAR(100),
  assigned_to VARCHAR(100)
);
