
CREATE TABLE IF NOT EXISTS club (
  clubID      VARCHAR(4)   NOT NULL,
  club_name   VARCHAR(50)  NOT NULL DEFAULT '',
  club_eName  VARCHAR(50)  NOT NULL DEFAULT '',
  address     VARCHAR(50)  NOT NULL DEFAULT '',
  web_site    VARCHAR(100) NOT NULL DEFAULT '',
  description VARCHAR(500) NOT NULL DEFAULT '',
  PRIMARY KEY (clubID)
);

INSERT INTO club (clubID, club_name, club_eName, address, web_site, description) VALUES
  ('A001', 'CLUB1', 'club1', 'place1', 'site1', '1111'),
  ('A002', 'CLUB2', 'club2', 'place2', 'site2', '2222'),
  ('A003', 'CLUB3', 'club3', 'place3', 'site3', '3333'),
  ('A004', 'CLUB4', 'club4', 'place4', 'site4', '4444'),
  ('A005', 'CLUB5', 'club5', 'place5', 'site5', '5555'),
  ('A006', 'CLUB6', 'club6', 'place6', 'site6', '6666');


CREATE TABLE IF NOT EXISTS news (
  NewsID   INT(4)      NOT NULL AUTO_INCREMENT,
  NewsType VARCHAR(10) NOT NULL DEFAULT '一般',
  NewsStar TINYINT     NOT NULL DEFAULT '0',
  major    TINYINT     NOT NULL,
  Time     TIMESTAMP   NULL,
  Title    TEXT        NOT NULL,
  Content  LONGTEXT    NOT NULL,
  upfile   TEXT,
  disable  TINYINT     NOT NULL DEFAULT '0',
  PRIMARY KEY (NewsID)
);

INSERT INTO news (NewsID, NewsType, NewsStar, major, Time, Title, Content, upfile, disable) VALUES
  (2014, '組務', 0, 0, '2013-07-31 08:23:24', 'title1', 'content1', 'file1', 0),
  (2015, '一般', 0, 0, '2013-08-01 08:23:24', 'title2', 'content2', 'file2', 0),
  (2016, '一般', 0, 0, '2013-08-02 08:23:24', 'title3', 'content3', 'file3', 0),
  (2017, '組務', 0, 1, '2013-08-03 08:23:24', 'title4', 'content4', 'file4', 0),
  (2018, '一般', 0, 0, '2013-08-04 08:23:24', 'title5', 'content5', 'file5', 1),
  (2019, '組務', 0, 1, '2013-08-05 08:23:24', 'title6', 'content6', 'file6', 1);

CREATE TABLE IF NOT EXISTS plan (
  plan_id      INT(50)      NOT NULL AUTO_INCREMENT,
  plan_name    VARCHAR(100) NOT NULL,
  club_id      VARCHAR(5)   NOT NULL,
  plan_place   VARCHAR(100) NOT NULL,
  detail_place VARCHAR(30)  NOT NULL,
  plan_time1   TEXT         NOT NULL,
  plan_time2   TEXT         NOT NULL,
  plan_content LONGTEXT     NOT NULL,
  active_time1 TEXT,
  active_time2 TEXT,
  active_time3 TEXT,
  active_time4 TEXT,
  PRIMARY KEY (plan_id)
);

INSERT INTO plan (plan_id, plan_name, club_id, plan_place, detail_place, plan_time1, plan_time2, plan_content, active_time1, active_time2, active_time3, active_time4)
VALUES
  (322, 'Activity1', 'A001', '1', 'none', '2013-09-10', '2013-09-11', 'content1', '2013-09-10 08:00&',
   '2013-09-10 09:00&', '2013-09-11 23:00&', '2013-09-11 24:00&'),
  (323, 'Activity2', 'A002', '2', 'none', '2013-09-11', '2013-09-12', 'content2', '2013-09-11 08:00&',
   '2013-09-11 09:00&', '2013-09-12 23:00&', '2013-09-12 24:00&'),
  (324, 'Activity3', 'A003', '3', 'none', '2013-09-12', '2013-09-13', 'content3', '2013-09-12 08:00&',
   '2013-09-12 09:00&', '2013-09-13 23:00&', '2013-09-13 24:00&'),
  (325, 'Activity4', 'A004', '4', 'none', '2013-09-13', '2013-09-14', 'content4', '2013-09-13 08:00&',
   '2013-09-13 09:00&', '2013-09-14 23:00&', '2013-09-14 24:00&'),
  (326, 'Activity5', 'A005', '5', 'none', '2013-09-14', '2013-09-15', 'content5', '2013-09-14 08:00&',
   '2013-09-14 09:00&', '2013-09-15 23:00&', '2013-09-15 24:00&');


CREATE TABLE IF NOT EXISTS active_place (
  place_id   INT(11)      NOT NULL AUTO_INCREMENT,
  place_name VARCHAR(100) NOT NULL,
  note       TEXT         NOT NULL,
  PRIMARY KEY (place_id)
);

INSERT INTO active_place (place_id, place_name, note) VALUES
  (1, 'place1', 'description1'),
  (2, 'place2', 'description2'),
  (3, 'place3', 'description3'),
  (4, 'place4', 'description4'),
  (5, 'place5', 'description5');