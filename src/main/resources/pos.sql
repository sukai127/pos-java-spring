CREATE DATABASE  IF NOT EXISTS  pos 
USE  pos ;


DROP TABLE IF EXISTS  category ;
CREATE TABLE  category  (
   id  int(11) NOT NULL AUTO_INCREMENT,
   name  varchar(45) NOT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


LOCK TABLES  category  WRITE;
INSERT INTO  category  VALUES (1,'饮料'),(2,'水果'),(3,'电器'),(4,'食品');
UNLOCK TABLES;

DROP TABLE IF EXISTS  product ;
CREATE TABLE  product  (
   id  int(10) NOT NULL AUTO_INCREMENT,
   category_id  int(10) NOT NULL,
   barcode  char(10) NOT NULL,
   name  varchar(30) NOT NULL,
   unit  varchar(10) NOT NULL,
   price  double(10,2) NOT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
LOCK TABLES  product  WRITE;

INSERT INTO  product  VALUES (1,1,'ITEM000000','可乐','瓶',3.00),(2,1,'ITEM000001','雪碧','瓶',3.00),(3,2,'ITEM000002','苹果','斤',5.50),(4,2,'ITEM000003','荔枝','斤',3.00),(5,3,'ITEM000004','电池','个',2.00),(6,4,'ITEM000005','方便 面','袋',4.50);
UNLOCK TABLES;

DROP TABLE IF EXISTS  productPromotions ;
CREATE TABLE  productPromotions  (
   id  int(11) NOT NULL AUTO_INCREMENT,
   product_id  int(11) NOT NULL,
   promotion_id  int(11) NOT NULL,
   discount  int(11) DEFAULT '100',
  PRIMARY KEY ( id ),
  KEY  fk_0_idx  ( product_id ),
  KEY  fk_1_idx  ( promotion_id ),
  CONSTRAINT  fk_0  FOREIGN KEY ( product_id ) REFERENCES  product  ( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT  fk_1  FOREIGN KEY ( promotion_id ) REFERENCES  promotion  ( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


LOCK TABLES  productPromotions  WRITE;

INSERT INTO  productPromotions  VALUES (1,2,1,100),(2,2,2,100),(3,2,3,75),(4,4,1,100),(6,4,2,100),(7,4,3,85),(8,6,1,100),(9,6,2,100),(10,6,3,90);
UNLOCK TABLES;

DROP TABLE IF EXISTS  promotion ;

CREATE TABLE  promotion  (
   id  int(10) NOT NULL AUTO_INCREMENT,
   type  int(10) NOT NULL,
   comment  varchar(50) NOT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES  promotion  WRITE;

INSERT INTO  promotion  VALUES (1,0,'buy_two_get_one'),(2,1,'second_half_price'),(3,2,'discount');

UNLOCK TABLES;
