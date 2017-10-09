package br.com.absn.model;

import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 04/10/17.
 */
public class SondaTest {

    @Test
    public void deveMovimentarUmaSondaParaEsquerda() throws Exception {

        List<Comando> comandoSondaUm = new ArrayList<>();
        comandoSondaUm.add(Comando.L);

        Sonda sonda = new Sonda(new Coordenadas(1,2), Direcao.N,comandoSondaUm);
        List<Sonda> sondas = new ArrayList<>();
        sondas.add(sonda);

        Planalto planalto = new Planalto(new Coordenadas(5, 5), sondas);

        Sonda sondaAtual = sonda.movimentar(planalto);

        Sonda sondaEsperada = new Sonda(new Coordenadas(1,2), Direcao.W, comandoSondaUm);

        Assert.assertEquals(sondaEsperada, sondaAtual);
    }

    @Test
    public void deveMovimentarUmaSondaParaDireita() throws Exception {

        List<Comando> comandoSondaUm = new ArrayList<>();
        comandoSondaUm.add(Comando.R);

        Sonda sonda = new Sonda(new Coordenadas(1,2), Direcao.N,comandoSondaUm);
        List<Sonda> sondas = new ArrayList<>();
        sondas.add(sonda);

        Planalto planalto = new Planalto(new Coordenadas(5, 5), sondas);

        Sonda sondaAtual = sonda.movimentar(planalto);

        Sonda sondaEsperada = new Sonda(new Coordenadas(1,2), Direcao.E, comandoSondaUm);

        Assert.assertEquals(sondaEsperada, sondaAtual);
    }

    @Test
    public void deveMovimentarUmaSondaParaFrente() throws Exception {

        List<Comando> comandoSondaUm = new ArrayList<>();
        comandoSondaUm.add(Comando.M);

        Sonda sonda = new Sonda(new Coordenadas(1,2), Direcao.N,comandoSondaUm);
        List<Sonda> sondas = new ArrayList<>();
        sondas.add(sonda);

        Planalto planalto = new Planalto(new Coordenadas(5, 5), sondas);

        Sonda sondaAtual = sonda.movimentar(planalto);

        Sonda sondaEsperada = new Sonda(new Coordenadas(1,3), Direcao.N, comandoSondaUm);

        Assert.assertEquals(sondaEsperada, sondaAtual);
    }
}