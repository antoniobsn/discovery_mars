package br.com.absn.model;

import br.com.absn.model.tinytypes.Coordenadas;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asampaio on 29/09/17.
 */

public class Planalto implements Serializable{

    private static final long serialVersionUID = -2406363739841437540L;

    @JsonProperty("coordenadas")
    private Coordenadas coordenadas;

    @JsonProperty("sondas")
    private List<Sonda> sondas;

    @JsonCreator
    public Planalto(@JsonProperty("coordenadas") Coordenadas coordenadas,
                    @JsonProperty("sondas") List<Sonda> sondas) {
        this.coordenadas = coordenadas;
        this.sondas = sondas;
    }

    public List<Sonda> explorar() {

        List<Sonda> sondas = this.getSondas();

        sondas.forEach(sonda -> sonda.movimentar(this));

        return sondas;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public List<Sonda> getSondas() {
        return sondas;
    }
}
