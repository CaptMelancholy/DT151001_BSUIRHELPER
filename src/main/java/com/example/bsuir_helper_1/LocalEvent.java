package com.example.bsuir_helper_1;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


public class LocalEvent implements Serializable  {

    @Serial
    private static final long serialVersionUID = 1L;

    private final LocalDate date;

    private final String description;

    public LocalEvent(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }



    // с помощью этого событие красиво отображается
    @Override
    public String toString() {
        return "At: " + date + " " + description;
    }

}
