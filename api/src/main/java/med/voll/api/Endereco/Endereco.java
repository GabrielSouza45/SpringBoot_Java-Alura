package med.voll.api.Endereco;

public record Endereco(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero) { }
