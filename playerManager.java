import java.util.ArrayList;
import java.util.Scanner;

public class playerManager{

//instance variables and list
private ArrayList<player> players;

//making list full of players

  public playerManager(){
    this.players= new ArrayList<player>();
    ArrayList<Integer> ranks = FileReader.toIntList("rank.txt");
    ArrayList<String> names = FileReader.toStringList("name.txt");
    ArrayList<String> teams = FileReader.toStringList("team.txt");
    ArrayList<Integer> ovrs = FileReader.toIntList("ovr.txt");
    ArrayList<Integer> threes = FileReader.toIntList("three.txt");
    ArrayList<Integer> dnks = FileReader.toIntList("dnk.txt");


for(int i=0; i<ranks.size(); i++){
  player temp = new player(ranks.get(i),names.get(i),teams.get(i),ovrs.get(i),threes.get(i),dnks.get(i));
  players.add(temp);
  
  } 
  }

  

  /*
  *returns a 5 player team of the 5 best three point shooters in NBA2K
  */
  public ArrayList<player>  bestThreeTeam(){
    ArrayList<player> roster = new ArrayList<player>();
    roster.add(players.get(0));
    roster.add(players.get(1));
    roster.add(players.get(2));
    roster.add(players.get(3));
    roster.add(players.get(4));

   for(int outer =0; outer<players.size()-1; outer++){
    for(int inner =0; inner<roster.size(); inner++){
      if(players.get(outer).getThree() > roster.get(inner).getThree()){
      roster.set(inner, players.get(outer));
      inner =0;
        break;
      }
    }
  }
    return roster;
  }
   /*
  *returns a 5 player team of the 5 best dunking players in NBA2K
  */

   public ArrayList<player>  bestDnkTeam(){
    ArrayList<player> roster = new ArrayList<player>();
    roster.add(players.get(0));
    roster.add(players.get(1));
    roster.add(players.get(2));
    roster.add(players.get(3));
    roster.add(players.get(4));

   for(int outer =0; outer<players.size()-1; outer++){
    for(int inner =0; inner<roster.size(); inner++){
      if(players.get(outer).getDnk() > roster.get(inner).getDnk()){
      roster.set(inner, players.get(outer));
      inner =0;
        break;
      }
    }
  }
    return roster;
  }

   /*
  *returns a 5 player team of random players in NBA2K
  */
   public ArrayList<player> randomTeam(){
    ArrayList<player> roster = new ArrayList<player>();

   for(int i =0; i<5; i++){
    roster.add(players.get((int)(Math.random()*99)));
   }
    return roster;
  
}
   /*
  *returns the list of the top 100 player in nba 2k
  */
   public ArrayList<player> getPlayers(){
     return players;
   }

   /*
  *Returns a string of the winning team as well as the score
  *depending on the ratings found from the myRating() method.
  */
  public String playGame(ArrayList<player> roster1, ArrayList<player> roster2){
  int rating1=0;
  int rating2=0;
  String result="";
  int temp1=0;
  int temp2=0;
    System.out.println("Team 1: "+ player.printTeam(roster1)+ " \nTeam 2: "+ player.printTeam(roster2));
    temp1= (int)(Math.random()*20)+120;
    temp2= (int)(Math.random()*20)+120;
    if(temp1<=temp2){
      temp2=temp1-1;
    }
  for(int i = 0; i<5; i++){
    rating1+=player.myRating(roster1.get(i));
    rating2+=player.myRating(roster2.get(i));
  }
   if(rating1>rating2){
  result= "Team 1 won";
  }if(rating2>rating1){
  result ="Team 2 won";
  }
    return result + " with a score of " +temp1 +"-"+temp2;
  }
/*
  *
  */

  public void receiveRating(){
    Scanner input=new Scanner(System.in);
    System.out.println("Write about what you love about the NBA");
       ArrayList<String> keywords = FileReader.toStringList("keywords.txt");
        
      ArrayList<String> textList = new ArrayList<String>();
        String text = input.nextLine();
        for(int i = 0; i<textList.size()+1;i++){
          if(text.indexOf(" ")>-1){
          String temp=text.substring(0, text.indexOf(" "));//creates word
          if(temp.indexOf(",")>-1||temp.indexOf(".")>-1||temp.indexOf("!")>-1){
            temp=temp.substring(0, temp.length()-1);//creates word
          }
          text=text.substring(text.indexOf(" ")+1);
            textList.add(temp);//adds word
          }
        }
        if(text.indexOf(" ")==-1){
          if(text.indexOf(",")>-1||text.indexOf(".")>-1||text.indexOf("!")>-1){
             textList.add(text.substring(0, text.length()-1));          
               }else{
            textList.add(text);
               }
               

        }
        int rating = 0;
        int shooting = 0;
        int dunking = 0;
        int dribbling = 0;
        int defense = 0;
        int rebound = 0;
        String custom="";
        String custom2="";
        for(int out = 0; out<textList.size();out++){
          for( int in = 0; in<keywords.size();in++){
            //if textList element is found in keywords and is longer than 3 characters.
              if(textList.get(out).indexOf(keywords.get(in))>-1&&textList.get(out).length()>3){
            rating++;
            if(in==0||in==1){
              shooting++;
            }
            if(in==2){
              dunking++;

            }
            if(in>=3&&in<=7){
              dribbling++;

            }
              if(in>=8&&in<=11){
                defense++;

              }
            if(in>=12&&in<=13){
              rebound++;
}
           
            
          }
          }
        }
         if(shooting>dunking&&shooting>dribbling&&shooting>defense&&shooting>rebound){
               custom = "Wow seems like you love shooting. ";
            }
            if(dunking>shooting&&dunking>dribbling&&dunking>defense&&dunking>rebound){
               custom = "Wow seems like you love dunking. ";
            }
            if(dribbling>dunking&&dribbling>shooting&&dribbling>defense&&dribbling>rebound){
               custom = "Wow seems like you love dribbling. ";
            }
            if(defense>dunking&&defense>dribbling&&defense>shooting&&defense>rebound){
               custom = "Wow seems like you love defense. ";
            }
          if(rebound>dunking&&rebound>dribbling&&rebound>defense&&rebound>shooting){
               custom = "Wow seems like you love rebounding. ";
            }
            if(rating==0){
               custom2="You dont seem like too much of an NBA fan.";
            }
            if(rating>0&&rating<=5){
               custom2="You seem like a pretty profound NBA fan.";
            }
          if(rating>=6&&rating>=10){
             custom2="Wow! You are a huge NBA fan.";
          }
            if(rating>10){
               custom2="You might just be the biggest NBA fan alive!";
            }
        System.out.println(custom+custom2);

  }
}