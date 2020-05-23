package com.test.aurozen.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.aurozen.MainActivity;
import com.test.aurozen.R;
import com.test.aurozen.model.AllCountriesModel;
import com.test.aurozen.view.adapter.CountriesCurrencyAdapter;
import com.test.aurozen.view.listener.CountriesCurrencyItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCurrencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCurrencyFragment extends Fragment implements CountriesCurrencyItemClickListener<AllCountriesModel> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    CountriesCurrencyAdapter countriesCurrencyAdapter;
    List<AllCountriesModel> allCountriesModelList = new ArrayList<>();

    public final String TAG = "AddCurrencyFragment";

    public AddCurrencyFragment() {
    }

    public AddCurrencyFragment(List<AllCountriesModel> allCountriesModelList) {
        // Required empty public constructor
        this.allCountriesModelList = allCountriesModelList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCurrencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCurrencyFragment newInstance(String param1, String param2) {
        AddCurrencyFragment fragment = new AddCurrencyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_add_currency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((MainActivity) Objects.requireNonNull(getActivity())).onShowSelectAll(false);
        }


        recyclerView = view.findViewById(R.id.rvCountriesCurrency);

        setRecyclerView();
        countriesCurrencyAdapter.setItems(allCountriesModelList);
    }

    private void setRecyclerView(){

        countriesCurrencyAdapter = new CountriesCurrencyAdapter(getActivity());
        countriesCurrencyAdapter.setListener(this);
        recyclerView.setAdapter(countriesCurrencyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onCardClick(AllCountriesModel item) {
        Log.d("TAG", "onCardClick: "+item.getName());
    }
}
