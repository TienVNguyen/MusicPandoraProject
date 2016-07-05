/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora.data;

import com.training.tiennguyen.musicpandora.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * AlbumsData<br>
 * TODO: Mockup data just for testing
 *
 * @author TienNguyen
 */
public class SongsData {
    public static List<Song> getSongsList(String albumName) {
        List<Song> songs = new ArrayList<>();

        // Temperately support these
        switch (albumName) {
            case "POP":
                songs = addPopSongs(albumName);
                break;
            case "ROCK":
                songs = addRockSongs(albumName);
                break;
            default:
                break;
        }

        return songs;
    }

    private static List<Song> addRockSongs(String albumName) {
        Song song1 = new Song();
        song1.setName("This Is What You Came For");
        song1.setSinger("Calvin Harris, Rihanna");
        song1.setImg("http://media.baouc.com/485/2016/5/21/calvin-harris.jpg");
        song1.setMedia("thisiswhatyoucameforcalvinharrisrihanna");
        song1.setUrl("http://mp3.zing.vn/bai-hat/This-Is-What-You-Came-For-Calvin-Harris-Rihanna/ZW7UUI8A.html");
        song1.setAlbum(albumName);
        song1.setDescription("Adam Richard Wiles (born 17 January 1984), known professionally as Calvin Harris," +
                " is a Scottish DJ, record producer, singer, songwriter and remixer. His debut studio album," +
                " I Created Disco, was released in 2007 and was the precursor to his top-10 singles" +
                " \"Acceptable in the 80s\" and \"The Girls\". In 2009, Harris released his second studio album, Ready for the Weekend," +
                " which debuted at number one on the UK Albums Chart and earned a gold certification from the British Phonographic Industry" +
                " within two months of release. Its lead single, \"I'm Not Alone\", became his first number one on the UK Singles Chart.");

        Song song2 = new Song();
        song2.setName("Sugar");
        song2.setSinger("Maren Morris");
        song2.setImg("https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2016/03/11/Style/Images/MarenMorris_LeAnnMueller_0347_CROP1457726410.jpg");
        song2.setMedia("sugarmarenmorris");
        song2.setUrl("http://mp3.zing.vn/bai-hat/Sugar-Maren-Morris/ZW7U9IIW.html");
        song2.setAlbum(albumName);
        song2.setDescription("Maren Larae Morris (born April 10, 1990) is an American musician, singer, and songwriter." +
                " She has released four albums; her latest, extended play Maren Morris, has charted on two Billboard charts." +
                " Her debut single, \"My Church\", hit #1 on Country Digital Songs in 2016.");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);

        return songs;
    }

    private static List<Song> addPopSongs(String albumName) {
        Song song1 = new Song();
        song1.setName("Sing Me To Sleep");
        song1.setSinger("Alan Walker");
        song1.setImg("http://image.mp3.zdn.vn/thumb/165_165/avatars/c/0/c0158a5d0afdbb8b3d177162b9328a7c_1452770729.jpg");
        song1.setMedia("singmetosleepalanwalker");
        song1.setUrl("http://mp3.zing.vn/bai-hat/Sing-Me-To-Sleep-Alan-Walker/ZW7U8679.html");
        song1.setAlbum(albumName);
        song1.setDescription("Alan Cameron Walker (1865–1931) was an Australian architect and philanthropist, born in Hobart, Tasmania." +
                " The grandson of John Walker, he was educated at Hutchins School and apprenticed to Henry Hunter." +
                " He produced many Tasmanian government and other buildings during his career, and was also a keen silversmith," +
                " serving as President of the Tasmanian Arts and Crafts Society for 25 years. He was the first President of the Tasmanian Architect's Registration Board.");

        Song song2 = new Song();
        song2.setName("Back To Sleep (Legends Remix)");
        song2.setSinger("Many");
        song2.setImg("https://i1.sndcdn.com/artworks-000146521105-7hl95r-t500x500.jpg");
        song2.setMedia("backtosleeplegendsremixchrisbrowntankrkellyanthonyhamilton");
        song2.setUrl("http://mp3.zing.vn/bai-hat/Back-To-Sleep-Legends-Remix-Chris-Brown-Tank-R-Kelly-Anthony-Hamilton/ZW7UO0CO.html");
        song2.setAlbum(albumName);
        song2.setDescription("A quantifier that can be used with count nouns - often preceded by 'as' or 'too'" +
                " or 'so' or 'that'; amounting to a large but indefinite number; 'many temptations'; 'a good many';" +
                " 'many directions'; more than a few, more than several");

        Song song3 = new Song();
        song3.setName("Nothing Left");
        song3.setSinger("Kygo, Will Heard");
        song3.setImg("https://i1.sndcdn.com/avatars-000051227737-yg2t1z-t500x500.jpg");
        song3.setMedia("nothingleftkygowillheard");
        song3.setUrl("http://mp3.zing.vn/bai-hat/Nothing-Left-Kygo-Will-Heard/ZW7WW0D6.html");
        song3.setAlbum(albumName);
        song3.setDescription("Kygo started getting piano lessons at the age of 6.[8] " +
                "He stopped when he was 15 or 16 and started producing music with Logic Studio and a MIDI" +
                " keyboard while watching several tutorials on YouTube.[9] When he decided to pursue music" +
                " full-time he was halfway through a degree in business and finance at Heriot-Watt University in Edinburgh, United Kingdom.");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);

        return songs;
    }
}
