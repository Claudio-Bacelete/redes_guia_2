package com.redes.redes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redes.redes.DTO.VeiculoDTO;
import com.redes.redes.Model.TipoVeiculo;
import com.redes.redes.Model.Veiculo;
import com.redes.redes.Repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private TipoVeiculoService tipoService;

    public Veiculo saveVeiculo(VeiculoDTO dto) {
        Veiculo veiculo = DTOToEntity(dto);
        return repository.save(veiculo);
    }

    public Veiculo DTOToEntity(VeiculoDTO veiculo) {
        Veiculo novoVeiculo = new Veiculo();
        List<TipoVeiculo> listVeiculo = tipoService.getAllTipoVeiculos();
        for (TipoVeiculo tipoVeiculo : listVeiculo) {
            if (veiculo.getTipoId().equals(tipoVeiculo.getId())) {
                novoVeiculo.setTipoVeiculo(tipoVeiculo);
            }
        }
        novoVeiculo.setDistEmRodoviaPavimentada(veiculo.getDistEmRodoviaPavimentada());
        novoVeiculo.setDistEmRodoviaNaoPavimentada(veiculo.getDistEmRodoviaNaoPavimentada());
        novoVeiculo.setCarga(veiculo.getCarga());
        Float custoTotal = (veiculo.getDistEmRodoviaPavimentada() * 0.63f
                + veiculo.getDistEmRodoviaNaoPavimentada() * 0.72f)
                * novoVeiculo.getTipoVeiculo().getFatorDeMultiplicacao();
        if (veiculo.getCarga() > 5) {
            int diferencaDoLimite = veiculo.getCarga() - 5;
            int somaKm = (veiculo.getDistEmRodoviaPavimentada() + veiculo.getDistEmRodoviaNaoPavimentada());
            custoTotal += diferencaDoLimite * 0.03f * somaKm;
        }

        novoVeiculo.setCustoTotal(custoTotal);

        return novoVeiculo;
    }

    public List<Veiculo> getAllVeiculos() {
        return repository.getAllVeiculos();
    }

    public String deletarVeiculo(long id) {
        repository.delete(id);
        return "Veículo removido: " + id + " !! ";
    }

    public Veiculo updateVeiculo(VeiculoDTO dto, Long id) {
        Veiculo veiculo = DTOToEntity(dto);
        return repository.update(veiculo, id);
    }
}
