package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.pageObject.Pages.ControleDeProdutoPO;
import automatizado.pageObject.Pages.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends Testes_testebase {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver); //instancia o PO de produto
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
        
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdcionar.click();
        // TODO: Remover esse clique assim que o sistema for corrigido;
        controleProdutoPage.buttonAdcionar.click();//bug do sistema do exemplo faz com que seja necessario clicar duas vezes

        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click(); //TODO: remover clique duplo
        controleProdutoPage.buttonSair.click();

    }   


/*    //TC002 - outra forma de fazer
    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdcionar.click();

        controleProdutoPage.cadastrarProduto("00001", "Martelo", 10, 59.9, "");

        //Capturar a mensagem de erro
        String mensagem = controleProdutoPage.spamMensagem.getText();
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);

    } 
   
 */

    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleProdutoPage.buttonAdcionar.click();

        //Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder  = new ProdutoBuilder(controleProdutoPage);

        //Aqui é testado se o produto é adicionado sem código
        produtoBuilder
        .adcionarCodigo("")
        .builder();
        assertEquals(mensagem, controleProdutoPage.spamMensagem.getText());

        //Aqui é testado se o produto é adcionado sem quantidade
        produtoBuilder
        .adcionarCodigo("0005")
        .adcionarQuantidade(null)
        .builder();
        assertEquals(mensagem, controleProdutoPage.spamMensagem.getText());

        //Aqui é testado se o produto é adcionado sem nome
        produtoBuilder
        .adcionarQuantidade(15)
        .adcionarNome("")
        .builder();
        assertEquals(mensagem, controleProdutoPage.spamMensagem.getText());

        //Aqui é testado se o produto é adcionado sem valor
        produtoBuilder
        .adcionarNome("Caixa")
        .adcionarValor(null)
        .builder();
        assertEquals(mensagem, controleProdutoPage.spamMensagem.getText());

        //Aqui é testado se o produto é adcionado sem data
        produtoBuilder
        .adcionarData("")
        .adcionarNome("10")
        .builder();
        assertEquals(mensagem, controleProdutoPage.spamMensagem.getText());

        controleProdutoPage.buttonSair.click();

    }   



}

