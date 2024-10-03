package br.com.alura.ScreenMatch;

import br.com.alura.ScreenMatch.Model.DadosEpisodio;
import br.com.alura.ScreenMatch.Model.DadosSerie;
import br.com.alura.ScreenMatch.Model.DadosTemporada;
import br.com.alura.ScreenMatch.Principal.Principal;
import br.com.alura.ScreenMatch.Service.ConsumoApi;
import br.com.alura.ScreenMatch.Service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();

		principal.exibiMenu();


	}
}
