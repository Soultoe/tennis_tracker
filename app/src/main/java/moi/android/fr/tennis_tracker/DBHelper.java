package moi.android.fr.tennis_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tennis_tracker.db";
    public static final String MATCH_TABLE_NAME = "tennis_match";
    public static final String MATCH_COLUMN_ID = "id_match";
    public static final String MATCH_PLAYER_1 = "player1";
    public static final String MATCH_PLAYER_2 = "player2";
    public static final String MATCH_SCORE = "score";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table if not exists tennis_match " +
                        "(id integer primary key, player1 text,player2 text,score text)"
        );

        db.execSQL(
                "create table if not exists pictures " +
                        "(id integer primary key autoincrement, image BLOB)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertMatch (String p1, String p2, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("player1", p1);
        contentValues.put("player2", p2);
        contentValues.put("score", score);
        db.insert("tennis_match", null, contentValues);
        return true;
    }

    public boolean insertPicture(Bitmap image){
        SQLiteDatabase db = this.getWritableDatabase();
        byte[] inBytes = DbBitmapUtility.getBytes(image);
        ContentValues contentValues = new ContentValues();
        contentValues.put("image", inBytes);
        db.insert("pictures", null, contentValues);
        return true;
    }

    public boolean updateMatchScore(String score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", score);

        //UPDATE table set col = 1 WHERE id = (SELECT MAX(id) FROM table)
        //update(TABLENAME, contentValues,"ID=?",new String[] {id});

        String lastId = getLastId();
        System.out.println("THE LAST ID: " + lastId);

        int myInt = db.update("tennis_match",contentValues,"ID=?",new String[] {lastId});
        System.out.println("UPDATE SUCCESSFUL: " + myInt);

        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tennis_match where id="+id+"", null );
        return res;
    }

    public String getLastId(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select id from tennis_match where id = (select MAX(id) from tennis_match)", null );
        res.moveToFirst();

        return res.getString(0);
    }

    public ArrayList<ArrayList<String>> getAll() {
        ArrayList<ArrayList<String>> array_list = new ArrayList<>();
        ArrayList<String> buffer = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tennis_match", null );
        res.moveToFirst();

        //array_list.add("Player1: " + res.getString(1)+ ", Player2: " + res.getString(2)+ ", Score: " + res.getString(3));

        while(!res.isAfterLast()){
            //array_list.add("Player1: " + res.getString(1)+ ", Player2: " + res.getString(2)+ ", Score: " + res.getString(3));
            buffer.add(res.getString(1));
            buffer.add(res.getString(2));
            buffer.add(res.getString(3));
            array_list.add(buffer);
            res.moveToNext();
        }
        return array_list;
    }


}
