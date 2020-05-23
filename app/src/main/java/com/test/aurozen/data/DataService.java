package com.test.aurozen.data;

import com.test.aurozen.model.AllCountriesModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DataService {

    @GET
    Observable<List<AllCountriesModel>> fetchAllCountries(
            @Url String url
    );
}
