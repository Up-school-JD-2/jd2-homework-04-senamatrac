package musicStore;

public class Singer {
    private String name;
    private Album[] albums;
    private int songCount = 0;
    public Singer (String name){
        this.name = name;
    }

    //region GETTER - SETTER
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Album[] getAlbums() {

        return albums;
    }
    public void setAlbums(Album[] albums) {
        this.albums = albums;
        setSongCount();
    }
    public int getSongCount() {
        return songCount;
    }

    //endregion

    private void setSongCount(){
        for (Album album:albums) {
            songCount += album.getSongs().length;
        }
    }

    public void addAlbum(Album al){
        if (al.getSongs() != null) {
            songCount += al.getSongs().length;
        }
        Album[] newAlbums;
        if (albums != null){
            newAlbums = new Album[albums.length+1];
            for (int i = 0; i < albums.length; i++) {
                newAlbums[i] = albums[i];
            }
        }
        else
            newAlbums = new Album[1];


        newAlbums[albums.length] = al;
        setAlbums(newAlbums);
    }
    public Song[] getAllSong(){
        Song[] allSong = new Song[songCount];
        int i = 0;
        for(Album album : albums){
            System.out.println(album.getTitle());
            for (; i < album.getSongs().length; i++) {
                allSong[i] = album.getSongs()[i];
                System.out.println(album.getSongs()[i].getTitle());
            }
        }

        return allSong;
    }
}
