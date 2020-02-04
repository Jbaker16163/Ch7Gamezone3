/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin Baker
 */
import java.util.Scanner;
import java.util.ArrayList;
public class SecretPhase {
    
    static public void guess(String enterWord, int lives){
        char[] filler = new char[enterWord.length()];
        int i=0;
        while(i<enterWord.length()){
            filler[i]='-';
            if(enterWord.charAt(i)==' '){
                filler[i]=' ';
            }
            i++;
        }
        System.out.print(filler);
        System.out.println("  Life Remaining= "+lives);
        Scanner fun = new Scanner(System.in);
        ArrayList<Character> l=new ArrayList<Character>();
        while(lives>0){
            char x = fun.next().charAt(0);
            if(l.contains(x)){
                System.out.println("Already entered! Try again!");
                continue;
            }
            l.add(x);
            if(enterWord.contains(x+"")){
                for(int y=0; y<enterWord.length();y++){     //this loop will check all indexes for 
                    if(enterWord.charAt(y)==x){             //character will replace - by
                        filler[y]=x;                        //characters
                    }
                }
            }else {
                lives--; //lives decrease
            }if(enterWord.equals(String.valueOf(filler))){
                System.out.println(filler);
                System.out.print("You won!!");
                break;
            }System.out.print(filler);
            System.out.println("     Life remaining= "+lives);
            
            if(lives==0){
            System.out.println("You lose! Sorry!");
            break;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String enterWord = "";
        System.out.println("Please enter in a phrase to guess!");
        Scanner inputWord = new Scanner (System.in);
        String enterWord = inputWord.nextLine();
        int lives = 10;
        int c = 0;
        for(c=0; c<20; c++){
            System.out.println("------------");
        }
        System.out.println("Now it's time to guess! Good luck!");
        guess(enterWord, lives);
    }
}
