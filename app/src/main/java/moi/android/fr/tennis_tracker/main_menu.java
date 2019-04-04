package moi.android.fr.tennis_tracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class main_menu extends Fragment {

    public OnKeyListener buttonPressed;
    public Button b_new_game, b_local_results, b_remote_results, pics;
    public new_match_players new_match_players;


    public main_menu() {
        // Required empty public constructor
    }


    public static main_menu newInstance(String param1, String param2) {
        return new main_menu();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        b_new_game = v.findViewById(R.id.new_game);
        b_new_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("New Game in Fragment");
                new_match_players = new new_match_players();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_players);
                fragmentManager.commit();
            }
        });

        b_local_results = v.findViewById(R.id.local_results);
        b_local_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), local_results.class);
                startActivity(intent2);
            }
        });

        b_remote_results = v.findViewById(R.id.remote_results);
        b_remote_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), remote_results.class);
                startActivity(intent2);
            }
        });

        pics = v.findViewById(R.id.picture);
        pics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), AddPictures.class);
                startActivity(intent2);
            }
        });

        return v;
    }

    public interface OnKeyListener {
        // TODO: Update argument type and name
        void onNumberKey(String number);
        void onOperationKey(String operation);
        void onEqualKey(Boolean equal); //maybe send a boolean indicating = has been pressed
    }

}
