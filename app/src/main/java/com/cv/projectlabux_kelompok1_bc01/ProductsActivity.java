package com.cv.projectlabux_kelompok1_bc01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ProductsActivity extends AppCompatActivity {

    String[] title = {"Assassin's Creed Valhalla", "Cyberpunk 2077", "Star Wars Jedi: Fallen Order", "Shadow of the Tomb Raider", "Spider-Man: Miles Morales", ""};
    int[] images = {R.drawable.assasins, R.drawable.cyberpunk, R.drawable.jedi, R.drawable.shadow_of_tomb_raider, R.drawable.spiderman, R.drawable.spiderman};
    String[] price = {"Rp613.000", "Rp867.000", "Rp510.000", "Rp520.000", "Rp730.000", ""};
    String[] year = {"2019", "2020", "2020", "2018", "2020", ""};
    String[] description = {"Ezio Auditore walks in the footsteps of the legendary mentor Altair, on a dangerous journey of discovery and revelation.",
    "Cyberpunk 2077 is an open-world, action-adventure RPG set in the dark future of Night City — a dangerous megalopolis obsessed with power, glamor, and ceaseless body modification.",
    "A galaxy-spanning adventure awaits in Star Wars Jedi: Fallen Order, a 3rd person action-adventure title from Respawn. An abandoned Padawan must complete his training, develop new powerful Force abilities, and master the art of the lightsaber - all while staying one step ahead of the Empire.",
    "Tomb Raider explores the intense origin story of Lara Croft and her ascent from a young woman to a hardened survivor.",
    "For the first time, you can suit up as Spider-Man and see what it’s like to be the world’s favorite superhero. Learn the ins and outs of your brand new Stark Industries upgraded web shooters and master different web types as you race to complete fast-paced targeting trials.", ""};

    ListView listView;

    class ViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.view_list, null);
            ImageView imageView = view.findViewById(R.id.imageview);
            TextView titleView = view.findViewById(R.id.title);
            TextView priceView = view.findViewById(R.id.price);
            TextView yearView = view.findViewById(R.id.year);

            imageView.setImageResource(images[i]);
            priceView.setText(price[i]);
            yearView.setText(year[i]);
            titleView.setText(title[i]);

            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        listView = findViewById(R.id.products_listview);
        ViewAdapter viewAdapter = new ViewAdapter();
        listView.setAdapter(viewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sp = getSharedPreferences("gameData", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("title", title[i]);
                edit.putString("price", price[i]);
                edit.putString("year", year[i]);
                edit.putString("description", description[i]);
                edit.putInt("image", images[i]);
                edit.apply();
                startActivity(new Intent(ProductsActivity.this, GameDetailActivity.class));
            }
        });
        
        Spinner productsDropdown = findViewById(R.id.products_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ProductsActivity.this,
                R.array.products_dropdown, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        productsDropdown.setAdapter(adapter);
        productsDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String option = adapterView.getItemAtPosition(i).toString();
                if(option.equals("Home")){
                    Intent toHome = new Intent(ProductsActivity.this, MainActivity.class);
                    startActivity(toHome);
                }else if(option.equals("About")){
                    Intent toAbout = new Intent(ProductsActivity.this, AboutUsActivity.class);
                    startActivity(toAbout);
                }else if(option.equals("Logout")){
                    Intent toLogin = new Intent(ProductsActivity.this, LoginActivity.class);
                    startActivity(toLogin);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

}