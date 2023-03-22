package musicStore;

public class Store {

    private Album[] albums;

    public Store(Album[] albums){
        this.albums = albums;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
    /*
    * Search Album Title
    * Search Song Title
    * Show All albums with songs
    *
    * */
}
