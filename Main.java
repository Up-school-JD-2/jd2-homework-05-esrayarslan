import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************************************");
        System.out.println("Welcome ! Please enter your information to log in ");
        System.out.println("*************************************************");

        try {
            double paymentAmount = getPaymentAmount();
            validatePaymentAmount(paymentAmount);
            String cardNumber = getCardNumber();
            validateCardNumber(cardNumber);
            String expirationDate = getExpirationDate();
            validateExpirationDate(expirationDate);
            String securityCode = getSecurityCode();
            validateSecurityCode(securityCode);

            pay();

        } catch (InvalidPaymentAmountException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCardNumberException e) {
            System.out.println(e.getMessage());
        } catch (InvalidExpirationDateException e) {
            System.out.println(e.getMessage());
        } catch (InvalidSecurityCodeException e) {
            System.out.println(e.getMessage());
        } catch (SystemNotWorkingException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again later...");

            try {
                pay();
            } catch (SystemNotWorkingException ex) {
                System.out.println("The pay transaction failed again, system is not working \" + e.getMessage());");
        }
        }
    }

    public static double getPaymentAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter payment amount: ");
        return scanner.nextDouble();
    }

    public static String getCardNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter card number: ");
        return scanner.nextLine();
    }

    public static String getExpirationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the expiration date (MM/YYYY): ");
        return scanner.nextLine();
    }

    public static String getSecurityCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter security code: ");
        return scanner.nextLine();
    }

    public static void validatePaymentAmount(double paymentAmount) throws InvalidPaymentAmountException {
        if (paymentAmount <= 0 || paymentAmount % 1 != 0) {
            throw new InvalidPaymentAmountException("Invalid Payment Amount : " + paymentAmount + " (A negative value or a comma value cannot be entered..)");
        }
    }

    public static void validateCardNumber(String cardNumber) throws InvalidCardNumberException {
        if (!cardNumber.matches("\\d{16}")) {
            throw new InvalidCardNumberException("Invalid Card Number : " + cardNumber + " (16 digits, it should consist of numbers..)");
        }
    }

    public static void validateExpirationDate(String expirationDate) throws InvalidExpirationDateException {
        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        if (year < 2023 || month < 1 || month > 12) {
            throw new InvalidExpirationDateException("Invalid Expiration Date : " + expirationDate + " (The expiration date (12/2013) cannot be entered in the past year or a month such as 13..)");
        }
    }

    public static void validateSecurityCode(String securityCode) throws InvalidSecurityCodeException {
        if (!securityCode.matches("\\d{3}")) {
            throw new InvalidSecurityCodeException("Invalid Security Code : " + securityCode + " (It should consist of 3 characters, numbers..)");
        }
    }

    public static void pay() throws SystemNotWorkingException {
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        if (randomNumber > 75) {
            throw new SystemNotWorkingException("An error occurred during the pay process.");
        } else {
            System.out.println("The pay transaction was completed successfully. " + randomNumber);
        }
    }
}






