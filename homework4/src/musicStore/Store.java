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
    public Store(List<Item> items){
        this.items = items;
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
        return albums;
    }
    public List<Singer> getAllSinger(){
        List<Singer> singers = new ArrayList<>();
        for (Item item : this.items){
            while (!singers.contains(item.getSinger())){
                singers.add(item.getSinger());
            }
        }
        return singers;
    }
    public List<Song> getAllSongs(){
        List<Song> songs = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Song){
                songs.add((Song) item);
            }
        }
        return songs;
    }
    public List<Song> getSongsOfSinger(String singerName){
        List<Song> songs = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Song & singerName.equalsIgnoreCase(item.getSinger().getName())){
                songs.add((Song) item);
            }
        }
        return songs;
    }

    public List<Album> getAllAlbumsOfSinger(String singerName){
        List<Album> albums = new ArrayList<>();
        for (Item item : this.items){
            if (item.getItemType() == ItemType.Album & singerName.equalsIgnoreCase(item.getSinger().getName())){
                albums.add((Album) item);
            }
        }
        return albums;
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
        List<Singer> singers = new ArrayList<>();
        Singer adele =  new Singer("Adele");
        Singer tarkan = new Singer("Tarkan");
        Singer kayahan =  new Singer("Kayahan");
        Singer sezen = new Singer("Sezen Aksu");
        Singer gulsen = new Singer("Gülşen");
        singers.add(adele);
        singers.add(tarkan);
        singers.add(kayahan);
        singers.add(sezen);
        singers.add(gulsen);

        //Songs
        List<Song> songs = new ArrayList<>();
        Song s1album1 = new Song("First Love", BigDecimal.valueOf(15d),"3:10",adele);
        Song s2album1 =  new Song("My Same",BigDecimal.valueOf(15d),"3:16",adele);
        Song s3album1 =  new Song("Cold Shoulder",BigDecimal.valueOf(15d),"3:12",adele);
        Song s1album2 = new Song("Odalarda Işıksızım",BigDecimal.valueOf(20d), "3:10",sezen);
        Song s2album2 = new Song("Emrin olur",BigDecimal.valueOf(20d), "3:08",gulsen);
        Song s3album2 = new Song("Yemin Ettim",BigDecimal.valueOf(20d), "3:48",tarkan);
        songs.add(s1album1);
        songs.add(s2album1);
        songs.add(s3album1);
        songs.add(s1album2);
        songs.add(s2album2);
        songs.add(s3album2);

        //Albums
        List<Song> album1Songs = new ArrayList<>();
        album1Songs.add(s1album1);
        album1Songs.add(s2album1);
        album1Songs.add(s3album1);
        Album album1 = new Album("19","2015", BigDecimal.valueOf(40.50d) ,adele,album1Songs);

        Album album2 = new Album("Kayahan'ın En İyileri No.1","2014",BigDecimal.valueOf(50d) ,kayahan);
        album2.addSong(s1album2);
        album2.addSong(s2album2);
        album2.addSong(s3album2);


        this.addItem(album1);
        this.addItem(album2);

        this.addItem(s1album1);
        this.addItem(s2album1);
        this.addItem(s3album1);
        this.addItem(s1album2);
        this.addItem(s2album2);
        this.addItem(s3album2);

    }
}
