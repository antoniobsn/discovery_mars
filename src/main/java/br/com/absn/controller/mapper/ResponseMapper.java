package br.com.absn.controller.mapper;

import br.com.absn.model.Sonda;
import br.com.absn.controller.response.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 04/10/17.
 */

@Component
public class ResponseMapper {

    public List<Response> converteSondasEmResponse(List<Sonda> sondas){

        List<Response> response = new ArrayList<>();

        sondas.forEach(sonda -> response.add(new Response(sonda.getCoordenadas(), sonda.getDirecao())));

        return response;
    }
}
