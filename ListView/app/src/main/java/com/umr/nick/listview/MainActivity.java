package com.umr.nick.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    private ListView mListView;
    private List<JavaBean> mList = new ArrayList<JavaBean>();
    private Adapter<JavaBean> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.id_lv);
        Init();
    }

    private void Init()
    {
        for (int i = 0; i < 15; i++)
        {
            JavaBean JB = new JavaBean();
            JB.setName("name" + i);
            JB.setContent("Android" + i);
            mList.add(JB);
        }
        mAdapter = new Adapter<JavaBean>(getApplicationContext(),
                            mList, R.layout.item)
        {
            @Override
            public void setViewbyId(ViewHolder vh, Object item) {
                vh.setText(R.id.id_tv1, ((JavaBean) item).getName());
                vh.setText(R.id.id_tv2, ((JavaBean) item).getContent());
                vh.setOnClickListener(R.id.id_iv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),
                                "点击头像", Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
        mListView.setAdapter(mAdapter);
    }
}
