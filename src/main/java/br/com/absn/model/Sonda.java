package br.com.absn.model;

import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.model.tinytypes.Localizacao;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by asampaio on 29/09/17.
 */
public class Sonda implements Serializable{

    private static final long serialVersionUID = -8315850734475864880L;

    @JsonProperty("posicao")
    private Coordenadas posicao;

    @JsonProperty("direcao")
    private Direcao direcao;

    @JsonProperty("comandos")
    private List<Comando> comandos;

    @JsonCreator
    public Sonda(@JsonProperty("posicao")Coordenadas posicao,
                 @JsonProperty("direcao")Direcao direcao,
                 @JsonProperty("comandos")List<Comando> comandos) {
        this.posicao = posicao;
        this.direcao = direcao;
        this.comandos = comandos;
    }

    public Sonda movimentar(Planalto planalto) {
        for(Comando comando : this.getComandos()){
            Localizacao localizacao = comando.movimentar(this);

            setLocalizacao(localizacao);

            localizacao.verificaLimitesPermitidos(planalto);
        }
        return this;
    }

    public List<Comando> getComandos() {
        return comandos;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public Coordenadas getCoordenadas() {
        return posicao;
    }

    private void setLocalizacao(Localizacao localizacao) {
        posicao = localizacao.getCoordenadas();
        direcao = localizacao.getDirecao();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sonda)) return false;
        Sonda sonda = (Sonda) o;
        return Objects.equals(posicao, sonda.posicao) &&
                getDirecao() == sonda.getDirecao() &&
                Objects.equals(getComandos(), sonda.getComandos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicao, getDirecao(), getComandos());
    }
}
