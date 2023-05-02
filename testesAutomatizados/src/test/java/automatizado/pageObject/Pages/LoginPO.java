package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;
    
    @FindBy(css = "form.form-login>div.alert>span") //@FindBy(id = "mensagem")
    public WebElement spamMensagem; //public WebElement spamMensagem;
    //#endregion Região dos WebElements


    //#region Região dos métodos
    /**
     * Construtor padrao para criacao de uma nova instancia da pagina de login
     * @param driver driver da pagina de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
        
    }
    
    /**
     * Método que captura a mensagem de spam na tela
     * @return retorna texto da mensagem
     */
    public String obterMensagem(){
        return this.spamMensagem.getText();
    }
    
    /**
     * Metodo escrever que recebe um elemento web input qualquer
     * @param input input do WebElement de texto
     * @param texto texto 
     */


    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email); 
        escrever(inputSenha, senha);
        buttonEntrar.click();        
    }
    //#endregion Região dos métodos



}
