package sky.pro.junittests.constants;

public class CalculatorUtilityConstants {
    public static final Integer NUMBER_1_POSITIVE = 10;
    public static final Integer NUMBER_2_POSITIVE = 26;
    public static final Integer NUMBER_1_NEGATIVE = -5;
    public static final Integer NUMBER_2_NEGATIVE = -11;
    public static final Integer NUMBER_1_NULL = null;
    public static final Integer NUMBER_2_NULL = null;
    public static final Integer NUMBER_2_ZERO = 0;
    public static final String PLUS_STRING = "plus";
    public static final String MINUS_STRING = "minus";
    public static final String MULTIPLY_STRING = "multiply";
    public static final String DIVIDE_STRING = "divide";
    public static final Integer EXPECTED_PLUS_1 = NUMBER_1_POSITIVE + NUMBER_2_POSITIVE;
    public static final Integer EXPECTED_PLUS_2 = NUMBER_1_POSITIVE + NUMBER_2_NEGATIVE;
    public static final Integer EXPECTED_MINUS_1 = NUMBER_1_POSITIVE - NUMBER_2_POSITIVE;
    public static final Integer EXPECTED_MINUS_2 = NUMBER_1_POSITIVE - NUMBER_2_NEGATIVE;
    public static final Integer EXPECTED_MULTIPLY_1 = NUMBER_1_POSITIVE * NUMBER_2_NEGATIVE;
    public static final Integer EXPECTED_MULTIPLY_2 = NUMBER_1_POSITIVE * NUMBER_2_ZERO;
    public static final Double EXPECTED_DIVIDE_1 = (double)NUMBER_1_POSITIVE / NUMBER_2_POSITIVE;
    public static final Double EXPECTED_DIVIDE_2 = (double)NUMBER_1_POSITIVE / NUMBER_2_NEGATIVE;


}
