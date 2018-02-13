//敦也さんが打ちました
package com.example.myshisakuapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //マップ表示
        mMap = googleMap;

        //Add a marker in Sydney and move the camera

        Intent intent = getIntent();
        //起動から受け取った値
        LatLng sangi = new LatLng(intent.getDoubleExtra("lat", 0), intent.getDoubleExtra("lot", 0));
        mMap.addMarker(new MarkerOptions().position(sangi).title("M"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sangi));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sangi, 15));

        //けいたが打った
        //マーカー追加セット
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.307049, 138.965078)).title("御殿場プレミアムアウトレット").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("gotenba", 150, 100))));

        mMap.addMarker(new MarkerOptions().position(new LatLng(35.019483, 138.895966)).title("伊豆・三津シーパラダイス").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("mitoshi", 150, 100))));

        mMap.addMarker(new MarkerOptions().position(new LatLng(34.762059, 137.634588)).title("浜松フラワーパーク").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("hamanatufurawaer", 150, 100))));

        mMap.addMarker(new MarkerOptions().position(new LatLng(34.73315, 137.576666)).title("浜名湖").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("hamanako", 150, 100))));

        mMap.addMarker(new MarkerOptions().position(new LatLng(34.983103, 138.406868)).title("静岡産業技術専門学校").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("sangi", 150, 100))));


        //マーカー押したときの処理
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override

            public boolean onMarkerClick(Marker marker) {

                String id = marker.getId();

                if (id.equals("m1")) {

                    Uri webpage = Uri.parse("http://www.premiumoutlets.co.jp/gotemba/");

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (intent.resolveActivity(getPackageManager()) != null) {

                        startActivity(intent);
                    }


                } else if (id.equals("m2")) {

                    Uri webpage1 = Uri.parse("http://www.izuhakone.co.jp/seapara/");

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage1);


                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }


                } else if (id.equals("m3")) {

                    Uri webpage2 = Uri.parse("https://e-flowerpark.com/");

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage2);


                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                } else if (id.equals("m4")) {
                    Uri webpage3 = Uri.parse("https://ja.wikipedia.org/wiki/%E6%B5%9C%E5%90%8D%E6%B9%96");

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage3);


                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                } else if (id.equals("m5")) {
                    Uri webpage4 = Uri.parse("http://www.sangi.ac.jp/");

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage4);


                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }

                return false;

            }

        });
    }






    public Bitmap resizeMapIcons(String iconName, int width , int height){

        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }


}

