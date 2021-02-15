package com.lavender.BitCoin.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lavender.BitCoin.R;
import com.lavender.BitCoin.activities.BitcoinDetailsActivity;
import com.lavender.BitCoin.model.Bitcoin;

import java.util.List;


public class BitcoinAdapter extends RecyclerView.Adapter<BitcoinAdapter.MyViewHolder> {

    private Context mContext;
    private List<Bitcoin> mData;

    public BitcoinAdapter(Context mContext, List<Bitcoin> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.bitcoin_row_item, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, BitcoinDetailsActivity.class);
                i.putExtra("bit_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("bit_symbol", mData.get(viewHolder.getAdapterPosition()).getSymbol());
                i.putExtra("bit_price_usd", mData.get(viewHolder.getAdapterPosition()).getPrice());
                i.putExtra("bit_price_btc", mData.get(viewHolder.getAdapterPosition()).getPriceBtc());
                i.putExtra("bit_percent_change_24h", mData.get(viewHolder.getAdapterPosition()).getPercen24h());
                i.putExtra("bit_percent_change_7d", mData.get(viewHolder.getAdapterPosition()).getPercen7d());
                i.putExtra("bit_market_cap_usd", mData.get(viewHolder.getAdapterPosition()).getMarket_cap_usd());
                i.putExtra("bit_volume24", mData.get(viewHolder.getAdapterPosition()).getVolume24());
                i.putExtra("bit_volume24a", mData.get(viewHolder.getAdapterPosition()).getVolume24a());
                i.putExtra("bit_csupply", mData.get(viewHolder.getAdapterPosition()).getCsupply());
                i.putExtra("bit_msupply", mData.get(viewHolder.getAdapterPosition()).getMsupply());
                i.putExtra("bit_tsupply", mData.get(viewHolder.getAdapterPosition()).getTsupply());


                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());
        holder.symbol.setText(mData.get(position).getSymbol());
        holder.price.setText(mData.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView symbol;
        TextView price;
        CardView view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = (CardView) itemView.findViewById(R.id.container);
            name = (TextView) itemView.findViewById(R.id.Name);
            symbol = (TextView) itemView.findViewById(R.id.symbol);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }

}
