package musicStore.data;

import java.math.BigDecimal;

public class Song extends Item {
    private String duration;
    private Album album;

    public Song(String title, BigDecimal price, String duration, Singer singer) {
        super(singer,title,price, ItemType.Song);
        this.duration = duration;
    }

    //region GETTER - SETTER

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
    //endregion
}
