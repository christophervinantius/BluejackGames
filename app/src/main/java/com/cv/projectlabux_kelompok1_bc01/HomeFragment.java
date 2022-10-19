package com.cv.projectlabux_kelompok1_bc01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SharedPreferences sp = getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);

        TextView welcomeText = view.findViewById(R.id.welcome_textview);
        String username = sp.getString("username", "");
        welcomeText.setText("Welcome, " + username + "!");

        Button about = view.findViewById(R.id.about_btn);
        Button logout = view.findViewById(R.id.logout_btn);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, new AboutFragment()).commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, new LogOutFragment()).commit();
            }
        });

        Button products = view.findViewById(R.id.products_btn);
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProducts = new Intent(getActivity(), ProductsActivity.class);
                startActivity(toProducts);
            }
        });

        return view;
    }
}