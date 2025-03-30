package com.example.oope11.repositories;

import com.example.oope11.models.SoccerEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends SoccerEntity> {
    protected List<T> items = new ArrayList<>();

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public void sort(Comparator<T> comparator) {
        items.sort(comparator);
    }

    public int size() {
        return items.size();
    }
}