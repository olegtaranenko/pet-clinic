package com.olegtaranenko.udemy.services.map;

import java.util.*;

public abstract class AbstractMapService<T, ID>  {

    private Map<ID, T> map = new HashMap<>();


    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
//        ID id = object.getId();
//        map.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }
}
