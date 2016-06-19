package com.example.felipe.androidchat.contactlist.ui;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.felipe.androidchat.R;
import com.example.felipe.androidchat.contactlist.ContactListPresenter;
import com.example.felipe.androidchat.contactlist.ui.adapters.ContactListAdapter;
import com.example.felipe.androidchat.contactlist.ui.adapters.OnItemClickListener;
import com.example.felipe.androidchat.entities.User;
import com.example.felipe.androidchat.lib.GlideImageLoader;
import com.example.felipe.androidchat.lib.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactListActivity extends AppCompatActivity implements ContactListView, OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerViewContacts)
    RecyclerView recyclerViewContacts;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private ContactListAdapter adapter;
    private ContactListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);

        setupAdapter();
        setupRecyclerView();
        //presenter.onCreate();
        setupToolbar();

    }

    private void setupAdapter(){
        ImageLoader loader = new GlideImageLoader(this.getApplicationContext());
        User user = new User();
        user.setEmail("aacs852@gmail.com");
        user.setOnline(true);
        adapter = new ContactListAdapter(Arrays.asList( new User[]{user}), loader, this);
    }

    private void setupRecyclerView() {
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewContacts.setAdapter(adapter);
    }

    private void setupToolbar() {
       // toolbar.setTitle(presenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);
    }

    /*
    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }
    */

    @OnClick(R.id.fab)
    public void addContact(){

    }

    @Override
    public void onContactAdded(User user) {

    }

    @Override
    public void onContactChanged(User user) {

    }

    @Override
    public void onContactRemoved(User user) {

    }

    @Override
    public void onItemClick(User user) {

    }

    @Override
    public void onItemLongClick(User user) {

    }
}