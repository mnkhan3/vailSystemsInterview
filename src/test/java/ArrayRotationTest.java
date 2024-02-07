import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRotationTest {

    private ArrayRotation routeArray;
    private int[] inputArray;

    @BeforeEach
    void setUp() {
        routeArray = new ArrayRotation();
        inputArray = new int[]{1, 2, 3, 4, 5, 6, 7};
    }

    @Test
    void throws_IllegalArgumentException_when_ArrayIsRotatedByNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> routeArray.rotateArray(inputArray, -1)
        );

        String expectedErrorMessage = "Rotating array by negative number is not allowed, please provide a positive number.";
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void RotatingArrayByZeroPositionShouldRemainUnchanged() {
        int[] result = routeArray.rotateArray(inputArray, 0);

        assertArrayEquals(inputArray, result);
    }

    @Test
    void RotatingArrayByArrayLengthPositionsShouldRemainUnchanged() {
        int[] result = routeArray.rotateArray(inputArray, inputArray.length);

        assertArrayEquals(inputArray, result);
    }

    @Test
    void RotatingArrayBy2Positions() {
        int[] result = routeArray.rotateArray(inputArray, 2);

        int[] expectedResult = {3, 4, 5, 6, 7, 1, 2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void RotatingArrayByPositionGreaterThanArrayLength() {
        int[] result = routeArray.rotateArray(inputArray, inputArray.length + 5);

        int[] expectedResult = {6, 7, 1, 2, 3, 4, 5};
        assertArrayEquals(expectedResult, result);
    }
}