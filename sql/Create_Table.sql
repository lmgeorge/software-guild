CREATE TABLE `Actors` 
( `ActorID` int auto_increment NOT NULL PRIMARY KEY, 
`FirstName` varchar(30) NOT NULL, 
`LastName` varchar(30) NOT NULL);

CREATE TABLE `MovieActors` 
( `MovieID` int NOT NULL, 
  `ActorID` int NOT NULL, 
  Constraint PK_MovieActors Primary key (MovieID, ActorID)
);

alter table `MovieActors`
  add constraint FK_MovieActors_Movies foreign key (MovieID)
  references `Movies` (MovieID);

alter table `MovieActors`
  add constraint FK_MovieActors_Actors foreign key (ActorID)
  references `Actors` (ActorID);