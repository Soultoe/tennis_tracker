package moi.android.fr.tennis_tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Display_match extends Fragment {

    public TextView player1_name, player1_set1, player1_set2, player1_set3, player1_set4, player1_set5;
    public TextView player2_name, player2_set1, player2_set2, player2_set3, player2_set4, player2_set5;

    public Display_match() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Display_match newInstance(String param1, String param2) {
        Display_match fragment = new Display_match();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_display_match, container, false);

        player1_name = v.findViewById(R.id.player1_name);
        player1_set1 = v.findViewById(R.id.player1_set1);
        player1_set2 = v.findViewById(R.id.player1_set2);
        player1_set3 = v.findViewById(R.id.player1_set3);
        player1_set4 = v.findViewById(R.id.player1_set4);
        player1_set5 = v.findViewById(R.id.player1_set5);

        player2_name = v.findViewById(R.id.player2_name);
        player2_set1 = v.findViewById(R.id.player2_set1);
        player2_set2 = v.findViewById(R.id.player2_set2);
        player2_set3 = v.findViewById(R.id.player2_set3);
        player2_set4 = v.findViewById(R.id.player2_set4);
        player2_set5 = v.findViewById(R.id.player2_set5);



        return v;
    }

    public void setPlayerName(int player, String name){
        if(player==1)
            player1_name.setText(name);
        else
            player2_name.setText(name);
    }

    public void setSetScore(int setNumber, int player, int setScore){

        if(player==1){
            switch (setNumber){
                case 1:
                    player1_set1.setText(setScore);
                    break;
                case 2:
                    player1_set2.setText(setScore);
                    break;
                case 3:
                    player1_set3.setText(setScore);
                    break;
                case 4:
                    player1_set4.setText(setScore);
                    break;
                case 5:
                    player1_set5.setText(setScore);
                    break;
            }
        }
        else{

            switch (setNumber){
                case 1:
                    player2_set1.setText(setScore);
                    break;
                case 2:
                    player2_set2.setText(setScore);
                    break;
                case 3:
                    player2_set3.setText(setScore);
                    break;
                case 4:
                    player2_set4.setText(setScore);
                    break;
                case 5:
                    player2_set5.setText(setScore);
                    break;
            }

        }

    }
}
