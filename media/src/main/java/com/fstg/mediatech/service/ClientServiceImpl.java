package com.fstg.mediatech.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fstg.mediatech.dao.ClientDao;
import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.models.ClientEntity;

@Service("impl1")
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	private ModelMapper modelMapper;
	
	
	public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
		super();
		this.clientDao = clientDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ClientResponseDto save(ClientRequestDto clientRequestDto) {
		ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
		ClientEntity saved = clientDao.save(clientEntity);
		return modelMapper.map(saved, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		ClientEntity clientEntity = clientDao.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
		return modelMapper.map(clientEntity, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findByNom(String nom) {
		ClientEntity clientEntity = clientDao.findByNom(nom);
		return modelMapper.map(clientEntity, ClientResponseDto.class);
	}

	@Override
	public void delete(Integer id) {
		clientDao.deleteById(id);
	}
	
	 @Override
	 public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException {
	    Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
	    if (clientEntityOptional.isPresent()) {
	        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
	        clientEntity.setId(id);
	        ClientEntity updated = clientDao.save(clientEntity);
	        return modelMapper.map(updated, ClientResponseDto.class);
	    } else {
	       throw new NotFoundException();
	    }
	 }


	@Override
	public List<ClientRequestDto> findAll() {
		return clientDao.findAll().stream().map(el->modelMapper.map(el, ClientRequestDto.class)).collect(Collectors.toList());
	}

}
