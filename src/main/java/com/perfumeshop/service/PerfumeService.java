package com.perfumeshop.service;

import com.perfumeshop.model.Perfume;
import com.perfumeshop.repository.PerfumeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository repository;

    @PostConstruct
    public void initData() {
        generarPerfumes("HOMBRE", "Agente 00", "Italia", "https://images.unsplash.com/photo-1594035910387-fea47794261f?w=400");
        generarPerfumes("MUJER", "Royale", "Francia", "https://images.unsplash.com/photo-1541643600914-78b084683601?w=400");
        generarPerfumes("MIXTO", "Skyfall", "Londres", "https://images.unsplash.com/photo-1592945403244-b3fbafd7f539?w=400");
    }

    private void generarPerfumes(String categoria, String baseName, String origen, String imgBase) {
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) {
            double precio = 30 + (200 * rand.nextDouble());
            String id = categoria.substring(0, 1) + i;
            
            // Generamos 3 imagenes variando la firma aleatoria para que parezcan distintas
            List<String> fotos = Arrays.asList(
                imgBase + "&sig=" + rand.nextInt(1000),
                imgBase + "&sig=" + rand.nextInt(1000),
                imgBase + "&sig=" + rand.nextInt(1000)
            );

            repository.save(new Perfume(
                id,
                baseName + " " + i,
                "Fragancia exclusiva " + categoria.toLowerCase() + " con notas de misterio y elegancia.",
                origen,
                Math.round(precio * 100.0) / 100.0,
                categoria,
                fotos
            ));
        }
    }

    public List<Perfume> obtenerTodos() { return repository.findAll(); }
    public Perfume obtenerPorId(String id) { return repository.findById(id).orElse(null); }
}