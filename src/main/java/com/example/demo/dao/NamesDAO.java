package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NamesDAO {

    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void addNames(List<String> names) {
        this.names.addAll(names);
    }
}
