package br.com.fiap.upskilling.exception;

/**
 * Exceção lançada para erros de regra de negócio
 */
public class RegraNegocioException extends RuntimeException {
    
    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}
