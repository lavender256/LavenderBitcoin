package com.lavender.BitCoin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lavender.BitCoin.R;
import com.lavender.BitCoin.dialogs.AboutApp;


public class ChooseActivity extends AppCompatActivity {

    ImageButton  bitcoin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        bitcoin = (ImageButton) findViewById(R.id.bitcoin);


        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitcoinActivity bitcoinActivity = new BitcoinActivity();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fr1, bitcoinActivity)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.aboutApp)
            startActivity(new Intent(ChooseActivity.this, AboutApp.class));
        return super.onOptionsItemSelected(item);
    }


}
