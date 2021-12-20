package com.senai3.julia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senai3.julia.domain.Cidade;
import com.senai3.julia.domain.Cliente;
import com.senai3.julia.domain.Endereco;
import com.senai3.julia.domain.Estado;
import com.senai3.julia.domain.column.TipoCliente;
import com.senai3.julia.repositories.CidadeRepository;
import com.senai3.julia.repositories.ClienteRepository;
import com.senai3.julia.repositories.EstadoRepository;

@SpringBootApplication
public class JuliaApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteRepository ClienteRepository;

	@Autowired
	private com.senai3.julia.repositories.EnderecoRepository EnderecoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JuliaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais", null);
		Estado est2 = new Estado(null, "São Paulo", null);
		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		cidadeRepository.saveAll(Arrays.asList(c1, c2));

		Cliente cli = new Cliente(null, "Júlia Alves", "23681239864", "julia@gmail.com", TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("923729372", "902342618"));
		clienteRepository.saveAll(Arrays.asList(cli));

		Endereco e1 = new Endereco(null, "Rua Tancredo Neves", "61", "", "Nova Cidade", "38401534", cli, c1);

		cli.getEnderecos().addAll(Arrays.asList(e1));

		Cliente cli2 = new Cliente(null, "José Vasconcelos", "23681890864", "vasconcelosjose@gmail.com",
				TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("923459372", "902390618"));
		clienteRepository.saveAll(Arrays.asList(cli2));

		Endereco e2 = new Endereco(null, "Rua Emboabas", "61", "", "Nova Cidade", "38401534", cli2, c2);

		cli.getEnderecos().addAll(Arrays.asList(e2));

		EnderecoRepository.saveAll(Arrays.asList(e2));
	}
}
