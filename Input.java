import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static int readInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }
}