package med.voll.api.Controller;

import med.voll.api.Record.Medico;
import med.voll.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medicos")
@CrossOrigin(allowedHeaders = "*")
public class MedicosRestAPIs {




    @PostMapping(value = "/adicionar")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public void cadastrarMedico(Medico medico){


    }

}
