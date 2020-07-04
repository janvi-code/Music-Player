package android.example.musify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayingFromPlayList extends AppCompatActivity {
    MediaPlayer mediaPlayer ;
   boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_from_play_list);
        Intent intent = getIntent();
        final word wordItem = intent.getParcelableExtra("Item");

        int imageRes = wordItem.getSongId();
        String line1 = wordItem.getSongName();
        String line2 = wordItem.getSingerName();


        TextView text1 = (TextView) findViewById(R.id.play_text2);
        text1.setText(line1);
        TextView text2 = (TextView) findViewById(R.id.singer_text);
        text2.setText(line2);
        TextView songText = (TextView) findViewById(R.id.song_text);
        songText.setText(line1);
        ImageView img = (ImageView) findViewById(R.id.play_image1);
        img.setImageResource(imageRes);

        final ImageView imPlay = (ImageView) findViewById(R.id.back);


        imPlay.setOnClickListener(new ImageView.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(flag)
                {
                    mediaPlayer = MediaPlayer.create(PlayingFromPlayList.this,wordItem.getSingId());
                    flag= false;
                }
                if(mediaPlayer.isPlaying())
                {
                    imPlay.setImageResource(R.drawable.newplay);
                    mediaPlayer.pause();
                }
                else {

                    mediaPlayer.start();
                    imPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                }
            }
        });


    }
}
