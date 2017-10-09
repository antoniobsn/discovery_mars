package br.com.absn.model.enums;

import br.com.absn.model.Sonda;
import br.com.absn.model.enums.interfaces.SondaState;
import br.com.absn.model.tinytypes.Coordenadas;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 28/09/17.
 */
public enum Direcao implements SondaState {
    N {
        @Override
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.E);
        }

        @Override
        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.W);
        }

        @Override
        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX(), sonda.getCoordenadas().getY()+1),
                    sonda.getDirecao());
        }
    }, E {
        @Override
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.S);
        }

        @Override
        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.N);
        }

        @Override
        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX()+1, sonda.getCoordenadas().getY()),
                    sonda.getDirecao());
        }
    }, S {
        @Override
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.W);
        }

        @Override
        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.E);
        }

        @Override
        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX(), sonda.getCoordenadas().getY()-1),
                    sonda.getDirecao());
        }
    }, W {
        @Override
        public Localizacao virarParaDireita(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.N);
        }

        @Override
        public Localizacao virarParaEsquerda(Sonda sonda) {
            return new Localizacao(sonda.getCoordenadas(), Direcao.S);
        }

        @Override
        public Localizacao moverParaFrente(Sonda sonda) {
            return new Localizacao(
                    new Coordenadas(sonda.getCoordenadas().getX()-1, sonda.getCoordenadas().getY()),
                    sonda.getDirecao());
        }
    };
}
