package moi.android.fr.tennis_tracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {

    private GoogleMap mMap;
    private MarkerOptions markerPosition;
    private MarkerOptions markerClick;

    public MapFragment newInstance() {
        MapFragment m = new MapFragment();
        return m;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        return v;
    }

    public void getMapAsync(new_match_score new_match_score) {
        System.out.println("In MapFragment");

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37, -122))
                .title("Marker"));
    }
}