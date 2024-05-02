package qa.page;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.helper.BasePage;

public class CheckoutEcommerceOverviewPage extends BasePage{
	By getValor = By.xpath("//div[@data-test='inventory-item-price']");
	By valorPagina = By.xpath("//div[@data-test='subtotal-label']");
	By btnFinish = By.id("finish");
	By validarMsg = By.xpath("//h2[@data-test='complete-header']");
	By btnCancel = By.id("cancel");
	By titleProducts = By.xpath("//span[@data-test='title' and contains(., 'Products')]");
	By btnBackHome = By.id("back-to-products");

	
	ArrayList<Double> obterValores = new ArrayList<Double>();
	
	public double resultadoSomaTotal() {
		obterValorUnitarioDasCompras();
		double resultado = 0;
		for(int i = 0; i < obterValores.size(); i++) {
			 resultado = resultado + obterValores.get(i);
		}
		return resultado;
	}
	
	public void obterValorUnitarioDasCompras() {
		for(int i = 0; i < obterElementos(getValor).size(); i++) {
			WebElement pegarValor = obterElementos(getValor).get(i);
			String receberValor = pegarValor.getText().replace("$", "");
			double converterValor = Double.parseDouble(receberValor);
			obterValores.add(converterValor);
		}
	}
	
	public double validarValorTotalPagina() {
		String receberValor = obterTexto(valorPagina).replace("$", "");
		String ajustarValor = receberValor.replace("Item total:", "").trim();
		double converterValor = Double.parseDouble(ajustarValor);
		return converterValor;
	}
	
	public void clicarFinish() {
		clicar(btnFinish);
	}
	
	public String validarMsgFinishPurchase() {
		return obterTexto(validarMsg);
	}

	public long clicarCancelarValidarTempo() {
		Instant inicioTempo = Instant.now();
		clicar(btnCancel);
		esperarInteratividade(titleProducts);
		Instant FinalTempo = Instant.now();
		Duration loginDuration = Duration.between(inicioTempo, FinalTempo);
		return loginDuration.getSeconds();
	}
	
	public long clicarBackHomeValidarTempo() {
		Instant inicioTempo = Instant.now();
		clicar(btnBackHome);
		esperarInteratividade(titleProducts);
		Instant FinalTempo = Instant.now();
		Duration loginDuration = Duration.between(inicioTempo, FinalTempo);
		return loginDuration.getSeconds();
	}
}
