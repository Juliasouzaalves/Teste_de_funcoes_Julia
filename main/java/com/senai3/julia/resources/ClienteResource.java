package com.senai3.julia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senai3.julia.services.ClienteService;
import com.senai3.julia.domain.Cliente;

@RestController 
@RequestMapping(value = "/clientes")
public class ClienteResource { 
	@Autowired
private com.senai3.julia.services.ClienteService ClienteService;
@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente>find (@PathVariable Integer id){
	Cliente obj = ClienteService.buscar(id); 
	return ResponseEntity.ok().body(obj);
} 
@CrossOrigin
@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<List<Cliente>>findALL(){
List<Cliente> listCliente = ClienteService.findAll(); 
return ResponseEntity.ok().body(listCliente); 

}
}
