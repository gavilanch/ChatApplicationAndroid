package com.example.felipe.androidchat.lib;

import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public interface ImageLoader {
    void load(ImageView imgAvatar, String url);
}
