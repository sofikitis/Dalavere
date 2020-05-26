package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.obj.Order;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.Map;
import java.util.Random;


public class MapActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {
    public static GoogleMap mapApi;
    private DrawerLayout drawer;
   // public GoogleMap mapApi;
    SupportMapFragment mapFragment;
    private Button details_button;
    Random r = new Random();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //-------- map fragment -----------------
            mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
            mapFragment.getMapAsync(this);
        //--------------------------------------
        //--------------------------------------------- TOOLBAR-----------------------
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        //-------------------------------------------------------------------------------
        details_button = (Button) findViewById(R.id.details_button);

    }

    public void testMap(Order ord){
        LatLng patra1 = new LatLng(ord.address_obj.lat, ord.address_obj.lon);
        Marker marker1 = mapApi.addMarker(new MarkerOptions()
                .position(patra1)
                .snippet("Request Timer: " + ord.minutes + "\n" +
                        "User Rating: " + ord.userObj.rating + "\n" +
                        "Price of service: " + ord.estimated_cost + "\n" +
                        "Service fee:10%" + "\n" +
                        "Tip: None" + "\n" +
                        "Distance:1km"));
    }


    public void onMapReady(GoogleMap googleMap) {
        mapApi = googleMap;

        //Order order_obj = new Order(null, null, null,14.6, 20);
        testMap(MainActivity.orderList.get(0));
        testMap(MainActivity.orderList.get(1));


        //Order order_obj1 = new Order(null, null, null,38.5, 20);
        // order_obj.testMap(x, y);
        //LatLng patra = new LatLng(38.230462, 21.753150);


        /*Marker marker = mapApi.addMarker(new MarkerOptions()
                .position(patra)
                .title("Delivery boy 1")
                .snippet("Request Timer: 30'" + "\n" +
                        "User Rating: **** " + "\n" +
                        "Price range of service: 20-25$" + "\n" +
                        "Service free:10%" + "\n" +
                        "Tip: None" + "\n" +
                        "Distance:1km")

        );*/

        if (mapApi != null){
            mapApi.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {

                    return null;
                }

                @Override                            //custom info window gia to pop-up pin toy anthropoy poy psaxnei delivera
                public View getInfoContents(Marker marker) {
                    View row = getLayoutInflater().inflate(R.layout.custom_info_window, null);
                    TextView t1_title = (TextView) row.findViewById(R.id.title);
                    TextView t2_snippet = (TextView) row.findViewById(R.id.snippet);
                    Button b1_details_button = (Button) row.findViewById(R.id.details_button);

                    t1_title.setText(marker.getTitle());
                    t2_snippet.setText(marker.getSnippet());


                    return row;
                }
            });
        }
        mapApi.setOnInfoWindowClickListener(this);

    }



    private void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override                //se paei sto details page poy o deliveras kitaei k epikinonei me ton pelati
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.wallet) {
            Log.d("Show", String.valueOf(MainActivity.mc_vagos.myWallet.balance));
            //Toast.makeText(this, String.valueOf(MainActivity.mc_vagos.myWallet.balance), Toast.LENGTH_SHORT).show();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
