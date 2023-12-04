package com.example.springaop;

import com.example.springaop.pildoras.dao.ClientDAO;
import com.example.springaop.pildoras.dao.ClientVipDAO;
import com.example.springaop.pildoras.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private ClientVipDAO clientVipDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client clientUno = new Client();
		String type = "normal";
		clientDAO.saveClient(clientUno, type);
		clientVipDAO.saveClientVip();
		clientDAO.setNormalClientCode("1234");
		clientDAO.setNormalClientRating("positive");
		String clientCode = clientDAO.getNormalClientCode();
		String clientRating = clientDAO.getNormalClientRating();
	}

}
