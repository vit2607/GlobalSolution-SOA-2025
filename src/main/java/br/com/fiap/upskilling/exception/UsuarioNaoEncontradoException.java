package br.com.fiap.upskilling.exception;

/**
 * Exceção lançada quando um usuário não é encontrado
 */
public class UsuarioNaoEncontradoException extends RuntimeException {
    
    public UsuarioNaoEncontradoException(Long id) {
        super("Usuário não encontrado com ID: " + id);
    }
    
    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
