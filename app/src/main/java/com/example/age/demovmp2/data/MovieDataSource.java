package com.example.age.demovmp2.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.age.demovmp2.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public interface MovieDataSource {
    interface CallBack {

        void onMoviesLoaded(List<Movie> movies);

        void onDataNotAvailable();
    }
    void getMovies(@Nullable String api_key, @Nullable int page, @NonNull CallBack
        callback);
}
