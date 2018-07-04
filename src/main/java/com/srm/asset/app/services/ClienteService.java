package com.srm.asset.app.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.asset.app.dtos.ClienteDto;
import com.srm.asset.app.entities.Cliente;
import com.srm.asset.app.enums.RiscoEnum;
import com.srm.asset.app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrar(ClienteDto clienteDto) {
		
		Cliente clienteEntity = new Cliente();
		
		clienteEntity.setNome(clienteDto.getNome());
		clienteEntity.setLimiteCredito(clienteDto.getLimiteCredito());
		clienteEntity.setRisco(RiscoEnum.getRisco(clienteDto.getRisco()));
		
		switch (RiscoEnum.getRisco(clienteDto.getRisco())) {
		case B:
			clienteEntity.setTxJuros(10);
			break;
			
		case C:
			clienteEntity.setTxJuros(20);
			break;
			
		default:
			clienteEntity.setTxJuros(0);
			break;
		}
		
		BigDecimal valorLimiteCreditoCalculado = clienteDto.getLimiteCredito().add(
				clienteDto.getLimiteCredito().multiply(
						new BigDecimal(clienteEntity.getTxJuros()).divide(new BigDecimal(100))
				)
		); 
		
		clienteEntity.setLimiteCreditoCalculado(valorLimiteCreditoCalculado);
		
		clienteRepository.save(clienteEntity);
		
	}
	
}
