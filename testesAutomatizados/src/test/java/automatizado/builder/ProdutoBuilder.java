package automatizado.builder;

import automatizado.pageObject.Pages.ControleDeProdutoPO;


/**
 * Classe que sabe construir ou adicionar um produto da tela
 */
public class ProdutoBuilder {

    private String codigo = "0001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "01/12/2000";
    
    private ControleDeProdutoPO controleDeProdutoPO;


    /**Construtor padrao do produto builder que recebe a pagina de controle de produto */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Método que adiciona um codigo ao builder
     * @param codigo codigo que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarCodigo(String codigo){
        this.codigo = codigo;
        return this; //retorna a propria instancia
    }

    /**
     * Método que adiciona um nome ao builder
     * @param nome nome que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Método que adiciona quantidade ao builder
     * @param quantidade quantidade que sera adicionada
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }


    /**
     * Método que adiciona um valor ao builder
     * @param valor valor que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarValor(Double valor){
        this.valor = valor;
        return this;
    }


    /**
     * Método que adiciona uma data ao builder
     * @param data data que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
     */
        public ProdutoBuilder adcionarData(String data){
        this.data = data;
        return this;
    }

    
    /**
     * Método que adiciona um produto pela tela de cadastro
     */
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();

    }
}
