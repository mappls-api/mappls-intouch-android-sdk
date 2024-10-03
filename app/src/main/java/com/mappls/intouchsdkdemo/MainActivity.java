package com.mappls.intouchsdkdemo;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mappls.intouchsdkdemo.databinding.ActivityMainBinding;
import com.mappls.sdk.intouch.InTouch;
import com.mappls.sdk.services.account.MapplsAccountManager;


public class MainActivity extends AppCompatActivity {

    private final String KEY_CLIENT_ID = "<your client id>";
    private final String KEY_CLIENT_SECRET = "<your client secret>";
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MapplsAccountManager.getInstance().setAtlasClientId(KEY_CLIENT_ID);
        MapplsAccountManager.getInstance().setAtlasClientSecret(KEY_CLIENT_SECRET);
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
