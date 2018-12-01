package com.epiclancers.scrolllistener;

import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private AdapterForList adapterForList;
    NestedScrollView nestedScrollView;
    int numberOfTextToAdd = 10;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        progressBar = findViewById(R.id.progressBar);
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged()
            {
                View view = (View)nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);

                int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView
                        .getScrollY()));

                if (diff == 0) {
                    // your pagination code
                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadMoreData();
                        }
                    },500);
                }
            }
        });
        recyclerView.setNestedScrollingEnabled(false);
        arrayList = new ArrayList<>();
        for (int i = 0; i < numberOfTextToAdd; i++) {
            arrayList.add(""+i);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapterForList = new AdapterForList(this,arrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterForList);
    }

    private void loadMoreData() {
        for (int i = 0; i < numberOfTextToAdd; i++) {
            arrayList.add(""+i);
            adapterForList.notifyItemInserted(arrayList.size());
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        },500);
    }

    public void btnClick(View v){
        int number = 0;
        switch (v.getId()){
            case R.id.button1:
                number = 1;
                break;
            case R.id.button2:
                number = 2;
                break;
            case R.id.button3:
                number = 3;
                break;
            case R.id.button4:
                number = 4;
                break;
            case R.id.button5:
                number = 5;
                break;
        }
        Toast.makeText(this, "The button clicked was " + number+"th button", Toast.LENGTH_SHORT).show();
    }
}
