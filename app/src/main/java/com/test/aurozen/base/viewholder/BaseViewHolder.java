package com.test.aurozen.base.viewholder;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.test.aurozen.base.listener.BaseRecyclerListener;

public abstract class BaseViewHolder<T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Bind data to the item and set listener if needed.
     *
     * @param item     object, associated with the item.
     * @param listener listener a listener {@link BaseRecyclerListener} which has to b set at the item (if not `null`).
     */
    public abstract void onBind(T item, @Nullable L listener);
}
