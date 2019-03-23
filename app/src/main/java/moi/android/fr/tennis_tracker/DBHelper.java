package moi.android.fr.tennis_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tennis_match where id="+id+"", null );
        return res;
    }

    public ArrayList<String> getAll() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tennis_match", null );
        res.moveToFirst();

        array_list.add("Player1: " + res.getString(1)+ ", Player2: " + res.getString(2)+ ", Score: " + res.getString(3));

        /*while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(MATCH_COLUMN_ID)));
            res.moveToNext();
        }*/
        return array_list;
    }
}
