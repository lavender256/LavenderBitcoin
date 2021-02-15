package com.lavender.BitCoin.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lavender.BitCoin.R;
import com.lavender.BitCoin.activities.ChooseActivity;


public class AboutApp extends AppCompatActivity {
    Button Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_app);
        Exit=(Button)findViewById(R.id.btnexit2);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutApp.this, ChooseActivity.class));
            }
        });


    }
}
