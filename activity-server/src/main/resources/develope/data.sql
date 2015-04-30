
CREATE TABLE IF NOT EXISTS club (
  clubID      VARCHAR(4)   NOT NULL,
  club_name   VARCHAR(50)  NOT NULL DEFAULT '',
  address     VARCHAR(50)  NOT NULL DEFAULT '',
  web_site    VARCHAR(100) NOT NULL DEFAULT '',
  description VARCHAR(500) NOT NULL DEFAULT '',
  PRIMARY KEY (clubID)
);

INSERT INTO club (clubID, club_name, address, web_site, description) VALUES
  ('A001', 'CLUB1', 'place1', 'site1', '1111'),
  ('A002', 'CLUB2', 'place2', 'site2', '2222'),
  ('A003', 'CLUB3', 'place3', 'site3', '3333'),
  ('A004', 'CLUB4', 'place4', 'site4', '4444'),
  ('A005', 'CLUB5', 'place5', 'site5', '5555'),
  ('A006', 'CLUB6', 'place6', 'site6', '6666');


CREATE TABLE IF NOT EXISTS news (
  NewsID   INT(4)      NOT NULL AUTO_INCREMENT,
  NewsType VARCHAR(10) NOT NULL DEFAULT '一般',
  major    TINYINT     NOT NULL,
  Time     TIMESTAMP   NULL,
  DeadTime DATE NULL,
  Title    TEXT        NOT NULL,
  Content  LONGTEXT    NOT NULL,
  upfile   TEXT,
  disable  TINYINT     NOT NULL DEFAULT '0',
  PRIMARY KEY (NewsID)
);

INSERT INTO news (NewsID, NewsType, major, Time, DeadTime, Title, Content, upfile, disable) VALUES
  (2014, '組務', 0, '2013-07-31 08:23:24', NULL, 'title1', 'content1', 'file1', 0),
  (2015, '一般', 0, '2013-08-01 08:23:24', NULL, 'title2', 'content2', 'file2', 0),
  (2016, '一般', 0, '2013-08-02 08:23:24', NULL, 'title3', 'content3', 'file3', 0),
  (2017, '組務', 1, '2013-08-03 08:23:24', NULL, 'title4', 'content4', '', 0),
  (2018, '一般', 0, '2013-08-04 08:23:24', NULL, 'title5', 'content5', 'file5', 1),
  (2019, '組務', 1, '2013-08-05 08:23:24', NULL, 'title6', 'content6', 'file6', 1),
  (2020, '組務', 0, '2013-08-06 08:23:24', '2013-08-08', 'title7', 'content7', 'file7', 0);

CREATE TABLE IF NOT EXISTS plan_new (
  plan_id INT NOT NULL AUTO_INCREMENT,
  plan_name    VARCHAR(100) NOT NULL,
  plan_content LONGTEXT NOT NULL,
  club_id VARCHAR(5) NOT NULL,
  PRIMARY KEY (plan_id)
);

INSERT INTO plan_new (plan_id, plan_name, plan_content, club_id ) VALUES
  (1, 'Activity1', 'content1', 'A001' ),
  (2, 'Activity2', 'content2', 'A002' ),
  (3, 'Activity3', 'content3', '1' ),
  (4, 'Activity4', 'content4', 'A004' ),
  (5, 'Activity5', 'content5', 'A005' ),
  (6, 'Activity6', 'content6', '2' );

CREATE TABLE IF NOT EXISTS place (
  place_id   INT(11)      NOT NULL AUTO_INCREMENT,
  place_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (place_id)
);

INSERT INTO place (place_id, place_name ) VALUES
  (1, 'place1' ),
  (2, 'place2' ),
  (3, 'place3' ),
  (4, 'place4' ),
  (5, 'place5' );

CREATE TABLE IF NOT EXISTS admin_unit (
  office_id INT NOT NULL AUTO_INCREMENT,
  office_name VARCHAR(30) NOT NULL,
  PRIMARY KEY (office_id)
);

INSERT INTO admin_unit (office_id, office_name ) VALUES
  (1, 'unit1' ),
  (2, 'unit2' ),
  (3, 'unit3' ),
  (4, 'unit4' ),
  (5, 'unit5' );

CREATE TABLE place_appointment
(
  pa_date DATE NOT NULL,
  place_id INT NOT NULL,
  plan_id INT,
  club_id VARCHAR(10) NOT NULL,
  pa_description VARCHAR(200) NOT NULL,
  pa_start_time TIME,
  pa_end_time TIME,
  PRIMARY KEY (pa_date, place_id)
);

INSERT INTO place_appointment (pa_date, place_id, plan_id, club_id, pa_description, pa_start_time, pa_end_time ) VALUES
  ('2015-04-22', '1', '1', '1', 'description1', '15:00:00', '18:00:00' ),
  ('2015-04-22', '2', '2', 'A001', 'description2', '15:00:00', '18:00:00' ),
  ('2050-04-22', '3', NULL, 'admin', 'description3', '15:00:00', '18:00:00' ),
  ('2050-04-22', '4', '-1', '2', 'description4', '15:00:00', '18:00:00' ),
  ('2050-04-22', '5', '5', 'A002', 'description5', '15:00:00', '18:00:00' );
