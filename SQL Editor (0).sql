
    create table `mystruts2db`.`student`(
        `StudentID` VARCHAR(255) not null,
       `Studentname` VARCHAR(255),
       `Birthday` VARCHAR(255),
       `Address` VARCHAR(255),
        primary key (`StudentID`)
    );

    create unique index `PRIMARY` on `mystruts2db`.`student`(`StudentID`);