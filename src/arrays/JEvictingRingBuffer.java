package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JEvictingRingBuffer<T> {
    private final int maxSize;
    private final T[] container;
    private int writeIndex = 0;
    private int readIndex = 0;
    private int elementsCount = 0;

    @SuppressWarnings("unchecked")
    public JEvictingRingBuffer(int maxSize, Class<T> clazz) {
        this.maxSize = maxSize;
        container = (T[]) Array.newInstance(clazz, maxSize);
    }

    void enqueue(T element) {
        container[writeIndex] = element;

        writeIndex = incrementIdx(writeIndex);
        if (elementsCount == maxSize) {
            readIndex = writeIndex;
        } else {
            elementsCount++;
        }
    }

    T dequeue() {
        if (elementsCount == 0) {
            throw new IllegalArgumentException("collection is empty");
        }
        T element = container[readIndex];
        readIndex = incrementIdx(readIndex);
        elementsCount--;
        return element;
    }

    List<T> elements() {
        List<T> result = new ArrayList<>(elementsCount);
        int idx = readIndex;
        for (int i = 0; i < elementsCount; i++) {
            result.add(container[idx]);
            idx = incrementIdx(idx);
        }
        return result;
    }

    int incrementIdx(int curIdx) {
        return (curIdx + 1 + maxSize) % maxSize;
    }
}
