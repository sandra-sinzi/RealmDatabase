package com.example.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realm.Teacher.Teddy;

import io.realm.Realm;
import io.realm.RealmResults;


public class Register extends AppCompatActivity {
    private static final String TAG="Register";
    EditText Username;
    EditText Password;
    Button Register;
    TextView display;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Username=(EditText)findViewById(R.id.Username);
        Password=(EditText)findViewById(R.id.Password);
        Register=(Button) findViewById(R.id.Register);
        display=(TextView) findViewById(R.id.display);
        Log.d(TAG, "onCreate:View initialazation dane");
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regesterdata();
                readdata();
            }
        });
    }
    private void regesterdata() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Teddy user = bgRealm.createObject(Teddy.class);
                user.setUsername(Username.getText().toString().trim());
                user.setPassword(Integer.parseInt(Password.getText().toString().trim()));
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.d(TAG, "on success:data store successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.d(TAG, "on success :data is not store");
            }
        });
    }
    private void readdata() {
        RealmResults<Teddy> Teddy = realm.where(Teddy.class).findAll();
        display.setText("");
        String data = "";
        for (Teddy User: Teddy) {
            try {
                Log.d(TAG, "insect data");
                data = data + "\n" + Teddy.toString();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            display.setText(data);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            Toast.makeText(getApplicationContext(), "logout succefully", Toast.LENGTH_LONG).show();
        } else if (id == android.R.id.home) {
            finish();

        }
        return super.onOptionsItemSelected(item);
    }



}
