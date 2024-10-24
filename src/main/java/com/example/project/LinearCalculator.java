package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below

    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1; // Private variable representing the first x value
    private int x2; // Private variable representing the first y value
    private int y1; // Private variable representing the second x value
    private int y2; // Private variable representing the second y value

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        int breakPt1 = point1.indexOf(","); //Identifies the comma in the first coordinate, allowing a separation between x and y values
        x1 = Integer.parseInt(point1.substring(1, breakPt1)); // Finds the x value in this coordinate (by using the previously found comma) and converts it into a String using parseInt
        y1 = Integer.parseInt(point1.substring(breakPt1 + 1, point1.length() - 1)); // Finds the y value in the coordinate and turns it from a String to a number using parseInt
        int breakPt2 = point2.indexOf(","); // Identifies the comma in the first coordinate, which allows the separationg between x and y values further on
        x2 = Integer.parseInt(point2.substring(1, breakPt2)); // Finds the x value in this coordinate (by using the previously found comma) and converts it into a String using parseInt
        y2 = Integer.parseInt(point2.substring(breakPt2 + 1, point2.length() - 1)); // Finds the y value in this coordinate (by using the previously found comma) and converts it into a String using parseInt
    }

    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1; // Returns the value of x1
    }

    public int getY1(){
        return y1; // Returns the value of y1
    }

    public int getX2(){
        return x2; // Returns the value of x2
    }

    public int getY2(){
        return y2; // Returns the value of y2
    }

    public void setX1(int newX1){
        x1 = newX1; // Allows the user to change x1 to a new value named newX1
    }

    public void setY1(int newY1){
        y1 = newY1; // Allows the user to change y1 to a new value named newY1
    }

    public void setX2(int newX2){
        x2 = newX2; // Allows the user to change x2 to a new value named newX2
    }

    public void setY2(int newY2){
        y2 = newY2; // Allows the user to change y2 to a new value named newY2
    }

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt((double)Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); // Finds the distance between both points by taking the square root of the difference between the x values squared plus the difference between the y values squared
        return Math.round(distance * 100.0) / 100.0; // Rounds the previous value to the nearest hundreth before returning it 
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt() {
        if (x2 == x1) { // This conditional statement makes sure the yIntercept is not undefined, and if it is it will return -999.99
            return -999.99; // Returns -999.99 if conditonal statement is true
        }

        double slope = slope(); // Using the slope method to add to a variable named slope for future use
        double yInt = y1 - (slope * x1); // Finds the y intercept by subtracting the first y by the slope times the first x
        return Math.round(yInt * 100.0) / 100.0; // Rounds the value of the y intercept we found before to the nearest hundreth and returns it
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double yVal = (double) y2 - y1; // Finds the "top" half of the slope equation and makes the value a double, this variable is yVal
        double xVal = (double) x2 - x1; // Finds the "bottom" half of the slope equation and makes the value a double, this variable is xVal 
        if (x2 == x1) {
            return -999.99;
        }
        return Math.round((yVal / xVal) * 100.0) / 100.0; // Rounds the value of the yVal / xVal to the nearest hundreth and returns it
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double slopeVal = slope();
        if (slopeVal == -999.99) { // This conditonal makes sure the slope is not undefined
            return "undefined"; // Returns undefined if the conditonal is true
        }
        
        double yInt = yInt(); // sets the value of the method yInt() to a variable here named yInt
        if (yInt == 0.0) { // To check if we need to remove the yInt part of the equation, or in other words if yInt is 0
            return "y=" + slopeVal + "x"; // Returns the equation without yInt if the conditional is true
        } else if (slopeVal == 0.0) { // If the first conditional isn't true, it checks if the slope is 0 now
            return "y=" + yInt; // Returns the equation without the slope and x if the conditonal is true
        } else if (yInt <= -1) { // If the first two conditonals aren't true, it checks if yInt is negative to remove the + sign in the equation
            return "y=" + slopeVal + "x" + yInt; // Returns the equation without the + sign if the conditional is true
        }

        return "y=" + slopeVal + "x" + "+" + yInt; // If none of those conditonals is true, it returns y=mx+b with the proper values
    }

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0) / 100.0; // Rounds x by using the Math.round method, learned through https://stackoverflow.com/questions/246193/how-do-i-round-a-number-in-javascript
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")"; // Initializes a String variable named str with the points (x1, y1)
        str += " and " + "(" + x2 + "," + y2 + ")"; // Adds the points (x2, y2) to the string
        str += "\nThe equation of the line between these points is: " + equation(); // Adds (with a space using \n) the equation of the points to the string
        str += "\nThe slope of this line is: " + slope(); // Adds (with a space using \n) the slope of the "line" created by the points
        str += "\nThe y-intercept of the line is: " + yInt(); // Adds (with a space using \n) the y intercept of the line
        str += "\nThe distance between the two points is: " + distance(); // Adds (with a space using \n) the distance between the points
        str += "\n" + findSymmetry(); // Adds (with a space using \n) the type of symmetry the points have 
        str += "\nThe midpoint of this line is: " + Midpoint(); // Adds (with space using \n) the midpoint of  the points
        return str; // Returns the string with all the added information
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x1 == -x2 && y1 == -y2) { // Check to see if the points are symmetric about the origin by checking if each is equal to its negative counterpart
            return "Symmetric about the origin"; // If conditional is true, it returns "Symmetric about the origin"
        } else if (y1 == -y2) { // Checks to see if the points are symmetric about the x-axis by checking if y1 is equal to negative y2
            return "Symmetric about the x-axis"; // If conditional is true, it returns "Symmetric about the x-axis"
        } else if (x1 == -x2) { // Checks to see if the points are symmetric about the y-axis by checking is x1 is equal to negative x2
            return "Symmetric about the y-axis"; // If conditonal is true, it returns "Symmetric about the y-axis"
        }
        
        return "No symmetry"; // If none of the conditionals are true, it will return "No symmetry"
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xVals = ((double) x1 + x2) / 2; // Finds the first "part" of the midpoint coordinate by adding the two x values and dividing them by 2 and placing the value into xVals double variable
        double yVals = ((double) y1 + y2) / 2; // Finds the second "part" of the midpoint coordinate by adding the two y values and diving them by 2 and placing the value into a yVals double variable
        return "The midpoint of this line is: " + "(" + xVals + "," + yVals + ")"; // Concatenates the two values into a coordinate point format and states that this is the midpoint
    }
}