package birdfly;

public enum StyleName {
    REDBIRD("redbird"),
    BLUEBIRD("bluebird")
    ;

    private String name;

    StyleName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
