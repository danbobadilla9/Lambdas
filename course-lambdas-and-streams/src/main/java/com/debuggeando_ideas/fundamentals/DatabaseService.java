package com.debuggeando_ideas.fundamentals;

import java.util.List;

public interface DatabaseService<T> {
    public T getById(Long id);

    List<T> getAllRecords();
}
