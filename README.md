# Wealth-Tracker
# WealthTrack 💰: Personal Finance & SIP Manager

A lightweight, interactive desktop application built in Java to help students manage their daily expenses and project mutual fund returns. 

I developed this as my **VITyarthi project** to strengthen my understanding of Object-Oriented Programming (OOP) principles, exception handling, and basic GUI implementation in Java.

## 🌟 Core Features
* **Daily Expense Logger:** Easily record day-to-day expenses (e.g., food, travel, stationery) through interactive popup dialogs rather than a static terminal.
* **Expense Summary:** View a complete history of logged expenses along with the dynamically calculated total spending.
* **SIP Wealth Calculator:** Predict the future value of Systematic Investment Plans (SIPs) by inputting your monthly investment, expected return rate, and time horizon.
* **In-Memory Storage:** Utilizes Java Collections (`ArrayList`) for fast, temporary data handling during runtime.

## 🧮 Mathematical Logic Used
The SIP Calculator module uses the standard compound interest formula for the future value of an annuity:

`FV = P × [((1 + r)^n - 1) / r] × (1 + r)`

* **P** = Monthly investment amount
* **r** = Monthly interest rate (Annual Rate / 12 / 100)
* **n** = Total number of months (Years × 12)

## 💻 Tech Stack & Concepts
* **Language:** Core Java
* **User Interface:** Java Swing (`javax.swing.JOptionPane`)
* **Core Concepts Applied:** 
  * Class Encapsulation (Constructors, Overriding `toString()`)
  * Exception Handling (`NumberFormatException` for invalid user inputs)
  * Java Collections Framework

## 🚀 How to Run the Project Locally
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Clone this repository to your local machine:
   ```bash
   git clone [https://github.com/Arpitpandey99099/WealthTrack.git](https://github.com/Arpitpandey99099/WealthTrack.git)
