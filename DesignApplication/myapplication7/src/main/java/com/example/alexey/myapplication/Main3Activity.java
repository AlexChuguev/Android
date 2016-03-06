package com.example.alexey.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private List<TrainingClass> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ZamerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ZamerAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void prepareMovieData() {
        TrainingClass movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        movie = new TrainingClass("21 февраля 2016,вс,17:06");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
