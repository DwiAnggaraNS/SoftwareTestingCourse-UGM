import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestTest {


    // Highest number in the array is at the first index
    @Test
    void testlargestNumberInArray_1() {
        int[] numbers = {100, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(100, Largest.largestNumberInArray(numbers), "It should be 100");
    }

    // Highest number in the array is at the middle index
    @Test
    void testlargestNumberInArray_2() {
        int[] numbers = {12, 2, 3, 24, 5, 26, 7, 8, 9, 10};
        assertEquals(26, Largest.largestNumberInArray(numbers), "It should be 26");
    }

    // Highest number in the array is at the last index
    @Test
    void testlargestNumberInArray_3() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(5, Largest.largestNumberInArray(numbers), "It should be 5");
    }

    // Highest number in the array that contains all negative numbers
    @Test
    void testlargestNumberInArray_4() {
        int[] numbers = {-1, -2, -3, -4, -5};
        assertEquals(-1, Largest.largestNumberInArray(numbers), "It should be -1");
    }

    // Highest number in one element
    @Test
    void testlargestNumberInArray_5() {
        int[] numbers = {1};
        assertEquals(1, Largest.largestNumberInArray(numbers), "It should be 1");
    }

}