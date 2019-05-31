package com.example.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username;
    EditText Password;
    Button Login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.Login);
        Register = (Button) findViewById(R.id.Register);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = Username.getText().toString();
                String Pass = Password.getText().toString();
                if (User.equals("") || Pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter your Username and Password", Toast.LENGTH_LONG).show();
                }
                else if (User.equals("sandra") && Pass.equals("123")) {
                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "invalid Username or Password ", Toast.LENGTH_LONG).show();
                }

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Register successful", Toast.LENGTH_LONG).show();
                Intent inti = new Intent(MainActivity.this,Register.class);
                startActivity(inti);

            }
        });



        }
}
