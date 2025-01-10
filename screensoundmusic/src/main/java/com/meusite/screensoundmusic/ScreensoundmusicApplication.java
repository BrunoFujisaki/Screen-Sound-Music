package com.meusite.screensoundmusic;

import com.meusite.screensoundmusic.main.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundmusicApplication implements CommandLineRunner {
	@Autowired
	Principal principal;
	public static void main(String[] args) {
		SpringApplication.run(ScreensoundmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.exibirMenu();
	}
}
