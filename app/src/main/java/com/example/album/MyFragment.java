package com.example.album;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MyFragment extends Fragment {
    private String mUrl;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View inflate = inflater.inflate(R.layout.myfragment,null);
        imageView = inflate.findViewById(R.id.image);
        Glide.with(this).load(mUrl)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(imageView);
        return inflate;
    }

    public void setUrl(String url){
        mUrl = url;
    }
}
