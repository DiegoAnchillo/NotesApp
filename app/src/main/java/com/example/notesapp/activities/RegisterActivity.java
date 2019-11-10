package com.example.notesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notesapp.R;
import com.example.notesapp.repository.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText userInput;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText contraseñaInput;
    private Button register_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userInput=findViewById(R.id.user_input);
        fullnameInput=findViewById(R.id.fullname_input);
        emailInput=findViewById(R.id.email_input);
        contraseñaInput=findViewById(R.id.password_input);
        register_user=findViewById(R.id.register_button);

        register_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_register();
            }
        });
    }

    public void new_register(){
        String user=userInput.getText().toString();
        String fullname=fullnameInput.getText().toString();
        String email=emailInput.getText().toString();
        String password=contraseñaInput.getText().toString();

        if(user.isEmpty()||fullname.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"Rellene estos campos porfavor",Toast.LENGTH_LONG).show();
            return;
        }
        UserRepository.create(user,fullname, email, password);

        finish();


    }
}
