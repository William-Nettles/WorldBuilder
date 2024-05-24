package com.clquinn.models.dictionary.atlas;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "atlas")

public class Chart {

    @EmbeddedId
    private ChartKey id;

    public Chart() {
    }

    public Chart(ChartKey id) {
        this.id = id;
    }

    public ChartKey getId() {
        return id;
    }

    public void setId(ChartKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                '}';
    }
}
