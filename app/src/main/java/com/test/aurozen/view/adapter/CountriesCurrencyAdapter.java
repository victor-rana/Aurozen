package com.test.aurozen.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.test.aurozen.R;
import com.test.aurozen.base.adapter.GenericRecyclerAdapter;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.listener.AllCountriesCardItemClickListener;
import com.test.aurozen.view.listener.CountriesCurrencyItemClickListener;
import com.test.aurozen.view.viewholder.AllCountriesCardsViewHolder;
import com.test.aurozen.view.viewholder.CountriesCurrencyViewHolder;

public class CountriesCurrencyAdapter extends GenericRecyclerAdapter<AllCountriesModel, CountriesCurrencyItemClickListener<AllCountriesModel>, CountriesCurrencyViewHolder> {
    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public CountriesCurrencyAdapter(Context context) {
        super(context);
    }

    @Override
    public CountriesCurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CountriesCurrencyViewHolder(inflate(R.layout.card_curreny_portals, parent));
    }
    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */

}
