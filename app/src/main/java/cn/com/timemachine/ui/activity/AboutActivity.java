package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;

/**
 * @author apple
 */
public class AboutActivity extends BaseActivity {

    @BindView(R.id.layout_back)
    LinearLayout layoutBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        layoutBack.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.About);
    }

    @OnClick({R.id.layout_back, R.id.tv_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_back:
                break;
            default:
                break;
        }
    }
}
