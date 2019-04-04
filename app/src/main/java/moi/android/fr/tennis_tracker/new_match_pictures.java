package moi.android.fr.tennis_tracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;

public class new_match_pictures extends Fragment {

    ImageView pic;
    public DBHelper mydb;

    public static new_match_pictures newInstance(String param1, String param2) {

        return new new_match_pictures();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_new_match_pictures, container, false);

        Button OpenCam = v.findViewById(R.id.newPic);
        pic = v.findViewById(R.id.image);

        OpenCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        Bitmap bitmap = (Bitmap) data.getExtras().get("data");

        pic.setImageBitmap(bitmap);

        mydb = new DBHelper(getActivity());
        mydb.insertPicture(bitmap);
    }

}
