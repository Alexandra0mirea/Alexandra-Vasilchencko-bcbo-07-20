package ru.mirea.Vasilchenko.networkstate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        LiveData<String> networkLiveData = NetworkLiveData.getInstance(this);
        networkLiveData.observe(this, new androidx.lifecycle.Observer<String>() {
            @Override
            public void onChanged(@Nullable String value) {
                textView.setText(value);
            }
        });
    }
}