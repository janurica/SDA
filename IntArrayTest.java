package Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntArrayTest {

    private IntArray intArray;

    // This method runs before each test, initializing the IntArray object
    @BeforeEach
    public void setUp() {
        intArray = new IntArray();
    }

    // Test for adding elements to the array
    @Test
    public void testAddElement() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);

        assertEquals(3, intArray.toString().split(",").length, "The number of elements should be 3");
        assertEquals(10, intArray.get(0), "The first element should be 10");
        assertEquals(20, intArray.get(1), "The second element should be 20");
        assertEquals(30, intArray.get(2), "The third element should be 30");
    }

    // Test for adding an element at a specific index
    @Test
    public void testAddElementAtIndex() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);
        intArray.add(40, 1); // Insert at index 1

        assertEquals(4, intArray.toString().split(",").length, "The number of elements should be 4");
        assertEquals(10, intArray.get(0), "The first element should be 10");
        assertEquals(40, intArray.get(1), "The second element should be 40");
        assertEquals(20, intArray.get(2), "The third element should be 20");
        assertEquals(30, intArray.get(3), "The fourth element should be 30");
    }

    // Test for getting elements from the array
    @Test
    public void testGetElement() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);

        assertEquals(10, intArray.get(0), "Should return the first element");
        assertEquals(20, intArray.get(1), "Should return the second element");
        assertEquals(30, intArray.get(2), "Should return the third element");

        assertNull(intArray.get(3), "Should return null for an invalid index");
    }

    // Test for removing an element from the array
    @Test
    public void testRemoveElement() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);
        intArray.remove(1); // Remove element at index 1

        assertEquals(2, intArray.toString().split(",").length, "The number of elements should be 2");
        assertEquals(10, intArray.get(0), "The first element should be 10");
        assertEquals(30, intArray.get(1), "The second element should be 30");

        // Test removing from invalid index
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            intArray.remove(5);
        });
        assertTrue(exception.getMessage().contains("Index 5 is out of bounds"), "Should throw IndexOutOfBoundsException");
    }

    // Test for swapping two elements
    @Test
    public void testSwapElements() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);
        intArray.swap(0, 2); // Swap elements at index 0 and 2

        assertEquals(30, intArray.get(0), "After swap, the first element should be 30");
        assertEquals(20, intArray.get(1), "The second element should remain 20");
        assertEquals(10, intArray.get(2), "After swap, the third element should be 10");

        // Test swapping with invalid indices
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            intArray.swap(0, 5);
        });
        assertTrue(exception.getMessage().contains("Swap indices out of bounds"), "Should throw IndexOutOfBoundsException");
    }

    // Test that the array resizes automatically when the capacity is exceeded
    @Test
    public void testArrayResize() {
        for (int i = 0; i < 15; i++) {
            intArray.add(i);
        }

        assertEquals(15, intArray.toString().split(",").length, "The number of elements should be 15 after resizing");
        assertEquals(15, intArray.toString().split(",").length, "Array size should automatically resize beyond the initial capacity.");
    }

    // Test the toString method, ensuring correct information is displayed
    @Test
    public void testToString() {
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);

        String expected = "[10, 20, 30] (Number of elements: 3, Array size: 10)";
        assertEquals(expected, intArray.toString(), "The toString method should display the correct array and metadata");
    }
}
