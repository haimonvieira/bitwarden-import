package haimonvieira.bitwardenImport;

import haimonvieira.bitwardenImport.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitwardenImportApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BitwardenImportApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Main main = new Main();
		main.exibirMenu();

	}
}
