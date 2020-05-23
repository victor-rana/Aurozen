package com.test.aurozen.view.listener;

import com.test.aurozen.base.listener.BaseRecyclerListener;

public interface CountriesCurrencyItemClickListener <T> extends BaseRecyclerListener {
    /**
     * Item has been clicked.
     *
     * @param item object associated with the clicked item.
     */
    void onCardClick(T item);
}