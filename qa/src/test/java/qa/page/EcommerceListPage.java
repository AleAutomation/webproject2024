package qa.page;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.helper.BasePage;

public class EcommerceListPage extends BasePage{
	
	By qtdCarrinho = By.xpath("//span[@data-test='shopping-cart-badge']");
	By btnShopCart = By.id("shopping_cart_container");
	By btnCheckout = By.id("checkout");
	By imgDog = By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']");
	By btnAddToCart = By.xpath("//div[@data-test='inventory-item-name']/..//..//..//div[@class='pricebar']//button");
	By listCart = By.xpath("//div[@data-test='inventory-item-name']");
	By backProducts = By.id("back-to-products");
	By btnContinueToShopping = By.id("continue-shopping");
	By titleProducts = By.xpath("//span[@data-test='title' and contains(., 'Products')]");
	By srcImgList = By.xpath("//div[@class='inventory_item_img']//img");
	
	
	List<String> pegarPreco = new ArrayList<String>();
	List<String> pegarElemento = new ArrayList<String>();
	List<String> pegarAtributo = new ArrayList<String>();
	List<String> pegarNomeCompra = new ArrayList<String>();
	List<String> pegarsrc = new ArrayList<String>();
	
	public void selecionarProdutosLista(List<List<String>> productsList) {
		
		for(int i = 0; i < productsList.size(); i++) {
			clicar(By.xpath("//div[@data-test='inventory-item-name' and contains(., '"+productsList.get(i).get(0)+"')]/..//..//..//div[@class='pricebar']//button"));
			String obterString = obterTexto(By.xpath("//div[@data-test='inventory-item-name' and contains(., '"+productsList.get(i).get(0)+"')]/..//..//..//div[@class='pricebar']//div[@data-test='inventory-item-price']")).replace("$", "");
			pegarPreco.add(obterString);
		}
	}
	
	public List<String> validarBotaoAddToCart(List<List<String>> productsList) {
		
		for(int i = 0; i < productsList.size(); i++) {
			String productName = productsList.get(i).get(0);
			By elementoDinamico = By.xpath("//div[@data-test='inventory-item-name' and contains(., '"+productName+"')]/..//..//..//div[@class='pricebar']//button");
			clicar(elementoDinamico);
			WebElement receberElemento = obterElementos(btnAddToCart).get(i);
			String obterString = receberElemento.getAttribute("data-test");
			pegarAtributo.add(obterString);
		}
		return pegarAtributo;
	}	
	
	public List<String> validarPrecoProdutos() {
		return pegarPreco;	
	}
	
	public int obterQtdProdutosAddCarrinho() {
		String obterValor = obterTexto(qtdCarrinho);
		int converterValor = Integer.parseInt(obterValor);
		return converterValor;
	}
	
	public void clicarCarrinhoCompras() {
		clicar(btnShopCart);
	}
	
	public void clicarCheckout() {
		clicar(btnCheckout);
	}
	

	public List<String> validarImagensDosProdutos() {
		for(int i = 0; i < obterElementos(imgDog).size(); i++) {
			WebElement obterValor = obterElementos(imgDog).get(i);
			String receberElemento = obterValor.getAttribute("src");
			pegarElemento.add(receberElemento.replace("https://www.saucedemo.com", ""));
		}
		return pegarElemento;
	}
	
	public List<String> obterNomeProdutosListaCart() {
		for(int i = 0; i < obterElementos(listCart).size(); i++) {
			WebElement pegarElemento = obterElementos(listCart).get(i);
			String obterDados = pegarElemento.getText();
			pegarNomeCompra.add(obterDados);
			}
		
			return pegarNomeCompra;
	}
	
	public void clicarCompraListaCart(String nomeProduto) {
		clicar(By.xpath("//div[@class='cart_item_label']//div[text()='"+nomeProduto+"']"));
	}

	public String validarCompraCorreta() {
		return obterTexto(listCart);
	}
	
	public void voltarParaProdutos() {
		clicar(backProducts);
	}

	public long validarTempoBtnContinueToShopping() {
		Instant inicioTempo = Instant.now();
		clicar(btnContinueToShopping);
		esperarInteratividade(titleProducts);
		Instant FinalTempo = Instant.now();
		Duration loginDuration = Duration.between(inicioTempo, FinalTempo);
		return loginDuration.getSeconds();
	}
	
	public List<String> validarImagensLista(List<List<String>> productsList) {
		
		for(int i = 0; i < productsList.size(); i++) {
			WebElement obterValor = obterElementos(srcImgList).get(i);
			String receberElemento = obterValor.getAttribute("src");
			pegarsrc.add(receberElemento.replace("https://www.saucedemo.com", ""));
		}
		return pegarsrc;
	}

	public boolean validarPosicaoCart() {
		boolean posicaoElemento = obterPosicaoElemento(btnShopCart, 1630, 10);
		if(posicaoElemento == true) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validarPosicaoBotao() {
		boolean posicaoElemento = obterPosicaoElemento(btnShopCart, 1647, 10);
		if(posicaoElemento == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
