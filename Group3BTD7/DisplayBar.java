import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DisplayBar is a greenfoot actor that displays text.
 * It is designed to work in a scenario that is 800x600 pixels.
 * Displays any string that fits, or send game info straight to customized method.
 * 
 * @author Jordan Cohen 
 * 
 */
public class DisplayBar extends Actor
{
    // Declare Objects
    private GreenfootImage scoreBoard;
    private Color background;
    private Color foreground;
    private Font textFont;
    private String text;

    private int fontSize;

    // Declare Variables:
    private int width;
    
    private String userName;
    private int highScore;
    
    //public DisplayBar (){
        //this (GameWorld.WIDTH);
    //}
    
    public DisplayBar (String userName, int highScore){
       
        this.userName = userName;
        this.highScore = highScore;
    }
    
    /**
     * Construct a ScoreBar of the appropriate size.
     *
     * @param width     width of the World where the
     *                  ScoreBar will be placed
     */
    public DisplayBar (int width)
    {
        fontSize = 22;
        scoreBoard = new GreenfootImage (width, 30);
        background = new Color (175, 20, 23);
        foreground = new Color (255, 255, 255);
        textFont = new Font ("Courier New", true, false, fontSize);
        scoreBoard.setColor(background);
        scoreBoard.fill();
        
        this.setImage (scoreBoard);
        scoreBoard.setFont(textFont);

        this.width = width;
    }

    public void setHighScore (int highScore){
        this.highScore = highScore;
        
    }
    
    public void update (int playerHP, int score){
        update ("User: " + userName + " HP: " + zeroAdder(playerHP, 3) + " High: " + highScore + " Score: " + zeroAdder(score, 5));
    }

    /**
     * Takes a String and displays it centered to the screen.
     *
     * @param output    Text for displaying.
     */
    public void update (String output)
    {
        // Refill the background with background color
        scoreBoard.setColor(background);
        scoreBoard.fill();

        // Write text over the solid background
        scoreBoard.setColor(foreground);
        // Smart piece of code that centers text, specific to 24 point Courier New

        int centeredY = (width/2) - (int)((output.length() * 0.58 * fontSize)/2);
//        int centeredY = (width/2) - ((output.length() * 14)/2);

      // Draw the text onto the image
        scoreBoard.drawString(output, centeredY, 22);
    }

    /**
     * Method that aids in the appearance of the scoreboard by generating
     * Strings that fill in zeros before the score. For example:
     *
     * 27 ===> to 5 digits ===> 00027
     *
     * @param   value   integer value to use for score output
     * @param   digits   number of zeros desired in the return String
     * @return  String  built score, ready for display
     */
    public static String zeroAdder (int value, int digits)
    {
        // Figure out how many digits the number is
        int numDigits = digitCounter(value);

        // If not extra digits are needed
        if (numDigits >= digits)
            return Integer.toString(value);

        else // Build the number with zeroes for extra place values:
        {
            String zeroes = "";
            for (int i = 0; i < (digits - numDigits); i++)
            {
                zeroes += "0";
            }
            return (zeroes + value);
        }

    }

    /**
     * Useful private method that counts the digit in any integer.
     *
     * @param number    The number whose digits you want to count
     * @return  int     The number of digits in the given number
     */
    private static int digitCounter (int number)
    {
        if (number < 10) {
            return 1;
        }
        int count = 0;
        while (number > 0) {

            number /= 10;
            count++;
        }
        return count;
    }

}
