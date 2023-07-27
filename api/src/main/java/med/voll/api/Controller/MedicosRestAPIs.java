package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Record.ListagemMedicoDTO;
import med.voll.api.Record.MedicoDTO;
import med.voll.api.Repository.MedicoRepository;
import med.voll.api.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
@CrossOrigin(allowedHeaders = "*")
public class MedicosRestAPIs {


    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid MedicoDTO medico){

        medicoRepository.save(new Medico(medico));

    }

    @GetMapping
    public List<ListagemMedicoDTO> listar() {
        return medicoRepository.findAll().stream().map(ListagemMedicoDTO::new).toList();
    }

}
