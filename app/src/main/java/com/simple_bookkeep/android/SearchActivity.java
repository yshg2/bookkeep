package com.simple_bookkeep.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.simple_bookkeep.android.adapter.AccountAdapter;
import com.simple_bookkeep.android.db.AccountBean;
import com.simple_bookkeep.android.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ListView searchLv;
    EditText searchEt;
    TextView emptyTv;
    List<AccountBean> mDatas;
    AccountAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        mDatas=new ArrayList<>();
        adapter=new AccountAdapter(this,mDatas);
        searchLv.setAdapter(adapter);
        searchLv.setEmptyView(emptyTv);
    }

    private void initView() {
        searchLv=findViewById(R.id.search_lv);
        searchEt=findViewById(R.id.search_et);
        emptyTv=findViewById(R.id.search_tv_empty);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_iv_back:
                finish();
                break;
            case R.id.search_iv_sh:
                String msg = searchEt.getText().toString().trim();
                if (TextUtils.isEmpty(msg)) {
                    Toast.makeText(this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                    return ;
                }
                List<AccountBean> list = DBManager.getAccountLisByRemarkFromAccounttb(msg);
                mDatas.clear();
                mDatas.addAll(list);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}