package med.voll.api.Record.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Record.Endereco.EnderecoDTO;
import med.voll.api.Tipo.Especialidade;

public record MedicoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotBlank(message = "CEM é obrigatório (4 à 6 dígitos)")
        @Pattern(regexp = "\\d{4,6}") // \\d -> São dígitos, {4,6} de 4 a 6 dígitos
        String crm,
        @NotNull(message = "Especialidade é obrigatório")
        Especialidade especialidade,
        @NotNull(message = "Endereço é obrigatorio é obrigatório")
        @Valid
        EnderecoDTO endereco) {
}
