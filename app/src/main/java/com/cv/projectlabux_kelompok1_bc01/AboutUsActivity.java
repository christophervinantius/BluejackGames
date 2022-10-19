package com.cv.projectlabux_kelompok1_bc01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class AboutUsActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.assasins_slideshow,
            R.drawable.cyberpunk_slideshow,
            R.drawable.jedi_slideshow,
            R.drawable.spiderman_2_slideshow,
            R.drawable.spiderman_slideshow,
            R.drawable.shadow_of_tomb_raider_slideshow,
            R.drawable.tomb_raider_slideshow
    };

    ViewFlipper viewFliper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        viewFliper = findViewById(R.id.carousel);
        for(int image : images){
            addImageToFlipper(image);
        }

        Spinner aboutUsDropdown = findViewById(R.id.about_us_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AboutUsActivity.this,
                R.array.about_dropdown, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        aboutUsDropdown.setAdapter(adapter);
        aboutUsDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String option = adapterView.getItemAtPosition(i).toString();
                if(option.equals("Home")){
                    Intent toHome = new Intent(AboutUsActivity.this, MainActivity.class);
                    startActivity(toHome);
                }else if(option.equals("Products")){
                    Intent toAbout = new Intent(AboutUsActivity.this, ProductsActivity.class);
                    startActivity(toAbout);
                }else if(option.equals("Logout")){
                    Intent toLogin = new Intent(AboutUsActivity.this, LoginActivity.class);
                    startActivity(toLogin);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void addImageToFlipper(int image) {

        ImageView imageView = new ImageView(AboutUsActivity.this);
        imageView.setBackgroundResource(image);

        viewFliper.addView(imageView);
        viewFliper.setFlipInterval(3000);
        viewFliper.setAutoStart(true);
        viewFliper.setInAnimation(AboutUsActivity.this, android.R.anim.slide_in_left);
        viewFliper.setOutAnimation(AboutUsActivity.this, android.R.anim.slide_out_right);
    }

}