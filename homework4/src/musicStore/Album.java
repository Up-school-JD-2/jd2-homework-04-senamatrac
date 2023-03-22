package musicStore;

public class Album {
    private String title;
    private Singer singer ;
    private String year;

    private Song[] songs;

    public Album(String title, String year){
        this.title = title;
        this.year = year;
    }
    public Album(String title, String year,Singer singer, Song[] songs){
        this.title = title;
        this.year = year;
        this.singer = singer;
        this.songs = songs;
    }

    //region GETTER SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
        this.singer.addAlbum(this);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
        setAlbumOfSongs();
    }
    //endregion

    private void setAlbumOfSongs(){
        if (songs != null) {
            for (Song s : songs){
                s.setAlbum(this);
            }
        }
    }


}
