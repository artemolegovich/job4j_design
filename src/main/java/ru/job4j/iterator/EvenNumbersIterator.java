package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int rsl = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = i;
                index = i;
                break;
            }
        }
        return rsl >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return data[index++];
        }
    }
}
