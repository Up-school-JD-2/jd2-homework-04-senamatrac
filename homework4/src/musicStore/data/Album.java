package musicStore.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Album extends Item {
    private String year;

    private List<Song> songs  = new ArrayList<>();


    public Album(String title, String year, BigDecimal price, Singer singer){
        super(singer,title,price, ItemType.Album);
        this.title = title;
        this.year = year;
        this.singer = singer;
    }

    public Album(String title, String year,BigDecimal price,Singer singer, List<Song> songs){
        this(title,year,price,singer);
        this.songs = songs;
        assignAlbum(songs);
    }


    //region GETTER SETTER
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    //endregion

    public void addSong(Song song){
        songs.add(song);
        song.setAlbum(this);
    }

    public void assignAlbum(List<Song> songs)
    {
        for (Song song : songs){
            song.setAlbum(this);
        }
    }


}
