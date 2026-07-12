package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.EstudanteDTO;
import br.edu.ufape.agendamentolapa.model.Estudante;

public class EstudanteMapper extends PessoaMapper{
	public Estudante toEntity(EstudanteDTO dto) {

	    Estudante estudante = new Estudante();

	    super.toEntity(dto, estudante);

	    estudante.setCurso(dto.getCurso());
	    estudante.setMatricula(dto.getMatricula());

	    return estudante;
	}
}
