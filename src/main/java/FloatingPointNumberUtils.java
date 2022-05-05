import com.google.common.math.DoubleMath;
import org.apache.commons.math3.util.Precision;

import java.util.Objects;

public class FloatingPointNumberUtils {

    private static final double EPSILON = 0.00001d;

    // there is always the possibility to use a trusted standard library
    public static boolean isApproximatelyEqualApacheCommons(Double a, Double b) {
        return Precision.equals(a, b, EPSILON);
    }

    public static boolean isApproximatelyEqualGuava(Double a, Double b) {
        return DoubleMath.fuzzyEquals(a, b, EPSILON);
    }

    // my own solution
    public static boolean isApproximatelyEqual(Double a, Double b) {
        if (a == null || b == null) {
            return a == b;
        }

        if (a.isInfinite() || a.isNaN() || b.isInfinite() || b.isNaN()) {
            return Objects.equals(a, b);
        }

        return Math.abs(a - b) <= EPSILON;
    }
}
