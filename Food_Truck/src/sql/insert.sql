/*admin insert*/
insert into admin values('admin@gmail.com','admin','010-2644-5584');
insert into admin values('admin01@naver.com','admin01','010-5561-8445');


/*seller insert*/
insert into seller values('seller@daum.net','seller','손혜연','010-7566-5921');
insert into seller values('seller01@naver.com','seller01','최재혁','010-1234-2165');
insert into seller values('seller02@gmail.com','seller02','김현각','010-1234-2165');

/*license_no insert*/
insert into license_no values('2208183676','seller@daum.net');
insert into license_no values('1048636968','seller01@naver.com');
insert into license_no values('5215685165','seller02@gmail.com');
insert into license_no values('2266165516','seller02@gmail.com');
insert into license_no values('6516523553','seller02@gmail.com');
insert into license_no values('6565165166','seller01@naver.com');
insert into license_no values('1631165353','seller02@gmail.com');
insert into license_no values('5165133515','seller@daum.net');
insert into license_no values('6545135555','seller@daum.net');
insert into license_no values('6553633533','seller@daum.net');

/*foodtruck insert*/
insert into foodtruck values('2208183676','또래오래','010-8559-4645','서울시 관악구','Y','N','Y',1.6,'img1.png','37.50179833140776','127.024631510072',01);
insert into foodtruck values('1048636968','BBQ','010-8559-5116','서울시 은평구','N','Y','Y',2.3,'img2.png','37.501483068205566','127.02420165745722',01);
insert into foodtruck values('5215685165','미스터피자','010-8559-4645','서울시 동대문구','Y','N','Y',2.4,'img3.png','37.50053696312773','127.02443884199365',02);
insert into foodtruck values('2266165516','파파존스','010-8559-5116','서울시 금천구','Y','N','Y',1.9,'img4.png','37.49870963045177','127.0269346568284',02);
insert into foodtruck values('6516523553','7번가피자','010-8559-4625','서울시 마포구','Y','N','Y',5.0,'img5.png',NULL,NULL,02);
insert into foodtruck values('1631165353','피자헛','010-8559-4645','서울시 영등포구','Y','N','Y',2.3,'img6.png',NULL,NULL,02);
insert into foodtruck values('5165133515','롯데리아','010-8559-4645','서울시 구로구','Y','N','Y',2.0,NULL,NULL,NULL,03);
insert into foodtruck values('6545135555','취홍','010-8559-5116','서울시 강남구','Y','N','Y',1.1,NULL,NULL,NULL,04);
insert into foodtruck values('6553633533','1인가득밥상','010-8559-4645',NULL,'N','N','N',0.0,NULL,NULL,NULL,04);

/*product insert*/
insert into product values(2017121165,'볼빨간 맵닭','스모키향 가득한 색다른 매운맛의 맵닭과 쫄깃한 떡튀김',18000,'2208183676');
insert into product values(2017121166,'마왕치킨','매콤, ㅉ짭잘 달달',18000,'2208183676');
insert into product values(2017121167,'써프라이드','20여가지의 천연 원재료와 올리브 오일로 맛있게 튀겨낸 새로운 치킨',18900,'1048636968');
insert into product values(2017121168,'황금올리브치킨','한입 베어 무는 순간, 입안 가득히 퍼지는 고소한 육즙',16000,'1048636968');
insert into product values(2017121169,'두산베어스','LG트윈스가 직접 요리해주는 절정의 음식',16000,'5215685165');
insert into product values(2017121170,'눈꽃치즈치킨','맛있는 눈꽃치즈치킨',15000,'2266165516');
insert into product values(2017121171,'묵은지갈비찜+콘셀러드+머슴밥+사이드','맛있는 묵은지',12900,'6516523553');
insert into product values(2017121172,'제육쌈밥',NULL,10000,'1631165353');
insert into product values(2017121173,'차돌된장 비빔밥',NULL,9000,'5165133515');
insert into product values(2017121174,'낙지김치죽',NULL,8500,'6545135555');
insert into product values(2017121175,'반미','베트남식 바게트를 반으로 가른 후 버터 특재소스..',7500,'6553633533');
insert into product values(2017121176,'하노이 직화분짜','매일아침 직접 뽑는 얇은 생면을 숲불고기, 완자, 각종허브와 함께',18000,'6553633533');
insert into product values(2017121177,'하노이 쌀국수','오랜 시간 동안 한우사골과 차돌양지',18900,'1631165353');
insert into product values(2017121178,'게살 계란볶음밥','대게살과 계란, 마늘쫑  각종야채를 소스로 볶아낸 담백한 볶음밥',16000,'5165133515');
insert into product values(2017121179,'짜조','다진 돼지고기 베트남 현지 목이버섯',16000,'1631165353');

/*member insert*/
insert into member values('user@naver.com','user','문성현','010-5498-6165');
insert into member values('user01@daum.net','user01','문현성','010-4352-2346');

/*orders insert*/
insert into orders values(123456789112344,'문성현','010-5498-6165',SYSDATE,'2017/12/13','Y','user@naver.com');
insert into orders values(123456789112345,'김다슬','010-5595-5816',SYSDATE,'2017/12/13','Y',null);
insert into orders values(123456789112346,'이진휘','010-5595-5826',SYSDATE,'2017/12/13','N',null);

/*orderdetail insert*//*여기서부터 수정*/
insert into orderdetail values(2017121165,123456789112344,1,18000);
insert into orderdetail values(2017121166,123456789112344,2,36000);
insert into orderdetail values(2017121179,123456789112345,4,64000);
insert into orderdetail values(2017121178,123456789112345,2,32000);
insert into orderdetail values(2017121171,123456789112346,1,18900);

/*deliverydetail insert*/
insert into deliverydetail values(123456789112344,0,'서울시 강남구 비트컴퓨터 r45','2017/12/13');
insert into deliverydetail values(123456789112345,1,'서울시 강남구 비트컴퓨터 r45','2017/12/13');

/*review insert*/
insert into review values('2208183676',1,'괜찮았어요',sysdate, 0, 'N',10.0,'user@naver.com');
insert into review values('2208183676',2,'배달이 좀 늦은게 아쉽지만 맛있었어요',sysdate, 0, 'N',5.0,'user@naver.com');
insert into review values('2208183676',3,'별점 최악 음식나왔다고 연락온지...',sysdate, 0, 'N',1.0, 'user@naver.com');

commit;
