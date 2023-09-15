package med.voll.api.Record.Medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Model.Endereco;

public record AtualizacaoMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco
) {
}
