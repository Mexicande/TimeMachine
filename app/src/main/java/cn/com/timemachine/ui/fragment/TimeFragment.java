package cn.com.timemachine.ui.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.melnykov.fab.FloatingActionButton;
import com.necer.ncalendar.calendar.NCalendar;
import com.necer.ncalendar.listener.OnCalendarChangedListener;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.adapter.HomeAdapter;
import cn.com.timemachine.ui.base.BaseLazyFragment;
import cn.com.timemachine.utils.RippleUtils;
import cn.com.timemachine.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends BaseLazyFragment implements OnCalendarChangedListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.time_recycler)
    RecyclerView timeRecycler;
    Unbinder unbinder;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.ncalendarrrr)
    NCalendar ncalendarrrr;
    @BindView(R.id.iv_dateLast)
    ImageView ivDateLast;
    @BindView(R.id.iv_dateNext)
    ImageView ivDateNext;

    private HomeAdapter mHomeAdapter;

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvTitle.setText("时光");
        setListener();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivDateNext.setBackground(RippleUtils.getRippleDrawable(getActivity(), ivDateNext));
        }
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        list.add("Aname");
        list.add("Bname");
        list.add("Cname");
        list.add("Dname");
        list.add("Ename");
        list.add("Fname");

        mHomeAdapter = new HomeAdapter(R.layout.time_item, null);
        timeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        timeRecycler.setAdapter(mHomeAdapter);
        mHomeAdapter.addData(list);
        fab.attachToRecyclerView(timeRecycler);
       /* View view = getActivity().getLayoutInflater().inflate(R.layout.search_header_item, null);
        mHomeAdapter.addHeaderView(view);*/

    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_time;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .navigationBarColor(R.color.shape1)
                .init();

    }

    @Override
    protected void setListener() {
        ncalendarrrr.post(new Runnable() {
            @Override
            public void run() {

                List<String> list = new ArrayList<>();
                list.add("2018-01-21");
                list.add("2017-12-16");
                list.add("2018-02-21");


                ncalendarrrr.setPoint(list);
            }
        });
        ncalendarrrr.setOnCalendarChangedListener(this);


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


    @Override
    public void onCalendarChanged(DateTime dateTime) {
        tvDate.setText(Utils.getMonth(dateTime.getMonthOfYear()) + " " + dateTime.getYear());
    }

    @OnClick({R.id.iv_dateLast, R.id.iv_dateNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_dateLast:
                ncalendarrrr.toLastPager();

                break;
            case R.id.iv_dateNext:
                ncalendarrrr.toNextPager();

                break;
            default:
                break;
        }
    }
}
