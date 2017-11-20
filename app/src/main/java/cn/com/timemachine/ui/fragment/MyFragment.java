package cn.com.timemachine.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseLazyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseLazyFragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).
                titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();

    }
}
