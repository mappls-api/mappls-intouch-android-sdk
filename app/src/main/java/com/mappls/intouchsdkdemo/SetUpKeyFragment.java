package com.mappls.intouchsdkdemo;

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


import com.mappls.intouchsdkdemo.databinding.FragmentKeyInitializationBinding;
import com.mappls.sdk.intouch.InTouch;
import com.mappls.sdk.intouch.callbacks.IAuthListener;
import com.mappls.sdk.tracking.utils.AutoStartPermissionHelper;

public class SetUpKeyFragment extends Fragment {


    private FragmentKeyInitializationBinding mBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_key_initialization, container, false);

        mBinding.setOnClickInItKey(v -> {
            if (getActivity() == null)
                return;
            InTouch.initialize(mBinding.textName.getText().toString(), new IAuthListener() {
                @Override
                public void onSuccess(Long id) {
                    if (getActivity() != null) {
                        ((MainActivity) getActivity()).replaceFragment(new TrackingFragment());
                    }
                }


                @Override
                public void onError(String reason, String errorIdentifier, String errorDescription) {
                    Toast.makeText(requireContext(), ":- " + reason + ";" + errorIdentifier + ";" + errorDescription, Toast.LENGTH_SHORT).show();
                }
            });

        });
        if (getActivity() != null) {
            AutoStartPermissionHelper.getPermissionHelper().getAutoStartPermission(getActivity());
        }
        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}
