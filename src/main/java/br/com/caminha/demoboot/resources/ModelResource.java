package br.com.caminha.demoboot.resources;

import br.com.caminha.demoboot.dao.ModelRepository;
import br.com.caminha.demoboot.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("${origin-allowed}")
public class ModelResource {

    @Autowired
    ModelRepository modelRepository;

    @RequestMapping(value = "/models", method = RequestMethod.GET)
    public ResponseEntity<List<Model>> list(){
        return new ResponseEntity<List<Model>>(new ArrayList<Model>(modelRepository.listAll()), HttpStatus.OK);
    }

    @PostMapping("/models")
    public ResponseEntity<Model> add(@RequestBody Model model){

        return modelRepository.save(model);
    }
}
