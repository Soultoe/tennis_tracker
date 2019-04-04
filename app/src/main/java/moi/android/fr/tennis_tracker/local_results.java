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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        results = findViewById(R.id.match_results);

        mydb = new DBHelper(this);
        ArrayList<ArrayList<String>> array_list = mydb.getAll();
        String rez = "";

        String name1, name2, score;

        for(int i=0; i<array_list.size();i++) {
            name1 = array_list.get(0).get(1);
            name2 = array_list.get(0).get(3);
            score = array_list.get(0).get(2);
            results.setText(String.format(" %s \n %s \n ", results.getText(), "Player1: " + name1+ "\nPlayer2: " +name2+ "\nScore: " +score));
        }






    }

}
