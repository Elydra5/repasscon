/*
* File: App.java
* Author: Klíber Benedek
* Copyright: 2024, Klíber Benedek
* Date: 2024-12-21
* Github: https://github.com/Elydra5
* License: MIT
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        printHeader();
        try (Scanner scanner = new Scanner(System.in)) {
            String username = getInput(scanner, "Felhasználónév: ");
            String password = getInput(scanner, "Jelszó: ");
            String location = getInput(scanner, "Hely: ");

            Store passList = new Store(password, username, location);
            boolean isSuccess = writeToFile("pass.txt", passList);

            if (isSuccess) {
                System.out.println("Ok. A kiírás sikeres.");
            } else {
                System.out.println("Hiba! A kiírás sikertelen");
            }
        }
    }

    private static void printHeader() {
        System.out.println("Klíber Benedek");
        System.out.println("Jelszavak");
        System.out.println("Verzió: 0.0.1");
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Hiba! A beolvasás sikertelen.");
            System.err.println(e.getMessage());
            return "";
        }
    }

    private static boolean writeToFile(String fileName, Store passList) {
        try (FileWriter fw = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fw)) {
            printWriter.print(passList.getPassword());
            if (!passList.isHollow()) {
                printWriter.print(passList.getUsername());
            }
            printWriter.print(passList.getLocation());
            return true;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
            return false;
        }
    }
}
