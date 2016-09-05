package davideventbusdemo.qq986945193.com.davideventbusdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import davideventbusdemo.qq986945193.com.davideventbusdemo.R;
import de.greenrobot.event.EventBus;


/**
 * 作者：程序员小冰 on 2015/11/30 19:55
 * <p/>
 * 网站：http://blog.csdn.net/qq_21376985
 * <p/>
 * 微博：http://weibo.com/mcxiaobing
 */

/**
 * 发布者 eventBus
 */
public class LeftFragment extends Fragment {

    private ListView lv;
    private String[] strs = new String[]{"JAVA", "ADNROID", "IOS", "PHP", "HTML5", "Python","程序员小冰"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.left_fragment,container,false);
        lv = (ListView) rootView.findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,strs);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //发送数据
                EventBus.getDefault().post(strs[position]);
            }
        });

        return rootView;
    }
}
