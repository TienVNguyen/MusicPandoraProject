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

import com.training.tiennguyen.musicpandora.adapter.AlbumsAdapter;
import com.training.tiennguyen.musicpandora.constant.VariableConstants;
import com.training.tiennguyen.musicpandora.data.AlbumsData;
import com.training.tiennguyen.musicpandora.model.Album;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * AlbumsActivity
 *
 * @author TienNguyen
 */
public class AlbumsActivity extends AppCompatActivity {
    @Bind(R.id.lv_album)
    protected ListView lvAlbum;
    @BindString(R.string.txt_album)
    protected String txtAlbum;
    private List<Album> albumList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        initView();
    }

    /**
     * Initial view(s)
     */
    private void initView() {
        ButterKnife.bind(this);

        setTitle(txtAlbum);

        albumList = AlbumsData.getAlbumsList();
        AlbumsAdapter albumsAdapter = new AlbumsAdapter(this, albumList);
        lvAlbum.setAdapter(albumsAdapter);

        lvAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Album album = albumList.get(i);

                if (album != null) {
                    Intent intent = new Intent(getApplicationContext(), SongsActivity.class);
                    intent.putExtra(VariableConstants.INTENT_ALBUM_NAME, album.getName());
                    startActivity(intent);
                }
            }
        });
    }
}
