import java.util.ArrayList;
import javax.swing.JOptionPane;

class Expense {
    String category;
    double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return category + " | Rs. " + amount;
    }
}

public class WealthTrack {
    public static void main(String[] args) {
        ArrayList<Expense> expenseList = new ArrayList<>();
        
        JOptionPane.showMessageDialog(null, "Welcome to WealthTrack, Arpit!");

        while (true) {
            String menu = "--- Menu ---\n"
                        + "1. Add an Expense\n"
                        + "2. View All Expenses\n"
                        + "3. SIP Wealth Calculator\n"
                        + "4. Exit\n\n"
                        + "Enter your choice (1, 2, 3, or 4):";
                        
            String choice = JOptionPane.showInputDialog(null, menu, "WealthTrack", JOptionPane.QUESTION_MESSAGE);

            // Exit condition
            if (choice == null || choice.equals("4")) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break; 
            }

            // Option 1: Add Expense
            if (choice.equals("1")) {
                String cat = JOptionPane.showInputDialog("Enter category (e.g., Food, Travel):");
                if (cat == null) continue;
                
                String amtStr = JOptionPane.showInputDialog("Enter amount:");
                if (amtStr == null) continue;
                
                try {
                    double amt = Double.parseDouble(amtStr);
                    expenseList.add(new Expense(cat, amt));
                    JOptionPane.showMessageDialog(null, "✅ Expense added!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount entered!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            // Option 2: View Expenses
            } else if (choice.equals("2")) {
                if (expenseList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No expenses recorded yet.");
                } else {
                    StringBuilder display = new StringBuilder("--- Your Expenses ---\n");
                    double total = 0;
                    for (Expense e : expenseList) {
                        display.append(e.toString()).append("\n");
                        total += e.amount;
                    }
                    display.append("\nTotal Spent: Rs. ").append(total);
                    JOptionPane.showMessageDialog(null, display.toString());
                }

            // Option 3: SIP Calculator
            } else if (choice.equals("3")) {
                try {
                    String monthlyStr = JOptionPane.showInputDialog("Enter your monthly SIP investment (Rs):");
                    if (monthlyStr == null) continue;
                    double monthlyInvest = Double.parseDouble(monthlyStr);

                    String rateStr = JOptionPane.showInputDialog("Enter expected annual return rate (e.g., 12 for 12%):");
                    if (rateStr == null) continue;
                    double annualRate = Double.parseDouble(rateStr);

                    String yearsStr = JOptionPane.showInputDialog("Enter duration in years:");
                    if (yearsStr == null) continue;
                    int years = Integer.parseInt(yearsStr);

                    // SIP Math Logic
                    double monthlyRate = annualRate / 12 / 100;
                    int months = years * 12;
                    double futureValue = monthlyInvest * ((Math.pow(1 + monthlyRate, months) - 1) / monthlyRate) * (1 + monthlyRate);
                    
                    double totalInvested = monthlyInvest * months;
                    double estimatedReturns = futureValue - totalInvested;

                    String result = String.format(
                        "--- SIP Projection ---\nTotal Invested: Rs. %.2f\nEstimated Returns: Rs. %.2f\n\nTotal Future Value: Rs. %.2f", 
                        totalInvested, estimatedReturns, futureValue
                    );
                    
                    JOptionPane.showMessageDialog(null, result, "SIP Calculator", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers only!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}