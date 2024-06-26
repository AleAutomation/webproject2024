package qa.utils;

import java.io.IOException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

public class Utils {

	public static String formataData(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		return dataFormatada;
	}

	  // Método para formatar um valor
	public static String formatarMoeda(double vlr) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(vlr);
	}
	
	public static String removerAcentos(String valorAcentuado){
		return Normalizer
				.normalize(valorAcentuado, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}
	
	public static long subtrairDatasEmSegundos(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		Duration diferenca = Duration.between(dataInicial, dataFinal);
		return diferenca.getSeconds();
	}
	
	public static String getConfiguracao(String chave) {
		// TODO Auto-generated method stub
		Properties arquivoConfiguracoes = new Properties();
		try {
			arquivoConfiguracoes.load(Utils.class.getClassLoader().getResourceAsStream("config_testes.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return arquivoConfiguracoes.getProperty(chave);
	}	
}
