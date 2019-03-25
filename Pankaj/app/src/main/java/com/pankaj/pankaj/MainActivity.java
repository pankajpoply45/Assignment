package com.pankaj.pankaj;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.InetAddress;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {



    private MessageAdapter mMessageAdapter;
    private RecyclerView mMessageRecycler;
    private ArrayList<Object> messageList = new ArrayList<>();
    private ImageView imageView;
    private ArrayList<Object> messageShown = new ArrayList<>();
    private FrameLayout screen;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.background);

        //load background image
        Picasso.get().load("https://image.winudf.com/v2/image/Y29tLndoYXRzYXBwLndhbGxwYXBlcl9zY3JlZW5zaG90c18zXzJkNDhjZDgw/screen-3.jpg?h=800&fakeurl=1&type=.jpg").fit().into(imageView);

        messageList.add(new ReceivedMessage("Hey Doc!"));
        messageList.add(new SentMessage("Hello Vijay. You didn't come for the last two sessions. Are you okay?"));
        messageList.add(new ReceivedMessage("Actually I am coming over to meet you"));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new SentMessage("Now? Vijay,I have left my office already. I'm heading home now."));
        messageList.add(new ReceivedMessage("I know"));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new ImageReceived("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new ReceivedMessage("I have a new friend now,Doc"));
        messageList.add(new SentMessage("Vijay have you been taking your medications regularly? tou know your condition Vijay."));
        messageList.add(new ReceivedMessage("I am aware of it Doc. Infact, I'd say I'm getting all better now."));
        messageList.add(new SentMessage("How do you know that?"));
        messageList.add(new ReceivedMessage("Well, do schizophrenics fall in love? With real people?"));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new SentMessage("Well there is no scientific basis to explain this but judjing by my five years of practice as a psychiatrist, I would say NO."));
        messageList.add(new ReceivedMessage("There you go then"));
        messageList.add(new SentMessage("Why don't you come to my office tommorrow? We'll talk about this."));
        messageList.add(new ReceivedMessage("I can tell you now. She is a good one,            Doc."));
        messageList.add(new ReceivedMessage("Really Pretty..."));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new ImageReceived("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new ReceivedMessage("Pretty eyes..."));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new ReceivedMessage("She scares for me too. But..."));
        messageList.add(new SentMessage("But?"));
        messageList.add(new ReceivedMessage("There's just one problem, Doc."));
        messageList.add(new SentMessage("Go on?"));
        messageList.add(new ReceivedMessage("It's my friend, Doc..."));
        messageList.add(new SentMessage("Who?"));
        messageList.add(new ImageReceived("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new ReceivedMessage("His name is I. Weird, I know..."));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new SentMessage("Vijay you know he's not real..."));
        messageList.add(new ReceivedMessage("But he is!!"));
        messageList.add(new ReceivedMessage("He has been putting ideas in my head,       Doc"));
        messageList.add(new ReceivedMessage("Reallly bad ideas."));
        messageList.add(new ReceivedMessage("Hey Doc!"));
        messageList.add(new SentMessage("Hello Vijay. You didn't come for the last two sessions. Are you okay?"));
        messageList.add(new ReceivedMessage("Actually I am coming over to meet you"));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new SentMessage("Now? Vijay,I have left my office already. I'm heading home now."));
        messageList.add(new ReceivedMessage("I know"));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new ImageReceived("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new ReceivedMessage("I have a new friend now,Doc"));
        messageList.add(new SentMessage("Vijay have you been taking your medications regularly? tou know your condition Vijay."));
        messageList.add(new ReceivedMessage("I am aware of it Doc. Infact, I'd say I'm getting all better now."));
        messageList.add(new SentMessage("How do you know that?"));
        messageList.add(new ReceivedMessage("Well, do schizophrenics fall in love? With real people?"));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new CenterAlignedMessage("2 hours later"));
        messageList.add(new SentMessage("Well there is no scientific basis to explain this but judjing by my five years of practice as a psychiatrist, I would say NO."));
        messageList.add(new ReceivedMessage("There you go then"));
        messageList.add(new ReceivedMessage("Hey Doc!"));
        messageList.add(new SentMessage("Hello Vijay. You didn't come for the last two sessions. Are you okay?"));
        messageList.add(new ReceivedMessage("Actually I am coming over to meet you"));
        messageList.add(new ImageSent("http://i.imgur.com/DvpvklR.png"));
        messageList.add(new SentMessage("Now? Vijay,I have left my office already. I'm heading home now."));
        messageList.add(new ReceivedMessage("I know"));

        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageAdapter( messageShown);
        LinearLayoutManager linearlayoutmanager= new LinearLayoutManager(this);
        //mMessageRecycler.smoothScrollToPosition(count);
        mMessageRecycler.setLayoutManager(linearlayoutmanager);
        mMessageRecycler.setAdapter(mMessageAdapter);
        screen=findViewById(R.id.screen);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.new_message);
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTap(getApplicationContext());
            }
        });
        mMessageRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTap(getApplicationContext());
            }
        });




    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    public void OnTap(Context context)
    {
        final MediaPlayer mp=MediaPlayer.create(context,R.raw.new_message);
        if(count<messageList.size() && isNetworkConnected()==true )
        {
            messageShown.add(messageList.get(count));
            mMessageAdapter.notifyItemInserted(count);
            count=count+1;
            mMessageRecycler.smoothScrollToPosition(count);
            Log.e("TAG","TAG");
            mp.start();
        }
        else if(count>=messageList.size())
        {
            Toast.makeText(context,"Chat ended",Toast.LENGTH_SHORT).show();
            mMessageRecycler.smoothScrollToPosition(count-1);
        }
        else if (isNetworkConnected()==false)
        {
            Toast.makeText(context,"Connect to internet",Toast.LENGTH_SHORT).show();
            android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.screen,new Retry());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}