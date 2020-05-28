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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.obj.Deliverer;
import com.example.myapplication.obj.Order;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.Map;
import java.util.Random;


public class MapActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener  {
    public static GoogleMap mapApi;
    private DrawerLayout drawer;
    // public GoogleMap mapApi;
    SupportMapFragment mapFragment;
    private Button details_button;
    Random r = new Random();
    private int i;





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
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //-------------------------------------------------------------------------------
        details_button = (Button) findViewById(R.id.details_button);

    }

    public void showOrders(Order ord){
        LatLng patra1 = new LatLng(ord.address_obj.lat, ord.address_obj.lon);
        Marker marker1 = mapApi.addMarker(new MarkerOptions()
                .position(patra1)
                .title(String.valueOf(ord.id))
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE ))
                .snippet("Request Timer: " + ord.minutes + "\n" +
                        "User Rating: " + ord.userObj.rating + "\n" +
                        "Price of service: " + ord.estimated_cost + "\n" +
                        "Service fee: 10%" + "\n" +
                        "Tip: None" + "\n" +
                        "Distance: 1km"));
    }

    public void showDeliverers(Deliverer del){
        LatLng patra1 = new LatLng(del.avail.location.lat, del.avail.location.lon);
        Marker marker1 = mapApi.addMarker(new MarkerOptions()
                .position(patra1)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("Deliverer")
                .snippet("Available for: " + del.avail.minutes + " minutes" + "\n" +
                        "User Rating: " + del.rating + "\n" +
                        "Max Cost: " + del.avail.max_cost + "\n" +
                        "Radius: "  + del.avail.radius));

    }

    public void onMapReady(GoogleMap googleMap) {
        mapApi = googleMap;

        for (int j = 0; j<MainActivity.orderList.size(); j++) {
            showOrders(MainActivity.orderList.get(j));
        }

        for (int j = 0; j<MainActivity.delivererList.size(); j++) {
            showDeliverers(MainActivity.delivererList.get(j));
        }

        if (mapApi != null){
            mapApi.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    Log.d("ONCLICK", "12345678");
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
        if(marker.getTitle().equals("Deliverer")){
            Intent intent = new Intent(this, DelivererActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("ORDER", marker.getTitle());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.wallet) {                                                          // ama epileksei to wallet option
            Log.d("testtag", "doulepse");														     // pigene sto activity wallet_ui page
            Intent intent = new Intent(this, wallet_ui.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation
        } else if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if (item.getItemId() == R.id.account){
            Toast.makeText(MapActivity.this, "o sofikitis einai gay", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.prefer){
            Toast.makeText(MapActivity.this, "o sofikitis einai gay", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.delivery){
            Toast.makeText(MapActivity.this, "o sofikitis einai gay", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.order){
            Toast.makeText(MapActivity.this, "o sofikitis einai gay POLI GAY", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.wallet) {
            Log.d("Show", String.valueOf(MainActivity.mc_vagos.myWallet.balance));
            //Toast.makeText(this, String.valueOf(MainActivity.mc_vagos.myWallet.balance), Toast.LENGTH_SHORT).show();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }*/
}