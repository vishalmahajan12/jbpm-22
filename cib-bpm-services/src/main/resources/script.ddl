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
  
 CREATE TABLE `mydb`.`QIB_GROUP_INFO` (
  `groupId` BIGINT,
  `name` VARCHAR(16),
  `rimNumber` BIGINT,
	`verifierGroup` BOOLEAN,
  `isActive` BOOLEAN,
  `entitlementUuid` VARCHAR(16),
  `affrimationCount` integer,
 `sequence` integer,
  `minLimit` BIGINT,
  `maxLimit` BIGINT);
  
   INSERT INTO `mydb`.`qib_group_info`
(`groupId`,
`name`,
`rimNumber`,
`verifierGroup`,
`isActive`,
`entitlementUuid`,
`affrimationCount`,
`sequence`,
`minLimit`,
`maxLimit`)
VALUES
(1,
"g1",
11,
true,
true,
"eid1",
1,
1,
10,
500);

INSERT INTO `mydb`.`qib_group_info`
(`groupId`,
`name`,
`rimNumber`,
`verifierGroup`,
`isActive`,
`entitlementUuid`,
`affrimationCount`,
`sequence`,
`minLimit`,
`maxLimit`)
VALUES
(2,
"g2",
11,
true,
true,
"eid2",
1,
1,
10,
500);
  