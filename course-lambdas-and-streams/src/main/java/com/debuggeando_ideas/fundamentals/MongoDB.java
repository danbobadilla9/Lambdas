package com.debuggeando_ideas.fundamentals;

import java.util.List;

public class MongoDB implements DatabaseService<Product>{
    @Override
    public Product getById(Long id) {
        return new Product(3L,"Lavadora",55.9);
    }

    @Override
    public List<Product> getAllRecords() {
        return List.of(new Product(4L,"TV",55.9));
    }
}
