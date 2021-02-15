package com.lavender.BitCoin.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.lavender.BitCoin.R;
import com.lavender.BitCoin.Utils;
import com.lavender.BitCoin.adapters.BitcoinAdapter;
import com.lavender.BitCoin.model.Bitcoin;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BitcoinActivity extends Fragment {
    private List<Bitcoin> lstBitcoin;
    private RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LinearLayout relativeLayoutPulldown;
    LinearLayout root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_bitcoin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = (LinearLayout) view.findViewById(R.id.root);
        relativeLayoutPulldown = (LinearLayout) view.findViewById(R.id.pullDown);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);

        lstBitcoin = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewid);
        if (isNetworkAvailable(getActivity())) {
            new getJson(getActivity()).execute();
        } else {
            final Snackbar snackbar = Snackbar.make(root, "No Connection", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(getResources().getColor(R.color.red));
            snackbar.setAction("Close", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetworkAvailable(getActivity())) {
                    new getJson(getActivity()).execute();
                } else {
                    final Snackbar snackbar = Snackbar.make(root, "No Connection", Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(getResources().getColor(R.color.red));
                    snackbar.setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                        }
                    });
                    snackbar.show();
                }
            }
        });


    }

    private class getJson extends AsyncTask<Void, Void, String> {
        Context context;
        private ProgressDialog progressDialog;

        public getJson(Context context) {
            this.context = context;
        }


        @Override
        protected void onPreExecute() {
            swipeRefresh.setRefreshing(true);
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


        @Override
        protected String doInBackground(Void... voids) {
            String Address = "https://www.megaweb.ir/api/digital-money";
            return Utils.getData(Address);
        }

        @Override
        protected void onPostExecute(String jsonStr) {
            swipeRefresh.setRefreshing(false);
            relativeLayoutPulldown.setVisibility(View.GONE);
            progressDialog.dismiss();

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray jsonArray = jsonObj.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Bitcoin bitcoin = new Bitcoin();
                        JSONObject c = jsonArray.getJSONObject(i);
                        bitcoin.setName(c.getString("name"));
                        bitcoin.setSymbol(c.getString("symbol"));
                        bitcoin.setPrice(c.getString("price_usd") + " $");
                        bitcoin.setPriceBtc(c.getString("price_btc"));
                        bitcoin.setPercen24h(c.getString("percent_change_24h"));
                        bitcoin.setPercen7d(c.getString("percent_change_7d"));
                        bitcoin.setMarket_cap_usd(c.getString("market_cap_usd"));
                        bitcoin.setVolume24(c.getString("volume24"));
                        bitcoin.setCsupply(c.getString("csupply"));
                        bitcoin.setMsupply(c.getString("msupply"));
                        bitcoin.setTsupply(c.getString("tsupply"));
                        lstBitcoin.add(bitcoin);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "No Data", Toast.LENGTH_LONG).show();
            }
            setuprecyclerview(lstBitcoin);
        }

    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    private void setuprecyclerview(List<Bitcoin> lstBitcoin) {

        final BitcoinAdapter myadapter = new BitcoinAdapter(getActivity(), lstBitcoin);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myadapter);

    }
}
