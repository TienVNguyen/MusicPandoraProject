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
import com.training.tiennguyen.musicpandora.model.Album;
import com.training.tiennguyen.musicpandora.utils.ImageUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * AlbumsAdapter
 *
 * @author TienNguyen
 */
public class AlbumsAdapter extends BaseAdapter {
    private Activity activity;
    private List<Album> albumList;
    private LayoutInflater layoutInflater;

    public AlbumsAdapter(Activity activity, List<Album> albumList) {
        this.activity = activity;
        this.albumList = albumList;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return albumList.size();
    }

    @Override
    public Object getItem(int i) {
        return albumList.get(i);
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
            view = layoutInflater.inflate(R.layout.activity_albums_adapter, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        Album album = albumList.get(i);
        if (album != null) {
            viewHolder.txtAlbumName.setText(album.getName());
            ImageUtils.setImage(activity, album.getImg(), 600, 600, viewHolder.imgAlbum);
        }

        return view;
    }

    protected static class ViewHolder {
        @Bind(R.id.img_album)
        protected ImageView imgAlbum;
        @Bind(R.id.txt_album_name)
        protected TextView txtAlbumName;

        protected ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
