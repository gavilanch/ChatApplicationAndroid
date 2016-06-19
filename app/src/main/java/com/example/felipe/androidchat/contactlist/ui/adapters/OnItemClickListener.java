package com.example.felipe.androidchat.contactlist.ui.adapters;

import com.example.felipe.androidchat.entities.User;

public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
