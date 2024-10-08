package com.example.realestate.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.realestate.Repositories.CasaRepository;
import com.example.realestate.Entities.Casa;


@RestController
@RequestMapping("/properties")
public class CasaController {
    @Autowired
    private CasaRepository casaRepository;

    @GetMapping
    public List<Casa> getAllCasas() {
        return casaRepository.findAll();
    }

    @GetMapping("/country/{pais}")
    public List<Casa> getCasaByPais(@PathVariable String pais) {
        List<Casa> casas = casaRepository.findByPais(pais);
        if (casas.isEmpty()) {
            throw new RuntimeException("No properties found in " + pais);
        }
        return casas;
    }

    @PostMapping
    public Casa createCasa(@RequestBody Casa casa) {
        return casaRepository.save(casa);
    }

    @DeleteMapping("/{id}")
    public void deleteCasa(@PathVariable Long id) {
        if (casaRepository.existsById(id)) {
            casaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Property not found with id " + id);
        }
    }

    @PutMapping("/{id}")
    public Casa updateCasa(@PathVariable Long id, @RequestBody Casa casa) {
        System.out.println("Received casa: " + casa);
        Casa casaToUpdate = casaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        casaToUpdate.setPais(casa.getPais());
        casaToUpdate.setCiudad(casa.getCiudad());
        casaToUpdate.setPrecio(casa.getPrecio());
        casaToUpdate.setDescription(casa.getDescription());
        casaToUpdate.setUrlImagenes(casa.getUrlImagenes());

        return casaRepository.save(casaToUpdate);
    }
}

