package moi.android.fr.tennis_tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class new_match_score extends Fragment {

    private Button b_picture, b_localise;
    private new_match_location new_match_location;
    private new_match_pictures new_match_pictures;

    private Button b_point_p1, b_point_p2;
    private TextView point_1, point_2;

    private int current_set;
    private ArrayList<Integer> sets_1;
    private ArrayList<Integer> sets_2;
    private TextView set_1_1, set_2_1, set_3_1, set_4_1, set_5_1;
    private TextView set_1_2, set_2_2, set_3_2, set_4_2, set_5_2;

    public new_match_score() {
        // Required empty public constructor
    }


    public static new_match_score newInstance(String param1, String param2) {
        return new new_match_score();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sets_1 = new ArrayList<>();
        sets_1.add(0);
        sets_1.add(0);
        sets_1.add(0);
        sets_1.add(0);
        sets_1.add(0);
        sets_2 = new ArrayList<>();
        sets_2.add(0);
        sets_2.add(0);
        sets_2.add(0);
        sets_2.add(0);
        sets_2.add(0);
        current_set = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_match_score, container, false);

        b_localise = v.findViewById(R.id.localise);
        b_localise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Start Game in Fragment");
                new_match_location = new new_match_location();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_location);
                fragmentManager.commit();
            }
        });

        b_picture = v.findViewById(R.id.picture);
        b_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Start Game in Fragment");
                new_match_pictures = new new_match_pictures();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_pictures);
                fragmentManager.commit();
            }
        });

        b_point_p1 = v.findViewById(R.id.point_p1);
        b_point_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPoint(1); // Send player number
            }
        });

        b_point_p2 = v.findViewById(R.id.point_p2);
        b_point_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPoint(2); // Send player number
            }
        });


        point_1 = v.findViewById(R.id.score_1_point);
        point_2 = v.findViewById(R.id.score_2_point);

        set_1_1 = v.findViewById(R.id.score_1_set_1);
        set_2_1 = v.findViewById(R.id.score_1_set_2);
        set_3_1 = v.findViewById(R.id.score_1_set_3);
        set_4_1 = v.findViewById(R.id.score_1_set_4);
        set_5_1 = v.findViewById(R.id.score_1_set_5);

        set_1_2 = v.findViewById(R.id.score_2_set_1);
        set_2_2 = v.findViewById(R.id.score_2_set_2);
        set_3_2 = v.findViewById(R.id.score_2_set_3);
        set_4_2 = v.findViewById(R.id.score_2_set_4);
        set_5_2 = v.findViewById(R.id.score_2_set_5);


        return v;
    }

    public void addSet(int player) {
        TextView t = null;
        TextView other_t = null;
        int set_point = 0;

        if (player == 1) {
            switch (current_set) {
                case 0:
                    t = set_1_1;
                    other_t = set_1_2;
                    set_point = sets_1.get(0);
                    set_point += 1;
                    sets_1.set(0, set_point);
                    break;
                case 1:
                    t = set_2_1;
                    other_t = set_2_2;
                    set_point = sets_1.get(1);
                    set_point += 1;
                    sets_1.set(1, set_point);
                    break;
                case 2:
                    t = set_3_1;
                    other_t = set_3_2;
                    set_point = sets_1.get(2);
                    set_point += 1;
                    sets_1.set(2, set_point);
                    break;
                case 3:
                    t = set_4_1;
                    other_t = set_4_2;
                    set_point = sets_1.get(3);
                    set_point += 1;
                    sets_1.set(3, set_point);
                    break;
                case 4:
                    t = set_5_1;
                    other_t = set_5_2;
                    set_point = sets_1.get(4);
                    set_point += 1;
                    sets_1.set(4, set_point);
                    break;

            }
        } else {
            switch (current_set) {
                case 0:
                    t = set_1_2;
                    other_t = set_1_1;
                    set_point = sets_2.get(0);
                    set_point += 1;
                    sets_2.set(0, set_point);
                    break;
                case 1:
                    t = set_2_2;
                    other_t = set_2_1;
                    set_point = sets_2.get(1);
                    set_point += 1;
                    sets_2.set(1, set_point);
                    break;
                case 2:
                    t = set_3_2;
                    other_t = set_3_1;
                    set_point = sets_2.get(2);
                    set_point += 1;
                    sets_2.set(2, set_point);
                    break;
                case 3:
                    t = set_4_2;
                    other_t = set_4_1;
                    set_point = sets_2.get(3);
                    set_point += 1;
                    sets_2.set(3, set_point);
                    break;
                case 4:
                    t = set_5_2;
                    other_t = set_5_1;
                    set_point = sets_2.get(4);
                    set_point += 1;
                    sets_2.set(4, set_point);
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (sets_1.get(i) >= 7) {
                if(sets_2.get(i) >= 5){
                    if (sets_1.get(i) == 8) {
                        sets_1.set(i, 7);
                        sets_1.set(i+1, 1);
                        set_point = 7;
                        current_set += 1;
                    }
                }
                else {
                    sets_1.set(i, 6);
                    sets_1.set(i + 1, 1);
                    set_point = 6;
                    current_set += 1;
                }

            } else if (sets_2.get(i) == 7) {
                if(sets_1.get(i) >5){
                    if(sets_2.get(i) == 8){
                        sets_2.set(i, 7);
                        sets_2.set(i+1, 1);
                        set_point = 7;
                        current_set += 1;
                    }
                }
                else {
                    sets_2.set(i, 6);
                    sets_2.set(i + 1, 1);
                    set_point = 6;
                    current_set += 1;
                }
            }
        }

        t.setText(set_point + "");
    }


    public void addPoint(int player) {
        int score = getTextScore(player);

        int other_player = 0;
        if (player == 1) {
            other_player = 2;
        } else {
            other_player = 1;
        }
        int other_score = getTextScore(other_player);

        System.out.println(score);

        if (score == 0) {
            score += 1;
        } else if (score == 1) {
            score += 1;
        } else if (score == 2) {
            score += 1;
        } else if (score == 3) { //has 40
            if (other_score <= 2) { // ennemy has 0, 15, 30
                //win game
                score = 0;
                other_score = 0;

                addSet(player);
            } else if (other_score == 3) { // enemy has 40
                score += 1; // player advantage
            } else if (other_score == 4) { // ennemy has advantage
                other_score -= 1; // ennemy looses advantage
            }
        } else if (score == 4) { // has advantage
            //win game
            score = 0;
            other_score = 0;

            addSet(player);
        }

        updateText(other_score, other_player);
        updateText(score, player);
    }

    public int getTextScore(int player) {
        TextView point = null;
        if (player == 1) {
            point = point_1;
        } else if (player == 2) {
            point = point_2;
        }
        String score = (String) point.getText();

        switch (score) {
            case "0":
                return 0;
            case "15":
                return 1;
            case "30":
                return 2;
            case "40":
                return 3;
            case "Av":
                return 4;
        }
        return 0;
    }

    public void updateText(int s, int player) {
        TextView point = null;
        if (player == 1) {
            point = point_1;
        } else {
            point = point_2;
        }

        switch (s) {
            case 0:
                point.setText(0 + "");
                break;
            case 1:
                point.setText(15 + "");
                break;
            case 2:
                point.setText(30 + "");
                break;
            case 3:
                point.setText(40 + "");
                break;
            case 4:
                point.setText("Av" + "");
                break;
        }
    }

}
