package br.acc.banco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.acc.banco.dto.operacao.OperacaoResponseDTO;
import br.acc.banco.mapper.OperacaoMapper;
import br.acc.banco.models.Operacao;
import br.acc.banco.service.OperacaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Injeção de depêndencia via lombok
@RestController
@RequestMapping("api/banco/operacao")
public class OperacaoController {

	private final OperacaoService operacaoService;
	
	private final OperacaoMapper mapper;
	
	
	@GetMapping("/{id}")
    public ResponseEntity<OperacaoResponseDTO> findById(@PathVariable Long id) {
        Operacao operacao = operacaoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(operacao));
    }
	
	@GetMapping
    public ResponseEntity<List<OperacaoResponseDTO>> findAll() {
        List<Operacao> operacoes = operacaoService.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toListDto(operacoes));
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        operacaoService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
