public class FinancialForecasting {

    public static double calculateFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        if (years == 0) {
            return currentValue;
        }

        return calculateFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue = calculateFutureValue(
                currentValue,
                growthRate,
                years
        );

        System.out.println("Current Value: " + currentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Number of Years: " + years);
        System.out.println("Future Value: " + futureValue);
    }
}
