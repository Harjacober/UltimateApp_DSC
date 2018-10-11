package com.example.harjacober.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.harjacober.myapplication.database.Thoughts;
import com.example.harjacober.myapplication.database.ThoughtsRepository;

import java.util.List;

public class ThoughtsViewModel extends AndroidViewModel {
    private ThoughtsRepository mRepository;

    private LiveData<List<Thoughts>> mAllThoughts;

    public ThoughtsViewModel (Application application) {
        super(application);
        mRepository = new ThoughtsRepository(application);
        mAllThoughts = mRepository.getAllThougths();
    }

    public LiveData<List<Thoughts>> getALlThoughts() { return mAllThoughts; }

    public void insert(Thoughts thoughts) { mRepository.insert(thoughts); }
}
