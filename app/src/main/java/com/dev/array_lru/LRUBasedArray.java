package com.dev.array_lru;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);
    private int capacity;
    private int count;
    private T[] value;
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap(capacity);
    }

    public void cache(T data) {
        rightShift(count);
        value[0] = data;
        holder.put(data, 0);
        count++;
    }

    public void removeAndCache(T data) {
        T key = value[--count];
        holder.remove(key);
        cache(data);
    }

    public void offer(T data) {
        if (data == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(data);
        if (index == null) {
            if (isFull()) {
                removeAndCache(data);
            } else {
                cache(data);
            }
        } else {
            update(index);
        }
    }

    public void update(int index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    /**
     * Update array and cash
     */
    private void rightShift(int index) {
        for (int i = index - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }
}
