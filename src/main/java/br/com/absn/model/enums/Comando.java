package br.com.absn.model.enums;

import br.com.absn.model.Sonda;
import br.com.absn.model.enums.interfaces.SondaMotor;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 28/09/17.
 */
public enum Comando implements SondaMotor {
    L{
        @Override
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().virarParaEsquerda(sonda);
        }
    },
    R{
        @Override
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().virarParaDireita(sonda);
        }
    },
    M{
        @Override
        public Localizacao movimentar(Sonda sonda) {
            return sonda.getDirecao().moverParaFrente(sonda);
        }
    };

}
