package com.test.aurozen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.test.aurozen.fragment.AddCurrencyFragment;
import com.test.aurozen.fragment.HomeFragment;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.viewmodel.HomeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    CardView cvSelectAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvSelectAll = findViewById(R.id.cvSelectAll);

        cvSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment fragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.fmFragments);
                fragment.onSelectAll();
            }
        });

        onLoadHomeFragment();

        onShowSelectAll(false);

    }

   void onLoadHomeFragment(){
       FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       ft.replace(R.id.fmFragments, new HomeFragment());
       ft.addToBackStack(new HomeFragment().TAG);
       ft.commit();
   }

   public void onLoadAddCurrencyFragment(List<AllCountriesModel> allCountriesModelList){
       FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       ft.replace(R.id.fmFragments, new AddCurrencyFragment(allCountriesModelList));
       ft.addToBackStack(new AddCurrencyFragment().TAG);
       ft.commit();
   }

   public void onShowSelectAll(boolean isShow){
       Log.d("TAG", "onShowSelectAll: ");
       if(isShow){
           cvSelectAll.setVisibility(View.VISIBLE);
       }
       else {
           cvSelectAll.setVisibility(View.GONE);
       }
   }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }
}
