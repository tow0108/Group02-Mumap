package com.egco428.a13283_a13265.mumap.Tram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class TramDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbhelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NUMBER, MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_LATITUDE, MySQLiteHelper.COLUMN_LONGITUDE, MySQLiteHelper.COLUMN_TYPE};

    public TramDataSource(Context context){
        dbhelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void createComment() {
        String count = "SELECT count(*) FROM tram";
        Cursor mcursor = database.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) return;
        else{
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (1,'1','South East Asia Music Museum','13.790097','100.322802','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (2,'2','College of Music','13.788335','100.324325','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (3,'3','Accross College of Music','13.790455','100.322472','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (4,'4','Faculty of Science','13.792011','100.322353','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (5,'5','Faculty of Liberal Arts','13.792032','100.323475','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (6,'6','Faculty of Social Science and Humanities','13.791958','100.324575','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (7,'7','International College','13.792224','100.326751','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (8,'8','Office of the President','13.794427','100.326007','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (9,'9','Asean Institude for health Development','13.791800','100.326254','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (10,'10','Language and Culture for Rural Development','13.791801','100.323814','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (11,'11','Parking 2','13.791808','100.322258','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (12,'1','Baan Sri Trang','13.794769','100.318894','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (13,'3','Football Field 1','13.793045','100.317683','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (14,'4','Faculty of Veterinary Science','13.798345','100.318112','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (15,'5','Condominiums','13.800567','100.320319','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (16,'6','Office of the President','13.794427','100.326007','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (17,'7','Rama Doministries','13.799193','100.321825','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (18,'8','Faculty of Medical Technology','13.798630','100.323880','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (19,'9','Population and Social Research','13.796799','100.324519','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (20,'10','Science and Technology For Research','13.796794','100.326332','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (21,'11','Parking 1','13.796791','100.320587','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (22,'12','Baan Sri Trang','13.794769','100.318894','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (23,'1','Baan Sri Trang','13.794769','100.318894','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (24,'2','College of Religion','13.798264','100.318247','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (25,'3','Institude for Child and Family Development','13.798867','100.319648','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (26,'4','Condominiums','13.800567','100.320319','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (27,'5','Rama Doministries','13.799193','100.321825','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (28,'6','Faculty of Medical Technology','13.798630','100.323880','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (29,'7','Population and Social Research','13.796799','100.324519','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (30,'8','Science and Technology For Research','13.796794','100.326332','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (31,'9','Office of the President','13.794427','100.326007','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (32,'10','Faculty of Science','13.792011','100.322353','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (33,'11','Faculty of Liberal Arts','13.792032','100.323475','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (34,'12','College of Music ','13.788335','100.324325','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (35,'13','Staff House','13.792125','100.319402','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (36,'14','South East Asia Music Museum','13.790097','100.322802','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (37,'15','Accross College of Music ','13.790455','100.322472','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (38,'1','Baan Sri Trang','13.794769','100.318894','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (39,'3','Faculty of Science','13.792011','100.322353','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (40,'4','Faculty of Liberal Arts','13.792032','100.323475','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (41,'8','Faculty of Social Science and Humanities','13.791958','100.324575','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (42,'9','International College','13.792224','100.326751','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (43,'10','Office of the President','13.794427','100.326007','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (44,'11','Gate 4','13.796288','100.326536','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (45,'12','Faculty of Engineering','13.796622','100.325934','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (46,'13','Library','13.795159','100.324440','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (47,'14','Faculty of Environment','13.795620','100.322851','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (48,'15','Nutrition','13.796600','100.322079','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (49,'16','Baan Sri Trang','13.794769','100.318894','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (50,'17','Sports & Recreation Building','13.796515','100.319924','4');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (51,'1','Tram1','13.793526','100.321677 ','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (52,'2','Tram1','13.791918','100.321732','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (53,'3','Tram1','13.792011','100.322353','5');\n"	);
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (54,'4','Tram1','13.791892','100.322655','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (55,'5','Tram1','13.790097','100.322802','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (56,'6','Tram1','13.788212','100.322666','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (57,'7','Tram1','13.788335','100.324325','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (58,'8','Tram1','13.788110','100.324868','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (59,'9','Tram1','13.788157','100.322518','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (60,'10','Tram1','13.790455','100.322472','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (61,'11','Tram1','13.791896','100.322502','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (62,'12','Tram1','13.792032','100.323475','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (63,'13','Tram1','13.791958','100.324575','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (64,'14','Tram1','13.791880','100.326813','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (65,'15','Tram1','13.792224','100.326751','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (66,'16','Tram1','13.794047','100.326765','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (67,'17','Tram1','13.794052','100.326073','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (68,'18','Tram1','13.794427','100.326007','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (69,'19','Tram1','13.794771','100.326030','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (70,'20','Tram1','13.794766','100.326695','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (71,'21','Tram1','13.791837','100.326874','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (72,'22','Tram1','13.791800','100.326254','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (73,'23','Tram1','13.791801','100.323814','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (74,'24','Tram1','13.791861','100.321661','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (75,'25','Tram1','13.793526','100.321677 ','5');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (76,'1','Tram2','13.794769','100.318894','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (77,'2','Tram2','13.791869','100.318717','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (78,'3','Tram2','13.792562','100.317496','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (79,'4','Tram2','13.793045','100.317683','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (80,'5','Tram2','13.795516','100.317416','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (81,'6','Tram2','13.796693','100.318188','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (82,'7','Tram2','13.798345','100.318112','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (83,'8','Tram2','13.798765','100.318148','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (84,'9','Tram2','13.798776','100.319917','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (85,'10','Tram2','13.800739','100.320004','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (86,'11','Tram2','13.800734','100.320245','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (87,'12','Tram2','13.800567','100.320319','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (88,'13','Tram2','13.796712','100.320216','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (89,'14','Tram2','13.796791','100.320587','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (90,'15','Tram2','13.796717','100.321568','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (91,'16','Tram2','13.799130','100.321558','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (92,'17','Tram2','13.799193','100.321825','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (93,'18','Tram2','13.799021','100.323747','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (94,'19','Tram2','13.798630','100.323880','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (95,'20','Tram2','13.796698','100.323768','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (96,'21','Tram2','13.796799','100.324519','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (97,'22','Tram2','13.796794','100.326332','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (98,'23','Tram2','13.796677','100.326590','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (99,'24','Tram2','13.794036','100.326727','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (100,'25','Tram2','13.794057','100.326062','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (101,'26','Tram2','13.794427','100.326007','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (102,'27','Tram2','13.794776','100.326056','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (103,'28','Tram2','13.794745','100.326700','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (104,'29','Tram2','13.791838','100.326798','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (105,'30','Tram2','13.791800','100.326254','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (106,'31','Tram2','13.791801','100.323814','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (107,'32','Tram2','13.791895','100.318709','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (108,'33','Tram2','13.794769','100.318894','6');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (109,'1','Tram3','13.794769','100.318894','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (110,'2','Tram3','13.791985','100.318764','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (111,'3','Tram3','13.792011','100.322353','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (112,'4','Tram3','13.791891','100.322637','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (113,'5','Tram3','13.790097','100.322802','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (114,'6','Tram3','13.788215','100.322661','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (115,'7','Tram3','13.788335','100.324325','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (116,'8','Tram3','13.788122','100.324861','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (117,'9','Tram3','13.788148','100.322522','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (118,'10','Tram3','13.790455','100.322472','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (119,'11','Tram3','13.791885','100.322493','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (120,'12','Tram3','13.792032','100.323475','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (121,'13','Tram3','13.791958','100.324575','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (122,'14','Tram3','13.791858','100.326818','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (123,'15','Tram3','13.792224','100.326751','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (124,'16','Tram3','13.794036','100.326748','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (125,'17','Tram3','13.794052','100.326077','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (126,'18','Tram3','13.794427','100.326007','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (127,'19','Tram3','13.794776','100.326056','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (128,'20','Tram3','13.794781','100.326689','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (129,'21','Tram3','13.796288','100.326536','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (130,'22','Tram3','13.796680','100.326589','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (131,'23','Tram3','13.796622','100.325934','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (132,'24','Tram3','13.796606','100.324250','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (133,'25','Tram3','13.796696','100.323773','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (134,'26','Tram3','13.798394','100.323676','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (135,'27','Tram3','13.799022','100.323770','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (136,'28','Tram3','13.799032','100.321925','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (137,'29','Tram3','13.799138','100.320184','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (138,'30','Tram3','13.798758','100.320179','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (139,'31','Tram3','13.798775','100.319942','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (140,'32','Tram3','13.800744','100.319996','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (141,'33','Tram3','13.800734','100.320253','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (142,'34','Tram3','13.800567','100.320319','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (143,'35','Tram3','13.798762','100.320179','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (144,'36','Tram3','13.798664','100.318999','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (145,'37','Tram3','13.798772','100.318162','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (146,'38','Tram3','13.798264','100.318247','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (147,'39','Tram3','13.796690','100.318197','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (148,'40','Tram3','13.796710','100.320672','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (149,'41','Tram3','13.796595','100.320677','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (150,'42','Tram3','13.796515','100.319924','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (151,'43','Tram3','13.796611','100.318692','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (152,'44','Tram3','13.794769','100.318894','7');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (153,'1','Tram4','13.794769','100.318894','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (154,'2','Tram4','13.792020','100.318738','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (155,'3','Tram4','13.792011','100.322353','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (156,'4','Tram4','13.792032','100.323475','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (157,'5','Tram4','13.791958','100.324575','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (158,'6','Tram4','13.791857','100.326812','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (159,'7','Tram4','13.792224','100.326751','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (160,'8','Tram4','13.794040','100.326758','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (161,'9','Tram4','13.794050','100.326082','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (162,'10','Tram4','13.794427','100.326007','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (163,'11','Tram4','13.794769','100.326055','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (164,'12','Tram4','13.794769','100.326709','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (165,'13','Tram4','13.796288','100.326536','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (166,'14','Tram4','13.796695','100.326572','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (167,'15','Tram4','13.796622','100.325934','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (168,'16','Tram4','13.796674','100.325490','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (169,'17','Tram4','13.795216','100.325477','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (170,'18','Tram4','13.795159','100.324440','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (171,'19','Tram4','13.795237','100.322902','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (172,'20','Tram4','13.795620','100.322851','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (173,'21','Tram4','13.796680','100.322870','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (174,'22','Tram4','13.796600','100.322079','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (175,'23','Tram4','13.796675','100.320665','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (176,'24','Tram4','13.796576','100.320611','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (177,'25','Tram4','13.796515','100.319924','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (178,'27','Tram4','13.794769','100.318894','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (179,'16','Sports & Recreation Building','13.796515','100.319924','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (180,'17','Faculty of Social Science and Humanities','13.791958','100.324575','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (181,'13','Asean Institude for health Development','13.791800','100.326254','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (182,'14','Language and Culture for Rural Development','13.791801','100.323814','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (183,'12','Mahidol Learning Center Tram Stop','13.793526','100.321677','1');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (184,'18','International College','13.792224','100.326751','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (185,'19','Gate 4','13.796288','100.326536','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (186,'20','Faculty of Engineering','13.796622','100.325934','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (187,'21','Faculty of Engineering 2','13.796606','100.324250','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (188,'26','Tram4','13.796576','100.318685','8');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (248,'15','Mahidol Organic Vetgetable Shop','13.798345','100.318112','2');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (249,'45','Faculty of Nursing Ramathibodi Hospital','13.799032','100.321925','3');\n" );
            database.execSQL("INSERT INTO `tram` (_id,number,name,latitude,longitude,type) VALUES (250,'22','National Institute for Child and Family Development','13.798664','100.318999','3');\n" );

        }
    }

//    public void deleteBuilding(TramPath buildingPlace){
//        long id = buildingPlace.getId();
//        System.out.println("TramPath deleted with id: "+id);
//        database.delete(MySQLiteHelper.TABLE_TRAM, MySQLiteHelper.COLUMN_ID+ " = "+id,null);
//    }

    public List<TramPath> getAllComments(){
        List<TramPath> tramPaths = new ArrayList<TramPath>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TRAM, allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            TramPath tramPath = cursorToComment(cursor);
            tramPaths.add(tramPath);
            cursor.moveToNext();
        }
        return tramPaths;
    }
    public List<TramPath> getAllType(String type){
        List<TramPath> tramPaths = new ArrayList<TramPath>();
        String selection =  MySQLiteHelper.COLUMN_TYPE +"= ?";
        String []selectionArgs = {type};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_TRAM, allColumns,selection,selectionArgs,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            TramPath tramPath = cursorToComment(cursor);
            tramPaths.add(tramPath);
            cursor.moveToNext();
        }
        return tramPaths;
    }

    public List<TramPath> getNearBy(String latmin,String latmax,String longmin,String longmax,String type){
        List<TramPath> buildingPlaces = new ArrayList<TramPath>();
        String selection = " ( "+ MySQLiteHelper.COLUMN_LATITUDE+" >= ? AND "+ MySQLiteHelper.COLUMN_LATITUDE+" < ? ) AND ( " + MySQLiteHelper.COLUMN_LONGITUDE+" >= ?  ) AND "+ MySQLiteHelper.COLUMN_LONGITUDE+" < ?  AND ( "+ MySQLiteHelper.COLUMN_TYPE+" = ? )";
        String []selectionArgs = {latmin,latmax,longmin,longmax,type};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_TRAM, allColumns,selection,selectionArgs,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            TramPath buildingPlace = cursorToComment(cursor);
            buildingPlaces.add(buildingPlace);
            cursor.moveToNext();
        }
        return buildingPlaces;
    }


    public TramPath cursorToComment(Cursor cursor){
        TramPath tramPath = new TramPath();
        tramPath.setId(cursor.getLong(0));
        tramPath.setNumber(cursor.getString(1));
        tramPath.setName(cursor.getString(2));
        tramPath.setLatitude(cursor.getString(3));
        tramPath.setLongtitude(cursor.getString(4));
        tramPath.setType(cursor.getString(5));

        return tramPath;
    }
}
