package sky.pro.junittests.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.junittests.exceptions.NullDivisionException;
import sky.pro.junittests.exceptions.ParameterMissingException;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.junittests.constants.CalculatorUtilityConstants.*;

class CalculatorUtilityImplTest {

    CalculatorUtility out;

    @BeforeEach
    public void setup() {
        out = new CalculatorUtilityImpl();
    }

    /**
     * __PLUS TESTS__
     **/
    // All parameters are valid and are positive.
    @Test
    public void solvePlus_allPositiveParameters() {
        int result = Integer.parseInt(out.solve("plus", NUMBER_1_POSITIVE, NUMBER_2_POSITIVE).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_POSITIVE + NUMBER_2_POSITIVE, result);
    }

    // All parameters are valid and one is negative.
    @Test
    public void solvePlus_onePositiveParameters() {
        int result = Integer.parseInt(out.solve("plus", NUMBER_1_POSITIVE, NUMBER_2_NEGATIVE).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_POSITIVE + NUMBER_2_NEGATIVE, result);
    }

    // One parameter is missing.
    @Test()
    public void solvePlus_oneParameter() {
        assertThrows(ParameterMissingException.class, () -> out.solve("plus", NUMBER_1_POSITIVE, NUMBER_2_NULL));
    }

    /**
     * __MINUS TESTS__
     **/
    // All parameters are valid and are positive.
    @Test
    public void solveMinus_allPositiveParameters() {
        int result = Integer.parseInt(out.solve("minus", NUMBER_1_POSITIVE, NUMBER_2_POSITIVE).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_POSITIVE - NUMBER_2_POSITIVE, result);
    }

    // All parameters are valid and are negative.
    @Test
    public void solveMinus_allNegativeParameters() {
        int result = Integer.parseInt(out.solve("minus", NUMBER_1_NEGATIVE, NUMBER_2_NEGATIVE).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_NEGATIVE - NUMBER_2_NEGATIVE, result);
    }

    // Both parameters are missing.
    @Test
    public void solveMinus_bothParametersNull() {
        assertThrows(ParameterMissingException.class, () -> out.solve("minus", NUMBER_1_NULL, NUMBER_2_NULL));
    }

    /**
     * __MULTIPLY TESTS__
     **/
    // All parameters are valid and are positive.
    @Test
    public void solveMultiply_allPositiveParameters() {
        int result = Integer.parseInt(out.solve("multiply", NUMBER_1_POSITIVE, NUMBER_2_POSITIVE).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_POSITIVE * NUMBER_2_POSITIVE, result);
    }

    // All parameters are valid and one is zero.
    @Test
    public void solveMultiply_allNegativeParameters() {
        int result = Integer.parseInt(out.solve("multiply", NUMBER_1_NEGATIVE, NUMBER_2_ZERO).replaceAll(".+ = ",""));
        assertEquals(NUMBER_1_NEGATIVE * NUMBER_2_ZERO, result);
    }

    // First parameter is missing.
    @Test
    public void solveMultiply_bothParametersNull() {
        assertThrows(ParameterMissingException.class, () -> out.solve("multiply", NUMBER_1_NULL, NUMBER_2_POSITIVE));
    }

    /**
     * __DIVIDE TESTS__
     **/
    // All parameters are valid and are positive. I use delta parameter in assertEquals in order to match result (which comes from formatted string) with actual double value
    @Test
    public void solveDivide_allPositiveParameters() {
        double result = Double.parseDouble(out.solve("divide", NUMBER_1_POSITIVE, NUMBER_2_POSITIVE).replaceAll(".+ = ","").replaceAll(",","."));
        assertEquals(((double)NUMBER_1_POSITIVE / NUMBER_2_POSITIVE), result, 0.01);
    }

    // All parameters are valid and one is negative.
    @Test
    public void solveDivide_onePositiveParameter() {
        double result = Double.parseDouble(out.solve("divide", NUMBER_1_NEGATIVE, NUMBER_2_POSITIVE).replaceAll(".+ = ","").replaceAll(",","."));
        assertEquals(((double)NUMBER_1_NEGATIVE / NUMBER_2_POSITIVE), result, 0.01);
    }

    // Division by zero.
    @Test
    public void solveDivideByZero() {
        assertThrows(NullDivisionException.class, () -> out.solve("divide", NUMBER_1_POSITIVE, NUMBER_2_ZERO));
    }

}