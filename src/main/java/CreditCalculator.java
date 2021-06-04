public class CreditCalculator {

    private double creditSum;
    private double creditTerm;
    private double creditRate;

    public void setCreditSum(double creditSum) {
        if(creditSum > 100) {
            this.creditSum = creditSum;
        } else {
            this.creditSum = 0;
        }
    }

    public void setCreditTerm(double creditTerm) {
        if(creditTerm > 0) {
            this.creditTerm = creditTerm;
        } else {
            this.creditTerm = 0;
        }
    }

    public void setCreditRate(double creditRate) {
        if(creditRate > 0 ) {
            this.creditRate = creditRate;
        } else {
            this.creditRate = 0;
        }
    }
    /**
     * Считает ежемесячный аннуитетный платеж по кредиту по формуле:
     * (источник формулы: https://journal.tinkoff.ru/guide/credit-payment/#five)
     * Если один из параметров объекта == 0, то возвращает 0.
     * @return
     */
    public double calculationMonthlyPayment() {
        double monthlyPayment = 0;
        double monthlyRate;
        double annuityCoefficient;
        double powPart;
        if(creditSum != 0 && creditTerm != 0 && creditRate != 0) {
            monthlyRate = (creditRate / 12) / 100;
            powPart = Math.pow((1+monthlyRate), creditTerm);
            annuityCoefficient = (monthlyRate * powPart)/(powPart - 1);
            monthlyPayment = creditSum * annuityCoefficient;
        }
        return monthlyPayment;
    }
    /**
     *  Рассчёт общей суммы выплат банку.
     *  Если один из параметров калькулятора == 0, вернётся 0.
     * @return
     */
    public double calculationTotalAmountReturn() {
        return calculationMonthlyPayment() * creditTerm;
    }

    /**
     * Рассчёт переплаты банку за весь срок пользования кредитом.
     * Еслим сумма если один из обязательных параметров == 0, вернётся 0.
     * @return
     */
    public double calculationOverpayment() {
        double overpayment = 0;
        if(creditSum != 0) {
            overpayment = calculationTotalAmountReturn() - creditSum;
        }
        return overpayment;
    }
}
