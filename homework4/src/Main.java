import musicStore.Album;
import musicStore.Singer;
import musicStore.Song;
import musicStore.Store;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Singer adele =  new Singer("Adele");
        Album album1 = new Album("19", "2015");
        Song s1 = new Song("First Love", "3:10");
        Song s2 =  new Song("My Same", "3:16");
        album1.setSinger(adele);


        /*for (Album a : store.getAlbums()) {
            System.out.println("Album: " + a.getTitle() + " Singer: "+ a.getSinger().getName());
            for (Song s : a.getSongs()) //null check
                System.out.println((char)176+" "+s.getTitle());
        }*/
        System.out.println(adele.getSongCount());
        for (Song s : adele.getAllSong()){
            System.out.println(s.getTitle() + " - " +s.getAlbum().getTitle());
        }


    }
}