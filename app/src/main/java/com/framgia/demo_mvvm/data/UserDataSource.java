package com.framgia.demo_mvvm.data;

import com.framgia.demo_mvvm.data.model.User;

import java.util.List;

/**
 * Created by admin on 2/7/2018.
 */

public interface UserDataSource {

    void getUsers(String urls, OnFetchDataListener onFetchDataListener);

    interface OnFetchDataListener {
        void onFail();

        void onSuccess(List<User> users);
    }
}
