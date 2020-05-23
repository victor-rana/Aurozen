package com.test.aurozen.view.viewholder;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.test.aurozen.R;
import com.test.aurozen.base.viewholder.BaseViewHolder;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.listener.AllCountriesCardItemClickListener;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;


public class AllCountriesCardsViewHolder extends BaseViewHolder<AllCountriesModel, AllCountriesCardItemClickListener<AllCountriesModel>> {
    TextView tvPortalName;
    CheckBox cbSelect;
    private RequestBuilder<PictureDrawable> requestBuilder;


    public AllCountriesCardsViewHolder(View itemView) {
        super(itemView);
        tvPortalName=itemView.findViewById(R.id.tvPortalName);
        cbSelect = itemView.findViewById(R.id.cbSelect);
    }

    @Override
    public void onBind(final AllCountriesModel item, @Nullable final AllCountriesCardItemClickListener<AllCountriesModel> listener) {
        Log.d("name", item.getName());

        tvPortalName.setText(item.getName());

        if(item.isSelected()){
            cbSelect.setChecked(true);
        }

        cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TAG", "onCheckedChanged: "+isChecked);
                listener.onTopCardClick(item,isChecked);
            }
        });

    }
}
