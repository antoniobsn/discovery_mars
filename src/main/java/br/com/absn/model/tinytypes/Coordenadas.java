package br.com.absn.model.tinytypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by asampaio on 29/09/17.
 */
public class Coordenadas implements Serializable{

    private static final long serialVersionUID = 1659342842058692025L;

    @JsonProperty("x")
    private int x;

    @JsonProperty("y")
    private int y;

    @JsonCreator
    public Coordenadas(@JsonProperty("x")int x,
                       @JsonProperty("y")int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenadas)) return false;
        Coordenadas that = (Coordenadas) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
