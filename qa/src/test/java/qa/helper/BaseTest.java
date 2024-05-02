package qa.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static qa.utils.Utils.removerAcentos;

public class BaseTest {
	
	protected static String cenario = "";
	protected static String feature = "";
	
	private int seq;
	
	public void gerarScreenshot() {
		gerarScreenshot(this.feature, this.cenario, seq);
		
	}
	
	public void gerarScreenshot(int seq) {
		this.seq = seq;
		gerarScreenshot();
	}
	
	public void gerarScreenshot(String feature, String cenario, int seq) {
		this.seq = seq;
		gerarScreenShot(feature, cenario);
	}
	
	public void gerarScreenShot(String feature, String cenario) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try	{
			if (seq > 0)
				FileUtils.copyFile(imagem, new File("target/evidencias/" + removerAcentos(feature) + "/"
						+ removerAcentos(cenario) + "_" + seq + ".png"));
			else
				FileUtils.copyFile(imagem, new File(
						"target/evidencias/" + removerAcentos(feature) + "/" + removerAcentos(cenario) + ".png"));
		}	catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
}
