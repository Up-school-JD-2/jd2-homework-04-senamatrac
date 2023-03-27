import shopping.Cart;
import musicStore.Store;
import musicStore.data.Album;
import musicStore.data.Item;
import musicStore.data.Singer;
import musicStore.data.Song;
import user.User;

import java.util.*;

public class Main {
    Store store = new Store();

    List<User> users = new ArrayList<>();
    User currentUser;

    public Main() {
        store.fillStore();
    }

    public void listAllSinger() {
        List<Singer> singers = store.getAllSinger();
        if (singers != null) {
            System.out.println("\u001B[31m Mağazada bulunan tüm sanatçılar: \u001B[0m");
            for (Singer singer : singers) {
                System.out.println(singer.getName());
            }
        } else
            System.out.println("Üzgünüz mağazada hiç sanatçı yok.");
    }

    public List<Album> listAllAlbums() {
        List<Album> albums = store.getAllAlbums();
        if (albums != null) {
            System.out.println("\u001B[31m Mağazada bulunan tüm albümler: \u001B[0m");
            int number = 1;
            for (Album al : albums) {
                System.out.println(number++ + " -> " + al.getSinger().getName() + " - " + al.getTitle() + " \u001B[34m Price: " + al.getPrice() + " ₺\u001B[0m ");
            }
        } else {
            System.out.println("Üzgünüz mağazada hiç album yok.");
        }
        return albums;
    }

    public List<Song> listAllSongs() {
        List<Song> songs = store.getAllSongs();
        if (songs != null) {
            System.out.println("\u001B[31m Mağazada bulunan tüm şarkılar: \u001B[0m");
            int number = 1;
            for (Song song : store.getAllSongs()) {
                System.out.println(number++ + " -> " + song.getSinger().getName()
                        + " Album: " + song.getAlbum().getTitle()
                        + " Title: " + song.getTitle()
                        + " Duration: " + song.getDuration()
                        + " \u001B[34m Price:" + song.getPrice() + " ₺\u001B[0m");
            }
        } else {
            System.out.println("Üzgünüz mağazada hiç şarkı yok.");
        }
        return songs;
    }

    public List<Song> listSongsOfSinger(String singerName) {
        List<Song> songs = store.getSongsOfSinger(singerName);
        if (songs != null) {
            System.out.println("\u001B[31m" + singerName + " isimli sanatçının şarkıları: \u001B[0m");
            int number = 1;
            for (Song song : songs) {
                System.out.println(number++ + " -> " + song.getSinger().getName()
                        + " Album: " + song.getAlbum().getTitle()
                        + " Title: " + song.getTitle()
                        + " Duration: " + song.getDuration()
                        + " \u001B[34m Price: " + song.getPrice() + " ₺\u001B[0m");
            }
        } else {
            System.out.println("Üzgünüz bu sanatçıya ait şarkı mağzamızda bulamadık.");
        }
        return songs;
    }

    public List<Album> listAllAlbumsOfSinger(String singerName) {
        List<Album> albums = store.getAllAlbumsOfSinger(singerName);
        if (albums != null) {
            System.out.println("\u001B[31m" + singerName + " isimli sanatçının albümleri: \u001B[0m");
            int number = 1;
            for (Album album : albums) {
                System.out.println(number++ + " -> " + album.getSinger().getName() + " - " + album.getTitle() + " \u001B[34m Price: " + album.getPrice() + " ₺\u001B[0m ");
            }
        } else {
            System.out.println("Üzgünüz bu sanatçıya ait albüm mağzamızda bulamadık.");
        }
        return albums;

    }

    public Album searchForAlbum(String albumTitle) {
        Album album = (Album) store.getAlbumByTitle(albumTitle);
        if (album != null) {
            System.out.println("\u001B[31m" + albumTitle + " isimli album ve şarkıları: \u001B[0m");
            List<Song> songs = album.getSongs();
            int number = 1;
            System.out.println(album.getTitle() + " albümü " + album.getSinger().getName() + " ~ " + " \u001B[34m" + album.getPrice() + " ₺\u001B[0m");
            for (Song song : songs) {
                System.out.println(number++ + " -> " + song.getTitle() + " \u001B[34m Price: " + song.getPrice() + " ₺\u001B[0m");
            }
        } else
            System.out.println("Üzgünüz bu albümü mağazamızda bulamadık.");

        return album;
    }

    public Song searchForSong(String songTitle) {
        Song song = (Song) store.getSongByTitle(songTitle);
        if (song != null) {
            System.out.println("1 -> " + song.getTitle()
                    + " Album: " + song.getAlbum().getTitle()
                    + " Duration: " + song.getDuration()
                    + " \u001B[34m Price: " + song.getPrice() + " ₺\u001B[0m");
        } else
            System.out.println("Üzgünüz bu şarkıyı mağzamızda bulamadık.");

        return song;
    }

    public void viewCart() {
        Cart cart = currentUser.getCart();
        if (!cart.getItems().isEmpty()) {
            System.out.println( " \u001B[34m  -----------------------  \u001B[0m ");
            for (Item item : cart.getItems()) {
                System.out.println(item.getItemType() + " ~ " + item.getTitle() + " " + item.getSinger().getName() + " " + item.getPrice());
            }
            System.out.println("Total price : " + cart.getTotalPrice());
        }else
            System.out.println("Sepetiniz boş");
    }

    public void addSongItemtoCart(List<Song> songs, Scanner sc) {
        System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
        int itemNumber = sc.nextInt();
        if (itemNumber == 0)
            mainMenu();
        else {
            if (songs.get(itemNumber - 1) != null)
                currentUser.getCart().addItem(songs.get(itemNumber - 1));
            else
                System.out.println("Hatalı seçim yaptınız.");
        }
    }

    public void addSongItemtoCart(Song song, Scanner sc) {
        System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
        int itemNumber = sc.nextInt();
        if (itemNumber == 0)
            mainMenu();
        else if (itemNumber == 1) {
            currentUser.getCart().addItem(song);
        } else
            System.out.println("Hatalı seçim yaptınız.");

    }

    public void addAlbumItemtoCart(Album album, Scanner sc) {
        System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz.Albümü almak istiyorsanız " + (album.getSongs().size() + 1) + "'e basınız. (Ana menüye dönmek için 0'a basınız)");
        int itemNumber = sc.nextInt();
        if (itemNumber == 0)
            mainMenu();
        else if (0 < itemNumber & itemNumber < album.getSongs().size()) {
            currentUser.getCart().addItem(album.getSongs().get(itemNumber - 1));
        } else if (itemNumber == album.getSongs().size() + 1) {
            currentUser.getCart().addItem(album);
        } else
            System.out.println("Hatalı numara girdiniz.");
    }

    public void addAlbumItemtoCart(List<Album> albums, Scanner sc) {
        System.out.println("Sepete eklemek istediğiniz ürünün numarasını giriniz. (Ana menüye dönmek için 0'a basınız)");
        int itemNumber = sc.nextInt();
        if (itemNumber == 0)
            mainMenu();
        else {
            if (albums.get(itemNumber - 1) != null)
                currentUser.getCart().addItem(albums.get(itemNumber - 1));
            else
                System.out.println("Hatalı seçim yaptınız.");
        }
    }

    public void purchase() {
        currentUser.getCart().purchase();
        System.out.println("Ödeme tamamlandı.");
    }

    public void mainMenu() {
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
        System.out.println("Oturumdan çıkış yapmak için -1'a basınız");
        System.out.println("Mağazadan çıkış yapmak için -2'ye basınız");
    }

    public void enterStore(Scanner sc){
        currentUser = null;
        boolean failed = true;
        while (failed) {
            System.out.println("1 -> Kayıt olun");
            System.out.println("2 -> Giriş yapın");
            System.out.print("İşleminiz: ");
            int nm = sc.nextInt();
            switch (nm){
                case 1 ->{
                    System.out.print("Lütfen bir isim giriniz: ");
                    String userName = sc.next();
                    User user = new User(userName);
                    if(!users.contains(user)) {
                        users.add(user);
                        currentUser = user;
                        failed = false;
                    }
                    else
                        System.out.println("Bu kullanıcıya ait bir hesap bulunmaktadır.");
                }
                case 2 ->{
                    System.out.print("Lütfen bir isim giriniz: ");
                    String userName = sc.next();
                    for (User user : users){
                        System.out.println(user.getName());
                        if(userName.equalsIgnoreCase(user.getName())){
                            currentUser = user;
                            failed = false;
                            break;
                        }
                    }
                    if (currentUser == null)
                        System.out.println(userName + " isimli bir kullanıcı bulunamadı.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.enterStore(sc);
        System.out.println("#### Hoşgeldiniz "+ main.currentUser.getName() + " #### ");
        main.mainMenu();
        int nm = 0;
        while (nm != -2) {
            if (nm != -1) {
                System.out.print("Yapmak istediğiniz işlem numarasını giriniz: ");
            }
            nm = sc.nextInt();
            switch (nm) {
                //Kullanıcı girişi
                case 0 ->{
                    main.enterStore(sc);
                    System.out.println("#### Hoşgeldiniz "+ main.currentUser.getName() + " #### ");
                    main.mainMenu();
                }
                // Albümleri listele
                case 1 -> {
                    List<Album> albums = main.listAllAlbums();
                    if (albums != null)
                        main.addAlbumItemtoCart(albums, sc);
                }
                //Şarkıları listele
                case 2 -> {
                    List<Song> songs = main.listAllSongs();
                    if (songs != null)
                        main.addSongItemtoCart(songs, sc);
                }
                //Sanatçıları listele
                case 3 -> main.listAllSinger();
                //Sanatçının şarkılarını listele
                case 4 -> {
                    System.out.print("Aradığınız sanatçı ismini giriniz: ");
                    String singerName = sc.nextLine();
                    List<Song> songs = main.listSongsOfSinger(singerName);
                    if (songs != null)
                        main.addSongItemtoCart(songs, sc);
                }
                //Sanatçının albümlerini listele
                case 5 -> {
                    System.out.print("Aradığınız sanatçı ismini giriniz: ");
                    String singerName = sc.nextLine();
                    List<Album> albums = main.listAllAlbumsOfSinger(singerName);
                    if (albums != null)
                        main.addAlbumItemtoCart(albums, sc);
                }
                //Şarkı ismi arama
                case 6 -> {
                    System.out.print("Aradığınız şarkı ismini giriniz: ");
                    String songTitle = sc.nextLine();
                    var song = main.searchForSong(songTitle);
                    if (song != null)
                        main.addSongItemtoCart(song, sc);
                }
                //albüm ismi arama
                case 7 -> {
                    System.out.print("Aradığınız albüm ismini giriniz: ");
                    String albumTitle = sc.nextLine();
                    Album album = main.searchForAlbum(albumTitle);
                    if (album != null)
                        main.addAlbumItemtoCart(album, sc);

                }
                case 8 -> main.viewCart();
                case 9 -> main.purchase();
            }
        }
        System.out.println("Hoşçakalın.");
    }
}