import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloatingPointNumberUtilsTest {

    @Test
    void isApproximatelyEqual() {
        // nulls
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(null, null));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(null, Double.NaN));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(null, Double.POSITIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(null, Double.NEGATIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(null, 42d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, null));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, null));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, null));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(42d, null));

        // special values - double
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, Double.NaN));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(42d, 42d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, Double.POSITIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, Double.NEGATIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, 42d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, Double.NaN));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, 1d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, Double.NaN));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, 2d));

        // special values - floats
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NaN, (double) Float.NaN));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.POSITIVE_INFINITY, (double) Float.POSITIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NEGATIVE_INFINITY, (double) Float.NEGATIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(42d, 42d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NaN, (double) Float.POSITIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NaN, (double) Float.NEGATIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NaN, 42d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.POSITIVE_INFINITY, (double) Float.NEGATIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.POSITIVE_INFINITY, (double) Float.NaN));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.POSITIVE_INFINITY, 1d));

        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NEGATIVE_INFINITY, (double) Float.POSITIVE_INFINITY));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NEGATIVE_INFINITY, (double) Float.NaN));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NEGATIVE_INFINITY, 2d));

        // compare double and floats
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.NaN, (double) Float.NaN));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NaN, Double.NaN));

        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.POSITIVE_INFINITY, (double) Float.POSITIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));

        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(Double.NEGATIVE_INFINITY, (double) Float.NEGATIVE_INFINITY));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) Float.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));

        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(42d, (double) 42f));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(42d, (double) 43f));

        // standard values - double
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(0.1d, 0.2d));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(0.01d, 0.02d));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(0.001d, 0.002d));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual(0.0001d, 0.0002d));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(0.00001d, 0.00002d));

        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual(0.0d, -0.0d));

        // standard values - float
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.1f, (double) 0.2f));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.01f, (double) 0.02f));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.001f, (double) 0.002f));
        assertFalse(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.0001f, (double) 0.0002f));
        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.00001f, (double) 0.00002f));

        assertTrue(FloatingPointNumberUtils.isApproximatelyEqual((double) 0.0f, (double) -0.0f));
    }
}