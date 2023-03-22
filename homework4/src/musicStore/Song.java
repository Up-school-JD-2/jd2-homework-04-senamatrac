package musicStore;

public class Song {

    private String title;
    private String duration;
    private Singer singer;
    private Album album;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    //region GETTER - SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
    //endregion
}
