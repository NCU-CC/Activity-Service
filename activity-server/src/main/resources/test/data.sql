
INSERT INTO club (clubID, club_name, address, web_site, description) VALUES
  ('A001', 'CLUB1', 'place1', 'site1', '1111'),
  ('A002', 'CLUB2', 'place2', 'site2', '2222'),
  ('A003', 'CLUB3', 'place3', 'site3', '3333'),
  ('A004', 'CLUB4', 'place4', 'site4', '4444'),
  ('A005', 'CLUB5', 'place5', 'site5', '5555'),
  ('A006', 'CLUB6', 'place6', 'site6', '6666');

INSERT INTO news (NewsID, NewsType, major, Time, DeadTime, Title, Content, upfile, disable) VALUES
  (2014, '組務', 0, '2013-07-31 08:23:24', NULL, 'title1', 'content1', 'file1', 0),
  (2015, '一般', 0, '2013-08-01 08:23:24', NULL, 'title2', 'content2', 'file2', 0),
  (2016, '一般', 0, '2013-08-02 08:23:24', NULL, 'title3', 'content3', 'file3', 0),
  (2017, '組務', 1, '2013-08-03 08:23:24', NULL, 'title4', 'content4', '', 0),
  (2018, '一般', 0, '2013-08-04 08:23:24', NULL, 'title5', 'content5', 'file5', 1),
  (2019, '組務', 1, '2013-08-05 08:23:24', NULL, 'title6', 'content6', 'file6', 1),
  (2020, '組務', 0, '2013-08-06 08:23:24', '2013-08-08', 'title7', 'content7', 'file7', 0);

INSERT INTO plan_new (plan_id, plan_name, plan_content, club_id ) VALUES
  (1, 'Activity1', 'content1', 'A001' ),
  (2, 'Activity2', 'content2', 'A002' ),
  (3, 'Activity3', 'content3', '1' ),
  (4, 'Activity4', 'content4', 'A004' ),
  (5, 'Activity5', 'content5', 'A005' ),
  (6, 'Activity6', 'content6', '2' );

INSERT INTO place (place_id, place_name ) VALUES
  (1, 'place1' ),
  (2, 'place2' ),
  (3, 'place3' ),
  (4, 'place4' ),
  (5, 'place5' );

INSERT INTO admin_unit (office_id, office_name ) VALUES
  (1, 'unit1' ),
  (2, 'unit2' ),
  (3, 'unit3' ),
  (4, 'unit4' ),
  (5, 'unit5' );

INSERT INTO place_appointment (pa_date, place_id, plan_id, club_id, pa_description, pa_start_time, pa_end_time ) VALUES
  ('2015-04-22', '1', '1', '1', 'description1', '15:00:00', '18:00:00' ),
  ('2015-04-22', '2', '2', 'A001', 'description2', '15:00:00', '18:00:00' ),
  ('2050-04-22', '3', NULL, 'admin', 'description3', '15:00:00', '18:00:00' ),
  ('2050-04-22', '4', '-1', '2', 'description4', '15:00:00', '18:00:00' ),
  ('2050-04-22', '5', '5', 'A002', 'description5', '15:00:00', '18:00:00' );
