package moi.android.fr.tennis_tracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class local_results extends AppCompatActivity {

    public TextView results;
    public DBHelper mydb;
    public Display_match match1, match2, match3, match4, match5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        match1 = new Display_match();
        getSupportFragmentManager().beginTransaction().add(R.id.match1, match1).commit();

        results = findViewById(R.id.match_results);

        mydb = new DBHelper(this);
        ArrayList<ArrayList<String>> array_list = mydb.getAll();
        String rez = "";

        String name1 = array_list.get(0).get(1);
        String name2 = array_list.get(0).get(3);
        String score = array_list.get(0).get(2);

        System.out.println("SWAG NAME1: " + name1);
        System.out.println("SWAG NAME2: " + name2);
        System.out.println("SWAG SCORE: " + score);

        results.setText(String.format(" %s \n %s \n ", results.getText(), name1+ ", " +name2+ ", " +score));

        /*char set1_p1 = score.charAt(0);
        char set2_p1 = score.charAt(1);
        char set3_p1 = score.charAt(2);
        char set4_p1 = score.charAt(3);
        char set5_p1 = score.charAt(4);

        char set1_p2 = score.charAt(5);
        char set2_p2 = score.charAt(6);
        char set3_p2 = score.charAt(7);
        char set4_p2 = score.charAt(8);
        char set5_p2 = score.charAt(9);*/

        /*match1.setPlayerName(1, name1);
        match1.setPlayerName(2,name2);
        match1.setSetScore(1,1,set1_p1);
        match1.setSetScore(2,1,set2_p1);
        match1.setSetScore(3,1,set3_p1);
        match1.setSetScore(4,1,set4_p1);
        match1.setSetScore(5,1,set5_p1);
        match1.setSetScore(1,2,set1_p2);
        match1.setSetScore(2,2,set2_p2);
        match1.setSetScore(3,2,set3_p2);
        match1.setSetScore(4,2,set4_p2);
        match1.setSetScore(5,2,set5_p2);*/
    }

}
