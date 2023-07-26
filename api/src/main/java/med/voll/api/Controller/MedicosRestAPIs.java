package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import med.voll.api.Record.MedicoDTO;
import med.voll.api.Repository.MedicoRepository;
import med.voll.api.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medicos")
@CrossOrigin(allowedHeaders = "*")
public class MedicosRestAPIs {


    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping(value = "/adicionar")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @Transactional
    public void cadastrarMedico(MedicoDTO medico){

        medicoRepository.save(new Medico(medico));
    }

}
