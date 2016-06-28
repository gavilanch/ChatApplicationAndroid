package com.example.felipe.androidchat.chat.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.felipe.androidchat.R;
import com.example.felipe.androidchat.chat.ChatPresenter;
import com.example.felipe.androidchat.chat.ChatPresenterImpl;
import com.example.felipe.androidchat.chat.ui.adapters.ChatAdapter;
import com.example.felipe.androidchat.domain.AvatarHelper;
import com.example.felipe.androidchat.entities.ChatMessage;
import com.example.felipe.androidchat.lib.GlideImageLoader;
import com.example.felipe.androidchat.lib.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity implements ChatView {

    @Bind(R.id.imgAvatar)
    CircleImageView imgAvatar;
    @Bind(R.id.txtUser)
    TextView txtUser;
    @Bind(R.id.txtStatus)
    TextView txtStatus;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.messageRecyclerView)
    RecyclerView messageRecyclerView;
    @Bind(R.id.editTxtMessage)
    EditText editTxtMessage;
    @Bind(R.id.btnSendMessage)
    ImageButton btnSendMessage;

    private ChatAdapter adapter;
    private ChatPresenter presenter;

    public final static String EMAIL_KEY =  "email";
    public final static String ONLINE_KEY = "online";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        setupAdapter();
        setupRecyclerView();


        presenter = new ChatPresenterImpl(this);
        presenter.onCreate();

        setupToolbar(getIntent());

    }

    private void setupAdapter() {
        adapter = new ChatAdapter(this, new ArrayList<ChatMessage>());
    }

    private void setupRecyclerView() {
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageRecyclerView.setAdapter(adapter);
    }

    private void setupToolbar(Intent intent) {
        String recipient = intent.getStringExtra(EMAIL_KEY);
        presenter.setChatRecipient(recipient);
        boolean online = intent.getBooleanExtra(ONLINE_KEY, false);

        String status = online ? "online" : "offline";
        int color = online ? Color.GREEN : Color.RED;

        txtUser.setText(recipient);
        txtStatus.setText(status);
        txtStatus.setTextColor(color);

        ImageLoader imageLoader = new GlideImageLoader(getApplicationContext());
        imageLoader.load(imgAvatar, AvatarHelper.getAvatarUrl(recipient));

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

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onMessageReceived(ChatMessage msg) {
        adapter.add(msg);
        messageRecyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }
}
