
CREATE TABLE IF NOT EXISTS club (
  clubID      VARCHAR(4)   NOT NULL,
  club_name   VARCHAR(50)  NOT NULL DEFAULT '',
  address     VARCHAR(50)  NOT NULL DEFAULT '',
  web_site    VARCHAR(100) NOT NULL DEFAULT '',
  description VARCHAR(500) NOT NULL DEFAULT '',
  PRIMARY KEY (clubID)
);

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

CREATE TABLE IF NOT EXISTS plan_new (
  plan_id INT NOT NULL AUTO_INCREMENT,
  plan_name    VARCHAR(100) NOT NULL,
  plan_content LONGTEXT NOT NULL,
  club_id VARCHAR(5) NOT NULL,
  PRIMARY KEY (plan_id)
);

CREATE TABLE IF NOT EXISTS place (
  place_id   INT(11)      NOT NULL AUTO_INCREMENT,
  place_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (place_id)
);

CREATE TABLE IF NOT EXISTS admin_unit (
  office_id INT NOT NULL AUTO_INCREMENT,
  office_name VARCHAR(30) NOT NULL,
  PRIMARY KEY (office_id)
);

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