package com.redes.redes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redes.redes.DTO.UsuarioDTO;
import com.redes.redes.Model.Usuario;
import com.redes.redes.Services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    @RequestMapping(value = "/cadastrar")
    @ApiOperation(value = "Adicionar valores de Usuário")
    public Usuario addUsuario(@RequestBody UsuarioDTO usuario) {
        return service.saveUsuario(usuario);
    }

}
