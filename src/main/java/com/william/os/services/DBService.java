package com.william.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.os.domain.Cliente;
import com.william.os.domain.OS;
import com.william.os.domain.Tecnico;
import com.william.os.domain.enuns.Prioridade;
import com.william.os.domain.enuns.Status;
import com.william.os.repositories.ClienteRepository;
import com.william.os.repositories.OSRepository;
import com.william.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Valdir Cesar", "097.683.890-79", "(11) 98888-8888");
		Tecnico t2 = new Tecnico(null, "William Soares", "331.546.458-88", "(11) 91388-8812");
		Cliente c1 = new Cliente(null, "Betina Campos", "888.851.800-27", "(11) 97777-7777");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create Os", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienterepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}

}
