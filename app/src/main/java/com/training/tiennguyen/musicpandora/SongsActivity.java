/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.training.tiennguyen.musicpandora.adapter.SongsAdapter;
import com.training.tiennguyen.musicpandora.constant.VariableConstants;
import com.training.tiennguyen.musicpandora.data.SongsData;
import com.training.tiennguyen.musicpandora.model.Song;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * SongsActivity
 *
 * @author TienNguyen
 */
public class SongsActivity extends AppCompatActivity {
    @Bind(R.id.txt_songs)
    protected TextView txtSongs;
    @Bind(R.id.txt_songs_describe)
    protected TextView txtSongsDescribe;
    @Bind(R.id.lv_songs)
    protected ListView lvSongs;
    @BindString(R.string.txt_song)
    protected String existSongs;
    @BindString(R.string.txt_no_song)
    protected String noSong;
    private List<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        initView();
    }

    /**
     * Initial view(s)
     */
    private void initView() {
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String albumName = intent.getStringExtra(VariableConstants.INTENT_ALBUM_NAME);
        songList = SongsData.getSongsList(albumName);

        if (songList != null) {
            if (songList.size() > 0) {
                SongsAdapter songsAdapter = new SongsAdapter(this, songList);
                lvSongs.setAdapter(songsAdapter);
                lvSongs.setVisibility(View.VISIBLE);
                txtSongs.setText(existSongs);
                txtSongsDescribe.setVisibility(View.VISIBLE);

                lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Song song = songList.get(i);

                        if (song != null) {
                            Intent intent = new Intent(getApplicationContext(), SongDetailsActivity.class);
                            intent.putExtra(VariableConstants.INTENT_SONG_NAME, song.getName());
                            intent.putExtra(VariableConstants.INTENT_SONG_SINGER, song.getSinger());
                            intent.putExtra(VariableConstants.INTENT_SONG_IMG, song.getImg());
                            intent.putExtra(VariableConstants.INTENT_SONG_MEDIA, song.getMedia());
                            intent.putExtra(VariableConstants.INTENT_SONG_URL, song.getUrl());
                            intent.putExtra(VariableConstants.INTENT_SONG_ALBUM, song.getAlbum());
                            intent.putExtra(VariableConstants.INTENT_SONG_DESCRIPTION, song.getDescription());
                            startActivity(intent);
                        }
                    }
                });
            } else {
                lvSongs.setVisibility(View.GONE);
                txtSongs.setText(noSong);
                txtSongsDescribe.setVisibility(View.GONE);
            }
        } else {
            lvSongs.setVisibility(View.GONE);
            txtSongs.setText(noSong);
            txtSongsDescribe.setVisibility(View.GONE);
        }
    }

    /*@OnItemClick(R.id.lv_songs)
    protected void onItemClickedSong(int position) {
        Song song = songList.get(position);

        if (song != null) {
            Intent intent = new Intent(this, SongDetailsActivity.class);
            intent.putExtra(VariableConstants.INTENT_SONG_NAME, song.getName());
            intent.putExtra(VariableConstants.INTENT_SONG_SINGER, song.getSinger());
            intent.putExtra(VariableConstants.INTENT_SONG_IMG, song.getImg());
            intent.putExtra(VariableConstants.INTENT_SONG_MEDIA, song.getMedia());
            intent.putExtra(VariableConstants.INTENT_SONG_URL, song.getUrl());
            intent.putExtra(VariableConstants.INTENT_SONG_ALBUM, song.getAlbum());
            intent.putExtra(VariableConstants.INTENT_SONG_DESCRIPTION, song.getDescription());
            startActivity(intent);
        }
    }*/
}
