package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            containerResize();
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T temp = container[index];
        container[index] = newValue;
        return temp;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T temp = container[index];
        System.arraycopy(container, index + 1,
                container, index, size - 1 - index);
        size--;
        modCount++;
        container[size] = null;
        return temp;
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            private final int modCountExpected = modCount;
            private int count;

            @Override
            public boolean hasNext() {
                if (modCountExpected != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext() || count == size) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
        return iterator;
    }
    private void containerResize () {
        container = container.length == 0
                ? Arrays.copyOf(container, 10)
                : Arrays.copyOf(container, size * 2);
    }
}
