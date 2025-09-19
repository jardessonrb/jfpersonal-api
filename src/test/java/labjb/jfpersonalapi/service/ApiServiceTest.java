package labjb.jfpersonalapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    @DisplayName("Primeiro teste no GitHub Actions")
    void testeGitHubAction(){
        String esperado = "sucesso";
        String atual = "sucesso";

        Assertions.assertEquals(esperado, atual);
    }
}
