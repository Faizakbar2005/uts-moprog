package com.example.a2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBeritaFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_IMAGE_RES = "image_res";

    private String title;
    private String content;
    private int imageRes;

    public DetailBeritaFragment() {
        // Diperlukan constructor kosong
    }

    public static DetailBeritaFragment newInstance(String title, String content, int imageRes) {
        DetailBeritaFragment fragment = new DetailBeritaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_IMAGE_RES, imageRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
            imageRes = getArguments().getInt(ARG_IMAGE_RES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_berita, container, false);

        TextView detailTitle = view.findViewById(R.id.detail_title);
        TextView detailContent = view.findViewById(R.id.detail_content);
        ImageView detailImage = view.findViewById(R.id.detail_image);
        Button buttonBack = view.findViewById(R.id.button_back);

        detailTitle.setText(title);
        detailContent.setText(content);
        detailImage.setImageResource(imageRes);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
