package com.example.mymenunavegacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar myToolbar;
    DrawerLayout mydrawerLayout;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(myToolbar);

        mydrawerLayout = findViewById(R.id.myDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mydrawerLayout, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mydrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.miNavigation);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

         View header = navigationView.getHeaderView(0);
        TextView myNombre = header.findViewById(R.id.minimbre);
        myNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Si has llegado aquí, eres un monstruo",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(mydrawerLayout.isDrawerOpen(GravityCompat.START)){
            mydrawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        showFragment(item);
        mydrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(MenuItem item) {
        String titulo;
        FragmentManager my_fragmentManager = getSupportFragmentManager();
        FragmentTransaction my_transction = my_fragmentManager.beginTransaction();

        switch (item.getItemId()){
            case R.id.id_inicio:
                titulo = "Home";
                WebFragment fragment1 = new WebFragment();
                my_transction.replace(R.id.myLayout, fragment1);

                my_transction.commit();
                setTitle(titulo);
                return;
            case R.id.id_horario:
                titulo = "horario";

                HorariosFragment fragment2 = new HorariosFragment();
                my_transction.replace(R.id.myLayout, fragment2);

                my_transction.commit();
                setTitle(titulo);
                return;
            case R.id.id_calendario:
                titulo = "Calendario";
                EventosFragment fragment3 = new EventosFragment();
                my_transction.replace(R.id.myLayout, fragment3);

                my_transction.commit();
                setTitle(titulo);
                return;
            case R.id.id_add:
                titulo = "Añadir Eventos";
                AnyadirFragment fragment4 = new AnyadirFragment();
                my_transction.replace(R.id.myLayout, fragment4);

                my_transction.commit();
                setTitle(titulo);
                return;
            case R.id.id_salir:
                System.exit(0);
            default:
                throw  new IllegalArgumentException("Menu option not implemented!!");
        }
    }
}