package br.com.absn.controller.request;

import br.com.absn.model.Planalto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by asampaio on 29/09/17.
 */
public class Request implements Serializable{

    private static final long serialVersionUID = -8894031780896397733L;

    @JsonProperty("planalto")
    private Planalto planalto;

    @JsonCreator
    public Request(@JsonProperty("planalto") Planalto planalto) {
        this.planalto = planalto;
    }

    public Request() {
    }

    public Planalto getPlanalto() {
        return planalto;
    }
}
