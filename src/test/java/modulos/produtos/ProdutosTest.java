package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver94\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da Lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("PlayStation 5")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto, branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Nao e permitido registar um produto com valor superior a sete mil")
    public void testNaoEPermitidoRegistrarProdutoComValorSuperiorASeteMil(){

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Playstation 5")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("Preto, Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa de 0,01 a 7.000.00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Playstation 5")
                .informarValorDoProduto("400000")
                .informarCoresDoProduto("Preto, Branco")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @AfterEach
    public void afterEach(){
        // Vou fechar o navegador
        navegador.quit();
    }
}
