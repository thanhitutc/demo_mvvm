package com.framgia.demo_mvvm.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.demo_mvvm.BR;

/**
 * Created by admin on 2/7/2018.
 */

public class User extends BaseObservable {
    private String mUrlImage;
    private String mIdUser;
    private String mNameUser;

    public User(String mUrlImage, String mIdUser, String mNameUser) {
        this.mUrlImage = mUrlImage;
        this.mIdUser = mIdUser;
        this.mNameUser = mNameUser;
    }

    @Bindable
    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String mUrlImage) {
        this.mUrlImage = mUrlImage;
        notifyPropertyChanged(BR.urlImage);
    }

    @Bindable
    public String getmIdUser() {
        return mIdUser;
    }

    public void setmIdUser(String mIdUser) {
        this.mIdUser = mIdUser;
        notifyPropertyChanged(BR.mIdUser);
    }

    @Bindable
    public String getNameUser() {
        return mNameUser;
    }

    public void setNameUser(String mNameUser) {
        this.mNameUser = mNameUser;
        notifyPropertyChanged(BR.nameUser);
    }

}
