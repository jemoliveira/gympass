package br.com.gympass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.gympass.bean.ClassificacaoBean;
import br.com.gympass.bean.CorridaBean;
import br.com.gympass.bean.TimeBean;

public class Main {

	static final String CAMINHO_ARQUIVO = "D:\\develop\\dados.txt";

	public static void main(String[] args) {

		// Carrega o caminho do arquivo em um objeto do tipo Path
		Path p = Paths.get(CAMINHO_ARQUIVO);
		System.out.println("Leitura 1: lendo os bytes");

		byte[] bytesArquivo;

		try {
			bytesArquivo = Files.readAllBytes(p);

			String textoArquivo = new String(bytesArquivo, "UTF-8");
			// Leitura 2: convertendo as linhas do arquivo em lista
			List<String> linhasArquivo = Files.readAllLines(p);

			List<CorridaBean> list = new ArrayList<>();
			CorridaBean bean = null;

			for (String str : linhasArquivo) {
				String[] splitStr = str.split("\\s+");

				if (!splitStr[0].equals("Hora")) {
					bean = new CorridaBean();
					bean.setHora(splitStr[0]);
					bean.setCodigoPiloto(splitStr[1]);
					bean.setPiloto(splitStr[3]);
					bean.setnVolta(splitStr[4]);
					bean.setTempoVolta(splitStr[5]);
					bean.setVelocidadeMedia(splitStr[6]);					
					list.add(bean);

				}
			}

			Map<String, List<CorridaBean>> filtroNomesList = list.stream()
					.filter(e -> e.getPiloto() != null)
					.collect(Collectors.groupingBy(CorridaBean::getPiloto));    

			List<ClassificacaoBean> listClassificacao = QuantidadesVoltas(list, filtroNomesList);

			listClassificacao = listClassificacao.stream()
					.sorted(Comparator.comparing(ClassificacaoBean::getQtdeVoltas).reversed()
							.thenComparing(ClassificacaoBean::getTempoTotal))
					.collect(Collectors.toList());

			mostraResultadoFinal(listClassificacao);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostraResultadoFinal(List<ClassificacaoBean> listClassificacao) {
		int count = 0;
		for (ClassificacaoBean beanResultado : listClassificacao) {
			beanResultado.setPosicaoChegada(count++);


			System.out.println("===============================================");

			System.out.println("Posição Chegada: " + beanResultado.getPosicaoChegada());
			System.out.println("Código Piloto: " + beanResultado.getCodigoPiloto());
			System.out.println("Nome Piloto: " + beanResultado.getNomePiloto());
			System.out.println("Qtde Voltas Completadas: " + beanResultado.getQtdeVoltas());
			System.out.println("Tempo Total de Prova: " + beanResultado.getTempoTotal());

			System.out.println("===============================================");
		}
	}

	private static List<ClassificacaoBean> QuantidadesVoltas(List<CorridaBean> list, Map<String, List<CorridaBean>> filtroNomesList) {

		ClassificacaoBean bean = null;
		List<ClassificacaoBean> listClassificacao = new ArrayList<>();

		for (Entry<String, List<CorridaBean>> entry : filtroNomesList.entrySet()) {

			bean = new ClassificacaoBean();

			bean.setCodigoPiloto(entry.getValue().get(0).getCodigoPiloto());
			bean.setNomePiloto(entry.getValue().get(0).getPiloto());
			bean.setQtdeVoltas(entry.getValue().size());
			bean.setTempoTotal(somaTempos(entry.getValue()));

			listClassificacao.add(bean);

		}
		return listClassificacao;
	}

	public static String somaTempos(List<CorridaBean> list) {

		LocalTime t1 = null; 
		LocalTime t2 = null;

		TimeBean timeStartBean = new TimeBean(0, 0, 0);
		t1 = LocalTime.of(0, timeStartBean.getMinutos(), timeStartBean.getSegundos(), timeStartBean.getMilisegundos());

		for (CorridaBean bean : list) {

			String tempoTmp = bean.getTempoVolta();
			tempoTmp = tempoTmp.replace(".", ":");

			String[] array = tempoTmp.split(":");

			TimeBean timeBean = new TimeBean(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));

			t2 = LocalTime.of(0, timeBean.getMinutos(), timeBean.getSegundos(), timeBean.getMilisegundos());

			t1 = t1.plusMinutes(t2.getMinute())
					.plusSeconds(t2.getSecond())
					.plusNanos(t2.getNano());			
		}					
		return t1.toString();
	}
}