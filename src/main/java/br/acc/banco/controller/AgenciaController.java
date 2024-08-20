package br.acc.banco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.acc.banco.dto.agencia.AgenciaCreateDTO;
import br.acc.banco.dto.agencia.AgenciaResponseDTO;
import br.acc.banco.mapper.AgenciaMapper;
import br.acc.banco.models.Agencia;
import br.acc.banco.service.AgenciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Injeção de depêndencia via lombok
@RestController
@RequestMapping("api/banco/agencia")
public class AgenciaController {

	private final AgenciaService agenciaService;
	
	private final AgenciaMapper agenciaMapper;
	
	@PostMapping
	public ResponseEntity<AgenciaResponseDTO> save(@Valid @RequestBody AgenciaCreateDTO createDTO){
		Agencia agencia = agenciaService.salvar(agenciaMapper.toAgencia(createDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(agenciaMapper.toDto(agencia));
	}
	
	@GetMapping
	public ResponseEntity<List<AgenciaResponseDTO>> getAll(){
		List<AgenciaResponseDTO> responseDTO = agenciaMapper.toListDto(agenciaService.buscarTodos());
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AgenciaResponseDTO> findById(@PathVariable Long id){
		AgenciaResponseDTO responseDTO = agenciaMapper.toDto(agenciaService.buscarPorId(id));
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		agenciaService.deletarPorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
