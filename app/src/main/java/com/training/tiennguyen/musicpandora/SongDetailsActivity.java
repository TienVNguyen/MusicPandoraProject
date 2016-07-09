/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.tiennguyen.musicpandora.constant.VariableConstants;
import com.training.tiennguyen.musicpandora.utils.ImageUtils;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * SongDetailsActivity
 *
 * @author TienNguyen
 */
public class SongDetailsActivity extends AppCompatActivity {
    @Bind(R.id.img_1_song)
    protected ImageView imgSong;
    @Bind(R.id.txt_1_song_name)
    protected TextView txtSongName;
    @Bind(R.id.txt_1_song_singer)
    protected TextView txtSongSinger;
    @Bind(R.id.txt_1_song_description)
    protected TextView txtSongDescription;
    @Bind(R.id.txt_1_song_link)
    protected TextView txtSongLink;
    @BindString(R.string.txt_details_title)
    protected String txtDetailsTitle;
    private String songLink;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_details);

        initView();
    }

    /**
     * Initial view(s)
     */
    private void initView() {
        ButterKnife.bind(this);

        setTitle(txtDetailsTitle);

        Intent intent = getIntent();
        if (intent != null) {
            txtSongName.setText(intent.getStringExtra(VariableConstants.INTENT_SONG_NAME));
            txtSongSinger.setText(intent.getStringExtra(VariableConstants.INTENT_SONG_SINGER));
            txtSongDescription.setText(intent.getStringExtra(VariableConstants.INTENT_SONG_DESCRIPTION));
            songLink = intent.getStringExtra(VariableConstants.INTENT_SONG_URL);
            txtSongLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = songLink;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url.toLowerCase()));
                    startActivity(i);
                }
            });

            ImageUtils.setImage(this, intent.getStringExtra(VariableConstants.INTENT_SONG_IMG), 400, 400, imgSong);

            String media = intent.getStringExtra(VariableConstants.INTENT_SONG_MEDIA);
            if (media != null) {
                int resID = this.getResources().getIdentifier(
                        media,
                        "raw",
                        this.getPackageName());
                mPlayer = MediaPlayer.create(SongDetailsActivity.this, resID);
                mPlayer.setLooping(true);
                mPlayer.start();
            }
        }
    }

    @Override
    protected void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }
}
