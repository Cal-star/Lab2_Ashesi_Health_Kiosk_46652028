/*
Name of file: HealthKiosk.java

The HealthKiosk program is a Java application that simulates a health service kiosk. 
It begins by welcoming the user and asking them to choose a service desk (Pharmacy, Lab, Triage, or Counseling). 
If Triage is selected, the user can calculate their BMI, determine dosage in tablets, or find trigonometric values (sine and cosine) of an angle.
The program then generates a unique 5-character ID, validates its format, and creates a display code using the user’s first name and calculated metric result. 
Finally, it prints out the service details along with the generated ID and display code. 
It makes use of Scanner for input, switch-case and if-else for control flow, math functions for calculations, and string manipulation.

Developer: Cal Senam Afun

Date: 28/09/25
*/

import java.util.Scanner;

public class HealthKiosk{
    public static void main (String [] args){
        // Task 0
        Scanner scanner = new Scanner (System.in);
        System.out.println("Welcome to Ashesi Health Kiosk!! ");

        // Task 1
        System.out.println("1. P -> Pharmacy Desk");
        System.out.println("2. L -> Lab Desk");
        System.out.println("3. T -> Triage Desk");
        System.out.println("4. C -> Counseling Desk");
        System.out.println("Enter Service Code (P/L/T/C): ");
        char serviceCode = Character.toUpperCase(scanner.nextLine().charAt(0)); 

        // Declaring Variable
        int metricResult = 0;
        String category;
        String service = "Unknown";
        String choice = "Unknown";

        switch(serviceCode){
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                service = "Pharmacy";
                break;

            case 'L':
                System.out.println("Go to: Lab Desk");
                service = "Lab Desk";
                break;

            case 'T':
                System.out.println("Go to: Triage Desk");
                service = "Triage";
                // Begining of Task 2
                System.out.println("Enter metric option: ");
                System.out.println("1 = BMI");
                System.out.println("2 = Dosage");
                System.out.println("3 = Trig helper");
                int option = scanner.nextInt();

                 // Task 2
                if (option == 1){
                    choice = "BMI=";
                    System.out.println("Enter weight (kg): ");
                    double weight = scanner.nextDouble();

                    System.out.println("Enter height (m): ");
                    double height = scanner.nextDouble();

                    double BMI = weight / (height * height);
                    double roundedBMI = Math.round(BMI * 10) / 10.0;
                    metricResult = (int) roundedBMI;

                    if (BMI < 18.5){
                        category = "Underweight";
                    } 
                    else if (BMI <= 24.9){
                        category = "Normal";
                    }
                    else if(BMI <= 29.9){
                        category = "Overweight";
                    } else{
                        category = "Obese";
                    }

                    System.out.println("BMI: " + roundedBMI + " Category: " + category);

                }

                else if (option == 2){
                    choice = "Dosage= ";
                    System.out.println("Enter daily dosage in mg ");
                    double dosage = scanner.nextDouble();
                    int tablets = (int) Math.ceil(dosage / 250.0);
                    System.out.println("Number of tablets: " + tablets);
                    metricResult = tablets;

                }

                else if (option == 3){
                    choice = "Angle= ";
                    System.out.println("Enter the angle in degrees");
                    double degrees = scanner.nextDouble();
                    double radians = Math.toRadians(degrees);
                    double sinValue = Math.round(Math.sin(radians) * 1000) / 1000.0;
                    double cosValue = Math.round(Math.cos(radians) * 1000) / 1000.0;
                    metricResult = (int) Math.round(sinValue * 100);
                    System.out.println("Sin of angle: " + sinValue + " Cos of angle: " + cosValue);

                }
                break;

            case 'C':
                System.out.println("Go to: Counseling Desk");
                service = "Counseling";
                break;

            default:
                System.out.println("Invalid Service Code");
        }



        // Task 3
        char randomChar = (char) ('A' + (int)(Math.random() * 26));
        int digit1 = 3 + (int)(Math.random() * 7);
        int digit2 = 3 + (int)(Math.random() * 7);
        int digit3 = 3 + (int)(Math.random() * 7);
        int digit4 = 3 + (int)(Math.random() * 7);

        String shortCode = "" + randomChar + digit1 + digit2 + digit3 + digit4;

        if (shortCode.length() != 5){
            System.out.println("Invalid Length");
        }
        else if (!Character.isLetter(shortCode.charAt(0))){
            System.out.println("Invalid: First character must be letter");
        }
        else if(!Character.isDigit(shortCode.charAt(1)) ||
                !Character.isDigit(shortCode.charAt(2)) ||
                !Character.isDigit(shortCode.charAt(3)) ||
                !Character.isDigit(shortCode.charAt(4))){
                System.out.println("Invalid: Last 4 digits must be numbers");
                }
        else{
            System.out.println("ID OK!!");
        }

        //Task 4
        scanner.nextLine();
        System.out.println("Enter your first name; ");
        String firstName = scanner.nextLine();
        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (base - 'A' + 2) % 26);
        String lastTwo = shortCode.substring(shortCode.length() - 2);
        String displayCode = "" + shifted + lastTwo + "-" + metricResult;
        System.out.println("Display Code: " + displayCode);

        // Task 5
        if (!service.equals( "Triage")){
        System.out.println(service + " | ID = " + shortCode + " | Code = " +  displayCode);
        } else{
            System.out.println(service + " | ID = " + shortCode + " | Code = " +  displayCode + " | " + choice + " " + metricResult);

        }
       
}


}