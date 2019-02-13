package us.mattgreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner keyboard;
    private Cookbook cookbook;

    public Main() {
        keyboard = new Scanner(System.in);
        cookbook = new Cookbook();

        FileInput indata = new FileInput("meals_data.csv");

        String line;

        System.out.println("Reading in meals information from file...");
        while ((line = indata.fileReadLine()) != null) {
            String[] fields = line.split(",");
            cookbook.addElementWithStrings(fields[0], fields[1], fields[2]);
        }

        runMenu();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void printMenu() {
        System.out.println("");
        System.out.println("Select Action");
        System.out.println("1. List All Items");
        System.out.println("2. List All Items by Meal");
        System.out.println("3. Search by Meal Name");
        System.out.println("4. Do Control Break");
        System.out.println("5. Exit");
        System.out.print("Please Enter your Choice: ");
    }

    private void runMenu() {
        boolean userContinue = true;

        while (userContinue) {
            printMenu();

            String ans = keyboard.nextLine();
            switch (ans) {
                case "1":
                    cookbook.printAllMeals();
                    break;
                case "2":
                    listByMealType();
                    break;
                case "3":
                    searchByName();
                    break;
                case "4":
                    doControlBreak();
                    break;
                case "5":
                    userContinue = false;
                    break;
            }
        }

        System.out.println("Goodbye");
        System.exit(0);
    }

    private void listByMealType() {
        // Default value pre-selected in case
        // something goes wrong w/user choice
        MealType mealType = MealType.DINNER;

        System.out.println("Which Meal Type");

        // Generate the menu using the ordinal value of the enum
        for (MealType m : MealType.values()) {
            System.out.println((m.ordinal() + 1) + ". " + m.getMeal());
        }

        System.out.print("Please Enter your Choice: ");
        String ans = keyboard.nextLine();

        try {
            int ansNum = Integer.parseInt(ans);
            if (ansNum < MealType.values().length) {
                mealType = MealType.values()[ansNum - 1];
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid Meal Type " + ans + ", defaulted to " + mealType.getMeal() + ".");
        }

        cookbook.printMealsByType(mealType);
    }

    private void searchByName() {
        keyboard.nextLine();
        System.out.print("Please Enter Value: ");
        String ans = keyboard.nextLine();
        cookbook.printByNameSearch(ans);
    }
    private void doControlBreak()
    {
        // create the variables used to find each instance of the meal type
          String mType = "";
          String conv;
          String testType = "";
          int cal;
          int total = 0;
          int count = 0;         
          double avg = 0.0;
          int max = Integer.MIN_VALUE;
          int min = Integer.MAX_VALUE;
          int median = 0;
          
          // bring in the file
          FileInput inFile = new FileInput("meals_data.csv");
                 String line;
                    
                 // read the file and put everything inside of an array using split
                 // make an arrayList for the cal, this will be used to find the median
                 // convert the string to an int for cal, we need to do some calculations
                    while ((line = inFile.fileReadLine()) != null) {    
                        String[] fields = line.split(","); 
                        ArrayList<Integer> cals = new ArrayList<Integer>();
                        mType = fields[0];
                        conv = fields[2];
                        cal = Integer.parseInt(conv);
                     
                            // if the array is reading breakfast, accumlate the min, max, increment the counter, get the total, and average
                          if(mType.equalsIgnoreCase("Breakfast") )
                            {                      
                                testType = fields[0];
                                    if(cal > max)
                                    {
                                        max = cal;
                                    }
                                    if(cal < min)
                                    {
                                        min = cal;
                                    }
                                  count++;
                                 total += cal;
                                 avg = total / count;
                                 // add the cal into the arrayList when complete divide the size by two, to get the median. then display that median
                                cals.add(Integer.parseInt(fields[2]));
                                int middle = cals.size()/2;
                                median = cals.get(middle);
                                 
                            
                           // if the mealType is not the testType then stop the loop
                                    if(!mType.equalsIgnoreCase(testType))
                                    {
                                        break;
                                    }
                          
                            }
                    }
                     
          
                        // we continue the pattern of bringing in the file, reading it, and doing the calculations. all of the variables are named slightly different
                        // in order to display the correct variable at the end, but everything is the same as above but the names are just a little different
                         FileInput LinFile = new FileInput("meals_data.csv");
                         
          String Lline;
                 
          String LmType = "";
          String Lconv;
          String LtestType = "";
          ArrayList<Integer> Lcals = new ArrayList<Integer>();
          int Lcal;
          int Ltotal = 0;
          int Lcount = 0;         
          double Lavg = 0.0;
          int Lmax = Integer.MIN_VALUE;
          int Lmin = Integer.MAX_VALUE;
          int Lmedian = 0;
                    while ((Lline = LinFile.fileReadLine()) != null) {    
                        String[] Lfields = Lline.split(","); 
                        
                        LmType = Lfields[0];
                        Lconv = Lfields[2];
                        Lcal = Integer.parseInt(Lconv);
                        
                           if(LmType.equalsIgnoreCase("Lunch") )
                            {                      
                                LtestType = Lfields[0];
                                    if(Lcal > Lmax)
                                    {
                                        Lmax = Lcal;
                                    }
                                    if(Lcal < Lmin)
                                    {
                                        Lmin = Lcal;
                                    }
                                 Lcount++;
                                 Ltotal += Lcal;
                                 Lavg = Ltotal / Lcount;
                                 
                                Lcals.add(Integer.parseInt(Lfields[2]));
                                int Lmiddle = Lcals.size()/2;
                                Lmedian = Lcals.get(Lmiddle);
                              
                            
                           
                               if(!LmType.equalsIgnoreCase(LtestType))
                                {
                                    break;
                                }
                            }
                    }
                                    
                         FileInput dinInFile = new FileInput("meals_data.csv");
                         
          String dinLine;
                        
          String dinmType = "";
          String dinConv;
          String dinTestType = "";
           ArrayList<Integer> dinCals = new ArrayList<Integer>();
          int dinCal;
          int dinTotal = 0;
          int dinCount = 0;         
          double dinAvg = 0.0;
          int dinMax = Integer.MIN_VALUE;
          int dinMin = Integer.MAX_VALUE;
          int dinMedian = 0;
          
                    while ((dinLine = dinInFile.fileReadLine()) != null) {    
                        String[] fields = dinLine.split(","); 
                        
                        dinmType = fields[0];
                        dinConv = fields[2];
                        dinCal = Integer.parseInt(dinConv);
                        
                           if(dinmType.equalsIgnoreCase("Dinner") )
                            {                      
                                dinTestType = fields[0];
                                    if(dinCal > dinMax)
                                    {
                                        dinMax =dinCal;
                                    }
                                    if(dinCal < dinMin)
                                    {
                                        dinMin = dinCal;
                                    }
                                dinCount++;
                                dinTotal += dinCal;
                                dinAvg = dinTotal / dinCount;
                                 
                                dinCals.add(Integer.parseInt(fields[2]));
                                int dinMiddle = dinCals.size()/2;
                                dinMedian = dinCals.get(dinMiddle);
                                 
                            
                                    if(!dinmType.equalsIgnoreCase(dinTestType))
                                    {
                                           break;
                                    }
                            }
                    }
                    
                    
                        
                         FileInput dInFile = new FileInput("meals_data.csv");
                         
                              String dLine;
                        
                            String DmType = "";
                            String dConv;
                            String dTestType = "";
                            int dCal;
                            int dTotal = 0;
                            int dCount = 0;         
                            double dAvg = 0.0;
                            int dMax = Integer.MIN_VALUE;
                            int dMin = Integer.MAX_VALUE;
                            int dMedian = 0;
                       
                        while ((dLine = dInFile.fileReadLine()) != null) {    
                        String[] dFields = dLine.split(","); 
                        ArrayList<Integer>dCals = new ArrayList<Integer>();
                        DmType = dFields[0];
                        dConv = dFields[2];
                        dCal = Integer.parseInt(dConv);
                     
                            
                          if(DmType.equalsIgnoreCase("Dessert") )
                            {                      
                                dTestType = dFields[0];
                                if(dCal > dMax)
                                {
                                    dMax = dCal;
                                }
                                if(dCal < dMin)
                                {
                                    dMin = dCal;
                                }
                                dCount++;
                                 dTotal += dCal;
                                 dAvg = dTotal / dCount;
                                 
                                dCals.add(Integer.parseInt(dFields[2]));
                                int dMiddle = dCals.size()/2;
                                dMedian = dCals.get(dMiddle);
                                 
                            
                           
                                if(!dTestType.equalsIgnoreCase(DmType))
                                {
                                    break;
                                }
                            }
                    }
                    
                           
                        
                        // printing out all the correct information to the user
                        System.out.println("");
                        System.out.println("Meal Type \tTotal  \t Mean \t Min \t Max \t Median");
                        System.out.println("");
                        System.out.println(testType + "\t" + total+"\t"+ avg+"\t"+ min+"\t"+max+"\t"+median);
                        System.out.println("");
                        System.out.println(LtestType+ "\t\t" + Ltotal+"\t"+ Lavg+"\t"+ Lmin+"\t"+Lmax+"\t"+Lmedian);
                        System.out.println("");
                        System.out.println(dinTestType + "\t\t" + dinTotal+"\t"+ dinAvg+"\t"+ dinMin+"\t"+dinMax+"\t"+dinMedian);
                        System.out.println("");
                        System.out.println(dTestType + "\t\t" + dTotal+"\t"+ dAvg+"\t"+ dMin+"\t"+dMax+"\t"+dMedian);
         }
                    
}

