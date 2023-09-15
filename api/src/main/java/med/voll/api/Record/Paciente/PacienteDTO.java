package med.voll.api.Record.Paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Record.Endereco.EnderecoDTO;

public record PacienteDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotBlank(message = "CPF é obrigatório (11 dígitos)")
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotNull(message = "Endereço é obrigatório")
        @Valid
        EnderecoDTO endereco) {
}
