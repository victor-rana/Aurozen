package com.test.aurozen.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.aurozen.MainActivity;
import com.test.aurozen.R;
import com.test.aurozen.base.BaseFragment;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.adapter.AllCountiresAdapter;
import com.test.aurozen.view.listener.AllCountriesCardItemClickListener;
import com.test.aurozen.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements AllCountriesCardItemClickListener<AllCountriesModel> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    HomeViewModel homeViewModel;
    AllCountiresAdapter allCountiresAdapter;
    RecyclerView recyclerView;
    List<AllCountriesModel> allCountriesModelArrayList = new ArrayList<>();
    List<AllCountriesModel> selectedCountriesModelList = new ArrayList<>();
    TextView tvOk;

    public final String TAG = "HomeFragment";

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((MainActivity) Objects.requireNonNull(getActivity())).onShowSelectAll(true);
        }

        initViews(view);
        setRecyclerView();

        homeViewModel= new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        homeViewModel.loadData();

        homeViewModel.mutableLiveData.observe(this, new Observer<List<AllCountriesModel>>() {
            @Override
            public void onChanged(List<AllCountriesModel> allCountriesModelList) {
                allCountriesModelArrayList.addAll(allCountriesModelList);
                allCountiresAdapter.setItems(allCountriesModelList);
            }
        });

        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    ((MainActivity) Objects.requireNonNull(getActivity())).onLoadAddCurrencyFragment(selectedCountriesModelList);
                }
            }
        });
    }

    void initViews(View view){
        recyclerView = view.findViewById(R.id.rvAllCountries);
        tvOk = view.findViewById(R.id.tvOk);
    }

    private void setRecyclerView(){

        allCountiresAdapter = new AllCountiresAdapter(getActivity());
        allCountiresAdapter.setListener(this);
        recyclerView.setAdapter(allCountiresAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onTopCardClick(AllCountriesModel item, boolean isChecked) {
        Log.d("TAG", "onTopCardClick: "+isChecked);
        if(isChecked){
            item.setSelected(true);
            selectedCountriesModelList.add(item);
        }
        else {
            deSelectItem(item);
        }
    }

    void deSelectItem(AllCountriesModel item){
        for(int i=0;i<selectedCountriesModelList.size();i++){
            AllCountriesModel allCountriesModel = selectedCountriesModelList.get(i);
            if(allCountriesModel.getName().equalsIgnoreCase(item.getName())){
                selectedCountriesModelList.remove(i);
            }
        }
    }

    public void onSelectAll(){
        Log.d("TAG", "onSelectAll: ");
        if(!selectedCountriesModelList.isEmpty()){
            selectedCountriesModelList.clear();
        }
        for(int i=0;i<allCountriesModelArrayList.size();i++){
            AllCountriesModel allCountriesModel = allCountriesModelArrayList.get(i);
            allCountriesModel.setSelected(true);
            selectedCountriesModelList.add(allCountriesModel);
        }
        allCountiresAdapter.setItems(selectedCountriesModelList);
    }
}
