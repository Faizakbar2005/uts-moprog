package com.example.a2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Diperlukan constructor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout untuk fragment ini
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Navbar button actions
        TextView homeText = view.findViewById(R.id.text_home);
        TextView beritaText = view.findViewById(R.id.text_berita);
        TextView profileText = view.findViewById(R.id.text_profile);

        homeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });

        beritaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BeritaFragment());
            }
        });

        profileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ProfileFragment());
            }
        });

        // Tambahkan efek klik
        applyClickEffect(homeText);
        applyClickEffect(beritaText);
        applyClickEffect(profileText);

        // Tombol Logout action
        Button logoutButton = view.findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tutup semua aktivitas dan keluar dari aplikasi
                getActivity().finishAffinity();
            }
        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void applyClickEffect(TextView textView) {
        textView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setBackgroundColor(Color.GRAY); // Ganti warna background saat ditekan
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    v.setBackgroundColor(Color.TRANSPARENT); // Kembali ke warna asli
                    break;
            }
            return false;
        });
    }
}
