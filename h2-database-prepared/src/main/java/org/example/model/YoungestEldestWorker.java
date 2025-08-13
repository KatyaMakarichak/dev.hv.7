package org.example.model;

import java.time.LocalDate;

public class YoungestEldestWorker {
    private final String type;
    private final String name;
    private final LocalDate birthday;

    public YoungestEldestWorker(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
