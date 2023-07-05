package sahinkalem.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentHome fragmentHome = new FragmentHome();
    FragmentSearch fragmentSearch = new FragmentSearch();
    FragmentSettings fragmentSettings = new FragmentSettings();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.appbar_menu_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.appbar_menu_home) {
            if (this.getClass().getName().equals("MainActivity")) {
                onBackPressed();
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));


        BottomNavigationView fragmentNavigation = findViewById(R.id.fragment_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_layout, fragmentHome).commit();

        fragmentNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_fragment_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_layout, fragmentHome).commit();
                return true;
            } else if (item.getItemId() == R.id.menu_fragment_search) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_layout, fragmentSearch).commit();
                return true;
            } else if (item.getItemId() == R.id.menu_fragment_settings) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_layout, fragmentSettings).commit();
                return true;
            } else return false;
        });
    }
}