package com.example.myshisakuapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.R.id.button2;
import static android.R.id.title;


public class KidouActivity extends AppCompatActivity {

    private Button Izubutton;
    private Button Shizuoka;
    private Button Hamamatsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidou);


        //試作背景画像
        ImageView imageView = (ImageView)findViewById(R.id.backGroundImage);
        imageView.setImageResource(R.drawable.haikei);


        //クリックイベントを取得したいボタン

        //伊豆ボタン
        Izubutton = (Button)findViewById(R.id.Izubutton);

        //静岡ボタン
        Shizuoka = (Button)findViewById(R.id.Shizuokabutton);

        //浜松ボタン
        Hamamatsu = (Button)findViewById(R.id.Hamamatsubutton);


        // 伊豆ボタンをクリックしたとき
        Izubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MapsActivity.class);
                intent.putExtra("lat",34.9765857);
                intent.putExtra("lot",138.9467040);
                startActivity(intent);



            }
        });

        //静岡ボタンをクリックしたとき
        Shizuoka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("lat",34.983419);
                intent.putExtra("lot",138.406868);

                startActivity(intent);

            }
        });

        //浜松ボタンを押したとき
        Hamamatsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("lat",34.7108344);
                intent.putExtra("lot",137.7261258);

                startActivity(intent);
            }
        });
    }
}
