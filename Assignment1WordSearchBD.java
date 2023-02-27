/*
Programer Benjamin Diskin  
2/27/2023
Assignment: make a or serach
Class: CS 145
we take words and put them into a word search for people to find the words
for this lab i used notes from class
*/




import java.util.*;
import java.io.*;

public class Assignment1WordSearchBD {

        //VARIABLES:
        // word search 2 dimensional array
   private static String[][] wordSearch = new String[15][15];
        // word search with answers right
   private static String[][] wordSearchKey = new String[15][15];
        // RANDOM # GENERATOR FOR LETTERS Will Fill Empty spots
   private static Random random = new Random();
   private static Scanner input = new Scanner(System.in);
        // words to collect
   private static String currentWord = "";
   private static String firstWord = "";
   private static String secondWord = "";
   private static String thirdWord = "";
   private static String fourthWord = "";
   private static String fiveWord = "";
   private static int tempa = 0; // starting array position verticle for next string
   private static int tempb = 0; // starting array position horizontal for next string

   private static ArrayList<String> list = new ArrayList<String>();
   

   public static void main(String[] args) {
   
      menu(wordSearch, wordSearchKey);
   } // end of main

   public static void menu(String[][] wordSearch, String[][] wordSearchKey) {
      Scanner input = new Scanner(System.in);
      String menu="";
      while(!menu.equals("g")&&!menu.equals("p")&&!menu.equals("s")&&!menu.equals("q")){ 
         System.out.println("this program will allow you to make your own word search puzzle");
         System.out.println("please selct and option: ");
         System.out.println("generate a new word search(g)");
         System.out.println("print your word search(p)");
         System.out.println("show the solution to your word search(s)");
         System.out.println("quit program(q)");
         menu = input.next();
      } // end while
   //-------------------------------------------------------------------------------------------------------------------------------------------------
      if(menu.equals("g")){
         int a = 0;
         int b = 0;
         boolean placement = false;
         for(int i = 0; i < 5; i++) {// change 2 back to 5 later
            System.out.print("Please choose a word that is less than 10 letters \t");
            switch(i) {
               case 0:
                  firstWord = input.next();
                  currentWord = firstWord;
                  list.add(firstWord);
                  break;
               case 1:
                  secondWord = input.next();
                  currentWord = secondWord;
                  list.add(secondWord);
                  break;
               case 2:
                  thirdWord = input.next();
                  currentWord = thirdWord;
                  list.add(thirdWord);
                  break;
               case 3:
                  fourthWord = input.next();
                  currentWord = fourthWord;
                  list.add(fourthWord);
                  break;
               case 4:
                  fiveWord = input.next();
                  currentWord = fiveWord;
                  list.add(fiveWord);
            }// end of case
            if(i==0){//vertical
               a=7;
               b= 7 -currentWord.length()/2;
               for(int j = 0; j < currentWord.length(); j++) {
                  String character = "" + currentWord.charAt(j);
                  
                  wordSearch[a][b + j] = character.toLowerCase(); // adds word to wordSearch lower case
                  wordSearchKey[a][b + j] = character.toUpperCase(); // adds the word all caps
               }//end of for
            }//end of if
            else if(i==1){// horizontal
               placement = false;
               for(int x = 0; x < list.get(list.size() - 2).length(); x++) {
                  
                  for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                     
                     if(list.get(list.size() - 2).charAt(x) == currentWord.charAt(y)) {
                        
                        if(placement == false) {
                           placement = true;
                           
                           a = a - y;
                           b = b + x;
                        }
                     
                        for(int j = 0; j < currentWord.length(); j++) {
                           String character = "" + currentWord.charAt(j);
                        
                           wordSearch[a + j][b] = character.toLowerCase(); // adds word to wordSearch lower case
                           wordSearchKey[a + j][b] = character.toUpperCase(); // adds the word all caps
                        
                        }//end of for
                     
                     }// end of iff
                  }//end of for
                  
               }// end of for
               if(placement == false) { // default position if no letters match
               
                  a = a - 2;
                  b = b - 2;
                  for(int j = 0; j < currentWord.length(); j++) { // places on left side
                     String character = "" + currentWord.charAt(j);
                     wordSearch[a + j][b] = character; // adds word to wordSearch lower case
                     wordSearchKey[a + j][b] = character.toUpperCase(); // adds the word all caps
                  }
               } // end of if false
              
            
            
            }//end of if else
            
            else if(i==2){// horizontal reverse
              
               placement = false;
               for(int x = 0; x < list.get(list.size() - 2).length(); x++) {
                  for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                     if(list.get(list.size() - 2).charAt(x) == currentWord.charAt(y)) {
                        if(placement == false) {
                           placement = true;
                           tempa = a + x;
                           tempb = b + y;
                           for(int j = 0; j < currentWord.length(); j++) {
                              String character = "" + currentWord.charAt(j);
                              if(wordSearch[tempa][tempb - j] != null && !wordSearch[tempa][tempb - j].equals(character)) {
                                 placement = false;
                              }// end of if
                           }// end of for
                           if(placement) {
                              a = a + x;
                              b = b + y;
                              for(int j = 0; j < currentWord.length(); j++) { // places on left side
                                 String character = "" + currentWord.charAt(j);
                                 wordSearch[a][b - j] = character; // adds word to wordSearch lower case
                                 wordSearchKey[a][b - j] = character.toUpperCase(); // adds the word all caps
                              }// end of for 
                           }// end of if
                                
                        } // end of if
                     }
                  } // end of y
               } // end of x   
            
               if(placement == false) { // default position if no match is found
               
                  a = a + 4;
                  b = a + 4;
               
                  for(int j = 0; j < currentWord.length(); j++) { // places on left side
                     String character = "" + currentWord.charAt(j);
                     wordSearch[a][b - (currentWord.length() - 1) - j]  = character; // adds word to wordSearch lower case
                     wordSearchKey[a][b - (currentWord.length() - 1) - j] = character.toUpperCase(); // adds the word all caps
                  } // end for
               } // end if
            }//end of if else
            else if(i==3){// vertical reverse
             
               placement = false;
               for(int x = 0; x < list.get(list.size() - 2).length(); x++) {
                  for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                     if(list.get(list.size() - 2).charAt(x) == currentWord.charAt(y)) {
                        if(placement == false) {
                           placement = true;
                           tempa = a + y;
                           tempb = b - x;
                        
                           for(int j = 0; j < currentWord.length(); j++) {
                              String character = "" + currentWord.charAt(j);
                              if(wordSearch[tempa - j][tempb] != null && !wordSearch[tempa - j][tempb].equals(character)) {
                                 placement = false;
                              }// end of if
                           }// end of for
                        
                           if(placement == true) {
                              a = a + y;
                              b = b - x;
                              for(int j = 0; j < currentWord.length(); j++) { // places on left side
                                 String character = "" + currentWord.charAt(j);
                                 wordSearch[a - j][b] = character; // adds word to wordSearch lower case
                                 wordSearchKey[a - j][b] = character.toUpperCase(); // adds the word all caps
                              }// end of for
                           } // end of if            
                        } // end of if
                     }//end of if
                  } // end of y
               } // end of x 
            
               if(placement == false) {
                  a = 14;
                  b = 0;
                  for(int j = 0; j < currentWord.length(); j++) { // places on left side
                     String character = "" + currentWord.charAt(j);
                     wordSearch[a - j][b] = character; // adds word to wordSearch lower case
                     wordSearchKey[a - j][b] = character.toUpperCase(); // adds the word all caps
                  }// end for
               }// end if
            }//end of if else
            else if(i==4){// diagnol
               placement = false;
               for(int x = 0; x < list.get(list.size() - 2).length(); x++) {
                  for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                     if(list.get(list.size() - 2).charAt(x) == currentWord.charAt(y)) {
                        if(placement == false) {
                           placement = true;
                           tempa = a + y;
                           tempb = b - x;
                        
                           for(int j = 0; j < currentWord.length(); j++) {
                              String character = "" + currentWord.charAt(j);
                              if(wordSearch[tempa + j][tempb - j] != null && !wordSearch[tempa + j][tempa - j].equals(character)) {
                                 placement = false;
                              }// end if
                           }// end for
                        
                           if(placement == true) {
                              a = a + y;
                              b = b - x;
                              for(int j = 0; j < currentWord.length(); j++) { // places on left side
                                 String character = "" + currentWord.charAt(j);
                                 wordSearch[a + j][b - j] = character; // adds word to wordSearch lower case
                                 wordSearchKey[a + j][b - j] = character.toUpperCase(); // adds the word all caps
                              }// end for
                           }  // end if           
                        } // end of if
                     }// end if
                  } // end of y
               } // end of x 
            
               if(placement == false) {
                  a = 0;
                  b = 14;
                  while(wordSearch[a][b] == null) {
                     a++;
                     b--;
                  }// end while
               
                  a -= currentWord.length() + 1;
                  b += currentWord.length() + 1;
               
                  for(int j = 0; j < currentWord.length(); j++) { // places on left side
                     String character = "" + currentWord.charAt(j);
                     wordSearch[a + j][b - j] = character; // adds word to wordSearch lower case
                     wordSearchKey[a + j][b - j] = character.toUpperCase(); // adds the word all caps
                  } // end of for
               } // end of if
            }// end else if
         
         }//------------------------------------------------------------------------------------------------------------------
               // for-loop to add random letters
         for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j ++) {
               int number = random.nextInt(26);
               char letter = (char) (number + 97);
               String sLetter = "" + letter;
               if(wordSearch[i][j] == null) {
                  wordSearch[i][j] = sLetter;
                  wordSearchKey[i][j] = "|";
               }
            } // end of for-loop j
         } // end of for-loop i
      }
      
      else if(menu.equals("p")){
         System.out.println("WORD SEARCH:");
           // for loop to print wordsearch
         for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j ++) {
               System.out.print(" " + wordSearch[i][j] + " ");
            } // end of for-loop j
            System.out.println();
         } // end of for-loop i
      }// end els if
      
      else if(menu.equals("s")){
         System.out.println("WORD SEARCH ANSWER KEY:");
           // for loop to print wordsearch key
         for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j ++) {
               System.out.print(" " + wordSearchKey[i][j] + " ");
            } // end of for-loop j
            System.out.println();
         } // end of for-loop i
      }// end else if
      
      else if(menu.equals("q")){
         System.out.println("thank you for playing.");
         System.exit(0);
      }
      menu(wordSearch, wordSearchKey);
   } // end menu
} // end of class