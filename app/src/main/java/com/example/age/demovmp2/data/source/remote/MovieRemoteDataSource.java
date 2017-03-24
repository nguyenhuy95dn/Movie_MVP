package com.example.age.demovmp2.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.age.demovmp2.data.MovieDataSource;
import com.example.age.demovmp2.data.model.MoviesResponse;
import com.example.age.demovmp2.service.MovieService;
import com.example.age.demovmp2.service.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Age on 3/23/2017.
 */
public class MovieRemoteDataSource implements MovieDataSource {
    private static MovieRemoteDataSource sDataSource;

    public static MovieRemoteDataSource getInstance() {
        if (sDataSource == null) {
            sDataSource = new MovieRemoteDataSource();
        }
        return sDataSource;
    }

    @Override
    public void getMovies(@Nullable String api_key, @Nullable int page, final
    @NonNull CallBack callback) {
        ServiceGenerator
            .createService(MovieService.class)
            .getNowPlayingMovies(api_key, page)
            .enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call,
                                       Response<MoviesResponse> response) {
                    if (response == null || response.body() == null) return;
                    callback.onMoviesLoaded(response.body().getResults());
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    callback.onDataNotAvailable();
                }
            });
    }
}
