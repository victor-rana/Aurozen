package com.test.aurozen.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.aurozen.Singleton;
import com.test.aurozen.data.DataFactory;
import com.test.aurozen.data.DataService;
import com.test.aurozen.model.AllCountriesModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<List<AllCountriesModel>> mutableLiveData=new MutableLiveData<>();


    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();



    public void loadData() {
        fetchAllCountries();
    }


    // NOTE: This method can return the observer and just subscribe to it in the activity or fragment,
    // an Activity or Fragment needn't to implement from the Observer java class
    // (it was my first approach to avoid RX in UI now we can use LiveData instead)
    private void fetchAllCountries() {

        Singleton peopleApplication = Singleton.get(context);
        DataService dataService = peopleApplication.getDataService();

        Disposable disposable = dataService.fetchAllCountries(DataFactory.URL_ALL_COUNTRIES)
                .subscribeOn(peopleApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Home allCountriesModel",throwable.getLocalizedMessage());
                    }
                })
                .subscribe(new Consumer<List<AllCountriesModel>>() {
                    @Override public void accept(List<AllCountriesModel> allCountriesModelList) {
                        Log.d("TAG", "accept: "+allCountriesModelList.get(0));
                        changePeopleDataSet(allCountriesModelList);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changePeopleDataSet(List<AllCountriesModel> allCountriesModelList) {
        mutableLiveData.setValue(allCountriesModelList);
    }


    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
