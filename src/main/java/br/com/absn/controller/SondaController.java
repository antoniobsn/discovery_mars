package br.com.absn.controller;

import br.com.absn.controller.mapper.ResponseMapper;
import br.com.absn.controller.request.Request;
import br.com.absn.controller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by asampaio on 29/09/17.
 */

@RestController
@RequestMapping("/api/v1/sonda")
public class SondaController {

    private final ResponseMapper mapper;

    @Autowired
    public SondaController(ResponseMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/explorar")
    public List<Response> explorar(@RequestBody final Request request){
        return mapper.converteSondasEmResponse(request.getPlanalto().explorar());
    }
}
