package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import automatizado.pageObject.Pages.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends Testes_testebase {

    private static LoginPO loginPage;


    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver); //instancia o PO de login
        
    }
    
    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){

        /*loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("");

        loginPage.escrever(loginPage.inputEmail, ""); //pagina de login escreve no campo email o texto
        loginPage.escrever(loginPage.inputSenha, "");
        loginPage.buttonEntrar.click();
        */

        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){

        loginPage.executarAcaoDeLogar("emailincorreto", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("", "senhaincorreta");
        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos."); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorretas(){

        loginPage.executarAcaoDeLogar("emailincorreto", "senhaincorreta");
        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos"); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "senhaincorreta");
        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos"); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){

        loginPage.executarAcaoDeLogar("emailincorreto", "admin@123");
        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos"); //mensagem esperada ; mensagem retornada

    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos"); //mensagem esperada ; mensagem retornada

    }



}
