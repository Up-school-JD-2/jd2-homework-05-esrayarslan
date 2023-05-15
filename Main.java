import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome ! Please enter your information to log in ");

        try {
            System.out.print("Name : ");
            String name = scanner.nextLine();
            if (containsDigits(name)) {
                throw new TextContainsDigitsException("Name cannot contain numbers", name);
            }
            System.out.print("Surname : ");
            String surname = scanner.nextLine();
            if (containsDigits(surname)) {
                throw new TextContainsDigitsException("Surname cannnot contain numbers", surname);
            }

            System.out.print("TR identification number : ");
            String trin = scanner.nextLine();
            if (!isValidTRIN(trin)) {
                throw new TRINInvalidExceptions("TRIN is invalid, it must be 11 character and cannot contain letters..");
                }
            } catch (TextContainsDigitsException e) {
            System.out.printf("%s wrong area: %s", e.getMessage(), e.getText());
            } catch (TRINInvalidExceptions e) {
            System.out.println(e.getMessage());
        }
        }
        private static boolean containsDigits(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
        }
        private static boolean isValidTRIN(String trin){
            if (trin.length() != 11) {
                return false;
            }
            for (char c : trin.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;

        }
        }


