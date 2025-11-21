package br.com.fiap.upskilling.exception;

/**
 * Exceção lançada quando uma trilha não é encontrada
 */
public class TrilhaNaoEncontradaException extends RuntimeException {
    
    public TrilhaNaoEncontradaException(Long id) {
        super("Trilha não encontrada com ID: " + id);
    }
    
    public TrilhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
