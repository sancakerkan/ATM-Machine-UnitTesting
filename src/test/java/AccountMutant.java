import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

//-------------------------------------------------------------------
// This is a mutated class of Account class to make mutation testings
//-------------------------------------------------------------------

public class AccountMutant {
    // variables
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public AccountMutant() {
    }

    public AccountMutant(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public AccountMutant(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Mutant 2: Changed subtraction to addition
    // Original: checkingBalance = (checkingBalance - amount);
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance + amount); // Mutant
        return checkingBalance;
    }

    // Mutant 5: Changed subtraction to addition
    // Original: savingBalance = (savingBalance - amount);
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance + amount); // Mutant
        return savingBalance;
    }

    // Mutant 1: Changed addition to subtraction
    // Original: checkingBalance = (checkingBalance + amount);
    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance - amount); // Mutant
        return checkingBalance;
    }

    // Mutant 6: Changed addition to subtraction
    // Original: savingBalance = (savingBalance + amount);
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance - amount); // Mutant
        return savingBalance;
    }

    // Mutant 8: Changed the transfer logic
    // Original: checkingBalance = checkingBalance - amount;
    // savingBalance = savingBalance + amount;
    public void calcCheckTransfer(double amount) {
        checkingBalance = checkingBalance + amount; // Mutant
        savingBalance = savingBalance - amount;
    }

    // Mutant 4: Subtracts the transfer amount from both balances
    // Original: savingBalance = savingBalance - amount;
    // checkingBalance = checkingBalance + amount;
    public void calcSavingTransfer(double amount) {
        savingBalance = savingBalance - amount; // Correct
        checkingBalance = checkingBalance - amount; // Mutant
    }

    public void getCheckingWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                System.out.print("\nAmount you want to withdraw from Checkings AccountMutant: ");
                double amount = input.nextDouble();
                if ((checkingBalance - amount) >= 0 && amount >= 0) {
                    calcCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getsavingWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                System.out.print("\nAmount you want to withdraw from Savings AccountMutant: ");
                double amount = input.nextDouble();
                if ((savingBalance - amount) >= 0 && amount >= 0) {
                    calcSavingWithdraw(amount);
                    System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getCheckingDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                System.out.print("\nAmount you want to deposit from Checkings AccountMutant: ");
                double amount = input.nextDouble();
                // Mutant 3: Changed comparison operator in the condition
                // Original: if ((checkingBalance + amount) >= 0 && amount >= 0) {
                if ((checkingBalance + amount) < 0 && amount >= 0) { // Mutant
                    calcCheckingDeposit(amount);
                    System.out.println("\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getSavingDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                System.out.print("\nAmount you want to deposit into your Savings AccountMutant: ");
                double amount = input.nextDouble();

                if ((savingBalance + amount) >= 0 && amount >= 0) {
                    calcSavingDeposit(amount);
                    System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }

    public void getTransferInput(String accType) {
        boolean end = false;
        while (!end) {
            try {
                if (accType.equals("Checkings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to:");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                            System.out.print("\nAmount you want to deposit into your Savings AccountMutant: ");
                            double amount = input.nextDouble();
                            if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
                                calcCheckTransfer(amount);
                                System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                                System.out.println(
                                        "\nCurrent Checkings AccountMutant Balance: " + moneyFormat.format(checkingBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                } else if (accType.equals("Savings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Savings AccountMutant Balance: " + moneyFormat.format(savingBalance));
                            System.out.print("\nAmount you want to deposit into your savings account: ");
                            double amount = input.nextDouble();
                            // Mutant 7: Changed balance check condition
                            // Original: if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                            if ((checkingBalance + amount) < 0 && (savingBalance - amount) >= 0 && amount >= 0) { // Mutant

                                calcSavingTransfer(amount);
                                System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkingBalance));
                                System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }
}

