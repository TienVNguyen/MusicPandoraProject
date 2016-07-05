/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora.data;

import com.training.tiennguyen.musicpandora.model.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * AlbumsData<br>
 * TODO: Mockup data just for testing
 *
 * @author TienNguyen
 */
public class AlbumsData {
    public static List<Album> getAlbumsList() {
        Album album1 = new Album();
        album1.setName("POP");
        album1.setImg("https://thumbs.dreamstime.com/z/pop-music-party-abstract-black-background-16870171.jpg");

        Album album2 = new Album();
        album2.setName("ROCK");
        album2.setImg("http://images4.fanpop.com/image/photos/17200000/rock-rock-music-17211271-1280-1024.jpg");

        Album album3 = new Album();
        album3.setName("RAP");
        album3.setImg("http://www.music-hallparis.com/wp-content/uploads/2016/05/rap.png");

        Album album4 = new Album();
        album4.setName("COUNTRY");
        album4.setImg("http://www.alpinemountainchalets.com/wp-content/uploads/2014/03/Country-Music.jpg");

        Album album5 = new Album();
        album5.setName("R&B");
        album5.setImg("http://atlantablackstar.com/wp-content/uploads/2015/01/RB1.png");

        Album album6 = new Album();
        album6.setName("AUDIOPHILE");
        album6.setImg("https://pbs.twimg.com/profile_images/2206814982/Audiophile.jpg");

        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        albums.add(album6);

        return albums;
    }
}
