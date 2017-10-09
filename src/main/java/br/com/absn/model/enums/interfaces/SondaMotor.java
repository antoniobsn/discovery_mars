package br.com.absn.model.enums.interfaces;

import br.com.absn.model.Sonda;
import br.com.absn.model.tinytypes.Localizacao;

/**
 * Created by asampaio on 03/10/17.
 */
public interface SondaMotor {

    Localizacao movimentar(Sonda sonda);
}
