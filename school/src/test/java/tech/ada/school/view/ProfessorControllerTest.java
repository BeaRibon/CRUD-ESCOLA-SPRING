package tech.ada.school.view;

import org.junit.jupiter.api.Test;
import tech.ada.school.mocks.ProfessorServiceMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessorControllerTest {
    
    @Test
    public void testListarProfessor(){
        ProfessorController underTest = new ProfessorController(new ProfessorServiceMock());
        assertEquals(1,underTest.lerProfessores().getBody().size(), "Tamanho tem de ser 1");
        underTest.lerProfessores().getBody();
    }
}
