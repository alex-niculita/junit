package sky.pro.junittests.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sky.pro.junittests.constants.CalculatorUtilityConstants.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

public class CalculatorUtilityImplTestParameterized {

    private CalculatorUtility out;

    @BeforeEach
    public void setup(){
        out = new CalculatorUtilityImpl();
    }

    // Input for the parameterized tests (excluding division)
    public static Stream<Arguments> provideTestParameters() {
        return Stream.of(Arguments.of(PLUS_STRING, NUMBER_1_POSITIVE, NUMBER_2_POSITIVE, EXPECTED_PLUS_1),
                Arguments.of(PLUS_STRING, NUMBER_1_POSITIVE, NUMBER_2_NEGATIVE, EXPECTED_PLUS_2),
                Arguments.of(MINUS_STRING, NUMBER_1_POSITIVE, NUMBER_2_POSITIVE, EXPECTED_MINUS_1),
                Arguments.of(MINUS_STRING, NUMBER_1_POSITIVE, NUMBER_2_NEGATIVE, EXPECTED_MINUS_2),
                Arguments.of(MULTIPLY_STRING, NUMBER_1_POSITIVE, NUMBER_2_NEGATIVE, EXPECTED_MULTIPLY_1),
                Arguments.of(MULTIPLY_STRING, NUMBER_1_POSITIVE, NUMBER_2_ZERO, EXPECTED_MULTIPLY_2));
    }

    // Input for the parameterized tests (for division)
    public static Stream<Arguments> provideTestParametersDivision() {
        return Stream.of(Arguments.of(DIVIDE_STRING, NUMBER_1_POSITIVE, NUMBER_2_POSITIVE, EXPECTED_DIVIDE_1),
                Arguments.of(DIVIDE_STRING, NUMBER_1_POSITIVE, NUMBER_2_NEGATIVE, EXPECTED_DIVIDE_2));
    }

    /**
     * __TESTS__
     **/

    @ParameterizedTest
    @MethodSource("provideTestParameters")
    public void solvePlusMinusMultiply(String operation, Integer num1, Integer num2, Integer expected){
        int result = Integer.parseInt(out.solve(operation, num1, num2).replaceAll(".+ = ",""));
        System.out.println(result);
        assertEquals(expected, result);
    }

    /**
     * __DIVISION TESTS__
     **/
    @ParameterizedTest
    @MethodSource("provideTestParametersDivision")
    public void solveDivide(String operation, Integer num1, Integer num2, Double expected){
        double result = Double.parseDouble(out.solve(operation, num1, num2).replaceAll(".+ = ","").replaceAll(",","."));
        assertEquals(expected, result, 0.01);
    }
}
