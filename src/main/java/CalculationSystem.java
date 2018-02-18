public class CalculationSystem {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        ConsoleApp consoleApp = new ConsoleApp();
        try {
            consoleApp.setupConsole();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }

    }
}
