import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[]args){
        System.out.println("----------- Welcome to the Ashesi Health Kiosk -----------"); // Welcome message
        Scanner input = new Scanner(System.in);

        
        

        // Task one - Service Router
        System.out.println("Enter service code(P/L/T/C): "); // Taking service code from user
        char code = input.next().toUpperCase().charAt(0);
         

        //Using the Switch Statement
        switch (code) {
        case 'P': System.out.println("Go to: Pharmacy Desk"); break;
        case 'L': System.out.println("Go to: Lab Desk"); break;
        case 'T': System.out.println("Go to: Triage Desk"); break;
        case 'C': System.out.println("Go to: Counseling Desk"); break;
        default:System.out.println("Invalid service code");
        }

        // Task two - Mini Health metric
        double metricValue = 0;
        System.out.println("Health Metric \n1.BMI \n2.Dosage round up \n3.Simple trig Helper.");
        System.out.println("Enter Choice 1-3: ");
        int healthMetric = input.nextInt();
        if (healthMetric == 1){
            System.out.println("Enter weight in kilogram(kg): ");
            double weightInKg = input.nextDouble();
            System.out.println("Enter height in meters(m): ");
            double heightInMeters = input.nextDouble();
            double bmi = weightInKg / Math.pow(heightInMeters,2 );
            double roundedBmi = Math.round(bmi * 10)/ 10.0;
            System.out.printf("BMI: %.1f Category: " , roundedBmi);
            if (bmi < 18.5){
                System.out.println("Underweight");
            }else if(bmi >= 18.5 && bmi <=24.9){
                System.out.println("Normal");
            }else if(bmi >= 25.0 && bmi <=29.9){
                System.out.println("Overweight");
            }else if(bmi >= 30){
                System.out.println("Obese");
            }else{
                System.out.println("Invalid inputs.Try again");
            }
        }else if (healthMetric == 2){
            System.out.println("Enter required dosage in milligrams(mg): ");
            double dosage = input.nextDouble();
            int pharmDispenseTablet = 250;
            double numberOfTablet = Math.ceil(dosage/pharmDispenseTablet);
            int tablet = (int)numberOfTablet;
            System.out.println("Number of tablets to dispense: " + tablet);
        }else if(healthMetric == 3){
            System.out.println("Enter angle in degrees: ");
            double angleInDegrees = input.nextDouble();
            double angleToRadians = Math.toRadians(angleInDegrees);
            double sinValue = Math.round(Math.sin(angleToRadians) * 1000)/1000.0;
            double cosValue = Math.round(Math.cos(angleToRadians) * 1000)/1000.0;

            System.out.println("sin(" + angleInDegrees + ") = " + sinValue);
            System.out.println("cos(" + angleInDegrees + ") = " + cosValue);


        }else{
            System.out.println("Invalid input.Try again.");
        }

        //task 3 - ID Sanity Check

        //Generate random uppercase letter
        char randomCharacter = (char) ('A' + (int)(Math.random() * 26));
        //Generate 4 random numbers between 3 and 9
        int randomDigit1 = 3 + (int)(Math.random() * 7);
        int randomDigit2 = 3 + (int)(Math.random() * 7);
        int randomDigit3 = 3 + (int)(Math.random() * 7);
        int randomDigit4 = 3 + (int)(Math.random() * 7);

        String shortStudentID = String.format("%c%d%d%d%d", randomCharacter,randomDigit1,randomDigit2,randomDigit3,randomDigit4);
        System.out.printf("Student's Short ID: %s%n",shortStudentID);

        //Checking the length of ID
        if(shortStudentID.length() != 5){
            System.out.println("Invalid length");

        //Checking if the first character is a letter    
        }else if(!Character.isLetter(shortStudentID.charAt(0))){
            System.out.println("Invalid: first character must be a letter.");

        //Checking if first character to fourth character are digit
        }else if(!Character.isDigit(shortStudentID.charAt(1))||
                 !Character.isDigit(shortStudentID.charAt(2))||
                 !Character.isDigit(shortStudentID.charAt(3))||
                 !Character.isDigit(shortStudentID.charAt(4))) {
                  System.out.println("Invalid: last 4 must be digits.");
         }else{
            System.out.println("ID OK");
            }
        
        //Task 4 - Secure display code
        System.out.println("Enter your first name: ");
        String studentName = input.next();

        //Get first letter of name and change to uppercase
        char firstLetter = studentName.toUpperCase().charAt(0);
        int alphabetIndex = firstLetter - 'A';  // convert to 0–25
        int shiftedIndex = (alphabetIndex + 2) % 26;
        char shiftedLetter = (char) ('A' + shiftedIndex);
        // Get last two chars of ID
        String lastTwo = shortStudentID.substring(shortStudentID.length() - 2);

        // Round metric
        int roundedMetric = (int) Math.round(metricValue);

        // Build final code manually
        String displayCode = shiftedLetter + lastTwo + "-" + roundedMetric;

        System.out.println("Display Code: " + displayCode);
       
       
        //Task 5
       String summary = "";
        switch (code) {
            case 'P':
                summary = "PHARMACY | ID=" + shortStudentID + " | Code=" + displayCode;
                break;
            case 'L':
                summary = "LAB | ID=" + shortStudentID + " | Code=" + displayCode;
                break;
            case 'T':
                summary = String.format("TRIAGE | ID=%s | BMI=%.1f | Code=%s", shortStudentID, metricValue, displayCode);
                break;
            case 'C':
                summary = "COUNSELING | ID=" + shortStudentID + " | Code=" + displayCode;
                break;
            default:
                summary = "UNKNOWN SERVICE | ID=" + shortStudentID + " | Code=" + displayCode;
        }

        System.out.println(summary); 


        input.close();


        
    }
}
