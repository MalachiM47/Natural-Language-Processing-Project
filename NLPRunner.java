import java.util.Scanner;
import java.util.ArrayList;

public class NLPRunner {
  public static void main(String[] args) {

  playerManager lebron = new playerManager();

Scanner input = new Scanner(System.in);
System.out.println("Select your activity \na:Create team\nb:Find player\nc:Play game\nd:Receive a fan rating");
String choice = input.nextLine();
  if(choice.equals("a")){
    ArrayList<String> Names = new ArrayList<String>();
    for(int i=0; i<lebron.getPlayers().size(); i++){
      Names.add(lebron.getPlayers().get(i).getName());
    }
    ArrayList<player> team = new ArrayList<player>();
    System.out.println("Create a team of 5 one by one by typing your players out in First Last notation.");
    for(int outer = 0; outer<6; outer++){
       if(team.size()==5){
          break;
       }
      String temp = input.nextLine();
       
         for(int i =0; i<Names.size(); i++){
      if(temp.equals(Names.get(i))){
        team.add(lebron.getPlayers().get(i));
        if(team.size()==5){
          break;
        }
      }
    }
    }
    System.out.println(player.printTeam(team));
    }else if(choice.equals("b")){
      System.out.println("How would you like to search?\na: By Name\nb: By Rank ");
      String choice2 = input.nextLine();
      if(choice2.equals("a")){
        System.out.println("Enter desired player in First Last notation");
          String name = input.nextLine();
           for(int i =0; i<lebron.getPlayers().size(); i++){
             if(name.equals(lebron.getPlayers().get(i).getName())){
               System.out.println(lebron.getPlayers().get(i).toString());
             }
           }
      }
    if(choice2.equals("b")){
      System.out.println("Enter desired players ranking");
      int rank = input.nextInt();
      for(int i =0; i<lebron.getPlayers().size(); i++){
             if(rank==lebron.getPlayers().get(i).getRank()){
               System.out.println(lebron.getPlayers().get(i).toString());
             }
           }
      
    }
      
    }
    if(choice.equals("c")){
      ArrayList<player> team1 = new ArrayList<player>();
      ArrayList<player> team2 = new ArrayList<player>();
      System.out.println("How would you like to organize the teams?\na:Choose the teams\nb:Randomize the teams");
      String choice2=input.next();
      if(choice2.equals("a")){
        System.out.println( "Create team 1\na:Best shooting team\nb:Best dunking team\nc:Customized team");
        String choice3=input.next();
        if(choice3.equals("a")){
          team1=lebron.bestThreeTeam();
        }
        if(choice3.equals("b")){
          team1=lebron.bestDnkTeam();
        }
        if(choice3.equals("c")){
          System.out.println("Enter five players in first last notation");
          for( int o = 0; o<=5; o++){
            String playerName=input.nextLine();
            for(int i =0; i<lebron.getPlayers().size(); i++){
              if(lebron.getPlayers().get(i).getName().equals(playerName)){
                team1.add(lebron.getPlayers().get(i));
              }
              }
            }
          
          }
         System.out.println( "Create team 2\na:Best shooting team\nb:Best dunking team\nc:Customized team");
        String choice4=input.next();
        if(choice4.equals("a")){
          team2=lebron.bestThreeTeam();
        }
        if(choice4.equals("b")){
          team2=lebron.bestDnkTeam();
        }
        if(choice4.equals("c")){
          System.out.println("Enter five players in first last notation");
          for( int o = 0; o<=5; o++){
            String playerName=input.nextLine();
            for(int i =0; i<lebron.getPlayers().size(); i++){
              if(lebron.getPlayers().get(i).getName().equals(playerName)){
                team2.add(lebron.getPlayers().get(i));
              }
              }
            }
          
          }
        }
      if(choice2.equals("b")){
        team1=lebron.randomTeam();
        team2=lebron.randomTeam();
      }
      System.out.println(lebron.playGame(team1, team2));
      }
      if(choice.equals("d")){
        lebron.receiveRating();
      }
    input.close();
  
    }


    
  }
