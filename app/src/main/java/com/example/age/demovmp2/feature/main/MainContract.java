package com.example.age.demovmp2.feature.main;

import com.example.age.demovmp2.BasePresenter;
import com.example.age.demovmp2.BaseView;
import com.example.age.demovmp2.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public interface MainContract {
    interface View extends BaseView {
        void showList(List<Movie> movies);
        void onError();
    }

    interface Presenter extends BasePresenter {
        void getList(int page);
    }
}
