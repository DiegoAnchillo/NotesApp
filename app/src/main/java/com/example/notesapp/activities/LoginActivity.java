package com.example.notesapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notesapp.R;
import com.example.notesapp.models.User;
import com.example.notesapp.repository.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText contraseña;
    private Button login_user;
    private Button register_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=findViewById(R.id.user);
        contraseña=findViewById(R.id.password);
        login_user=findViewById(R.id.login);
        register_user=findViewById(R.id.register);

        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        register_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void login(){
        String user_input=usuario.getText().toString();
        String password_input=contraseña.getText().toString();

        if (user_input.isEmpty()||password_input.isEmpty()){
            Toast.makeText(this,"Rellenar estos campos",Toast.LENGTH_LONG).show();
        }

        User user= UserRepository.login(user_input,password_input);
        if (user==null){
            Toast.makeText(this, "Usuario o Contraseña invalida", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Hola " + user.getFullname(), Toast.LENGTH_SHORT).show();
        goNotes();

        }


    public void goNotes(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void register(){
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
