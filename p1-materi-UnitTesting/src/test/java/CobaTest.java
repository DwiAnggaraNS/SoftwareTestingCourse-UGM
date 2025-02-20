import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CobaTest {
    @Test
    void testEquals() {
        int angka1_expected = 1;
        int angka1_actual = 1;
        assertEquals(angka1_expected, angka1_actual, "1 is not equal to 1");
    }

    @Test
    void testSame() {
        String expected = new String("test");
        String actual = new String("test");
        // Meskipun value-nya sama, tetapi bukan objek yang sama (objek disimpan di lokasi memori yang berbeda)

        assertSame(expected, actual, "Var expected is not equal to actual");
    }

    @Test
    void testArrayEquals() {
        int[] array_expected = {1, 2, 3};
        int[] array_actual = {1, 2, 3};
        assertArrayEquals(array_expected, array_actual, "array_expected is not equal to array_actual");
    }
    @Test
    void testTrue() {
        boolean actual = true;
        assertTrue(actual, "actual is not true");
    }

    @Test
    void testFalse() {
        boolean actual = false;
        assertFalse(actual, "actual is not false");
    }

    @Test
    void testNull() {
        Object actual = null;
        assertNull(actual, "actual is not null");
    }

    @Test
    void testNotNull() {
        Object actual = new Object();
        assertNotNull(actual, "actual is null");
    }

    @Test
    void testInstanceOf() {
        Object actual = new Object();
        assertTrue(actual instanceof Object, "actual is not an instance of Object");
    }
}
