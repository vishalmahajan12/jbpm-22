create database mydb;
use mydb;


CREATE TABLE `mydb`.`customer` (
  `name` VARCHAR(16) NOT NULL,
  `experience` integer,
  `lessThan` integer,
  `greaterThan` integer,
  `salary` integer);
  
CREATE TABLE `mydb`.`rules_data` (
  `condLessThan` integer,
  `condGreaterThan` integer,
  `actSalary` integer);