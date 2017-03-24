package com.example.age.demovmp2.data.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.age.demovmp2.R;
import com.example.age.demovmp2.service.ServiceGenerator;
import com.squareup.picasso.Picasso;

/**
 * Created by Age on 3/24/2017.
 */
public class ProfileViewModel {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
            .load(ServiceGenerator.BASE_IMAGE_URL + imageUrl)
            .placeholder(R.drawable.bg_no_img)
            .into(view);
    }
}
