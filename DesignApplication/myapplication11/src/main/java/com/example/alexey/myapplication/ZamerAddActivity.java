package com.example.alexey.myapplication;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

public class ZamerAddActivity extends AppCompatActivity {
    private static final int SCALE_DELAY = 30;
    private List<TrainingClass> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ZamerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamer_add);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        Slide slideExitTransition = new Slide(Gravity.BOTTOM);
        slideExitTransition.excludeTarget(android.R.id.navigationBarBackground, true);
        slideExitTransition.excludeTarget(android.R.id.statusBarBackground, true);
        mAdapter = new ZamerAdapter(movieList);

        final   RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        prepareMovieData();

        for (int i = 0; i < recyclerView.getChildCount(); i++) {

            View rowView = recyclerView.getChildAt(i);
            rowView.animate().setStartDelay(i * SCALE_DELAY)
                    .scaleX(0).scaleY(0);
        }



        getWindow().getEnterTransition().addListener(new TransitionAdapter() {

            @Override
            public void onTransitionEnd(Transition transition) {

                super.onTransitionEnd(transition);

                getWindow().getEnterTransition().removeListener(this);

                for (int i = 0; i < recyclerView.getChildCount(); i++) {

                    View rowView = recyclerView.getChildAt(i);
                    rowView.animate().setStartDelay(i * SCALE_DELAY)
                            .scaleX(1).scaleY(1);
                }
            }
        });

    }


    @Override
    public void onBackPressed()
    {

        for (int i = 0; i < recyclerView.getChildCount(); i++) {

            View rowView = recyclerView.getChildAt(i);

            ViewPropertyAnimator propertyAnimator = rowView.animate()
                    .setStartDelay(i * SCALE_DELAY)
                    .scaleX(0).scaleY(0)
                    .setListener(new AnimatorAdapter() {

                        @Override
                        public void onAnimationEnd(Animator animation) {

                            super.onAnimationEnd(animation);
                            finishAfterTransition();
                        }
                    });
        }
    }
    private void prepareMovieData() {
        TrainingClass movie = new TrainingClass("ЗамерЗамерЗамер 1");
        movieList.add(movie);


        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass( "Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
        movieList.add(movie);

        movie = new TrainingClass("Замер 1");
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
