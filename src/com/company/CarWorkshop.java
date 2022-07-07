package com.company;

import java.util.Scanner;

public class CarWorkshop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                    ###################################################################
                    
                    ~~~~~ WElCOME TO WORKSHOP MANAGEMENT SYSTEM ~~~~~
                    
                    ###################################################################
                    """);

        int admin_pass = 1234;                                                  //Password for admin
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""                                    
                            
                            --------------
                            Press if:
                            1 --> Admin
                            2 --> Customer
                            3 --> Exit
                            --------------                              
                            ~>\s""");                                           //Printing main menu
                int choice = input.nextInt();                                   //Taking input of user's choice
                if (choice == 1) {                                              //If user enters 1
                    System.out.print("Enter Password: ");
                    int pass = input.nextInt();                                 //Taking input of admins' password
                    while (pass != admin_pass) {                                //While loop executes until right password is entered
                        System.out.print("Wrong Password! Enter again: ");      //While loop if admin enters wrong password
                        pass = input.nextInt();                                 //Taking again input of admins' password
                    }
                    if (pass == admin_pass)                                     //If right password is entered
                        Admin();                                                //Calls admin method
                }
                else if (choice == 2)                                           //If user enters 2
                    Customer();                                                 //Calls customer method
                else if (choice == 3)                                           //If user enters 3
                    break;                                                      //Exits from the system
                else
                    System.out.println("Please enter from the given choices");  //If user enters other than the options
            }
            catch (Exception ex) {                                              //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Admin() {                                                //Admin method is defined
        String[][] w = new String[100][5];                                      //Workshop 2-D array is created
        String[][] c = new String[100][5];                                      //Customer 2-D array is created
        String[][] r = new String[100][4];                                      //Reservation 2-D array is created
        int[] x = new int[3];                                                   //x Array is created to count number of records
        Scanner input = new Scanner(System.in);
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                                       
                                        ----------------------
                                        Press for:
                                        1 --> Workshop Records
                                        2 --> Customer Records
                                        3 --> Reservations
                                        4 --> Back
                                        ----------------------
                                        ~>\s""");                               //Printing main menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1) {                                                //If user enters 1
                    Workshop_Records(w, x);                                     //Calls Workshop records method
                } else if (data == 2) {                                         //If user enters 2
                    Customer_Records(c, x);                                     //Calls Customer records method
                } else if (data == 3) {                                         //If user enters 3
                    Reservations(r, x);                                         //Calls Reservation method
                } else if (data == 4) {                                         //If user enters 4
                    break;                                                      //Returns to previous menu
                } else {                                                        //If user enters other than the options
                    System.out.println("Invalid  Input");
                }
            } catch (Exception ex) {                                            //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Customer() {                                             //Customer method is defined
        String[][] c = new String[100][5];                                      //Customer 2-D array is created
        String[][] r = new String[100][4];                                      //Reservation 2-D array is created
        int[] x = new int[3];                                                   //x Array is created to count number of records
        Scanner input = new Scanner(System.in);
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                        
                        ----------------------
                        Press for:
                        1 --> Customer Records
                        2 --> Reservation
                        3 --> Back
                        ----------------------
                        ~>\s""");                                               //Printing main menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1){                                                 //If user enters 1
                    Customer_Records(c, x);                                     //Calls Customer records method
                } else if (data == 2) {                                         //If user enters 2
                    Reservations(r, x);                                         //Calls Reservation method
                } else if (data == 3) {                                         //If user enters 3
                    break;                                                      //Returns to previous menu
                } else                                                          //If user enters other than the options
                    System.out.println("Invalid Input");
            }
            catch (Exception ex) {                                              //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Workshop_Records(String[][] Array, int[] num) {          //Workshop records method is defined
        Scanner input = new Scanner(System.in);                                 //Array (w) and num (x) are passed
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                        
                        ------------------------------
                        Press for:
                        1 --> Add Workshop Records
                        2 --> View Workshop Records
                        3 --> Search Workshop Records
                        4 --> Edit Workshop Records
                        5 --> Back
                        ------------------------------
                        ~>\s""");                                               //Printing sub menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1) {                                                //If user enters 1
                    Add_Workshop_Records(Array, num);                           //Calls Add Workshop records method
                } else if (data == 2) {                                         //If user enters 2
                    View_Workshop_Records(Array, num);                          //Calls View Workshop records method
                } else if (data == 3) {                                         //If user enters 3
                    Search_Workshop_Records(Array, num);                        //Calls Search Workshop records method
                } else if (data == 4) {                                         //If user enters 4
                    Edit_Workshop_Records(Array, num);                          //Calls Edit Workshop records method
                } else if (data == 5) {                                         //If user enters 5
                    break;                                                      //Returns back
                } else {                                                        //If user enters other than the options
                    System.out.println("Invalid Input. Please Enter from the given choices");
                }
            }
            catch (Exception ex) {                                              //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Add_Workshop_Records(String[][] Array, int[] num) {      //Add Workshop records method defined
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the car number: ");                             //Taking input of car number
        Array[num[0]][0] = input.nextLine();
        System.out.print("Enter the Customer Name: ");                          //Taking input of customer name
        Array[num[0]][1] = input.nextLine();
        System.out.print("Enter the type of service been done: ");              //Taking input of service been done
        Array[num[0]][2] = input.nextLine();
        System.out.print("Enter the date: ");                                   //Taking input of date
        Array[num[0]][3] = input.nextLine();
        System.out.print("Enter the cost (e.g. 500): ");                        //Taking input of cost
        Array[num[0]][4] = input.nextLine();
        num[0]++;                                                               //Adding 1 in number of records

        System.out.println("\nData is added into the record");
    }

    public static void View_Workshop_Records(String[][] Array, int[] num) {     //View Workshop records method defined
        Scanner input = new Scanner(System.in);                                 //Array (w) and num (x) are passed
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                                                
                        ------------------------------
                        Press for:
                        1 --> View Records
                        2 --> View Workshop Stats
                        3 --> Back
                        ------------------------------
                        ~>\s""");                                               //Printing sub menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1) {                                                //If user enters 1
                    View_Records(Array, num);                                   //Calls View records method
                } else if (data == 2) {                                         //If user enters 2
                    View_Workshop_Stats(Array, num);                            //Calls View Workshop Stats method
                } else if (data == 3) {                                         //If user enters 3
                    break;                                                      //Returns back
                } else {                                                        //If user enters other than the options
                    System.out.println("Invalid Input. Please Enter from the given choices");
                }
            } catch (Exception ex) {                                            //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void View_Records(String[][] Array, int[] num) {              //View records method is defined
        if (num[0] > 0) {                                                       //Shows record if any added before
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Car number", "Name", "Service", "Date", "Cost");
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (Array[i][0] != null) {                                      //Checking if the rows are not null
                    for (int j = 0; j < Array[i].length; j++) {                 //For loop iterating through columns
                        System.out.printf("%-20s", Array[i][j]);                //Printing the data
                    }
                    System.out.println();                                       //Printing new line
                }
            }
        }
        else                                                                    //If there is no data in the record
            System.out.println("There is no data in the record");
    }

    public static void View_Workshop_Stats(String[][] Array, int[] num) {       //View Workshop stats method is defined
        if (num[0] > 0) {                                                       //Shows record if any added before
            System.out.println("");                                             //Printing new line
            int  total = 0;                                                     //Creating and initializing total variable
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (Array[i][0] != null) {                                      //Checking if the rows are not null
                    total += Integer.parseInt(Array[i][4]);                     //Calculating total
                }
            }
            System.out.println("Total cost is: Rs. " + total);                   //Printing total cost
            System.out.println("Number of records: " + num[0]);                  //Printing number of records
        }
        else                                                                    //If there is no data in the record
            System.out.println("There is no data in the record");
    }

    public static void Search_Workshop_Records(String[][] Array, int[] num) {   //Search Workshop records method defined
        if (num[0] > 0) {                                                       //Shows record if any added before
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the car number to Search Records: ");       //Asks user car number to search records
            String CN = input.nextLine();                                       //Takes input of car number
            int y;                                                              //Creates variable named y
            boolean check = true;                                               //Boolean variable check is created
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (CN.equals(Array[i][0])) {                                   //Checks if input car number equals to added car number
                    y = i;                                                      //Assign value of i to y
                    check = false;                                              //Check is equals to false
                    System.out.println("Car Number: " + Array[y][0]);           //Printing car number
                    System.out.println("Customer Name: " + Array[y][1]);        //Printing customer name
                    System.out.println("Type of service: " + Array[y][2]);      //Printing service been done
                    System.out.println("Date: " + Array[y][3]);                 //Printing date
                    System.out.println("Cost: " + Array[y][4]);                 //Printing cost
                    break;                                                          //Breaks the for loop
                }
            }
            if (check)                                                      //If user enters wrong phone number
                System.out.println("No record found");
        }
        else                                                                    //If there is no data in the record
            System.out.println("There is no data in the record");
    }

    public static void Edit_Workshop_Records(String[][] Array, int[] num) {     //Edit Workshop records method defined
        if (num[0] > 0) {                                                       //Shows record if any added before
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the car number to edit records: ");         //Asks user car number to edit records
            String CN = input.nextLine();                                       //Takes input of car number
            int y;                                                              //Creates variable named y
            boolean check = true;                                               //Boolean variable check is created
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (CN.equals(Array[i][0])) {                                   //Checks if input car number equals to added car number
                    y = i;                                                      //Assign value of i to y
                    check = false;                                              //Check is equals to false
                    System.out.print("Enter the Customer Name: ");              //Taking input of customer name
                    Array[y][1] = input.nextLine();
                    System.out.print("Enter the type of service been done: ");  //Taking input of service been done
                    Array[y][2] = input.nextLine();
                    System.out.print("Enter the date: ");                       //Taking input of date
                    Array[y][3] = input.nextLine();
                    System.out.print("Enter the cost: ");                       //Taking input of cost
                    Array[y][4] = input.nextLine();

                    System.out.println("\nYour data is edited");                //Displaying that data is edited
                    break;                                                      //Breaks the for loop
                }
            }
            if (check)                                                      //If user enters wrong phone number
                System.out.println("No record found");
        }
        else {                                                                  //If there is no data in the record
            System.out.println("There is no data in the record");
        }
    }

    public static void Customer_Records(String[][] Array, int[] x) {            //Customer records method defined
        Scanner input = new Scanner(System.in);                                 //Array (c) and num (x) are passed
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                        
                        -----------------------------
                        Press for:
                        1 --> Add Customer Records
                        2 --> View Customer Records
                        3 --> Search Customer Records
                        4 --> Edit Customer Records
                        5 --> Back
                        -----------------------------
                        ~>\s""");                                               //Printing sub menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1) {                                                //If user enters 1
                    Add_Customer_Records(Array, x);                             //Calls Add Customer records method
                } else if (data == 2) {                                         //If user enters 2
                    View_Customer_Records(Array, x);                            //Calls View Customer records method
                } else if (data == 3) {                                         //If user enters 3
                    Search_Customer_Records(Array, x);                          //Calls Search Customer records method
                } else if (data == 4) {                                         //If user enters 4
                    Edit_Customer_Records(Array, x);                            //Calls Edit Customer records method
                } else if (data == 5) {                                         //If user enters 5
                    break;                                                      //Breaks the while loop
                }
                else {                                                          //If user enters other than the options
                    System.out.println("Invalid Input. Please Enter from the given choices");
                }
            } catch (Exception ex) {                                            //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Add_Customer_Records(String[][] Array, int[] x) {        //Add Customer records method defined
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the phone number: ");                           //Taking input of phone number
        Array[x[1]][0] = input.nextLine();
        System.out.print("Enter the car number: ");                             //Taking input of car number
        Array[x[1]][1] = input.nextLine();
        System.out.print("Enter the Customer Name: ");                          //Taking input of customer name
        Array[x[1]][2] = input.nextLine();
        System.out.print("Enter the type of service been done: ");              //Taking input of service been done
        Array[x[1]][3] = input.nextLine();
        System.out.print("Enter the date: ");                                   //Taking input of date
        Array[x[1]][4] = input.nextLine();
        x[1]++;                                                                 //Adding 1 in number of records

        System.out.println("\nData is added into the record");
    }

    public static void View_Customer_Records(String[][] Array, int[] x) {       //View Customer records method defined
        if (x[1] > 0) {                                                         //Shows record if any added before
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Phone Number", "Car Number", "Name", "Service", "Date");
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (Array[i][0] != null) {                                      //Checking if the rows are not null
                    for (int j = 0; j < Array[i].length; j++) {                 //For loop iterating through columns
                        System.out.printf("%-20s", Array[i][j]);                //Printing the data
                    }
                    System.out.println();                                       //Printing new line
                }
            }
            System.out.println("\nNumber of entries: " + x[1]);                 //Printing number of records
        }
        else
            System.out.println("There is no data in the record");               //If there is no data in the record
    }

    public static void Search_Customer_Records(String[][] Array, int[] x) {     //Search Customer records method defined
        if (x[1] > 0) {                                                         //Shows record if any added before
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the phone number to Search Records: ");     //Asks user phone number to search records
            String PN = input.nextLine();                                       //Takes input of phone number
            int y;                                                              //Creates variable named y
            boolean check = true;                                               //Boolean variable check is created
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (PN.equals(Array[i][0])) {                                   //Checks if input phone number equals to added phone number
                    y = i;                                                      //Assign value of i to y
                    System.out.println("Phone number: " + Array[y][0]);         //Printing phone number
                    System.out.println("Car number: " + Array[y][1]);           //Printing car number
                    System.out.println("Customer Name: " + Array[y][2]);        //Printing customer name
                    System.out.println("Type of service been done: " + Array[y][3]);    //Printing service been done
                    System.out.println("Date: " + Array[y][4]);                 //Printing date
                    check = false;                                              //Check is equals to false
                    break;                                                          //Breaks the for loop
                }
            }
            if (check)                                                      //If user enters wrong phone number
                System.out.println("No record found");
        }
        else
            System.out.println("There is no data in the record");               //If there is no data in the record
    }

    public static void Edit_Customer_Records(String[][] Array, int[] x) {       //Search Customer records method defined
        if (x[1] > 0) {                                                         //Shows record if any added before
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the phone number to Search Records: ");     //Asks user phone number to search records
            String PN = input.nextLine();                                       //Takes input of phone number
            int y;                                                              //Creates variable named y
            boolean check = true;                                               //Boolean variable check is created
            for (int i = 0; i < Array.length; i++) {                            //For loop iterating through rows
                if (PN.equals(Array[i][0])) {                                   //Checks if input phone number equals to added phone number
                    y = i;                                                      //Assign value of i to y
                    check = false;                                              //Check is equals to false
                    System.out.print("Enter the car number: ");                 //Taking input of car number
                    Array[y][1] = input.nextLine();
                    System.out.print("Enter the Customer Name: ");              //Taking input of customer name
                    Array[y][2] = input.nextLine();
                    System.out.print("Enter the type of service been done: ");  //Taking input of service been done
                    Array[y][3] = input.nextLine();
                    System.out.print("Enter the date: ");                       //Taking input of date
                    Array[y][4] = input.nextLine();

                    System.out.println("\nYour data is edited");                  //Displaying that data is edited
                    break;                                                          //Breaks the for loop
                }
            }
            if (check)                                                      //If user enters wrong phone number
                System.out.println("No record found");
        }
        else                                                                    //If there is no data in the record
            System.out.println("There is no data in the record");
    }

    public static void Reservations(String[][] Array3, int[] n) {               //Reservations method defined
        Scanner input = new Scanner(System.in);                                 //Array (r) and num (x) are passed
        while (true) {                                                          //Infinite while loop
            try {                                                               //Try block
                System.out.print("""
                        
                        ----------------------
                        Press for:
                        1 --> Add Reservation
                        2 --> View Reservation
                        3 --> Back
                        ----------------------
                        ~>\s""");                                               //Printing sub menu
                int data = input.nextInt();                                     //Taking input of user's choice
                if (data == 1) {                                                //If user enters 1
                    Add_Reservation(Array3, n);                                 //Calls Add reservation method
                } else if (data == 2) {                                         //If user enters 2
                    View_Reservation(Array3, n);                                //Calls View Reservation method
                } else if (data == 3) {                                         //If user enters 3
                    break;                                                      //Return back
                }
                else {                                                          //If user enters other than the options
                    System.out.println("Invalid Input. Please Enter from the given choices");
                }
            } catch (Exception ex) {                                            //Catch block
                System.out.println("Please Enter an integer");                  //If user enters other than integer
                input.nextLine();
            }
        }
    }

    public static void Add_Reservation (String[][]Array, int[] n) {             //Add Reservations method is defined
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the phone number: ");                           //Takes input of phone number
        Array[n[2]][0] = input.nextLine();
        System.out.print("Enter your name: ");                                  //Taking input of customer name
        Array[n[2]][1] = input.nextLine();
        System.out.print("Enter day (e.g. Wednesday): ");                       //Taking input of day
        String day = input.nextLine();
        Array[n[2]][2] = day;
        String time;                                                            //Creates variable time

        while(true){                                                            //Infinite while loop
            boolean check = true;                                               //Creates variable check and assign it true
            System.out.print("Enter the time for booking between 9am - 4pm (e.g. 3pm): ");
            time = input.nextLine();                                            //Takes input of time
            if (n[2] == 0){                                                     //If time is unique
                Array[n[2]][3] = time;                                          //Time is stored
                break;                                                          //Breaks the while loop
            }
            else{                                                               //If there is some data in reservations
                for (int i = 0 ; i < n[2] ; i++){                               //For loop iterates through rows
                    if ( (day.equals(Array[i][2])) && (time.equals(Array[i][3])) ){     //If time and day is equal
                        check = false;                                          //Check is assigned false
                        break;                                                  //Breaks the for loop
                    }
                }
            }
            if (check){                                                         //If check is true and time is unique
                Array[n[2]][3] = time;                                          //Time is stored
                break;                                                          //Breaks the while loop
            }
            else{                                                               //If check is false or time is not unique
                System.out.println("Sorry! This time slot is not available select another");

            }
        }
        n[2]++;                                                                 //Adding 1 in number of records

        System.out.println("\nYour booking is booked at " + time + " on " + day);   //Displaying booking
    }

    public static void View_Reservation(String[][] Array3, int[] n) {           //View Reservations method is defined
        if (n[2] > 0) {                                                         //Shows record if any added before
            System.out.printf("%-20s%-20s%-20s%-20s\n", "Phone Number", "Name", "Day", "Time");
            for (int i = 0; i < Array3.length; i++) {                           //For loop iterating through rows
                if (Array3[i][0] != null) {                                     //Checking if the rows are not null
                    for (int j = 0; j < Array3[i].length; j++) {                //For loop iterating through columns
                        System.out.printf("%-20s", Array3[i][j]);               //Printing the data
                    }
                    System.out.println();                                       //Printing new line
                }
            }
        }
        else                                                                    //If there is no data in the record
            System.out.println("There is no data in the record");
    }
}
