package com.example.mediaplayer;

        import androidx.appcompat.app.AppCompatActivity;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play,pause,restart,rewind,forward,stop;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int starttime=0;
        int stoptime=0;
        int forwardtime=5000;
        int rewindtime=5000;
        play=findViewById(R.id.play);
        restart=findViewById(R.id.restart);
        pause=findViewById(R.id.pause);
        rewind=findViewById(R.id.rewind);
        forward=findViewById(R.id.forward);
        stop=findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Playing media now", Toast.LENGTH_SHORT).show();
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.sample);
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pausing ...", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Rewind by 5sec", Toast.LENGTH_SHORT).show();
                int curr=mediaPlayer.getCurrentPosition();
                int pos=curr-rewindtime;
                if(pos>=starttime)
                {
                    mediaPlayer.seekTo(pos);
                }
                else
                {
                    mediaPlayer.seekTo(starttime);
                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Forward by 5sec", Toast.LENGTH_SHORT).show();
                int curr=mediaPlayer.getCurrentPosition();
                int pos=curr+forwardtime;
                if(pos>mediaPlayer.getDuration())
                {
                    mediaPlayer.seekTo(mediaPlayer.getDuration());
                }
                else
                {
                    mediaPlayer.seekTo(pos);
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "stopping ...", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Restarting ...", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(starttime);
                mediaPlayer.start();
            }
        });
    }
}