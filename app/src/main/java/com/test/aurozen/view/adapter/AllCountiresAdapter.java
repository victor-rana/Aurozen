package com.test.aurozen.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.test.aurozen.R;
import com.test.aurozen.base.adapter.GenericRecyclerAdapter;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.listener.AllCountriesCardItemClickListener;
import com.test.aurozen.view.viewholder.AllCountriesCardsViewHolder;


public class AllCountiresAdapter extends GenericRecyclerAdapter<AllCountriesModel, AllCountriesCardItemClickListener<AllCountriesModel>, AllCountriesCardsViewHolder> {
    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public AllCountiresAdapter(Context context) {
        super(context);
    }

    @Override
    public AllCountriesCardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllCountriesCardsViewHolder(inflate(R.layout.card_home_portals, parent));
    }
    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */

}
