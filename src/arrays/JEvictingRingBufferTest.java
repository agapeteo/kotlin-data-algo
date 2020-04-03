package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JEvictingRingBufferTest {

    @Test
    public void write3timesAndReadAllElements() {
        // given
        JEvictingRingBuffer<Integer> buffer = new JEvictingRingBuffer(3, Integer.class);

        // when
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // then
        assertEquals(Arrays.asList(1, 2, 3), buffer.elements());
    }

    @Test
    public void overflow_1_and_read_elements() {
        // given
        JEvictingRingBuffer<Integer> buffer = new JEvictingRingBuffer(3, Integer.class);

        // when
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);

        // then
        assertEquals(Arrays.asList(2, 3, 4), buffer.elements());
    }

    @Test
    public void overflow_2_and_dequeue_1_and_read_elements() {
        // given
        JEvictingRingBuffer<Integer> buffer = new JEvictingRingBuffer(3, Integer.class);

        // when
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);
        Integer actual = buffer.dequeue();

        // then
        assertEquals(Arrays.asList(4, 5), buffer.elements());
        assertEquals(3, actual);
    }

    @Test
    public void overflow_full_length_10_times() {
        // given
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        JEvictingRingBuffer<String> buffer = new JEvictingRingBuffer(letters.length, String.class);

        // when
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < letters.length; j++) {
                buffer.enqueue(letters[j]);
            }
        }

        // then
        assertEquals(Arrays.asList(letters), buffer.elements());
    }

    @Test
    public void overflow_full_length_10_times_and_dequeue_full_length() {
        // given
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        JEvictingRingBuffer<String> buffer = new JEvictingRingBuffer(letters.length, String.class);

        // when
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < letters.length; j++) {
                buffer.enqueue(letters[j]);
            }
        }

        for (int j = 0; j < letters.length; j++) {
            buffer.dequeue();
        }

        // then
        assertEquals(Arrays.asList(), buffer.elements());
    }

    @Test
    public void overflows_10_times_with_size_2() {
        // given
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        JEvictingRingBuffer<String> buffer = new JEvictingRingBuffer(2, String.class);

        // when
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < letters.length; j++) {
                buffer.enqueue(letters[j]);
            }
        }

        // then
        assertEquals(Arrays.asList("f", "g"), buffer.elements());
    }

    @Test
    public void throwsExceptionWhenEmpty() {
        // given
        JEvictingRingBuffer<Integer> buffer = new JEvictingRingBuffer(3, Integer.class);

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            buffer.enqueue(1);
            buffer.dequeue();
            buffer.dequeue();
        });
    }

}