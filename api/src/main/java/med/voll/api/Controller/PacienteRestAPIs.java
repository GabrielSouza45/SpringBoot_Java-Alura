package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Record.Paciente.ListagemPacienteDTO;
import med.voll.api.Record.Paciente.PacienteDTO;
import med.voll.api.Record.Paciente.DadosDetalhamentoPaciente;
import med.voll.api.Repository.PacienteRepository;
import med.voll.api.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(allowedHeaders = "*")
public class PacienteRestAPIs {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Transactional
    public ResponseEntity<?> cadastrarPaciente(@RequestBody @Valid PacienteDTO dados, UriComponentsBuilder builder){

        Paciente paciente = new Paciente(dados);
        pacienteRepository.save(paciente);

        URI uri = builder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }

    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listarPaciente(Pageable paginacao){

        var page = pacienteRepository.findAll(paginacao).map(ListagemPacienteDTO::new);
        return ResponseEntity.ok(page);

    }
}
