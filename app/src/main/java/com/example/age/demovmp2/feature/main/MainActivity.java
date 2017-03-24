package com.example.age.demovmp2.feature.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.age.demovmp2.R;
import com.example.age.demovmp2.data.MovieRepository;
import com.example.age.demovmp2.data.model.Movie;
import com.example.age.demovmp2.data.model.MoviesResponse;
import com.example.age.demovmp2.ui.adapter.NowPlayingAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Movie> mMovies = new ArrayList<>();
    private MainContract.Presenter mPresenter;
    private NowPlayingAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this, MovieRepository.getInstance(this));
        start();
        mPresenter.start();
    }

    private void setupRecycleView() {
        mAdapter = new NowPlayingAdapter(this, mMovies);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadDataView(MoviesResponse listMovie) {
        mMovies.addAll(listMovie.getResults());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showList(List<Movie> movies) {
        mAdapter.updateData(movies);
    }

    @Override
    public void onError() {
        //To do prevent error
    }

    @Override
    public void start() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_now_playing);
        mLinearLayout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayout);
        setupRecycleView();
    }
}
