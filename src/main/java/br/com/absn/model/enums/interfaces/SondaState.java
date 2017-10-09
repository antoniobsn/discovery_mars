package br.com.absn.model.enums.interfaces;

import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 05/10/17.
 */
public interface SondaState {
    Localizacao virarParaDireita(Sonda sonda);

    Localizacao virarParaEsquerda(Sonda sonda);

    Localizacao moverParaFrente(Sonda sonda);
}
