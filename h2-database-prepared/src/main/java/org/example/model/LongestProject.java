package org.example.model;

public class LongestProject {
    private final int id;
    private final int monthCount;

    public LongestProject(int id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }

    public int getId() {
        return id;
    }

    public int getMonthCount() {
        return monthCount;
    }
}
