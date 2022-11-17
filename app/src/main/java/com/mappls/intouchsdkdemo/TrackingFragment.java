package com.mappls.intouchsdkdemo;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mappls.intouchsdkdemo.databinding.FragmentTrackingBinding;
import com.mappls.sdk.bleplugin.BleScanResultCallback;
import com.mappls.sdk.bleplugin.BluetoothLEScanHelper;
import com.mappls.sdk.intouch.InTouch;
import com.mappls.sdk.tracking.Config;
import com.mappls.sdk.tracking.LocationChangeObserver;
import com.mappls.sdk.tracking.TrackingStateObserver;
import com.mappls.sdk.tracking.utils.TrackingError;


public class TrackingFragment extends Fragment implements TrackingStateObserver.OnTrackingStateChangeListener, LocationChangeObserver.OnLocationStateChangeListener {
    private FragmentTrackingBinding mBinding;
    private BleScanResultCallback mBleScanResultCallback = null;
    // Enter user device Mac Address
    private String bleMacAddress = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_tracking, container, false);
        String bleAddress = BluetoothLEScanHelper.getInstance().getBleDeviceMacId();
        mBinding.textMacId.setText(bleAddress != null ? bleAddress : bleMacAddress);
        mBinding.setIsBeaconEnabled(InTouch.isRunning());
        InTouch.addNotificationIconsAndTitle(R.drawable.ic_stat_phone_iphone,
                R.drawable.ic_stat_phone_iphone,
                "MapmyIndia Tracking Sdk",
                "Tracking your position",
                "com.mapmyindia.intouchsdkdemo.MainActivity",
                R.color.colorWhite);

        mBinding.setOnClickStartBeacon(v -> {
            if (getActivity() == null) {
                return;
            }
            if (TextUtils.isEmpty(mBinding.textMacId.getText().toString())) {
                Toast.makeText(requireActivity(), "Please enter Ble device mac address", Toast.LENGTH_SHORT).show();
            } else {
                startTracking();
            }
        });
        mBinding.setOnClickRedirect(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://intouch.mapmyindia.com")));
        });
        InTouch.addTrackingStateListener(this);
        if (mBleScanResultCallback == null) {
            mBleScanResultCallback = externalSensor -> {
                mBinding.txtDeviceCode.setText("\nTemperature:- " + externalSensor.getTemperature() + "\nHumidity:- " + externalSensor.getHumidity());
            };
            BluetoothLEScanHelper.getInstance().addBleScanResultListener(mBleScanResultCallback);
        }
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void stopTracking() {
        InTouch.stopTracking();
    }

    private void startTracking() {
        if (getActivity() == null) {
            return;
        }
        if (!InTouch.isRunning()) {
            new Config.Builder(getContext())
                    .setPriority(InTouch.BEACON_PRIORITY_FAST)
                    .build();
            BluetoothLEScanHelper.getInstance().setBleDeviceMacId(mBinding.textMacId.getText().toString());
            InTouch.startTracking();
        } else {
            stopTracking();
        }
    }


    @Override
    public void onError(TrackingError trackingError) {

    }

    @Override
    public void onTrackingStart() {
        mBinding.setIsBeaconEnabled(true);
        Toast.makeText(requireActivity(), "onTrackingStart", Toast.LENGTH_SHORT).show();
        InTouch.addLocationStateChangeListener(this);
    }

    @Override
    public void onTrackingStop() {
        if (getActivity() != null)
            Toast.makeText(getActivity(), "onTrackingStop", Toast.LENGTH_SHORT).show();
        mBinding.setIsBeaconEnabled(false);
        InTouch.removeLocationStateChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
        InTouch.removeTrackingStateListener(this);
        BluetoothLEScanHelper.getInstance().removeBleScanResultListener(mBleScanResultCallback);
        mBleScanResultCallback = null;

    }

    @Override
    public void onLocationChange(Location location, boolean isFake, boolean isAccurate) {
        // write your code here.
    }
}