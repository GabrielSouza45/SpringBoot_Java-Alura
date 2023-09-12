package med.voll.api.Record.Medico;

import med.voll.api.Tipo.Especialidade;
import med.voll.api.model.Medico;

public record ListagemMedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public ListagemMedicoDTO(Medico medico) {
        this(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}
