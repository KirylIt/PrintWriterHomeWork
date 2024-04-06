import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Пользователь вводит три элемента с консоли: его имя, фамилию и телефон.
        // С помощью метода printf() отформатируйте результирующую строку так,
        // чтобы вместо троеточий было:
        // «Пользователя зовут … … Его возраст - …» находилась введённая информация.
        // Использовать спецификаторы формата.

        try (PrintWriter printWriter = new PrintWriter("notes.txt")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите Имя, Фамилию и номер телефона");
            String name = scanner.nextLine();
            String surname = scanner.nextLine();
            String number = scanner.nextLine();

            printWriter.println("Доброго времени суток, кто вы? ");
            printWriter.printf("« Пользователя зовут %s %s ,его номер телефона - %s »", name, surname, number);
            System.out.println("Запись проведена!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("notes.txt"))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}