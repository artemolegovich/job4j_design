package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    public int findEven() {
        int rsl = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean hasNext() {
        return findEven() >= 0;
    }

    @Override
    public Integer next() {
        if (findEven() < 0) {
            throw new NoSuchElementException();
        } else {
            index = findEven();
            return data[index++];
        }
    }
}
