package tech.ada.school.domain.mappers;

import tech.ada.school.domain.dto.v1.AlunoDto;
import tech.ada.school.domain.entities.Aluno;

public class AlunoMapper {
    public static Aluno toEntity(AlunoDto dto){
        return Aluno
                .builder()
                .nome(dto.getNome())
                .ra(dto.getRa())
                .cpf(dto.getCpf())
                .eMail(dto.getEmail())
                .build();
    }

    public static AlunoDto toDto(Aluno entity, String activity){
        return new AlunoDto(
                entity.getId(),
                entity.getNome(),
                entity.getRa(),
                entity.getCpf(),
                entity.getEMail(),
                activity
        );
    }
}
