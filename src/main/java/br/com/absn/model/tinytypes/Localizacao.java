package br.com.absn.model.tinytypes;

import br.com.absn.exception.LimiteExcedidoException;
import br.com.absn.model.Planalto;
import br.com.absn.model.enums.Direcao;

/**
 * Created by asampaio on 03/10/17.
 */
public class Localizacao {

    private Coordenadas coordenadas;
    private Direcao direcao;

    public Localizacao(Coordenadas coordenadas, Direcao direcao) {
        this.coordenadas = coordenadas;
        this.direcao = direcao;
    }

    public void verificaLimitesPermitidos(Planalto planalto){
        if(planalto.getCoordenadas().getX() < coordenadas.getX() ||
                planalto.getCoordenadas().getY() < coordenadas.getY()){
            throw new LimiteExcedidoException("Nao e permitido ultrapassar os limites do planalto");
        }else if(0 > coordenadas.getX() || 0 > coordenadas.getY()){
            throw new LimiteExcedidoException("Nao e permitido ultrapassar os limites do planalto");
        }
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public Direcao getDirecao() {
        return direcao;
    }
}
