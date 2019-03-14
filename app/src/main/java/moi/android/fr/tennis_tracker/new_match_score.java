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


public class new_match_score extends Fragment {

    private Button b_picture, b_localise;
    private new_match_location new_match_location;
    private new_match_pictures new_match_pictures;

    public new_match_score() {
        // Required empty public constructor
    }


    public static new_match_score newInstance(String param1, String param2) {
        return new new_match_score();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_match_score, container, false);

        b_localise = v.findViewById(R.id.localise);
        b_localise.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Start Game in Fragment");
                new_match_location = new new_match_location();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_location);
                fragmentManager.commit();
            }
        });

        b_picture = v.findViewById(R.id.picture);
        b_picture.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Start Game in Fragment");
                new_match_pictures = new new_match_pictures();
                FragmentTransaction fragmentManager = getFragmentManager().beginTransaction();
                fragmentManager.addToBackStack("Replace fragment");
                fragmentManager.replace(R.id.frag_main, new_match_pictures);
                fragmentManager.commit();
            }
        });

        return v;
    }


}
