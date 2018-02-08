package com.framgia.demo_mvvm.data.repository;

import com.framgia.demo_mvvm.data.UserDataSource;

/**
 * Created by admin on 2/7/2018.
 */

public class UserRepository implements UserDataSource {
    private static UserRepository mRepository;
    private UserDataSource mUserDataSource;

    public static UserRepository getInstance(UserDataSource userDataSource) {
        if (mRepository == null) {
            mRepository = new UserRepository(userDataSource);
        }
        return mRepository;
    }

    private UserRepository(UserDataSource userDataSource) {
        mUserDataSource = userDataSource;
    }


    @Override
    public void getUsers(String urls, OnFetchDataListener onFetchDataListener) {
        mUserDataSource.getUsers(urls, onFetchDataListener);
    }
}
