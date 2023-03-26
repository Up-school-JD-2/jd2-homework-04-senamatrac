package musicStore.data;

public class Singer {
    private String name;

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

    //endregion
}
