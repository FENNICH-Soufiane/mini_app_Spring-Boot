package com.fstg.mediatech.service;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;

public interface ClientService {

	ClientResponseDto save(ClientRequestDto clientRequestDto);
	
	ClientResponseDto findById(Integer id);
	
	ClientResponseDto findByNom(Integer nom);
	
	void delete(Integer id);
	
	ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id);
}
