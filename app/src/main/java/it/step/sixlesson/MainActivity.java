package it.step.sixlesson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //@BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;
    //@BindView(R.id.tv) TextView tv;
    @BindView(R.id.drawer) DrawerLayout drawer;
    @BindView(R.id.navigation) NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, TypesActivity.class));
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.drawer.
                                openDrawer(MainActivity.this.navigation);
                    }
                });
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                show();
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.profile:
                startActivity(new Intent(MainActivity.this, TypesActivity.class));
                return true;
            case R.id.settings:
                Toast.makeText(MainActivity.this, "Any text for settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit:
                Toast.makeText(MainActivity.this, "Any text for exit", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;
        }
    }

//    private void show(){
//        Snackbar.make(fab, R.string.test_snack, Snackbar.LENGTH_INDEFINITE)
//                .setAction(R.string.action, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
//    }
}
