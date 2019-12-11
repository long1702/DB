CREATE DATABASE Youtube_database;
USE youtube_database;

-- 1xx: ID Video
-- 2xx: ID UserID
-- 3xx: Advertise
-- 4xx: Discussion
-- 5xx: Story
-- 6xx: CmtID


CREATE TABLE User
(
  UserID					INT unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  isRegistered				BOOLEAN DEFAULT FALSE,
  Name						VARCHAR(40),
  Gmail						VARCHAR(40),
  Password					VARCHAR(40),
  SignUpDate				DATETIME
);
INSERT INTO User (UserID, isRegistered, Name, Gmail, Password, SignUpDate) VALUES # Registered
  ( 20000001, TRUE, 'abc', 	'abc@gmail.com', 	'abc_pw', '2011-08-21 06:20:10.040607' ),
  ( 20000002, TRUE, 'AbC', 	'AbC@gmail.com', 	'AbC_pw', '2010-06-21 04:03:20.020011' ),
  ( 20000003, TRUE, 'Uss', 	'Uss@gmail.com', 	'Uss_pw', '2009-01-25 12:30:20.467890' ), 		
  ( 20000004, TRUE, 'cde', 	'cde@gmail.com', 	'cde_pw', '2008-03-18 12:31:21.030300' ),
  ( 20000005, TRUE, 'xyz', 	'xyz@gmail.com', 	'xyz_pw', '2008-11-30 11:43:12.002312' ), 		
  ( 20000006, TRUE, 'XYZZ', 'XYZZ@gmail.com', 	'XYZZ_pw', '2008-01-18 00:42:23.767675' ),
  ( 20000007, TRUE, 'aaaa', 'aaaa@gmail.com', 	'aaaa_pw', '2008-08-27 04:23:43.125893' ), 		
  ( 20000008, TRUE, 'bbb', 	'bbb@gmail.com', 	'bbb_pw', '2007-06-16 23:53:43.023658' ),
  ( 20000009, TRUE, 'ccc', 	'ccc@gmail.com', 	'ccc_pw', '2007-04-30 14:12:12.789654' ), 		
  ( 20000010, TRUE, 'PPL', 	'PPL@gmail.com', 	'PPL_pw', '2007-03-01 11:00:23.456321' );
INSERT INTO User (UserID, isRegistered) VALUES # Guest
  ( 20000011, FALSE ), ( 20000012, FALSE ),
  ( 20000013, FALSE ), ( 20000014, FALSE ),
  ( 20000015, FALSE ), ( 20000016, FALSE ),
  ( 20000017, FALSE ), ( 20000018, FALSE ),
  ( 20000019, FALSE ), ( 20000020, FALSE );


CREATE TABLE Object
(
  ID					INT unsigned NOT NULL PRIMARY KEY auto_increment, 
  Time 					DATETIME NOT NULL,           
  UserID				INT unsigned NOT NULL
);
INSERT INTO Object (ID, Time, UserID) VALUES
  ( 40000001, '2012-01-01 06:20:10.040607', '20000001' ),
  ( 40000002, '2013-02-14 04:03:20.020011', '20000002' ),
  ( 40000003, '2014-03-23 12:30:20.467890', '20000003' ),
  ( 40000004, '2017-09-12 12:31:21.030300', '20000004' ),
  ( 40000005, '2013-12-31 11:43:12.002312', '20000005' ),
  ( 40000006, '2015-07-14 00:42:23.767675', '20000006' ),
  ( 40000007, '2018-08-22 04:23:43.125893', '20000007' ),
  ( 40000008, '2014-09-11 23:53:43.023658', '20000008' ),
  ( 40000009, '2012-01-31 14:12:12.789654', '20000009' ),
  ( 40000010, '2016-04-02 11:00:23.456321', '20000010' ),
  ( 50000001, '2012-03-12 09:22:11.040607', '20000001' ),
  ( 50000002, '2011-06-14 04:23:22.020011', '20000001' ),
  ( 50000003, '2013-09-23 21:23:22.467890', '20000001' ),
  ( 50000004, '2016-08-11 11:34:11.030300', '20000002' ),
  ( 50000005, '2017-01-12 11:43:12.002312', '20000003' ),
  ( 50000006, '2016-06-30 00:54:33.767675', '20000002' ),
  ( 50000007, '2015-05-12 12:11:43.125893', '20000002' ),
  ( 50000008, '2014-04-22 23:32:11.023658', '20000007' ),
  ( 50000009, '2006-03-23 12:54:13.789654', '20000008' ),
  ( 50000010, '2002-02-24 11:23:22.456321', '20000010' ),
  ( 10000001, '2013-01-23 21:23:22.467890', '20000001' ),
  ( 10000002, '2016-01-25 00:54:33.767675', '20000002' ),
  ( 10000003, '2014-01-24 12:30:20.467890', '20000005' ),
  ( 10000004, '2017-02-13 12:31:21.030300', '20000001' ),
  ( 10000005, '2013-05-12 11:43:12.002312', '20000002' ),
  ( 10000006, '2014-03-23 23:32:11.023658', '20000003' ),
  ( 10000007, '2018-08-25 04:23:43.125893', '20000003' ),
  ( 10000008, '2014-07-26 23:53:43.023658', '20000003' ),
  ( 10000009, '2012-08-15 14:12:12.789654', '20000010' ),
  ( 10000010, '2016-09-13 11:00:23.456321', '20000010' ),
  ( 10000011, '2013-01-21 21:23:22.467890', '20000001' ),
  ( 10000012, '2016-01-25 00:54:33.767675', '20000002' ),
  ( 10000013, '2014-01-29 12:30:20.467890', '20000005' ),
  ( 10000014, '2017-02-28 12:31:21.030300', '20000001' ),
  ( 10000015, '2013-05-24 11:43:12.002312', '20000002' ),
  ( 10000016, '2014-03-13 23:32:11.023658', '20000003' ),
  ( 10000017, '2018-08-23 04:23:43.125893', '20000003' ),
  ( 10000018, '2014-07-24 23:53:43.023658', '20000003' ),
  ( 10000019, '2012-08-16 14:12:12.789654', '20000010' ),
  ( 10000020, '2016-09-17 11:00:23.456321', '20000010' );

  
  CREATE TABLE Discussion
(
  ID					INT unsigned NOT NULL PRIMARY KEY, 
  Content				VARCHAR(225) NOT NULL,
  FOREIGN KEY 			(ID) 	REFERENCES Object(ID)
);
INSERT INTO Discussion (ID, Content) VALUES
  ( '40000001', 'Your gud.' ), 				( '40000005', 'Alo alo..' ),
  ( '40000007', 'Nice job.'), 				( '40000006', 'Aww. I hate you.'),
  ( '40000010', 'Incrediable music.'), 		( '40000002', 'Spam spam spam...'),
  ( '40000009', 'Waaa.. Interesting!'), 	( '40000003', 'Lovely song <3'),
  ( '40000008', 'Marry me, Jewtuber'), 		( '40000004', 'Who I am? Where I am?');   


  CREATE TABLE Story
(
  ID					INT unsigned NOT NULL PRIMARY KEY, 
  Story					VARCHAR(225) NOT NULL,
  FOREIGN KEY 			(ID) 	REFERENCES Object(ID)
);
INSERT INTO Story (ID, Story) VALUES
  ( '50000001', 'Today, Im lucky.' ), 				( '50000006', 'Alo alo..' ),
  ( '50000002', 'Aw.. Boring day.'), 				( '50000007', '._.'),
  ( '50000003', 'Hows your day, everyone?'), 		( '50000008', 'Spam spam spam...'),
  ( '50000004', 'Nyaa nyaa kyaa kyaa~'), 			( '50000009', 'Subcribe me.'),
  ( '50000005', 'Ill livestream right now!~'), 		( '50000010', 'Who I am? Where I am?');


  CREATE TABLE Video
(
  ID						INT unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,  
  Description				VARCHAR(225) NOT NULL,
  Name						VARCHAR(40) NOT NULL,
  Mode						VARCHAR(40) NOT NULL,
  VideoData					VARCHAR(225) NOT NULL, # ~~Temporary~~
  Thumbnail					VARCHAR(225) NOT NULL, # A link
  FOREIGN KEY 				(ID) 	REFERENCES Object (ID)
);
INSERT INTO Video (ID, Description, Name, Mode, VideoData, Thumbnail) VALUES
  ( 10000001,	'Bla..bla', 	'My life', 			'Public', 	'http://..', 	'http://..' ),
  ( 10000002,	'nfsjkdn', 		'A horror film', 	'Private', 	'http://..', 	'http://..' ),
  ( 10000003,	'Bang bang', 	'A action video', 	'Public', 	'http://..', 	'http://..' ), 
  ( 10000004,	'Bang bang 2', 	'A action video 2', 'Public', 	'http://..', 	'http://..' ),
  ( 10000005, 	'Bla..bla 2', 	'My life 2', 		'Public', 	'http://..', 	'http://..' ), 
  ( 10000006, 	'Hm..', 		'Not My life', 		'Public', 	'http://..', 	'http://..' ),
  ( 10000007, 	'Hm...', 		'2 girls', 			'Private', 	'http://..', 	'http://..' ), 
  ( 10000008, 	'abc', 			'cde', 				'Public', 	'http://..', 	'http://..' ),
  ( 10000009, 	'Tom > Jerry', 	'Tom and Jerry', 	'Public', 	'http://..', 	'http://..' ), 
  ( 10000010, 	'Wheres my pen','My pen', 			'Public', 	'http://..', 	'http://..' ),
  ( 10000011, 	'Kyaaa', 		'My dream', 		'Public', 	'http://..', 	'http://..' ),
  ( 10000012, 	'aaa', 			'Action 1', 		'Private', 	'http://..', 	'http://..' ),
  ( 10000013, 	'bbb', 			'Action 2', 		'Public', 	'http://..', 	'http://..' ), 
  ( 10000014, 	'ccc', 			'Action 3', 		'Public', 	'http://..', 	'http://..' ),
  ( 10000015, 	'Bla..bla 2', 	'My life 3', 		'Public', 	'http://..', 	'http://..' ), 
  ( 10000016, 	'Hm..', 		'Robot', 			'Public', 	'http://..', 	'http://..' ),
  ( 10000017, 	'Hm...', 		'2 girls', 			'Private', 	'http://..', 	'http://..' ), 
  ( 10000018, 	'abc', 			'Feel the rhythm', 	'Public', 	'http://..', 	'http://..' ),
  ( 10000019, 	'Badminton', 	'Championship', 	'Public', 	'http://..', 	'http://..' ), 
  ( 10000020, 	'Football', 	'Seagame 2019', 	'Public', 	'http://..', 	'http://..' );
--
--
CREATE TABLE Advertise
(
  AdID						INT unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  Content					VARCHAR(225) NOT NULL,
  Advertiser				VARCHAR(225) NOT NULL
);
INSERT INTO Advertise (AdID, Content, Advertiser) VALUES
  ( 30000001, 'Ad_abc', 	'Google' ), 				
  ( 30000006, 'Ad_GGez', 	'Google' ),
  ( 30000002, 'Ad_ccde', 	'Youtube' ), 				
  ( 30000007, 'Ad_fb', 		'Facebook' ),
  ( 30000003, 'Ad_abxc', 	'Facebook' ), 				
  ( 30000008, 'Ad_MySQL', 	'Facebook' ),
  ( 30000004, 'Ad_ast', 	'Chrome' ), 				
  ( 30000009, 'Ad_Jasmine', 'HCMUT' ),
  ( 30000005, 'Ad_self.visit()', 'LOL' ), 		
  ( 30000010, 'Ad_GenCode', 'HCMUT' );


CREATE TABLE Comment
(
  CmtID						INT unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  UserID					INT unsigned NOT NULL,
  ID						INT unsigned NOT NULL,
  TimeStamp					DATETIME NOT NULL,
  Content					VARCHAR(225) NOT NULL,
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(ID) 		REFERENCES Object(ID)
);
INSERT INTO Comment (CmtID, UserID, ID, TimeStamp, Content) VALUES
  ( 60000001, 20000001, 10000001, '2012-08-21 05:20:10.040607', 'Cmt1' ),
  ( 60000002, 20000001, 10000002, '2012-06-21 03:03:20.020011', 'Cmt2' ),
  ( 60000003, 20000002, 10000003, '2013-01-25 11:30:20.467890', 'Cmt3' ), 		
  ( 60000004, 20000003, 10000004, '2014-03-18 10:31:21.030300', 'Cmt4' ),
  ( 60000005, 20000003, 10000005, '2015-11-30 10:43:12.002312', 'Cmt5' ), 		
  ( 60000006, 20000003, 10000006, '2016-01-18 00:41:23.767675', 'Cmy6' ),
  ( 60000007, 20000003, 10000007, '2018-08-27 04:22:43.125893', 'Cmt7' ), 		
  ( 60000008, 20000004, 10000008, '2012-06-16 23:51:43.023658', 'Cmt8' ),
  ( 60000009, 20000004, 10000009, '2014-04-30 14:10:12.789654', 'Cmt9' ), 		
  ( 60000010, 20000009, 10000010, '2018-03-01 01:00:23.456321', 'Cmt10' );

CREATE TABLE Newlistvideo
(
  UserID					INT unsigned NOT NULL, 
  Name						VARCHAR(40) NOT NULL,
  Mode						VARCHAR(40) NOT NULL,
  PRIMARY KEY				(UserID, Name),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID)
);
INSERT INTO Newlistvideo (UserID, Name, Mode) VALUES
  ( 20000001, 'Mylist', 'Public' ), ( 20000001, 'Mylist2', 'Public' ),
  ( 20000002, 'list', 'Public' ), 	( 20000003, 'Fav1', 'Public' ),
  ( 20000003, 'Fav2', 'Public' ), 	( 20000003, 'listmusic', 'Private' ),
  ( 20000003, 'Fav3', 'Private' ), 	( 20000004, 'liked', 'Private' ),
  ( 20000004, 'later', 'Private' ), ( 20000009, 'secret', 'Private' );


CREATE TABLE Reply
(
  CmtID						INT unsigned NOT NULL, 
  UserID					INT unsigned NOT NULL, 
  TimeStamp					DATETIME NOT NULL,
  Content					VARCHAR(255) NOT NULL,	
  PRIMARY KEY 				(CmtID, UserID, TimeStamp),
  FOREIGN KEY 				(CmtID) 	REFERENCES Comment(CmtID),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID)
);
INSERT INTO Reply (CmtID, UserID, TimeStamp, Content) VALUES
  ( 60000001, 20000001, '2012-08-21 06:20:10.040607', 'Great' ),
  ( 60000004, 20000001, '2012-06-21 04:03:20.020011', 'GG' ),
  ( 60000002, 20000002, '2013-01-25 12:30:20.467890', 'GJ' ), 		
  ( 60000006, 20000003, '2014-03-18 12:31:21.030300', 'Hm....' ),
  ( 60000003, 20000003, '2015-11-30 11:43:12.002312', 'BlaBla' ), 		
  ( 60000008, 20000003, '2016-01-18 00:42:23.767675', 'Good' ),
  ( 60000003, 20000003, '2018-08-27 04:23:43.125893', 'Spam Spam' ), 		
  ( 60000008, 20000004, '2012-06-16 23:53:43.023658', 'You did great' ),
  ( 60000003, 20000004, '2014-04-30 14:12:12.789654', 'Waaah...' ), 		
  ( 60000008, 20000009, '2018-03-01 11:00:23.456321', 'Haha' );


CREATE TABLE LikeCmt
(
  CmtID						INT unsigned NOT NULL, 
  UserID					INT unsigned NOT NULL,
  TimeStamp					DATETIME NOT NULL,
  IsLike					BOOLEAN NOT NULL, # FALSE = Dislike
  PRIMARY KEY 				(CmtID, UserID, TimeStamp),
  FOREIGN KEY 				(CmtID) 	REFERENCES Comment(CmtID),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID));
INSERT INTO LikeCmt (CmtID, UserID, TimeStamp, IsLike) VALUES
  ( 60000001, 20000001, '2012-01-01 01:20:10.040607', TRUE ),
  ( 60000004, 20000001, '2013-02-14 02:03:20.020011', TRUE ),
  ( 60000002, 20000002, '2012-01-31 13:12:12.789654', TRUE ), 		
  ( 60000006, 20000003, '2011-06-14 04:23:22.020011', FALSE ),
  ( 60000003, 20000003, '2013-09-23 21:23:22.467890', FALSE ), 		
  ( 60000008, 20000003, '2017-01-12 12:43:12.002312', TRUE ),
  ( 60000003, 20000003, '2014-04-22 11:32:11.023658', FALSE ), 		
  ( 60000008, 20000004, '2014-01-29 13:30:20.467890', FALSE ),
  ( 60000003, 20000004, '2013-05-14 09:43:12.002312', TRUE ), 		
  ( 60000008, 20000009, '2014-07-21 21:53:43.023658', TRUE );


CREATE TABLE LikeReply
(
  CmtID						INT unsigned NOT NULL, 
  UserReply					INT unsigned NOT NULL,
  UserLike					INT unsigned NOT NULL,
  TimeStamp					DATETIME NOT NULL,
  IsLike					BOOLEAN NOT NULL, # FALSE = Dislike
  PRIMARY KEY 				(CmtID, UserReply, UserLike, TimeStamp),
  FOREIGN KEY 				(CmtID) 	REFERENCES Comment(CmtID),
  FOREIGN KEY 				(UserReply) 	REFERENCES User(UserID),
  FOREIGN KEY 				(UserLike) 	REFERENCES User(UserID)
);
INSERT INTO LikeReply (CmtID, UserReply, UserLike, TimeStamp, IsLike) VALUES
  ( 60000001, 20000001, 20000002, '2012-01-01 01:20:10.040607', TRUE ),
  ( 60000004, 20000001, 20000003, '2013-02-14 02:03:20.020011', TRUE ),
  ( 60000002, 20000002, 20000004, '2012-01-31 13:12:12.789654', TRUE ), 		
  ( 60000006, 20000003, 20000005, '2011-06-14 04:23:22.020011', FALSE ),
  ( 60000003, 20000003, 20000006, '2013-09-23 21:23:22.467890', FALSE ), 		
  ( 60000008, 20000003, 20000007, '2017-01-12 12:43:12.002312', TRUE ),
  ( 60000003, 20000003, 20000008, '2014-04-22 11:32:11.023658', FALSE ), 		
  ( 60000008, 20000004, 20000009, '2014-01-29 13:30:20.467890', FALSE ),
  ( 60000003, 20000004, 20000001, '2013-05-14 09:43:12.002312', TRUE ), 		
  ( 60000008, 20000009, 20000002, '2014-07-21 21:53:43.023658', TRUE );


  CREATE TABLE Type
(
  VideoID					INT unsigned NOT NULL,
  Name						VARCHAR(40) NOT NULL, # Name of type video
  PRIMARY KEY				(VideoID, Name),
  FOREIGN KEY 				(VideoID) 	REFERENCES Video (ID)
);
INSERT INTO Type (VideoID, Name) VALUES
  ( 10000001, 'Drama' ), 			( 10000006, 'Gaming' ),
  ( 10000002, 'Lifestyle' ), 			( 10000007, 'Lifestyle' ),
  ( 10000003, 'Drama' ), 			( 10000008, 'Food' ),
  ( 10000004, 'Beauty' ), 		( 10000009, 'Nature' ),
  ( 10000005, 'Cartoon' ), 			( 10000010, 'Beauty' ),
  ( 10000011, 'Sport' ), 			( 10000016, 'Gaming' ),
  ( 10000012, 'Music' ), 			( 10000017, 'Lifestyle' ),
  ( 10000013, 'Food' ), 			( 10000018, 'Beauty' ),
  ( 10000014, 'Cartoon' ), 		( 10000019, 'Food' ),
  ( 10000015, 'Gaming' ), 			( 10000020, 'Else' ),
  ( 10000001, 'Dramma' ), 		( 10000002, 'Horror' ),
  ( 10000001, 'Cartoon' ), 			( 10000002, 'Sport' );  


CREATE TABLE LikeObject
(
  UserID					INT unsigned NOT NULL,
  ID 						INT unsigned NOT NULL,
  IsLike					BOOLEAN NOT NULL, # FALSE = Dislike
  PRIMARY KEY 				(UserID, ID),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(ID) 		REFERENCES Object(ID)
 );
INSERT INTO LikeObject (UserID, ID, IsLike) VALUES
  ( 20000001, 10000001, TRUE ),
  ( 20000004, 10000001, TRUE ),
  ( 20000002, 10000002, TRUE ), 		
  ( 20000006, 40000003, FALSE ),
  ( 20000003, 40000003, FALSE ), 		
  ( 20000008, 40000003, TRUE ),
  ( 20000003, 50000003, FALSE ), 		
  ( 20000008, 50000004, FALSE ),
  ( 20000003, 50000004, TRUE ), 		
  ( 20000008, 10000009, TRUE );


CREATE TABLE Watching
(
  UserID					INT unsigned NOT NULL,
  VideoID 					INT unsigned NOT NULL,
  CurrentTimePoint			VARCHAR(40),
  PRIMARY KEY 				(UserID, VideoID),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(VideoID) 		REFERENCES Video(ID)
 );
INSERT INTO Watching (UserID, VideoID, CurrentTimePoint) VALUES
  ( 20000001, 10000001, '00:00:05' ), 			( 20000001, 10000005, '00:01:00' ),
  ( 20000002, 10000001, '00:02:00' ), 			( 20000005, 10000003, '00:03:00' ),
  ( 20000003, 10000001, '00:04:00' ), 			( 20000009, 10000001, '00:05:00' ),
  ( 20000004, 10000006, '00:06:00' ), 			( 20000003, 10000002, '00:07:00' ),
  ( 20000005, 10000001, '00:08:00' ), 			( 20000005, 10000005, '01:00:00' ),
  ( 20000001, 10000007, '00:01:00' ), 			( 20000001, 10000002, '00:02:00' );


CREATE TABLE Action
(
  UserID					INT unsigned NOT NULL, 
  VideoID					INT unsigned NOT NULL,
  TimeStamp					DATETIME NOT NULL,
  Type						VARCHAR(40) NOT NULL,
  PRIMARY KEY 				(UserID, VideoID, TimeStamp),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(VideoID) 	REFERENCES Video(ID)
);
INSERT INTO Action (UserID, VideoID, TimeStamp, Type) VALUES
  ( 20000001, 10000001, '2012-01-01 06:20:10.020607', 'watched' ),
  ( 20000004, 10000001, '2013-02-14 04:03:20.010011', 'later' ),
  ( 20000002, 10000002, '2012-01-31 14:12:12.739654', 'watched' ), 		
  ( 20000006, 10000003, '2011-06-14 04:23:22.040011', 'later' ),
  ( 20000003, 10000003, '2013-09-23 21:23:22.457890', 'watched' ), 		
  ( 20000008, 10000003, '2017-01-12 11:43:12.062312', 'watched' ),
  ( 20000003, 10000003, '2014-04-22 23:32:11.073658', 'later' ), 		
  ( 20000008, 10000004, '2014-01-29 12:30:20.487890', 'downloaded' ),
  ( 20000003, 10000004, '2013-05-14 11:43:12.092312', 'downloaded' ), 		
  ( 20000008, 10000009, '2014-07-21 23:53:43.013658', 'downloaded' );


CREATE TABLE Click
(
  UserID					INT unsigned NOT NULL,
  AdID						INT unsigned NOT NULL,
  Time 						DATETIME,
  PRIMARY KEY				(UserID, AdID),
  FOREIGN KEY 				(UserID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(AdID) 		REFERENCES Advertise(AdID)
);
INSERT INTO Click (UserID, AdID, Time) VALUES
  ( 20000001, 30000001, '2012-01-01 06:20:10.040607' ),
  ( 20000001, 30000005, '2013-02-14 04:03:20.020011' ),
  ( 20000002, 30000001, '2012-01-31 14:12:12.789654' ), 
  ( 20000005, 30000003, '2011-06-14 04:23:22.020011' ),
  ( 20000003, 30000001, '2013-09-23 21:23:22.467890' ), 
  ( 20000011, 30000001, '2017-01-12 11:43:12.002312' ),
  ( 20000004, 30000006, '2014-04-22 23:32:11.023658' ), 
  ( 20000013, 30000002, '2014-01-29 12:30:20.467890' ),
  ( 20000005, 30000001, '2013-05-14 11:43:12.002312' ), 
  ( 20000015, 30000005, '2014-07-21 23:53:43.023658' );


CREATE TABLE Contain
(
  VideoID					INT unsigned NOT NULL,
  AdID						INT unsigned NOT NULL, 
  TimeAppear				VARCHAR(40),
  PRIMARY KEY				(VideoID, AdID, TimeAppear),
  FOREIGN KEY 				(VideoID) 	REFERENCES Video(ID),
  FOREIGN KEY 				(AdID) 		REFERENCES Advertise(AdID)
);
INSERT INTO Contain (VideoID, AdID, TimeAppear) VALUES
  ( 10000001, 30000001, '00:00:10' ), 			( 10000001, 30000005, '00:01:10' ),
  ( 10000002, 30000001, '00:02:10' ), 			( 10000005, 30000003, '00:03:10' ),
  ( 10000003, 30000001, '00:04:10' ), 			( 10000011, 30000001, '00:05:10' ),
  ( 10000004, 30000006, '00:06:10' ), 			( 10000013, 30000002, '00:07:10' ),
  ( 10000005, 30000001, '00:08:10' ), 			( 10000015, 30000005, '01:00:00' ),
  ( 10000001, 30000001, '00:01:10' ), 			( 10000001, 30000001, '00:02:10' ); 


CREATE TABLE Subcribe
(
  SubcriberID				INT unsigned NOT NULL,
  ChannelID					INT unsigned NOT NULL, 
  PRIMARY KEY				(SubcriberID, ChannelID),
  FOREIGN KEY 				(SubcriberID) 	REFERENCES User(UserID),
  FOREIGN KEY 				(ChannelID) 		REFERENCES User(UserID)
);
INSERT INTO Subcribe (SubcriberID, ChannelID) VALUES
  ( 20000001, 20000002 ), 			( 20000001, 20000006 ),
  ( 20000002, 20000001 ), 			( 20000005, 20000003 ),
  ( 20000003, 20000001 ), 			( 20000001, 20000007 ),
  ( 20000004, 20000006 ), 			( 20000003, 20000002 ),
  (	20000005, 20000001 ), 			( 20000005, 20000006 );

  
CREATE TABLE Enqueue
(
  VideoID					INT unsigned NOT NULL, 
  UserID						INT unsigned NOT NULL, 
  Name						VARCHAR(40) NOT NULL,
  PRIMARY KEY 				(VideoID, UserID, Name),
  FOREIGN KEY 				(VideoID) 	REFERENCES Video(ID),
  FOREIGN KEY 				(UserID, Name) 	REFERENCES Newlistvideo(UserID, Name)
);
INSERT INTO Enqueue (VideoID, UserID, Name) VALUES
  ( 10000001, 20000001, 'Mylist' ), 	( 10000001, 20000001, 'Mylist2' ),
  ( 10000002, 20000002, 'list' ), 		( 10000003, 20000003, 'Fav1' ),
  ( 10000003, 20000003, 'Fav2' ), 		( 10000013, 20000003, 'listmusic' ),
  ( 10000003, 20000003, 'Fav3' ), 		( 10000014, 20000004, 'liked' ),
  ( 10000004, 20000004, 'later' ), 		( 10000019, 20000009, 'secret' );



#SHOW DATABASES;
#SHOW TABLES;
#DESCRIBE Enqueue;
#SELECT * FROM Enqueue;
#DROP TABLE Enqueue;