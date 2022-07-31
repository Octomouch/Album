package com.example.album;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout myTab;
    private ViewPager2 myPager2;

    List<String>titles = new ArrayList<>();
    List<Fragment>fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTab = findViewById(R.id.my_tab);
        myPager2 = findViewById(R.id.my_pager2);

        //添加标题
        titles.add("1");
        titles.add("2");
        titles.add("3");
        /*titles.add("4");
        titles.add("5");
        titles.add("6");
        titles.add("7");
        titles.add("8");
        titles.add("9");
        titles.add("10");*/

        //设置Fragment图片
        MyFragment fragment1 = new MyFragment();
        fragment1.setUrl("http://c.hiphotos.baidu.com/image/w%3D2048/sign=396e9d640b23dd542173a068e531b2de/cc11728b4710b9123a8117fec1fdfc039245226a.jpg");
        MyFragment fragment2 = new MyFragment();
        fragment2.setUrl("http://e.hiphotos.baidu.com/image/w%3D2048/sign=c9c32d60f1deb48ffb69a6dec4273b29/960a304e251f95cae5f125b7cb177f3e670952ae.jpg");
        MyFragment fragment3 = new MyFragment();
        fragment3.setUrl("http://f.hiphotos.baidu.com/image/w%3D2048/sign=0e0fe1d417ce36d3a20484300ecb3b87/3801213fb80e7bec015d1eef2d2eb9389b506b3c.jpg");


        //添加Fragment进去
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        //实例化适配器
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        //设置适配器
        myPager2.setAdapter(myAdapter);
        //TabLayout和Viewpager2进行关联
        new TabLayoutMediator(myTab, myPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_img){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        return true;
    }
}