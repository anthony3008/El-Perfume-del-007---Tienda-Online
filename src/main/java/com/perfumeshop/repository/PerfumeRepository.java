package com.perfumeshop.repository;

import com.perfumeshop.model.Perfume;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PerfumeRepository {
    private List<Perfume> database = new ArrayList<>();

    public void save(Perfume perfume) {
        database.add(perfume);
    }

    public List<Perfume> findAll() {
        return database;
    }

    public Optional<Perfume> findById(String id) {
        return database.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}