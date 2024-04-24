package tech.ada.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.RequiredArgsConstructor;
import tech.ada.school.domain.dto.v1.AlunoDto;
import tech.ada.school.domain.dto.v1.ProfessorDto;
import tech.ada.school.service.IAlunoService;
import tech.ada.school.service.IProfessorService;

@SpringBootApplication()
@RequiredArgsConstructor
@EnableFeignClients
public class SchoolManagementApplication implements CommandLineRunner {

	private final IProfessorService professorServico;
	private final IAlunoService alunoServico;

	public static void main(String... args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(2000);
		var professor = new ProfessorDto(1, "Nuno", "80405526210", "nuno@email.com", null);
		professorServico.criarProfessor(professor);

		var aluno = new AlunoDto(1, "Beatriz", "foiofh",  "46210460801", "beatrizribon3@gmail.com", null);
		alunoServico.criarAluno(aluno);

	}
}