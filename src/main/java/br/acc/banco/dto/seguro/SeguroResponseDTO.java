package br.acc.banco.dto.seguro;

import java.math.BigDecimal;

import br.acc.banco.models.enums.StatusSeguro;
import br.acc.banco.models.enums.TipoSeguro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroResponseDTO {

	private Long id;
	
	private BigDecimal valor;
	
	private StatusSeguro status;
	
	private TipoSeguro tipoSeguro;
	
	private int quatidadeParcelas;
	
	private int quantidadesParcelasPagas;
	
	private BigDecimal valorparcela;
}
