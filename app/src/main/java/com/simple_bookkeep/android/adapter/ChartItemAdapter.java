package com.simple_bookkeep.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple_bookkeep.android.R;
import com.simple_bookkeep.android.db.ChartItemBean;
import com.simple_bookkeep.android.utils.FloatUtils;

import java.util.List;

public class ChartItemAdapter extends BaseAdapter {
    Context context;
    List<ChartItemBean>mDatas;
    LayoutInflater inflater;

    public ChartItemAdapter(Context context, List<ChartItemBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null) {
            convertView=inflater.inflate(R.layout.item_chartfrag_lv,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        ChartItemBean bean = mDatas.get(position);
        holder.iv.setImageResource(bean.getsImageId());
        holder.typeTv.setText(bean.getType());
        float ratio = bean.getRatio();
        String pert = FloatUtils.ratioToPercent(ratio);
        holder.ratioTv.setText(pert);
//        holder.ratioTv.setText(bean.getRation());
        holder.totalTv.setText("￥ "+bean.getTotalMoney());
        return convertView;
    }

    class ViewHolder{
        TextView typeTv,ratioTv,totalTv;
        ImageView iv;
        public ViewHolder(View view){
            typeTv=view.findViewById(R.id.item_chartfrag_tv_type);
            ratioTv=view.findViewById(R.id.item_chartfrag_tv_pert);
            totalTv=view.findViewById(R.id.item_chartfrag_tv_sum);
            iv=view.findViewById(R.id.item_chartfrag_iv);
        }
    }
}
