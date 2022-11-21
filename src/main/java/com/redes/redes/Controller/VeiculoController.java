package com.redes.redes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redes.redes.DTO.VeiculoDTO;
import com.redes.redes.Model.Veiculo;
import com.redes.redes.Services.VeiculoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping
    @ApiOperation(value = "Adicionar valores de Veículo")
    public Veiculo addVeiculo(@RequestBody VeiculoDTO Veiculo) {
        return service.saveVeiculo(Veiculo);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os Veículos")
    public List<Veiculo> findAllVeiculos() {
        return service.getAllVeiculos();
    }

    @PostMapping(value = "/atualizar/{id}")
    @ApiOperation(value = "Atualizar valor do veículo")
    public Veiculo updateVeiculo(@PathVariable(name = "id") Long id, @RequestBody VeiculoDTO veiculo) {
        return service.updateVeiculo(veiculo, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar o valor do veículo")
    public String deleteVeiculo(@PathVariable long id) {
        return service.deletarVeiculo(id);
    }

}
