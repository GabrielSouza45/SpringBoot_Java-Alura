package med.voll.api.Record;

import med.voll.api.Tipo.Especialidade;

public record MedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoDTO endereco) {
}
