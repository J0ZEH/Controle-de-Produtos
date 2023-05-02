package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO {
    
    //#region Região dos WebElements
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdcionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;
    
    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spamMensagem;
    //#endregion Região dos WebElements

    //construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

    //#region Métodos
    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data){
        
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputValor, valor.toString());
        escrever(inputData, data);

        buttonSalvar.click();


    }


    public void cadastrarProduto(ProdutoBuilder produtoBuilder){
 
        produtoBuilder.builder();

    }
    //#endregion Métodos

}
