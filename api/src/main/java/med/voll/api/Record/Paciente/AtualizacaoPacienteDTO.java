package med.voll.api.Record.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.Endereco;

public record AtualizacaoPacienteDTO (
        @NotNull
        long id,
        String nome,
        String telefone,
        Endereco endereco
){
}
