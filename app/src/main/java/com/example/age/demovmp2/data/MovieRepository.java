package com.example.age.demovmp2.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.age.demovmp2.data.model.Movie;
import com.example.age.demovmp2.data.source.remote.MovieRemoteDataSource;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public class MovieRepository implements MovieDataSource {
    private static MovieRepository sMovieRepository;
    private final MovieDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public static MovieRepository getInstance(Context context) {
        if (sMovieRepository == null)
            return new MovieRepository(MovieRemoteDataSource.getInstance());
        return sMovieRepository;
    }

    @Override
    public void getMovies(@Nullable String api_key, @Nullable int page,
                          @NonNull final CallBack callback) {
        mMovieRemoteDataSource.getMovies(api_key, page, new CallBack() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }
}
