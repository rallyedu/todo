package net.rallyedu.todo.model;

public class Item {
    private long id;
    private String info;

    public Item(long id, String info) {
        this.id = id;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }
}
