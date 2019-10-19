package com.example.kakicomeets_sell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Kakicomeets_Sell_Activity extends AppCompatActivity {

    private final static int RESULT_CAMERA = 1001;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakicomeets_sell);

        imageView = findViewById(R.id.sellTakePhotoView);

        ImageView sellTakePhotoview (ImageView)this.findViewById(R.id.sellTakePhotoView);
        sellTakePhotoview.setImageResource(R.drawable.ic_launcher);

        sellTakePhotoview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, RESULT_CAMERA);
                    }
                }
        );
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.getExtras() == null){
            Log.d("debug","cancel ?");
            return;
        }
        else {
            bitmap = (Bitmap) data.getExtras().get("data");
            if(bitmap != null){
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();
                Log.d("debug"),String.format("w= %d",bmpWidth));
                Log.d("debug",String.format("h= %d",bmpHeight));

            }
        }

        imageView.setImageBitmap(bitmap);
    }
}
