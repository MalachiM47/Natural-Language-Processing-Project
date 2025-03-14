import java.util.ArrayList;
public class player{

  //instance variables
  private int rank;
  private String name;
  private String team;
  private int ovr;
  private int three;
  private int dnk;


  //constructor
  public player(int rank,String name, String team, int ovr, int three, int dnk){
    this.rank = rank;
    this.name = name;
    this.team = team;
    this.ovr = ovr;
    this.three = three;
    this.dnk = dnk;
  }
 /*
  *toString method that returns a string of a player object
  *this includes their rank, overall, three point rating, dunk rating, and team they play for.
  */
  public String toString(){
    return name + " has a rank of number "+ rank + " with an overall rating of "+ ovr + ", a three point rating of "+ three + ", and a dunk rating of "+ dnk+ ". He plays for "+ team+".";
  }
   /*
  *Getter methods for the instance variables of rank, name, team, ovr, three, and dnk
  */
  public int getRank(){
    return rank;
  }
  public String getName(){
    return name;
  }
  public String getTeam(){
    return team;
  }
  public int getOvr(){
    return ovr;
  }
  public int getThree(){
    return three;
  }
  public int getDnk(){
    return dnk;
  }

   /*
  *Static method that prints aspects of a 5 man team
  *this includes each players name and best attribute between dunk and three point.
  */
  public static String printTeam(ArrayList<player>roster){
    String[] ratingType = new String[5];
    int[] rating = new int[5];
    for(int i = 0; i<roster.size(); i++){
      if(roster.get(i).getThree()>roster.get(i).getDnk()){
        ratingType[i]= "Three";
        rating[i]= roster.get(i).getThree();
      }else{
        ratingType[i]= "Dunk";
        rating[i]= roster.get(i).getDnk();
      }
    }
     return roster.get(0).getName()+" "+ rating[0]+ " "+ ratingType[0]+ ", "+roster.get(1).getName()+" "+ rating[1]+ " "+ ratingType[1]+", "+roster.get(2).getName()+" "+ rating[2]+ " "+ ratingType[2]+", "+roster.get(3).getName()+" "+ rating[3]+ " "+ ratingType[3]+", "+roster.get(4).getName()+" "+ rating[4]+ " "+ ratingType[4]+"\n A rating of: "+ (player.myRating(roster.get(0))+player.myRating(roster.get(1))+player.myRating(roster.get(2))+ player.myRating(roster.get(3))+ player.myRating(roster.get(4)));
  }

   /*
  *returns an int of the the player object passed through the parameters
  *this int is a sum of their ovr, dnk, and three.
  */
  public static int myRating(player guy){
    return guy.getDnk()+guy.getThree()+guy.getOvr();
  }
}

    