package com.fstg.mediatech.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;

public interface ClientService {

	ClientResponseDto save(ClientRequestDto clientRequestDto);
	
	ClientResponseDto findById(Integer id);
	
	ClientResponseDto findByNom(String nom);
	
	void delete(Integer id);
	
	ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException;
	
	List<ClientRequestDto> findAll();
}
