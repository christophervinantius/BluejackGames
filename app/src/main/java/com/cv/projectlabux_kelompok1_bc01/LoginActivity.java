package com.cv.projectlabux_kelompok1_bc01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username_edittext);
        EditText password = findViewById(R.id.password_edittext);
        Button login = findViewById(R.id.login_btn);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);

        SharedPreferences sp = getSharedPreferences("userData", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length() == 0){
                    dialogBuilder.setTitle("Error");
                    dialogBuilder.setMessage("Username cannot be empty!");
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog;
                    dialog = dialogBuilder.create();
                    dialog.show();
                }else if(username.getText().toString().length() <= 3){
                    dialogBuilder.setTitle("Error");
                    dialogBuilder.setMessage("Username's total characters must be greater than 3!");
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog;
                    dialog = dialogBuilder.create();
                    dialog.show();
                }else if(password.getText().toString().length() == 0){
                    dialogBuilder.setTitle("Error");
                    dialogBuilder.setMessage("Password must be filled!");
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog;
                    dialog = dialogBuilder.create();
                    dialog.show();
                }else{
                    edit.putString("username", username.getText().toString());
                    edit.putString("password", password.getText().toString());
                    edit.apply();
                    Intent toHome = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(toHome);
                }
            }
        });

    }
}