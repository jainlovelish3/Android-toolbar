package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar3);
        toolbar.setTitle("My Tool Bar");
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem searchViewItem = menu.findItem(R.id.menuSearch);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)searchViewItem.getActionView();
        searchView.setQueryHint("Search Tutorials ...");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuAbout:
                Toast.makeText(getApplicationContext(),"you clicked About" , Toast.LENGTH_LONG).show();
                break;

            case R.id.menuSetting:
                Toast.makeText(getApplicationContext(),"you clicked SEttings" , Toast.LENGTH_LONG).show();
                break;

            case R.id.menuLogout:
                Toast.makeText(getApplicationContext(),"you clicked Logout" , Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
