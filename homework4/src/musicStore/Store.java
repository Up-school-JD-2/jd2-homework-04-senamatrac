package musicStore;

import musicStore.data.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Item> items;
    public Store(){
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void  addItem(Item item){
        items.add(item);
    }
    public List<Album> getAllAlbums(){
        List<Album> albums = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Album){
                albums.add((Album) item);
            }
        }
        return albums.size() == 0 ? null : albums;
    }
    public List<Singer> getAllSinger(){
        List<Singer> singers = new ArrayList<>();
        for (Item item : this.items){
            while (!singers.contains(item.getSinger())){
                singers.add(item.getSinger());
            }
        }
        return singers.size() == 0 ? null : singers;
    }
    public List<Song> getAllSongs(){
        List<Song> songs = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Song){
                songs.add((Song) item);
            }
        }
        return songs.size() == 0 ? null : songs;
    }
    public List<Song> getSongsOfSinger(String singerName){
        List<Song> songs = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Song & singerName.equalsIgnoreCase(item.getSinger().getName())){
                songs.add((Song) item);
            }
        }
        return songs.size() == 0 ? null : songs;
    }

    public List<Album> getAllAlbumsOfSinger(String singerName){
        List<Album> albums = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Album & singerName.equalsIgnoreCase(item.getSinger().getName())){
                albums.add((Album) item);
            }
        }
        return albums.size() == 0 ? null : albums;
    }

    public Item getAlbumByTitle(String albumTitle){
       for (Item item : getItems()){
           if (item.getItemType() == ItemType.Album & item.getTitle().equalsIgnoreCase(albumTitle)){
                return item;
           }
       }
        return null;
    }

    public Item getSongByTitle(String songTitle){
        for (Item item : getItems()){
            if (item.getItemType() == ItemType.Song & songTitle.equalsIgnoreCase(item.getTitle())){
                return item;
            }
        }
        return null;
    }

    public void fillStore(){
        //Singers
        Singer adele =  new Singer("Adele");
        Singer tarkan = new Singer("Tarkan");
        Singer varius =  new Singer("Varius");
        Singer sezen = new Singer("Sezen Aksu");
        Singer gulsen = new Singer("Gülşen");
        //Songs
        Song s1album1 = new Song("First Love", BigDecimal.valueOf(15d),"3:10",adele);
        Song s2album1 =  new Song("My Same",BigDecimal.valueOf(15d),"3:16",adele);
        Song s3album1 =  new Song("Cold Shoulder",BigDecimal.valueOf(15d),"3:12",adele);

        Song s1album2 = new Song("Odalarda Işıksızım",BigDecimal.valueOf(20d), "3:10",sezen);
        Song s2album2 = new Song("Emrin olur",BigDecimal.valueOf(20d), "3:08",gulsen);
        Song s3album2 = new Song("Yemin Ettim",BigDecimal.valueOf(20d), "3:48",tarkan);

        Song s1album3 = new Song("Hold on", BigDecimal.valueOf(17d),"6:06",adele);
        Song s2album3 =  new Song("Can I Get It",BigDecimal.valueOf(14d),"3:30",adele);
        Song s3album3 =  new Song("Love is a game",BigDecimal.valueOf(15d),"6:43",adele);

        Song s1album4 = new Song("Gülümse Kaderine", BigDecimal.valueOf(17d),"6:06",tarkan);
        Song s2album4 =  new Song("Dudu",BigDecimal.valueOf(14d),"3:30",tarkan);


        //Albums
        List<Song> album1Songs = new ArrayList<>();
        album1Songs.add(s1album1);
        album1Songs.add(s2album1);
        album1Songs.add(s3album1);
        Album album1 = new Album("19","2021", BigDecimal.valueOf(40.50d) ,adele,album1Songs);

        Album album2 = new Album("Kayahan'ın En İyileri No.1","2014",BigDecimal.valueOf(50d) ,varius);
        album2.addSong(s1album2);
        album2.addSong(s2album2);
        album2.addSong(s3album2);

        Album album3 = new Album("30","2014",BigDecimal.valueOf(44.33d) ,adele);
        album3.addSong(s1album3);
        album3.addSong(s2album3);
        album3.addSong(s3album3);

        Album album4 = new Album("Dudu","2014",BigDecimal.valueOf(44.33d) ,tarkan);
        album4.addSong(s1album4);
        album4.addSong(s2album4);

        this.addItem(album1);
        this.addItem(s1album1);
        this.addItem(s2album1);
        this.addItem(s3album1);

        this.addItem(album2);
        this.addItem(s1album2);
        this.addItem(s2album2);
        this.addItem(s3album2);

        this.addItem(album3);
        this.addItem(s1album3);
        this.addItem(s2album3);
        this.addItem(s3album3);

        this.addItem(album4);
        this.addItem(s1album4);
        this.addItem(s2album4);





    }
}
