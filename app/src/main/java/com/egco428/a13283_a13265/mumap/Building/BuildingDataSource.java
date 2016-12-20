package com.egco428.a13283_a13265.mumap.Building;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class BuildingDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbhelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NUMBER, MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_LATITUDE, MySQLiteHelper.COLUMN_LONGITUDE, MySQLiteHelper.COLUMN_TYPE};

    public BuildingDataSource(Context context){
        dbhelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void createComment() {
        String count = "SELECT count(*) FROM building";
        Cursor mcursor = database.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) ;
        else{
            database.execSQL( "INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (1,'1','Mahidol Learning Center','13.793603','100.321169','1');\n");
            database.execSQL( "INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (2,'2','Faculty of Liberal Arts','13.797124','100.321084','1');\n" );
            database.execSQL( "INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (3,'3','Siri Building','13.797525','100.321143','1');\n" );
            database.execSQL( "INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (4,'4','Faculty of Physical Therapy ','13.797468','100.321964','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (5,'5','Ramathibodi Dorministries ','13.798651','100.322243','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (6,'6','Faculty of Medical Technology ','13.798687','100.323021','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (7,'7','Population and Social research','13.796912','100.324635','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (8,'8','Institude of Molecular Biosciences(MB)','13.797068','100.326271','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (9,'9','Faculty of Engineering ','13.795753','100.325877','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (10,'10','Information Communicate Technology ','13.794416','100.324916','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (11,'11','Library ','13.794497','100.324159','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (12,'12','Office of President','13.794404','100.325557','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (13,'13','Salaya Pavilion Hotel','13.792684','100.326403','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (14,'14','International College','13.792752','100.325958','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (15,'15','Faculty of Social Science and Humanities','13.792484','100.324949','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (16,'16','Faculty of Science ','13.792683','100.322520','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (17,'17','Faculty Student','13.793806','100.322194','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (119,'107','Mahidol Learning Center Tram Stop ','13.793526','100.321677','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (108,'106','Sports & Recreation Building','13.796515','100.319924','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (107,'105','Accross College of Music','13.790455','100.322472','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (106,'104','College of Music','13.788335','100.324325','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (105,'103','Faculty of Medical Technology','13.798630','100.323880','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (104,'102','Rama Doministries','13.799193','100.321825','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (103,'101','Condominiums','13.800567','100.320319','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (102,'106','Institude for Child and Family Development','13.798867','100.319648','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (101,'105','Faculty of Veterinary Science','13.798345','100.318112','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (100,'104','Football Field 1','13.793045','100.317683','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (99,'103','Staff House','13.792125','100.319402','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (98,'100','Faculty of Science','13.792011','100.322353','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (97,'99','South East Asia Music Museum','13.790097','100.322802','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (96,'98','Faculty of Liberal Arts','13.792032','100.323475','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (95,'97','Faculty of Social Science and Humanities','13.791958 ','100.324575','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (94,'96','International College','13.792224','100.326751','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (93,'95','Gate 4','13.796288','100.326536','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (92,'94','Faculty of Engineering','13.796622','100.325934','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (91,'93','Library','13.795159','100.324440','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (90,'92','Faculty of Environment','13.795620','100.322851','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (89,'91','Nutrition','13.796600','100.322079','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (88,'88','Parking 2','13.791808','100.322258','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (87,'87','Language and Culture for Rural Development','13.791801','100.323814','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (86,'86','Asean Institude for health Development','13.791800','100.326254','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (85,'85','Office of the President','13.794427','100.326007','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (84,'84','Science and Technology For Research','13.796794','100.326332','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (83,'83','Population and Social Research','13.796799','100.324519','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (82,'82','Faculty of Medical Technology','13.798630','100.323880','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (81,'81','Rama Doministries','13.799193','100.321825','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (80,'80','Faculty of Physical Therapy','13.797966','100.321538','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (79,'79','Parking 1','13.796791','100.320587','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (78,'78','Baan Sri Trang','13.794769','100.318894','4');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (77,'77','Brew & Bev','13.792100','100.325681','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (76,'76','Chiang Rai Coffee','13.791612','100.323098','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (75,'75','หอมข้าวคั่วครัวอินทรีย์','13.791219','100.323774','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (74,'74','IL Synergy','13.791259','100.323986','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (73,'73','Music Square','13.788916','100.323423','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (72,'72','Irene''s Cafe','13.789819','100.323515','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (71,'71','SugarCane Coffee','13.793464','100.325209','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (70,'70','Cafe Amason','13.794948','100.321918','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (69,'69','ตามตะวัน By Ying&Tum','13.792864','100.320771','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (68,'68','Jeffer ','13.792775','100.321216','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (67,'67','True Lab Mahidol','13.793705','100.321192','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (66,'66','ร้าน เนย นมสด','13.794222','100.321282','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (65,'65','Pearly tea by Jiffy','13.793797','100.321306','3');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (18,'18','MU Home','13.793113','100.319907','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (19,'19','Student Dormitories','13.792854','100.319966','1');\n" );
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (20,'20','Football Field1','13.793354','100.318223','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (21,'21','SCB Mahidol Bank','13.794510','100.319766','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (22,'22','MU Lake','13.794462','100.316818','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (23,'23','VS','13.798197','100.317176','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (24,'24','Prasu Arthorn Animal Hospital','13.798171','100.317992','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (25,'25','CRS','13.798437','100.318620','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (26,'26','Nationnal Institute for Child and Family Development','13.798302','100.319634','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (27,'27','Rugby-Football Field','13.798104','100.320696','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (28,'28','Mahidol Wittayanusorn ','13.800209','100.318372','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (29,'29','NLAC MU','13.799146 ','100.317385','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (30,'30','MUIDS ','13.800060','100.323388','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (31,'31','Institude of Nutrition','13.796113','100.322442','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (32,'32','Swimming pool at SS','13.795674','100.321153','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (33,'33','Faculty of Environment','13.794925','100.322063','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (34,'34','Faculty of Public Health ','13.794737','100.322278','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (35,'35','Post Office MU','13.795309','100.325867','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (36,'36','Condominium','13.800039','100.321199','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (37,'37','KTB Bank','13.793349','100.321957','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (38,'38','Salaya Store','13.793321','100.322751','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (39,'39','Prince Mahidol Hall','13.789561','100.321087','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (40,'40','MS','13.788209','100.324272','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (41,'41','Mahidol Adulyadej-Prasrinakarin Building','13.788846','100.326050','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (42,'42','Research Institute for Languages and Cultures of Asia (RILCA)','13.791114','100.323177','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (43,'43','South East Asian Music Museum','13.790546','100.323102','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (44,'44','Sireerukachart Botanical Garden','13.790188','100.318407','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (45,'45','ASEAN Institute for Health Development','13.791083','100.325695','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (46,'46','Ruen Thai ','13.790556','100.324336','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (47,'47','U•Store by SPVi','13.794332','100.324043','1');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (48,'48','ATM KTB','13.793888','100.325268','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (49,'49','ATM KTB','13.794580','100.323245','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (50,'50','ATM KTB','13.793349','100.321957','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (51,'51','ATM SCB','13.794349','100.325700','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (52,'52','ATM SCB','13.794698','100.325483','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (53,'53','ATM SCB','13.794732','100.325856','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (54,'54','ATM SCB','13.796240','100.324882','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (55,'55','ATM SCB','13.794580','100.322851','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (56,'56','ATM SCB','13.794250','100.321426','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (57,'57','ATM SCB','13.794522','100.319992','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (58,'58','ATM SCB','13.800281','100.320438','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (59,'59','ATM SCB','13.798297','100.318190','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (60,'60','ATM SCB','13.788506','100.324224','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (61,'61','ATM SCB','13.788740','100.324549','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (62,'62','ATM AOMSIN','13.797317','100.321132','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (63,'63','ATM AOMSIN','13.796770','100.321282','2');\n");
            database.execSQL("INSERT INTO `building` (_id,number,name,latitude,longitude,type) VALUES (64,'64','ATM TMB','13.801219','100.318846','2');\n");

        }
    }


//    public void deleteBuilding(TramPath buildingPlace){
//        long id = buildingPlace.getId();
//        System.out.println("TramPath deleted with id: "+id);
//        database.delete(MySQLiteHelper.TABLE_TRAM, MySQLiteHelper.COLUMN_ID+ " = "+id,null);
//    }

    public List<BuildingPlace> getAllComments(){
        List<BuildingPlace> buildingPlaces = new ArrayList<>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_BUILDING, allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            BuildingPlace buildingPlace = cursorToComment(cursor);
            buildingPlaces.add(buildingPlace);
            cursor.moveToNext();
        }
        return buildingPlaces;
    }
    public List<BuildingPlace> getAllType(String type){
        List<BuildingPlace> buildingPlaces = new ArrayList<>();
        String selection =  MySQLiteHelper.COLUMN_TYPE +"=?";
        String []selectionArgs = {type};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BUILDING, allColumns,selection,selectionArgs,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            BuildingPlace buildingPlace = cursorToComment(cursor);
            buildingPlaces.add(buildingPlace);
            cursor.moveToNext();
        }
        return buildingPlaces;
    }

    public List<BuildingPlace> getNearBy(String latmin,String latmax,String longmin,String longmax,String type){
        List<BuildingPlace> buildingPlaces = new ArrayList<>();
        String selection = " ( "+ MySQLiteHelper.COLUMN_LATITUDE+" >= ? AND "+ MySQLiteHelper.COLUMN_LATITUDE+" < ? ) AND ( " + MySQLiteHelper.COLUMN_LONGITUDE+" >= ?  ) AND "+ MySQLiteHelper.COLUMN_LONGITUDE+" < ?  AND ( "+ MySQLiteHelper.COLUMN_TYPE+" = ? )";
        String []selectionArgs = {latmin,latmax,longmin,longmax,type};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BUILDING, allColumns,selection,selectionArgs,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            BuildingPlace buildingPlace = cursorToComment(cursor);
            buildingPlaces.add(buildingPlace);
            cursor.moveToNext();
        }
        return buildingPlaces;
    }



    public BuildingPlace cursorToComment(Cursor cursor){
        BuildingPlace buildingPlace = new BuildingPlace();
        buildingPlace.setId(cursor.getLong(0));
        buildingPlace.setNumber(cursor.getString(1));
        buildingPlace.setName(cursor.getString(2));
        buildingPlace.setLatitude(cursor.getString(3));
        buildingPlace.setLongitude(cursor.getString(4));
        buildingPlace.setType(cursor.getString(5));

        return buildingPlace;
    }
}
