package moi.android.fr.tennis_tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class new_match_players extends Fragment {

    private Button b_start_game;
    private new_match_score new_match_score;

    public new_match_players() {
        // Required empty public constructor
    }

    public static new_match_players newInstance(String param1, String param2) {
        return new new_match_players();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_match_players, container, false);

        b_start_game = v.findViewById(R.id.start_game);
        b_start_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Start Game in Fragment");
                new_match_score = new new_match_score();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_score);
                fragmentManager.commit();
            }
        });

        return v;
    }

}
