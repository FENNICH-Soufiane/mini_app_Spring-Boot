package com.fstg.mediatech.service;

import org.springframework.stereotype.Service;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;


@Service("impl2")
public class ClientServiceImpl2 implements ClientService {

	@Override
	public ClientResponseDto save(ClientRequestDto clientRequestDto) {
		return null;
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		return null;
	}

	@Override
	public ClientResponseDto findByNom(Integer nom) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
		return null;
	}

}
