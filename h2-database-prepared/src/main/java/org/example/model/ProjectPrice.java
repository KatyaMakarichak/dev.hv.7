package org.example.model;

public class ProjectPrice {
    private final int projectId;
    private final int price;

    public ProjectPrice(int projectId, int price) {
        this.projectId = projectId;
        this.price = price;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getPrice() {
        return price;
    }
}
