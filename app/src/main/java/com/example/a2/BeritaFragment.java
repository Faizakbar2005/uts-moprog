package com.example.a2;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BeritaFragment extends Fragment {

    public BeritaFragment() {
        // Diperlukan constructor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout untuk fragment ini
        View view = inflater.inflate(R.layout.fragment_berita, container, false);

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

        // Tambahkan click listener untuk berita
        View beritaView = view.findViewById(R.id.news_view); // Sesuaikan ID dengan ID yang ada pada berita
        beritaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Contoh data berita
                String title = "Judul Berita";
                String content = "Isi lengkap berita yang lebih detail.";
                int imageRes = R.drawable.news; // Gambar berita

                // Tampilkan detail berita
                DetailBeritaFragment detailFragment = DetailBeritaFragment.newInstance(title, content, imageRes);
                loadFragment(detailFragment);
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
