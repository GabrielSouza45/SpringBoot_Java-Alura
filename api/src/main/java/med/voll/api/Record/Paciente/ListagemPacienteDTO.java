package med.voll.api.Record.Paciente;

import med.voll.api.model.Paciente;

public record ListagemPacienteDTO(
        String nome,
        String email,
        String cpf
){

    public ListagemPacienteDTO(Paciente paciente) {
        this(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf()
        );
    }
}
