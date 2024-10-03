package br.com.alura.ScreenMatch.Principal;

import br.com.alura.ScreenMatch.Model.DadosEpisodio;
import br.com.alura.ScreenMatch.Model.DadosSerie;
import br.com.alura.ScreenMatch.Model.DadosTemporada;
import br.com.alura.ScreenMatch.Service.ConsumoApi;
import br.com.alura.ScreenMatch.Service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=2d273465";

    public void exibiMenu(){
        System.out.println("Digite o Nome da Serie");
        var nomeSerie = sc.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dados = converte.obterDados(json, DadosSerie.class);
        System.out.println(dados);
		var temporadas = new ArrayList<DadosTemporada>();
		for(var i = 1;i<= dados.totalTemporadas();i++){
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+")+ "&Season=" + i + APIKEY);
			DadosTemporada temporada = converte.obterDados(json, DadosTemporada.class);
			temporadas.add(temporada);
		}
		temporadas.forEach(System.out::println);
//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodioTemporadas = temporadas.get(i).episodioList();
//            for (DadosEpisodio episodioTemporada : episodioTemporadas) {
//                System.out.println(episodioTemporada.titulo());
//            }
//        }
        temporadas.forEach(t -> t.episodioList().forEach(dadosEpisodio -> System.out.println(dadosEpisodio.titulo())));
    }
}
