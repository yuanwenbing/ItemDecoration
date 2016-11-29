package com.yuan.itemdecoration;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.yuan.library.HorizontalItemDecoration;
import com.yuan.library.VerticalItemDecoration;
import com.yuan.library.YItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private YItemDecoration mDecoration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mDecoration = new VerticalItemDecoration.Builder().showStart(true).showEnd(true).paddingLeft(50).paddingRight(20).color(Color.BLUE).size(10).build();
        mRecyclerView.addItemDecoration(mDecoration);
        ListAdapter adapter = new ListAdapter(getDatas());
        mRecyclerView.setAdapter(adapter);

    }

    private List<String> getDatas() {
        List<String> datas = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            char c = (char) i;
            datas.add(String.valueOf(c));
        }
        return datas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vertical:
                mRecyclerView.removeItemDecoration(mDecoration);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                mDecoration = new VerticalItemDecoration.Builder().showStart(false).showEnd(true).paddingLeft(50).paddingRight(20).color(Color.BLUE).size(10).build();
                new VerticalItemDecoration.Builder().showStart(true).showEnd(true).paddingLeft(50).paddingRight(20).color(Color.BLUE).size(10).build();
                mRecyclerView.addItemDecoration(mDecoration);
                break;
            case R.id.horizontal:
                mRecyclerView.removeItemDecoration(mDecoration);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                mDecoration = new HorizontalItemDecoration.Builder().showStart(false).showEnd(true).paddingBottom(50).paddingTop(20).color(Color.RED).size(10).build();
                mRecyclerView.addItemDecoration(mDecoration);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
