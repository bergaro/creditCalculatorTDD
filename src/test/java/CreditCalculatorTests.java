import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CreditCalculatorTests {
    private static CreditCalculator calculator;

    @BeforeAll
    public static void initField() {
        calculator = new CreditCalculator();
        calculator.setCreditSum(300_000);
        calculator.setCreditTerm(18);
        calculator.setCreditRate(15);
    }
    @Test
    public void allParametersInZero_MonthlyPaymentTest() {
        CreditCalculator calculator = new CreditCalculator();
        calculator.setCreditSum(0);
        calculator.setCreditTerm(0);
        calculator.setCreditRate(0);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void allParametersInZero_TotalAmountTest() {
        CreditCalculator calculator = new CreditCalculator();
        calculator.setCreditSum(0);
        calculator.setCreditTerm(0);
        calculator.setCreditRate(0);
        double actualResult = calculator.calculationTotalAmountReturn();
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    public void allParametersInZero_OverpaymentTest() {
        CreditCalculator calculator = new CreditCalculator();
        calculator.setCreditSum(0);
        calculator.setCreditTerm(0);
        calculator.setCreditRate(0);
        double actualResult = calculator.calculationOverpayment();
        Assertions.assertEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100_000.45, 200_000.6, 300_000})
    public void calculationMonthlyPaymentTrueTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertNotEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-100_000, 0, 100})
    public void calculationMonthlyPaymentFalseTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100_000.45, 200_000.6, 300_000})
    public void calculationTotalAmountReturnTrueTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertNotEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000, 0, 100})
    public void calculationTotalAmountReturnFalseTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100_000.45, 200_000.6, 300_000})
    public void calculationOverpaymentTrueTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertNotEquals(0, actualResult);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000.56, 0, 100})
    public void calculationOverpaymentFalseTest(double arg) {
        calculator.setCreditSum(arg);
        double actualResult = calculator.calculationMonthlyPayment();
        Assertions.assertEquals(0, actualResult);
    }
}
