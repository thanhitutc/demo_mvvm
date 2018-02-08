package com.framgia.demo_mvvm.screen;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.framgia.demo_mvvm.BR;
import com.framgia.demo_mvvm.data.UserDataSource;
import com.framgia.demo_mvvm.data.model.User;
import com.framgia.demo_mvvm.data.repository.UserRepository;
import com.framgia.demo_mvvm.data.source.remote.UserRemoteDataSource;

import java.util.List;

/**
 * Created by admin on 2/7/2018.
 */

public class MainViewModel extends BaseObservable {
    public static final String LINK_API = "https://api.github.com/search/users?per_page=";
    private UserRepository mUserRepository;
    private MainAdapter mMainAdapter;
    private String mKeyName;
    private String mKeyLimit;
    private List<User> mUsers;

    public MainViewModel() {
        mUserRepository = UserRepository.getInstance(UserRemoteDataSource.getInstance());
        mMainAdapter = new MainAdapter(mUsers);
    }

    @Bindable
    public String getKeyName() {
        return mKeyName;
    }

    public void setKeyName(String keyName) {
        mKeyName = keyName;
    }

    @Bindable
    public String getKeyLimit() {
        return mKeyLimit;
    }

    public void setKeyLimit(String keyLimit) {
        mKeyLimit = keyLimit;
    }

    @Bindable
    public MainAdapter getMainAdapter() {
        return mMainAdapter;
    }

    public void setMainAdapter(MainAdapter mainAdapter) {
        mMainAdapter = mainAdapter;
        notifyPropertyChanged(BR.mainAdapter);
    }

    public void onClickSearch(View view) {
        mUserRepository.getUsers(LINK_API + getKeyLimit() + "&q=" + getKeyName(),
                new UserDataSource.OnFetchDataListener() {
                    @Override
                    public void onFail() {
                        Log.e("FAIL", "L");
                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        mMainAdapter.setUsers(users);
                    }
                });

    }

}

