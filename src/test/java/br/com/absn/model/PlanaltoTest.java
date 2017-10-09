package br.com.absn.model;

import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.model.tinytypes.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by antonio on 04/10/17.
 */
public class PlanaltoTest {

    private Planalto planalto;
    private List<Sonda> sondas;
    private List<Comando> comandosSondaUm;
    private List<Comando> comandosSondaDois;

    @Before
    public void beforeMethods(){
        planalto = makePlanalto();
        comandosSondaUm = makeComandosSondaUm();
        comandosSondaDois = makeComandosSondaDois();
        sondas = makeSondas();
    }

    @Test
    public void moveTodasAsSondas() throws Exception {
        List<Sonda> responsesAtual = planalto.explorar();
        Assert.assertEquals(sondas, responsesAtual);

    }

    private Planalto makePlanalto(){
        List<Comando> comandoSondaUm = makeComandosSondaUm();
        List<Comando> comandoSondaDois = makeComandosSondaDois();

        List<Sonda> sondas = new ArrayList<>();
        sondas.add(new Sonda(new Coordenadas(1,2), Direcao.N, comandoSondaUm));
        sondas.add(new Sonda(new Coordenadas(3,3), Direcao.E, comandoSondaDois));

        return new Planalto(new Coordenadas(5,5), sondas);
    }

    private List<Comando> makeComandosSondaDois() {
        List<Comando> comandoSondaDois = new ArrayList<>();
        comandoSondaDois.addAll(Arrays.asList(
                Comando.M, Comando.M,
                Comando.R, Comando.M,
                Comando.M, Comando.R,
                Comando.M, Comando.R,
                Comando.R, Comando.M));
        return comandoSondaDois;
    }

    private List<Comando> makeComandosSondaUm() {
        List<Comando> comandoSondaUm = new ArrayList<>();
        comandoSondaUm.addAll(Arrays.asList(
                Comando.L, Comando.M,
                Comando.L, Comando.M,
                Comando.L, Comando.M,
                Comando.L, Comando.M, Comando.M));
        return comandoSondaUm;
    }

    private List<Sonda> makeSondas(){
        List<Sonda> sondas = new ArrayList<>();
        sondas.add(new Sonda(new Coordenadas(1,3), Direcao.N, comandosSondaUm));
        sondas.add(new Sonda(new Coordenadas(5,1), Direcao.E, comandosSondaDois));

        return sondas;
    }

}