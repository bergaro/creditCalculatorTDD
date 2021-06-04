import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditCalculator calculator = new CreditCalculator();

        System.out.println("Кредитный калькулятор");
        while (true) {
            System.out.println("Введите сумму кредита(Минимум = 100 руб.): ");
            String creditSum = scanner.nextLine();
            calculator.setCreditSum(Double.parseDouble(creditSum.replace(",", ".")));

            System.out.println("Введите срок кредит в месяцах: ");
            String creditTerm = scanner.nextLine();
            calculator.setCreditTerm(Double.parseDouble(creditTerm.replace(",", ".")));

            System.out.println("Введите процентную ставку по кредиту");
            String creditRate = scanner.nextLine();
            calculator.setCreditRate(Double.parseDouble(creditRate.replace(",", ".")));

            System.out.printf("Ежемесячный платёж по кредиту составляет: %.2f рублей\n", calculator.calculationMonthlyPayment());
            System.out.printf("Общая сумма выплат по кредиту за весь период: %.2f\n", calculator.calculationTotalAmountReturn());
            System.out.printf("Переплата по кредиту за весь период: %.2f\n", calculator.calculationOverpayment());
            System.out.println("Введите `end` для завершения, любой символ для продолжения.");
            String endScenario = scanner.nextLine();
            if(endScenario.equals("end")) {
                System.out.println("Завершение работы программы...");
                break;
            }

        }
    }
}
