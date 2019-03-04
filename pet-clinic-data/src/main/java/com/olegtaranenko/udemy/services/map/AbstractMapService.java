package com.olegtaranenko.udemy.services.map;

import com.olegtaranenko.udemy.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity>  {

    private Map<Long, T> map = new HashMap<>();

    T findById(Long id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null");
        }

        return object;
    }

    void deleteById(Long id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    private Long getNextId() {

        Long nextId = null;
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException ex) {
            nextId = 1L;
        }
        return nextId;
    }
}
