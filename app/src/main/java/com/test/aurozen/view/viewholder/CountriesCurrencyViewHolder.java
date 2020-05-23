package com.test.aurozen.view.viewholder;

import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.RequestBuilder;
import com.test.aurozen.R;
import com.test.aurozen.base.viewholder.BaseViewHolder;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.listener.AllCountriesCardItemClickListener;
import com.test.aurozen.view.listener.CountriesCurrencyItemClickListener;

public class CountriesCurrencyViewHolder extends BaseViewHolder<AllCountriesModel, CountriesCurrencyItemClickListener<AllCountriesModel>> {
    TextView tvPortalName,tvQuantity;
    ImageView ivAsc,ivDesc;
    int currencyQty = 1;


    public CountriesCurrencyViewHolder(View itemView) {
        super(itemView);
        tvPortalName=itemView.findViewById(R.id.tvPortalName);
        ivAsc = itemView.findViewById(R.id.ivAsc);
        ivDesc = itemView.findViewById(R.id.ivDesc);
        tvQuantity = itemView.findViewById(R.id.tvQuantity);
    }

    @Override
    public void onBind(final AllCountriesModel item, @Nullable final CountriesCurrencyItemClickListener<AllCountriesModel> listener) {
        Log.d("name", item.getName());

        tvPortalName.setText(item.getName()+"\n"+item.getCurrencies().get(0).getName()+"("+item.getCurrencies().get(0).getSymbol()+")");

        ivAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyQty = currencyQty+1;
                tvQuantity.setText(String.valueOf(currencyQty));
            }
        });

        ivDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currencyQty == 1){
                    Toast.makeText(ivDesc.getContext(),"Minimum Quantity reached",Toast.LENGTH_SHORT).show();
                }
                else {
                    currencyQty = currencyQty-1;
                    tvQuantity.setText(String.valueOf(currencyQty));
                }
            }
        });

        tvPortalName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCardClick(item);
            }
        });

    }
}
