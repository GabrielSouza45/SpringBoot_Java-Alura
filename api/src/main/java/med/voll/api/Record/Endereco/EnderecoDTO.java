package med.voll.api.Record.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank(message = "Rua é obrigatório")
        String logradouro,
        @NotBlank(message = "Bairro é obrigatório")
        String bairro,
        @NotBlank(message = "CEP é obrigatório (8 dígitos)")
        @Pattern(regexp = "\\d{8}") // 8 digitos
        String cep,
        @NotBlank(message = "Cidade é obrigatório")
        String cidade,
        @NotBlank(message = "UF é obrigatório")
        String uf,
        String complemento,
        String numero) { }
