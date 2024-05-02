package qa.page;

import org.openqa.selenium.By;

import qa.helper.BasePage;

public class CheckoutEcommercePage extends BasePage{

	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By btnContinue = By.id("continue");
	By errorCheckout = By.xpath("//h3[@data-test='error']");
	

	public void inserirPrimeiroNome(String primeiroNome) {
		escrever(firstName, primeiroNome);
	}
	
	public void inserirUltimoNome(String ultimoNome) {
		escrever(lastName, ultimoNome);
	}
	
	public void inserirCodigoPostal(String codPostal) {
		escrever(postalCode, codPostal);
	}
	
	public void clicarContinue() {
		clicar(btnContinue);
	}
	
	public String validarMsgErroCheckout() {
		return obterTexto(errorCheckout);
	}

	public String validarNomeInputCheckout() {
		String nome = obterAtributo(firstName);
		return nome;
	}
	
	
	public String validarSobrenomeInputCheckout() {
		String sobrenome = obterAtributo(lastName);
		return sobrenome;
	}
	
	public String validarCodPostalInputCheckout() {
		String codPostal = obterAtributo(postalCode);
		return codPostal;
	}
}
