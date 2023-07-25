package med.voll.api.Record;

import med.voll.api.Endereco.Endereco;
import med.voll.api.Tipo.Especialidade;

public record Medico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {
}
