package com.debuggeando_ideas.fundamentals;

import java.util.List;

public class PostgresDB implements DatabaseService<Employee>{
    @Override
    public Employee getById(Long id) {
        return new Employee("israel",100.0,"2029");
    }

    @Override
    public List<Employee> getAllRecords() {
        return List.of(new Employee("segundo",120.0,"20219"));
    }
}
