package com.example.age.demovmp2.feature.main;

import com.example.age.demovmp2.BuildConfig;
import com.example.age.demovmp2.data.MovieDataSource;
import com.example.age.demovmp2.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private MovieDataSource mMovieRepository;

    public MainPresenter(MainContract.View view,
                         MovieDataSource movieRepository) {
        mView = view;
        mMovieRepository = movieRepository;
    }

    @Override
    public void getList(int page) {
        mMovieRepository.getMovies(BuildConfig.API_KEY, page,
            new MovieDataSource.CallBack() {
                @Override
                public void onMoviesLoaded(List<Movie> movies) {
                    mView.showList(movies);
                }

                @Override
                public void onDataNotAvailable() {
                    mView.onError();
                }
            });
    }

    @Override
    public void start() {
        getList(1);
    }
}
