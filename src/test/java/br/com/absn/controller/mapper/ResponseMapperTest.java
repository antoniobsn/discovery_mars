package br.com.absn.controller.mapper;

import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.controller.response.Response;
import br.com.absn.model.tinytypes.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by antonio on 04/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ResponseMapperTest {

    @InjectMocks
    private ResponseMapper mapper;

    private List<Comando> comandosSondaUm;
    private List<Comando> comandosSondaDois;
    private List<Response> response;

    @Before
    public void beforeMethods(){
        comandosSondaUm = makeComandosSondaUm();
        comandosSondaDois = makeComandosSondaDois();
        response = makeResponse();
    }

    @Test
    public void converteSondasEmResponse() throws Exception {

        List<Sonda> sondas = new ArrayList<>();
        sondas.add(new Sonda(new Coordenadas(1,3), Direcao.N, comandosSondaUm));
        sondas.add(new Sonda(new Coordenadas(5,1), Direcao.E, comandosSondaDois));

        List<Response> actual = mapper.converteSondasEmResponse(sondas);
        Assert.assertEquals(response, actual);

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

    private List<Response> makeResponse(){
        List<Response> response = new ArrayList<Response>();
        response.add(new Response(new Coordenadas(1,3), Direcao.N));
        response.add(new Response(new Coordenadas(5,1), Direcao.E));

        return response;
    }

}