package sky.pro.junittests.utilities;

import org.springframework.stereotype.Service;
import sky.pro.junittests.exceptions.NullDivisionException;
import sky.pro.junittests.exceptions.ParameterMissingException;

@Service
public class CalculatorUtilityImpl implements CalculatorUtility{

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String solve(String operation, Integer num1, Integer num2) {
        if (num1 == null || num2 == null) throw new ParameterMissingException("One or both parameters are missing!");
        if (operation.equals("divide") && num2 == 0) throw new NullDivisionException("Division by O is not allowed!");
        return switch (operation) {
            case "plus" -> String.format("%d + %d = %d", num1, num2, num1+num2);
            case "minus" -> String.format("%d - %d = %d", num1, num2, num1-num2);
            case "multiply" -> String.format("%d * %d = %d", num1, num2, num1*num2);
            case "divide" -> String.format("%d / %d = %.2f", num1, num2, ((double)num1/num2));
            default -> "Something went wrong!";
        };
    }

}
