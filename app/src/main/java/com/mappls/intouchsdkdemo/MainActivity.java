package com.mappls.intouchsdkdemo;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mappls.intouchsdkdemo.databinding.ActivityMainBinding;
import com.mappls.sdk.intouch.InTouch;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        new Handler().postDelayed(() -> {
            if (InTouch.isInitialized()) {
                replaceFragment(new TrackingFragment());
            } else {
                replaceFragment(new SetUpKeyFragment());
            }
        }, 3000);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(mBinding.mainContainer.getId(), fragment, fragment.getClass().getName())
               // .addToBackStack(null)
                .commit();
    }
}
