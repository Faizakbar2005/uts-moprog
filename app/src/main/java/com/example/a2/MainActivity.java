package com.example.a2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

// Impor HomeFragment
import com.example.a2.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private LinearLayout loginLayout;

    // Data login yang valid
    private final String validEmail = "sycopat22@mail.com";
    private final String validPassword = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen UI
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_btn);
        loginLayout = findViewById(R.id.login_layout);

        // Set OnClickListener pada tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil input dari user
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Log input untuk debugging
                Log.d("LoginDebug", "Input Email: " + email);
                Log.d("LoginDebug", "Input Password: " + password);

                // Validasi input
                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    // Periksa kredensial
                    if (email.equals(validEmail) && password.equals(validPassword)) {
                        // Ubah visibilitas fragment_container menjadi visible
                        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
                        // Ubah visibilitas login_layout menjadi gone
                        loginLayout.setVisibility(View.GONE);
                        // Jika login berhasil, ganti fragment
                        loadFragment(new HomeFragment());
                    } else {
                        Toast.makeText(MainActivity.this, "Email atau password salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // Create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace the FrameLayout with the new Fragment
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
