package cn.edu.gdmec.a07150810.mycontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by qaq on 2016/11/15.
 */
public class MyDB extends SQLiteOpenHelper{
    private static String DB_NAME="My_DB.db";
    private static int DB_VERSION=2;
    private SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public MyDB(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        db=getWritableDatabase();
    }
    public SQLiteDatabase openConnection(){
        if(!db.isOpen()){
            db=getWritableDatabase();
        }
        return db;
    }
    public boolean isTableExits(String tablename) {
        try{
            openConnection();
            String str="select count(*)xcount from"+tablename;
            db.rawQuery(str,null).close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean createTable(String createTableSql) {
        try{
            openConnection();
            db.execSQL(createTableSql);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean save(String tableName, ContentValues values) {
        try{
            openConnection();
            db.insert(tableName,null,values);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public Cursor find(String findSql, String obj[]) {
        try{
            openConnection();
            Cursor cursor=db.rawQuery(findSql,obj);
            return cursor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public boolean update(String table,ContentValues values,String whereClause,String[] whereArgs){
        try{
            openConnection();
            db.update(table,values,whereClause,whereArgs);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean delete(String table, String deleteSql, String obj[]) {
        try{
            openConnection();
            db.delete(table,deleteSql,obj);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
}
