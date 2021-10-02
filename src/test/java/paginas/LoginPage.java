package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario) {
        navegador.findElement(By.cssSelector("label[for='usuario']")).click(); // clique no campo
        navegador.findElement(By.id("usuario")).sendKeys(usuario); // digite no campo

        return this;
    }

    public LoginPage informarASenha(String senha) {
        navegador.findElement(By.cssSelector("label[for='senha']")).click(); // clique no campo
        navegador.findElement(By.id("senha")).sendKeys(senha); // digite no campo

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }
}
