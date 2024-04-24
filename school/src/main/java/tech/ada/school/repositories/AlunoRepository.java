package tech.ada.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.school.domain.entities.Aluno;

import java.util.Optional;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);
}
