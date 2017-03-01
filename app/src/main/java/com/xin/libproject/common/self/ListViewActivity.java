package com.xin.libproject.common.self;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xin.libproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    public ListView listView;
    private List<ListBean> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        lists = new ArrayList<ListBean>();
        lists.add(new ListBean("hello", R.mipmap.ic_launcher, "hellofirst"));
        lists.add(new ListBean("hello2", R.mipmap.ic_launcher, "hellosecond"));
        lists.add(new ListBean("hello3", R.mipmap.ic_launcher, "hellothree"));
        lists.add(new ListBean("hello4", R.mipmap.ic_launcher, "hellofour"));
        listView.setAdapter(new ListAdapter(getApplicationContext(), lists));
    }

    class ListAdapter extends BaseAdapter {
        Context context;
        List<ListBean> lists;

        public ListAdapter(Context context, List<ListBean> lists) {
            this.context = context;
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int i) {
            return lists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (null == view) {
                holder = new ViewHolder();
                view = View.inflate(ListViewActivity.this, R.layout.list_item_layout, null);
                holder.item_tv = (TextView) view.findViewById(R.id.item_tv);
                holder.item_iv = (ImageView) view.findViewById(R.id.item_iv);
                holder.item_desc = (TextView) view.findViewById(R.id.item_desc);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.item_tv.setText(lists.get(i).getTitle());
            holder.item_iv.setImageResource(lists.get(i).getImageId());
            holder.item_desc.setText(lists.get(i).getDesc());
            return view;
        }

        class ViewHolder {
            TextView item_tv;
            ImageView item_iv;
            TextView item_desc;
        }

    }

    public class ListBean {
        private String title;
        private int imageId;
        private String desc;

        public ListBean(String title, int imageId, String desc) {
            this.title = title;
            this.imageId = imageId;
            this.desc = desc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
