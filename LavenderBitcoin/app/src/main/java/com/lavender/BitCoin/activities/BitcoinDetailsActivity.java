package com.lavender.BitCoin.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.lavender.BitCoin.R;


public class BitcoinDetailsActivity extends AppCompatActivity {
    CoordinatorLayout root3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        root3 = (CoordinatorLayout) findViewById(R.id.root3);
        getSupportActionBar().hide();


        String name2 = getIntent().getExtras().getString("bit_name");
        String symbol2 = getIntent().getExtras().getString("bit_symbol");
        String price2 = getIntent().getExtras().getString("bit_price_usd");
        String price_btc = getIntent().getExtras().getString("bit_price_btc");
        String percentChange7d2 = getIntent().getExtras().getString("bit_percent_change_7d");
        String percent_change24h2 = getIntent().getExtras().getString("bit_percent_change_24h");
        String volume24 = getIntent().getExtras().getString("bit_volume24");
        String market_cap_usd = getIntent().getExtras().getString("bit_market_cap_usd");
        String csupply = getIntent().getExtras().getString("bit_csupply");
        String msupply = getIntent().getExtras().getString("bit_msupply");
        String tsupply = getIntent().getExtras().getString("bit_tsupply");


        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_symbol2 = (TextView) findViewById(R.id.symbol2);
        TextView tv_price2 = (TextView) findViewById(R.id.price2);
        TextView tv_price_btc = (TextView) findViewById(R.id.pc1h2);
        TextView tv_percent_change24h2 = (TextView) findViewById(R.id.pc24h2);
        TextView tv_percent_change7d2 = (TextView) findViewById(R.id.pc7d2);
        TextView tv_market_cap_usd = (TextView) findViewById(R.id.marketcapusd);
        TextView tv_volume24 = (TextView) findViewById(R.id.volume24);
        TextView tv_csupply = (TextView) findViewById(R.id.csupply);
        TextView tv_tsupply = (TextView) findViewById(R.id.tsupply);
        TextView tv_msupply = (TextView) findViewById(R.id.msuply);

        tv_symbol2.setText(symbol2);
        tv_price2.setText(price2);
        tv_price_btc.setText(price_btc);
        tv_percent_change24h2.setText(percent_change24h2);
        tv_percent_change7d2.setText(percentChange7d2);
        tv_market_cap_usd.setText(market_cap_usd);
        tv_volume24.setText(volume24);
        tv_csupply.setText(csupply);
        tv_tsupply.setText(tsupply);
        tv_msupply.setText(msupply);

        collapsingToolbarLayout.setTitle(name2);
    }

    public void onclick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.cardsymbol:
                final Snackbar snackbar = Snackbar.make(root3, R.string.symbol, Snackbar.LENGTH_INDEFINITE);
                snackbar.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;

            case R.id.cardprice:
                final Snackbar snackbar1 = Snackbar.make(root3, R.string.price, Snackbar.LENGTH_LONG);
                snackbar1.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar1.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar1.dismiss();
                    }
                });
                snackbar1.show();
                break;

            case R.id.cardpricebtc:
                final Snackbar snackbar2 = Snackbar.make(root3, R.string.price_btc, Snackbar.LENGTH_LONG);
                snackbar2.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar2.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar2.dismiss();
                    }
                });
                snackbar2.show();
                break;

            case R.id.cardpercent24h:
                final Snackbar snackbar3 = Snackbar.make(root3, R.string.percent_change24, Snackbar.LENGTH_LONG);
                snackbar3.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar3.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar3.dismiss();
                    }
                });
                snackbar3.show();
                break;

            case R.id.cardpercent7d:
                final Snackbar snackbar4 = Snackbar.make(root3, R.string.percent_change7, Snackbar.LENGTH_LONG);
                snackbar4.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar4.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar4.dismiss();
                    }
                });
                snackbar4.show();
                break;

            case R.id.cardmarket:
                final Snackbar snackbar5 = Snackbar.make(root3, R.string.market_cap_usd, Snackbar.LENGTH_LONG);
                snackbar5.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar5.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar5.dismiss();
                    }
                });
                snackbar5.show();
                break;

            case R.id.cardvolume:
                final Snackbar snackbar6 = Snackbar.make(root3, R.string.volume24, Snackbar.LENGTH_LONG);
                snackbar6.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar6.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar6.dismiss();
                    }
                });
                snackbar6.show();
                break;

            case R.id.cardcsupply:
                final Snackbar snackbar7 = Snackbar.make(root3, R.string.cSupply, Snackbar.LENGTH_LONG);
                snackbar7.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar7.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar7.dismiss();
                    }
                });
                snackbar7.show();
                break;

            case R.id.cardtsupply:
                final Snackbar snackbar8 = Snackbar.make(root3, R.string.tsupply, Snackbar.LENGTH_LONG);
                snackbar8.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar8.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar8.dismiss();
                    }
                });
                snackbar8.show();
                break;

            case R.id.cardmsupply:
                final Snackbar snackbar9 = Snackbar.make(root3, R.string.msupply, Snackbar.LENGTH_LONG);
                snackbar9.setActionTextColor(getResources().getColor(R.color.niceRed));
                snackbar9.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar9.dismiss();
                    }
                });
                snackbar9.show();
                break;
        }
    }

}
