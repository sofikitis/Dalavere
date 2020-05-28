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

import com.example.myapplication.obj.Wallet;
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


public class MapActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    GoogleMap mapApi;
    SupportMapFragment mapFragment;
    private Button details_button;



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

    public void onMapReady(GoogleMap googleMap) {
        mapApi = googleMap;

        LatLng patra = new LatLng(38.230462, 21.753150);
        Marker marker = mapApi.addMarker(new MarkerOptions()
                .position(patra)
                .title("haha b0y 1")
                .snippet("Request Timer: 30'" + "\n" +
                        "User Rating: **** " + "\n" +
                        "Price range of service: 20-25$" + "\n" +
                        "Service free:10%" + "\n" +
                        "Tip: None" + "\n" +
                        "Distance:1km")

        );

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
	/////////////////////////////////////////////////////////////////
////////////// NAVIGATION BAR MENU ITEM ON CLICK EVENT HANDLER //////////////////
////////////// BY VAGOS_MC (ENA YO GIA KATHE CLICK ) //////////////////
/////////////////////////////////////////////////////////////////////////
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
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
