package moi.android.fr.tennis_tracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddPictures extends AppCompatActivity {

    ImageView pic;
    public DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pictures);

        Button OpenCam = findViewById(R.id.newPic);
        pic = findViewById(R.id.image);

        OpenCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        Bitmap bitmap = (Bitmap) data.getExtras().get("data");

        pic.setImageBitmap(bitmap);

        mydb = new DBHelper(this);
        mydb.insertPicture(bitmap);
    }
}
