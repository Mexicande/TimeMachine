package cn.com.timemachine.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.adapter.HomeAdapter;
import cn.com.timemachine.ui.base.BaseLazyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseLazyFragment {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    Unbinder unbinder;

    private HomeAdapter mHomeAdapter;
    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvTitle.setText("时光机(20)");

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .navigationBarColor(R.color.shape1)
                .init();

    }

    @Override
    protected void initData() {
        List<String>list=new ArrayList<>();
        list.add("Aname");
        list.add("Bname");
        list.add("Cname");
        list.add("Dname");
        list.add("Ename");
        list.add("Fname");

        mHomeAdapter=new HomeAdapter(null);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(mHomeAdapter);
        mHomeAdapter.addData(list);
        View view = getActivity().getLayoutInflater().inflate(R.layout.search_header_item, null);
        mHomeAdapter.addHeaderView(view);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), toolbar);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
