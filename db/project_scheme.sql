CREATE TABLE `Activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Assignment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employeeId` bigint(20) NOT NULL,
  `projectId` bigint(20) NOT NULL,
  `activityId` bigint(20) NOT NULL,
  `workLoad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `EmployeeIdProjectIdActivityId_UNIQUE` (`employeeId`,`projectId`,`activityId`),
  KEY `AssignmentProject_idx` (`projectId`),
  KEY `AssignmentEmployee_idx` (`employeeId`),
  KEY `AssignmentActivity_idx` (`activityId`),
  CONSTRAINT `AssignmentActivity` FOREIGN KEY (`activityId`) REFERENCES `Activity` (`id`),
  CONSTRAINT `AssignmentEmployee` FOREIGN KEY (`employeeId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `AssignmentProject` FOREIGN KEY (`projectId`) REFERENCES `Project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `logo` varchar(45) NOT NULL,
  `ownerId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Name_UNIQUE` (`name`),
  UNIQUE KEY `Logo_UNIQUE` (`logo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `photoUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email_UNIQUE` (`email`),
  UNIQUE KEY `PhotoUrlPhoneName_UNIQUE` (`photoUrl`,`phone`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Integration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyId` bigint(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TypeCompanyId_UNIQUE` (`companyId`,`type`),
  KEY `IntegrationCompany_idx` (`companyId`),
  CONSTRAINT `IntegrationCompany` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Invitations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `partnerId` bigint(20) NOT NULL,
  `code` varchar(40) NOT NULL,
  `dateEnd` datetime NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `PartnerId_UNIQUE` (`partnerId`),
  KEY `InvationPartner_idx` (`partnerId`),
  CONSTRAINT `InvationPartnerId` FOREIGN KEY (`partnerId`) REFERENCES `Partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assignmentId` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `order` int(11) NOT NULL,
  `time` double NOT NULL,
  `comment` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `OrderDataAssignmentId_UNIQUE` (`assignmentId`,`order`,`date`),
  KEY `LogsAssignment_idx` (`assignmentId`),
  CONSTRAINT `LogsAssignment` FOREIGN KEY (`assignmentId`) REFERENCES `assignment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `partnerId` bigint(20) NOT NULL,
  `createdAt` datetime NOT NULL,
  `status` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text,
  `link` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `NotificationPartnerId_idx` (`partnerId`),
  UNIQUE KEY `partnerId_UNIQUE` (`partnerId`),
  CONSTRAINT `NotificationPartnerId` FOREIGN KEY (`partnerId`) REFERENCES `Partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyId` bigint(20) NOT NULL,
  `employeeId` bigint(20) NOT NULL,
  `roleId` varchar(10) NOT NULL,
  `workLoad` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `EmployeeIdCompanyId_UNIQUE` (`employeeId`,`companyId`),
  KEY `PartnerRoleId_idx` (`roleId`),
  KEY `PartnerEmployeeId_idx` (`employeeId`),
  KEY `PartnerCompanyId_idx` (`companyId`),
  CONSTRAINT `PartnerCompanyId` FOREIGN KEY (`companyId`) REFERENCES `Company` (`id`),
  CONSTRAINT `PartnerEmployeeId` FOREIGN KEY (`employeeId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `PartnerRoleId` FOREIGN KEY (`roleId`) REFERENCES `Role` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Period` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from` date NOT NULL,
  `to` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyId` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `logoUrl` varchar(100) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  `manHours` int(11) DEFAULT NULL,
  `code` varchar(45) NOT NULL,
  `color` varchar(20) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`,`logoUrl`),
  UNIQUE KEY `CompanyIdName_UNIQUE` (`companyId`,`name`),
  KEY `companyId_idx` (`companyId`),
  CONSTRAINT `ProjectCompanyId` FOREIGN KEY (`companyId`) REFERENCES `Company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Role` (
  `code` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyId` bigint(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CompanyIdType_UNIQUE` (`companyId`,`type`),
  KEY `SettingCompany_idx` (`companyId`),
  CONSTRAINT `SettingCompanyId` FOREIGN KEY (`companyId`) REFERENCES `Company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Timesheet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assignmentId` bigint(20) NOT NULL,
  `periodId` bigint(20) NOT NULL,
  `status` varchar(100) NOT NULL,
  `TimesheetJson` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AssignmentIdPeriodId_UNIQUE` (`assignmentId`,`periodId`),
  KEY `TimesheetAssignment_idx` (`assignmentId`),
  KEY `TimesheetPeriodId_idx` (`periodId`),
  CONSTRAINT `TimesheetAssignment` FOREIGN KEY (`assignmentId`) REFERENCES `Assignment` (`id`),
  CONSTRAINT `TimesheetPeriodId` FOREIGN KEY (`periodId`) REFERENCES `Period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8