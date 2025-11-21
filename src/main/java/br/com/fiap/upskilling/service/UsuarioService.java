package br.com.fiap.upskilling.service;

import br.com.fiap.upskilling.exception.UsuarioNaoEncontradoException;
import br.com.fiap.upskilling.model.Usuario;
import br.com.fiap.upskilling.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
    }

    public Usuario criar(Usuario usuario) {
        Objects.requireNonNull(usuario, "Usuário não pode ser nulo");
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setAreaAtuacao(usuarioAtualizado.getAreaAtuacao());
        usuario.setNivelCarreira(usuarioAtualizado.getNivelCarreira());
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}
