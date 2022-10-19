package com.cv.projectlabux_kelompok1_bc01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class GameDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        SharedPreferences sp = getSharedPreferences("gameData", Context.MODE_PRIVATE);
        TextView title = findViewById(R.id.game_title_textview);
        TextView year = findViewById(R.id.game_year_textview);
        TextView price = findViewById(R.id.game_price_textview);
        TextView description = findViewById(R.id.game_description_textview);
        ImageView display = findViewById(R.id.game_display_imageview);

        EditText quantity = findViewById(R.id.quantity_editText);
        Button buy = findViewById(R.id.buy_btn);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GameDetailActivity.this);

        title.setText(sp.getString("title", ""));
        year.setText(sp.getString("year", ""));
        price.setText(sp.getString("price", ""));
        description.setText(sp.getString("description", ""));
        display.setImageResource(sp.getInt("image", 0));

        ImageView back = findViewById(R.id.back_btn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProducts = new Intent(GameDetailActivity.this, ProductsActivity.class);
                startActivity(toProducts);
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity.getText().toString().length() == 0){
                    Snackbar.make(view, "Quantity must be filled", Snackbar.LENGTH_LONG)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }).show();
                }else if(Integer.parseInt(quantity.getText().toString()) <= 0){
                    dialogBuilder.setTitle("Error");
                    dialogBuilder.setMessage("Your purchase failed, quantity must be greater than 0!");
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog;
                    dialog = dialogBuilder.create();
                    dialog.show();
                }else{
                    dialogBuilder.setTitle("Success");
                    dialogBuilder.setMessage("Your purchase succeed!");
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent toProducts = new Intent(GameDetailActivity.this, ProductsActivity.class);
                            startActivity(toProducts);
                        }
                    });
                    AlertDialog dialog;
                    dialog = dialogBuilder.create();
                    dialog.show();
                }
            }
        });

    }

}