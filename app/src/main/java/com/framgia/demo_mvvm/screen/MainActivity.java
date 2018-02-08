package com.framgia.demo_mvvm.screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framgia.demo_mvvm.R;
import com.framgia.demo_mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = new MainViewModel();
        binding.setViewModel(mainViewModel);
    }
}
