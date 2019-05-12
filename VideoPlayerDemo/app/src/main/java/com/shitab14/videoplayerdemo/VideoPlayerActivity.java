package com.shitab14.videoplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    VideoView player;
    ImageButton rewindButton, playpauseButton, forwardButton;
    ProgressDialog progressDialog;
    String videoURL;
    Uri uri;
    Boolean started;
    TextView starttimeTextview,endtimeTextview, videourlTextview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        player=findViewById(R.id.id_videoplayer);
        videoURL="https://shitab14.github.io/shitabsdomain/Marvel_Black_Panther_Music_Video.mp4";

        //Video set
        uri = Uri.parse(videoURL);

        started=false;

        //Progress Msg
        progressDialog=new ProgressDialog(VideoPlayerActivity.this);
        progressDialog.setMessage("Loading Video");
        progressDialog.setCanceledOnTouchOutside(false);

        //Buttons
        rewindButton=findViewById(R.id.id_rewind_button);
        playpauseButton=findViewById(R.id.id_playpause_button);
        forwardButton=findViewById(R.id.id_forward_button);

        //TextViews
        starttimeTextview=findViewById(R.id.tv_starttime);
        endtimeTextview=findViewById(R.id.tv_endtime);
        videourlTextview=findViewById(R.id.tv_videourl);

        //Initially set
        playpauseButton.setImageResource(R.drawable.ic_play);
        player.setMediaController(new MediaController(this));

        //progressDialog.show();
        player.setVideoURI(uri);
        videourlTextview.setText("Playing from: "+videoURL);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playpauseButton.setImageResource(R.drawable.ic_play);
            }
        });
        player.requestFocus();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                mp.setLooping(false);

                playpauseButton.setImageResource(R.drawable.ic_pause);
            }
        });
        //starttimeTextview.setText(player.getCurrentPosition());
        //endtimeTextview.setText(player.getDuration());

/*
        try{
            if(!player.isPlaying()) {
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        playpauseButton.setImageResource(R.drawable.ic_play);
                    }
                });
            }
            else {
                player.pause();
                playpauseButton.setImageResource(R.drawable.ic_play);

            }
        }
        catch (Exception e){

        }
        player.requestFocus();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                mp.setLooping(true);

                if(started) {
                    try {
                        //player.resume();
                        player.start();
                    }catch (Exception x){

                    }
                }
                else {
                    player.start();
                    started = true;
                }
                playpauseButton.setImageResource(R.drawable.ic_pause);
            }
        });
*/


/*
        //OnClicks
        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        playpauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    */
    }

}
