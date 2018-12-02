package bolt_shaun_slot;
import javax.swing.JOptionPane;
import java.util.Random;

/*
Project/Assignment Title: Slot Machine Simulation
File Name: bolt_shaun_slot
Data Complied Last: October 22, 2018
Author: Shaun Bolt
Complied in: NetBeans 8.2
Integrity Statement: By submitting this project, I am taking the integrity oath
that I have not copied any line(s) of code - partially or completely - from any
other individual, former student work, textbook, online resources, website, and
any reference avaliable anywhere.
 * @author shabolt
 */
public class Bolt_Shaun_Slot 
{
    public static void main(String[] args) 
    {
       String input;                //So the player could input money.
       String word = "";            //So that the words/icons are matched with values.
       String word1 = "";           //^^^.
       String word2 = "";           //^^^.
       String word3 = "";           //^^^.
       String outputString;         /*So that the words/icons show up on the output
                                      message box after the player inputs amount($).
                                    */
       char again = 'y';            //To control the loop.
       double money;                //Hold the value of the money inserted.
       int slots;                   //Hold the numbers and the words/assigned to them.
       double totalMoney_entered = 0;  //The total amount of money the player has used.
       double totalMoney_won;       /*The total amount of money that the player has
                                      won during their time at the slot machine.
                                    */
        totalMoney_won = 0;
       
       Random rand = new Random();  //Allows for random number generating for slot machine.
       
       //Opening message.
       JOptionPane.showMessageDialog(null, "Welcome to LoneStar Casino!!!");
       
       //Start of game.
       while( again == 'y' )
       {
           
        outputString = "";      /*This is declared so that the winning 
                                  and the input dialog box for wanting to play
                                  again does not getting mixed together when
                                  playing.*/ 
   
        /*The input message box that the player sees in order to put in how
          much they want to play with.*/
        input = JOptionPane.showInputDialog("How much do you want to put in?"
                    + " (max $1000) :");
        money = Double.parseDouble(input);
        
        //Totals up how much money the player put into the slot machine.
        totalMoney_entered += money;
        
        /*Formulas to determine the winnings due to how many icons matched to
        how much money they inserted in to the slot machine.
        */ 
        double win2 = (2 * money);
        double win3 = (3 * money);

        //Input message for player to insert how much money they want to gamble with.
        while (money < 1 || money > 1000)
        {
            input = JOptionPane.showInputDialog("How much do you want to put in?"
                    + " (max $1000) :");
            money = Double.parseDouble(input);
            
            //Totals up how much money the player put into the slot machine.
            totalMoney_entered += money;
        }

        //The resulting icons that correspond with the random numbers.
        JOptionPane.showMessageDialog(null, "And the results are~...!!!");

        for(int wordCount = 1; wordCount <= 3; wordCount++)
        {
            slots = rand.nextInt(6);

              if(slots == 0)
               {
                    word = "Cherries";
               }
               else
               {
                   if(slots == 1)
                   {
                        word = "Oranges";
                   }
                   else
                  {
                      if(slots == 2)
                      {
                            word = "Plums";
                        }
                      else
                       {
                          if(slots == 3)
                           {
                                word = "Bells";
                           }
                           else
                           {
                              if(slots == 4)
                              {
                                    word = "Melons";
                               }
                               else
                               {
                                    if(slots == 5)
                                   {
                                      word = "Bars";
                                   }
                               }
                           }
                      }
                   }
               }

              if(wordCount == 1)
               {
                   word1 = word;
               }
               else
               {
                   if(wordCount == 2)
                   {
                       word2 = word;
                   }
                   else
                   {
                       if(wordCount == 3)
                       {
                           word3 = word;
                       }
                   }
               }

              outputString += word + "\n";  
         }

             //The output messages that pop up if they match 0,2, or 3 icons.
             if( (word1.equals(word2)) && (word1.equals(word3)) && (word2.equals(word3)) )
                  {
                      outputString = outputString + "\nYou have won $" + win3 + "\n\n";
                      totalMoney_won += win3;
                  }
                  else
                  {
                      if( (word1.equals(word2)) || (word1.equals(word3)) || (word2.equals(word3)) )
                      {
                          outputString = outputString + "\nYou have won $" + win2 + "\n\n";
                          totalMoney_won += win2;
                      }
                      else
                      {
                          outputString = outputString + "\nBetter luck next time\n\n";
                          System.out.println(totalMoney_won);
                      }
                  }

             //Shows the results of the winning and if they player won any money or not.
             JOptionPane.showMessageDialog(null, outputString);

             //How the player is able to play again and/or exit the game.
             again = JOptionPane.showInputDialog("Do you" + 
                                    " want to play again?\nPlease press 'y'" + 
                                    " for yes, or 'n' for no: ").charAt(0); 
       }   
             
             /*If the conditions are met, the player will be shown if they
             profited, loss money, or neither while playing.
             */
             if(totalMoney_entered > totalMoney_won)
             {
                 JOptionPane.showMessageDialog(null, "Today, you've inserted $" + 
                     totalMoney_entered + "," + "\nand you've won $" + totalMoney_won + "." +
                     "\nThat means you've loss -$" + (totalMoney_entered - totalMoney_won) + "."
                         + "\n\nThanks for playing at the LoneStar Casino !!! :D");
             }
             else
             {
                 if(totalMoney_entered < totalMoney_won)
                 {
                     JOptionPane.showMessageDialog(null, "Today, you've inserted $" + 
                         totalMoney_entered + "," + "\nand you've won $" + totalMoney_won + "." +
                         "\nThat means you've won $" + (totalMoney_won - totalMoney_entered) + "."
                             + "\n\nThanks for playing at the LoneStar Casino !!! :D");
                 }
                 else
                 {
                     if(totalMoney_entered == totalMoney_won)
                     {
                         JOptionPane.showMessageDialog(null, "Today, you didn't " +
                                 "lose or win any money." + 
                                 "\n\nThanks for playing at the LoneStar Casino !!! :D");
                     }
                 }
             }
          System.exit(0);
       }
     }