package com.example.notesapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesapp.R;
import com.example.notesapp.models.User;
import com.example.notesapp.repository.UserRepository;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton addnote;
    private TextView hello;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addnote=findViewById(R.id.floatingActionButton);
        hello=findViewById(R.id.name_user);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username=sharedPreferences.getString("username",null);

        User user=UserRepository.getUser(username);
        hello.setText(user.getFullname());


        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_note();
            }
        });
    }

    public void new_note(){
        Intent intent=new Intent(this,AddNoteActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.progress_circular:
                Toast.makeText(this, "Refrescar las notas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_takepicture:
                Toast.makeText(this, "Tomando una foto...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_day_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista diaria activada...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_week_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista semanal activada...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_month_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista mensual activada...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
