package br.com.absn.controller;

import br.com.absn.controller.mapper.ResponseMapper;
import br.com.absn.model.Planalto;
import br.com.absn.model.Sonda;
import br.com.absn.model.enums.Comando;
import br.com.absn.model.enums.Direcao;
import br.com.absn.controller.request.Request;
import br.com.absn.controller.response.Response;
import br.com.absn.model.tinytypes.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asampaio on 30/09/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class SondaControllerTest{

    @InjectMocks
    private SondaController controller;

    @Mock
    private ResponseMapper mapper;

    private Request request;
    private List<Response> response;
    private List<Comando> comandosSondaUm;
    private List<Comando> comandosSondaDois;

    @Before
    public void beforeMethods(){
        request = makeRequest();
        response = makeResponse();
        comandosSondaUm = makeComandosSondaUm();
        comandosSondaDois = makeComandosSondaDois();
    }

    @Test
    public void deveExplorarMarte() throws Exception {

        List<Sonda> sondas = new ArrayList<>();
        sondas.add(new Sonda(new Coordenadas(1,3), Direcao.N, comandosSondaUm));
        sondas.add(new Sonda(new Coordenadas(5,1), Direcao.E, comandosSondaDois));

        Mockito.when(mapper.converteSondasEmResponse(sondas)).thenReturn(response);

        Assert.assertEquals(response, controller.explorar(request));
    }

    private Request makeRequest(){
        List<Comando> comandoSondaUm = makeComandosSondaUm();

        List<Comando> comandoSondaDois = makeComandosSondaDois();

        List<Sonda> sondas = new ArrayList<>();
        sondas.add(new Sonda(new Coordenadas(1,2), Direcao.N, comandoSondaUm));
        sondas.add(new Sonda(new Coordenadas(3,3), Direcao.E, comandoSondaDois));

        return new Request(new Planalto(new Coordenadas(5,5), sondas));
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