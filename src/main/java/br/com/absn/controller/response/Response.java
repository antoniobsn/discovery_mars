package br.com.absn.controller.response;

import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by asampaio on 29/09/17.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -933183258514491945L;

    @JsonProperty("posicao")
    private Coordenadas posicao;

    @JsonProperty("direcao")
    private Direcao direcao;

    @JsonCreator
    public Response(@JsonProperty("posicao")Coordenadas posicao,
                    @JsonProperty("direcao")Direcao direcao) {
        this.posicao = posicao;
        this.direcao = direcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        Response response = (Response) o;
        return Objects.equals(posicao, response.posicao) &&
                direcao == response.direcao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicao, direcao);
    }
}
