package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Record.AtualizacaoMedicoDTO;
import med.voll.api.Record.DadosDetalhamentoMedico;
import med.voll.api.Record.ListagemMedicoDTO;
import med.voll.api.Record.MedicoDTO;
import med.voll.api.Repository.MedicoRepository;
import med.voll.api.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoDTO dados, UriComponentsBuilder builder){

        var medico = new Medico(dados);
        medicoRepository.save(medico);

        var uri = builder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>> listar(Pageable paginacao) {
        var page = medicoRepository.findAll(paginacao).map(ListagemMedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoMedicoDTO medico ){
        Medico medico1 = medicoRepository.getReferenceById(medico.id());
        medico1.atualizaInformacoes(medico);

        return ResponseEntity.ok( new DadosDetalhamentoMedico(medico1));
    }

    @DeleteMapping("/{id}") // -> Pega o parâmetro que vem pela url em forma de variavel
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){ // -> @PathVariable informa para o /spring que o parâmetro da função vem pela url
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}") // -> Pega o parâmetro que vem pela url em forma de variavel
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id){ // -> @PathVariable informa para o /spring que o parâmetro da função vem pela url
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok( new DadosDetalhamentoMedico(medico) );
    }
}
