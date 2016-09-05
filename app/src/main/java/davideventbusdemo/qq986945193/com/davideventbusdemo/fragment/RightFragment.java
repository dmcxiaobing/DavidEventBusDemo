package davideventbusdemo.qq986945193.com.davideventbusdemo.fragment;

import android.app.UiAutomation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import davideventbusdemo.qq986945193.com.davideventbusdemo.R;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


/**
 * 作者：程序员小冰 on 2015/11/30 19:56
 * <p/>
 * 网站：http://blog.csdn.net/qq_21376985
 * <p/>
 * 微博：http://weibo.com/mcxiaobing
 */
public class RightFragment extends Fragment {
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.right_fragment,container,false);

        tv = (TextView) rootView.findViewById(R.id.tv);
        //首先要注册eventbus
        EventBus.getDefault().register(this);
        return rootView;
    }

    /**
     *
     * 从发布者那里得到eventbus传送过来的数据
     *
     * 加上@Subscribe以防报错：its super classes have no public methods with the @Subscribe annotation
     *
     * @param event
     */
    @Subscribe
    public void onEvent(String event){
        tv.setText(event);
    }

    /**
     * 最后一定要在销毁的时候，解绑
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
