package br.edu.ufape.agendamentolapa.exception;

public class EntityNotFoundException extends RuntimeException {
    
	public EntityNotFoundException(String mensagem) {
	    
		super(mensagem);
	}
}

