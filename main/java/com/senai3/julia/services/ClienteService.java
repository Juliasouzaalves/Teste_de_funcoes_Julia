package com.senai3.julia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai3.julia.domain.Cliente;
import com.senai3.julia.repositories.ClienteRepository;
import com.senai3.julia.repositories.EnderecoRepository;
import com.senai3.julia.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private static ClienteRepository cli;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Cliente buscar(Integer idCliente) {
		
		 Optional<Cliente> obj = cli.findById(idCliente);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Número de id não encontro. Id: " + idCliente + ", tipo: "
				 + Cliente.class.getName()));
	}
	
	
	public static List<Cliente> findAll() {
		return cli.findAll();
	}
	
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = cli.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		
		buscar(obj.getIdCliente());
		
		return cli.save(obj);
	}
	
	public void delete (Integer id) {
		buscar(id);
		cli.deleteById(id);
	}
	
}