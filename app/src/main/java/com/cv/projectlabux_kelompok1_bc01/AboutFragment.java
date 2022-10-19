package com.cv.projectlabux_kelompok1_bc01;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        Button home = view.findViewById(R.id.home_btn);
        Button logout = view.findViewById(R.id.logout_btn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, new LogOutFragment()).commit();
            }
        });

        Button aboutUs = view.findViewById(R.id.aboutUs_btn);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAboutUs = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(toAboutUs);
            }
        });

        return view;
    }
}