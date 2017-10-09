package br.com.absn.model.tinytypes;

import br.com.absn.exception.LimiteExcedidoException;
import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 04/10/17.
 */
public class LocalizacaoTest {

    @Test(expected = LimiteExcedidoException.class)
    public void deveLancarExceptionLimiteExcedido() throws Exception {
        List<Comando> comandoSondaUm = new ArrayList<>();
        comandoSondaUm.add(Comando.R);

        Sonda sonda = new Sonda(new Coordenadas(1,2), Direcao.N,comandoSondaUm);
        List<Sonda> sondas = new ArrayList<>();
        sondas.add(sonda);

        Planalto planalto = new Planalto(new Coordenadas(5, 5), sondas);

        Localizacao localizacao = new Localizacao(new Coordenadas(1,6), Direcao.N);
        localizacao.verificaLimitesPermitidos(planalto);
    }

}