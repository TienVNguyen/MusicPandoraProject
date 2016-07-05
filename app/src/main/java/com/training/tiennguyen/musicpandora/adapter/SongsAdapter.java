/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.tiennguyen.musicpandora.R;
import com.training.tiennguyen.musicpandora.model.Song;
import com.training.tiennguyen.musicpandora.utils.ImageUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * SongsAdapter
 *
 * @author TienNguyen
 */
public class SongsAdapter extends BaseAdapter {
    private Activity activity;
    private List<Song> songList;
    private LayoutInflater layoutInflater;

    public SongsAdapter(Activity activity, List<Song> songList) {
        this.activity = activity;
        this.songList = songList;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return songList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = layoutInflater.inflate(R.layout.activity_songs_adapter, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        Song song = songList.get(i);
        if (song != null) {
            viewHolder.txtSongName.setText(song.getName());
            viewHolder.txtSongSinger.setText(song.getSinger());
            ImageUtils.setImage(activity, song.getImg(), 200, 200, viewHolder.imgSong);
        }

        return view;
    }

    protected static class ViewHolder {
        @Bind(R.id.img_song)
        protected ImageView imgSong;
        @Bind(R.id.txt_song_name)
        protected TextView txtSongName;
        @Bind(R.id.txt_song_singer)
        protected TextView txtSongSinger;

        protected ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
