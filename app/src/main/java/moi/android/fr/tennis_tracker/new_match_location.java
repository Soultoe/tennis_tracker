package moi.android.fr.tennis_tracker;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;

public class new_match_location extends Fragment {

    public new_match_location() {
        // Required empty public constructor
    }

    public static new_match_location newInstance() {
        return new new_match_location();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Create the Fragment Map
        View v = inflater.inflate(R.layout.fragment_new_match_location, container, false);

        return v;
    }

    public void getMapAsync(new_match_score new_match_score) {

        System.out.println("In the _location");
    }
}
