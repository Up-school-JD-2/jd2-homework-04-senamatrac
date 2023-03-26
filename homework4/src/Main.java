import Shopping.Cart;
import musicStore.Store;
import musicStore.data.Album;
import musicStore.data.Item;
import musicStore.data.Singer;
import musicStore.data.Song;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Store store = new Store();

    static List<User> users = new ArrayList<>();

    public void listAllSinger(){
        System.out.println("\u001B[31m Mağazada bulunan tüm sanatçılar: \u001B[0m");
        for (Singer singer : store.getAllSinger()){
            System.out.println(singer.getName());
        }
    }
    public List<Album> listAllAlbums(){
        System.out.println("\u001B[31m Mağazada bulunan tüm albümler: \u001B[0m");
        int number = 1;
        List<Album> albums = store.getAllAlbums();
        for (Album al : albums){
            System.out.println(number++ + " -> " +al.getSinger().getName()+" - "+al.getTitle()+" \u001B[34m"+al.getPrice()+" \u20BA \u001B[0m ");
        }
        return albums;
    }
    public List<Song> listAllSongs(){
        System.out.println("\u001B[31m Mağazada bulunan tüm şarkılar: \u001B[0m");
        int number = 1;
        List<Song> songs = store.getAllSongs();
        for (Song song : store.getAllSongs()){
            System.out.println(number++ + " -> " +song.getSinger().getName()+" - "+song.getTitle()+" \u001B[34m"+song.getPrice()+" \u20BA \u001B[0m");
        }
        return  songs;
    }

    public List<Song> listSongsOfSinger(String singerName){
        System.out.println("\u001B[31m"+singerName+" isimli sanatçının şarkıları: \u001B[0m");
        int number = 1;

        List<Song> songs = store.getSongsOfSinger(singerName);
        for (Song song : songs){
                System.out.println(number++ + " -> " +song.getSinger().getName()+" song.getAlbum() "+song.getTitle()+" \u001B[34m"+song.getPrice()+" \u20BA \u001B[0m");
        }
        return songs;
    }

    public List<Album> listAllAlbumsOfSinger(String singerName){

        List<Album> albums = store.getAllAlbumsOfSinger(singerName);
        if (albums != null) {
            System.out.println("\u001B[31m"+singerName+" isimli sanatçının albümleri: \u001B[0m");
            int number = 1;
            for (Album album : albums) {
                System.out.println(number++ + " -> " + album.getSinger().getName() + " - " + album.getTitle() + " \u001B[34m" + album.getPrice() + " \u20BA \u001B[0m ");
            }
        }
        return albums;

    }

    public Album searchForAlbum(String albumTitle){
        System.out.println("\u001B[31m"+albumTitle+" isimli album ve şarkıları: \u001B[0m");
        Album album = (Album) store.getAlbumByTitle(albumTitle);
        if (album != null) {
            List<Song> songs = album.getSongs();
            int number = 1;
            System.out.println(album.getTitle() + " albümü "+album.getSinger().getName()+ " ~ "+" \u001B[34m" + album.getPrice() + " \u20BA \u001B[0m");
            for (Song song : songs) {
                System.out.println(number++  + " -> " + song.getTitle() + " \u001B[34m" + song.getPrice() + " \u20BA \u001B[0m");
            }
        }else
            System.out.println("Üzgünüz bu albümü mağazamız da bulamadık.");

        return album;
    }

    public void searchForSong(String songTitle){
        System.out.println("\u001B[31m"+songTitle+": \u001B[0m");
    }

    public void viewCart(User user){
        Cart cart = user.getCart();
        for (Item item : cart.getItems()){
            System.out.println(item.getItemType()+" ~ " + item.getTitle() + " " + item.getSinger().getName() +" "+ item.getPrice());
        }
        System.out.println("Total price : "+cart.getTotalPrice());
    }

    public void purchase(User user){
        user.getCart().purchase();
        System.out.println("Ödeme tamamlandı.");
    }
    public void mainMenu(){
        System.out.println(" ^^^^ Yapabileceğiniz işlemler ^^^^");
        System.out.println("1- Albümleri listele");
        System.out.println("2- Şarkıları listele");
        System.out.println("3- Sanatçıları listele");
        System.out.println("4- Sanatçıya ait tüm şarkıları listele");
        System.out.println("5- Sanatçıya ait tüm albümleri listele");
        System.out.println("6- Bir şarkı ara");
        System.out.println("7- Bir albüm ara");
        System.out.println("8- Sepetine bak");
        System.out.println("9- Ödeme yap");
        System.out.println("Çıkış için -1 e basınız");

    }


    public static void main(String[] args) {
        Main main = new Main();
        main.store.fillStore();

        System.out.println("Kayıt olun: ");

        User user1 = new User("Sena");
        Cart cart = new Cart(user1);
        User user2 = new User("Yasin");
        Cart cart2 = new Cart(user1);
        users.add(new User("Sena"));
        users.add(new User("Yasin"));
        main.mainMenu();
        int nm  = 0;
        while (nm != -1) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Yapmak istediğiniz işlem numarasını giriniz: ");
            nm = sc.nextInt();
            sc.nextLine();
            switch (nm){
                case 1 ->{
                    List<Album> albums = main.listAllAlbums();
                    System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
                    int itemNumber = sc.nextInt();
                    if (itemNumber == 0)
                        main.mainMenu();
                    else {
                        user1.getCart().addItem(albums.get(itemNumber - 1));
                    }

                }
                case 2 -> {
                    List<Song> songs = main.listAllSongs();
                    System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
                    int itemNumber = sc.nextInt();
                    if (itemNumber == 0)
                        main.mainMenu();
                    else {
                        user1.getCart().addItem(songs.get(itemNumber - 1));
                    }
                }
                case 3 -> main.listAllSinger();
                case 4 -> {
                    System.out.print("Aradığınız sanatçı ismini giriniz: ");
                    String singerName = sc.nextLine();

                    main.listSongsOfSinger(singerName);
                }
                case 5 ->  {
                    System.out.print("Aradığınız sanatçı ismini giriniz: ");
                    String singerName = sc.nextLine();
                    List<Album> albums = main.listAllAlbumsOfSinger(singerName);
                    if (albums != null) {
                        System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
                        int itemNumber = sc.nextInt();
                        if (itemNumber == 0)
                            main.mainMenu();
                        else {
                            user1.getCart().addItem(albums.get(itemNumber - 1));
                        }
                    }else
                        System.out.println("Üzgünüz bu sanatçıya ait hiç albüm bulamadık.");
                }
                case 6 -> {
                    System.out.print("Aradığınız şarkı ismini giriniz: ");
                    String songTitle = sc.nextLine();
                     main.searchForSong(songTitle);
                }
                case 7 -> {
                    System.out.print("Aradığınız albüm ismini giriniz: ");
                    String albumTitle = sc.nextLine();
                    Album album = main.searchForAlbum(albumTitle);
                    System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz.Albümü almak istiyorsanız "+(album.getSongs().size()+1)+"'e basınız. (Ana menüye dönmek için 0'a basınız)");
                    int itemNumber = sc.nextInt();
                    if (itemNumber == 0)
                        main.mainMenu();
                    else if(0 < itemNumber & itemNumber < album.getSongs().size() ){
                        user1.getCart().addItem(album.getSongs().get(itemNumber - 1));
                    }else if (itemNumber == album.getSongs().size()+1){
                        user1.getCart().addItem(album);
                    }else
                        System.out.println("Hatalı numara girdiniz.");

                }
                case 8 -> main.viewCart(user1);
                case 9 -> main.purchase(user1);

            }
        }


    }
}