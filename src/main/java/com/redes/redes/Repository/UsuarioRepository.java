package com.redes.redes.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.redes.redes.Model.Usuario;

@Repository
public class UsuarioRepository {
    private List<Usuario> listUsuarios = new ArrayList<Usuario>();

    public List<Usuario> getAllUsuarios() {
        return listUsuarios;
    }

    public Optional<Usuario> findByEmail(String email) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}
