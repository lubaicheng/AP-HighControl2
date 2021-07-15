package com.example.androidpractice_highcontrol2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
/*
* 1、获取到recyclerview控件对象
* 2、设计recyclerview控件的适配器，包括item视图的布局和数据内容都要在适配器种定义出来
* 3、设置recyclerview的布局管理器
* 4、创建适配器对象，将此对象交付给recyclerview控件对象。
*
*
* */
    private RecyclerView mylist;

    private String[] titles={"苹果","蛋糕","猫","狗","桌子"};
    private int[] icons={R.drawable.apple,R.drawable.cake,R.drawable.cat,R.drawable.dog,R.drawable.table};
    private String[]  information={"苹果是一种水果","蛋糕是一种甜品","猫是一种动物","狗是一种动物","桌子是一种家具",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist=findViewById(R.id.mylist);
        mylist.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,true
        ));//设置recyclerview的布局管理器
        MyAdapter ma=new MyAdapter();
        mylist.setAdapter(ma);


    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
        @NonNull
        @Override
        //onCreateViewHolder 获取itemview的视图对象，并将视图对象传递给viewholder
        public MyHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
            View v1=View.inflate(MainActivity.this,R.layout.itemlayout,null);
            MyHolder myHolder=new MyHolder(v1);
            return myHolder;
        }

        @Override//onBindViewHolder,将值绑定给holder对象
        public void onBindViewHolder(@NonNull  MainActivity.MyAdapter.MyHolder holder, int position) {
            holder.title.setText(titles[position]);
            holder.info.setText(information[position]);
            holder.iv.setBackgroundResource(icons[position]);

        }

        @Override
        public int getItemCount() {
            return titles.length;
        }

        class MyHolder extends RecyclerView.ViewHolder{

            //定义需要赋值的控件对象
            ImageView iv;
            TextView title,info;
           public MyHolder(@NonNull View itemView) {
               super(itemView);
               iv=itemView.findViewById(R.id.iv);
               title=itemView.findViewById(R.id.title);
               info=itemView.findViewById(R.id.info);
           }
       }
    }
}