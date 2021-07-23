package baseballrecords;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BaseballRecords {
  public static void main(String [] args) {
    FinalMainPrgLevel4Hamdan obj = new FinalMainPrgLevel4Hamdan();
    obj.mainMenu();
  }
}
class PlayerClassHamdan {
  private String surname;
  private String givenName;
  private String position;
  private int height; 

  PlayerClassHamdan() {
    surname = "";
    givenName = "";
    position = "";
    height = -1;
  }
  PlayerClassHamdan(String surname, String givenName, String position, int height) {
    surname = "";
    givenName = "";
    position = "";
    height = -1;
  } 
  public String getSurname() {return surname;}
  public String getGivenName() {return givenName;}
  public String getPosition() {return position;}
  public int getHeight() {return height;}
  public void setSurname(String surname) {this.surname = surname;}
  public void setGivenName(String givenName) {this.givenName = givenName;}
  public void setPosition(String position) {this.position = position;}
  public void setHeight(int height) {this.height = height;}

  public void initializePlayer() {
    surname = "";
    givenName = "";
    position = "";
    height = -1;
  }
 
  public void assignValuePlayer(String surname, String givenName, String position, int height) {
    this.surname = surname;
    this.givenName = givenName;
    this.position = position;
    this.height = height;
  }
} 

class BaseballStatsHamdan extends PlayerClassHamdan {
  private int hits;
  private int atBats;
  private int singles;
  private int doubles;
  private int triples;
  private int homeRuns;
  BaseballStatsHamdan() {
    hits = -1;
    atBats = -1;
    singles = -1;
    doubles = -1;
    triples = -1;
    homeRuns = -1;
  }
  BaseballStatsHamdan(int hits, int atBats, int singles, int doubles, int triples, int homeRuns) {
    hits = -1;
    atBats = -1;
    singles = -1;
    doubles = -1;
    triples = -1;
    homeRuns = -1;
  }
  public int getHits() {return hits;}
  public int getAtBats() {return atBats;}
  public int getSingles() {return singles;}
  public int getDoubles() {return doubles;}
  public int getTriples() {return triples;}
  public int getHomeRuns() {return homeRuns;}
  public void setHits(int hits) {this.hits = hits;}
  public void setAtBats(int atBats) {this.atBats = atBats;}
  public void setSingles(int singles) {this.singles = singles;}
  public void setDoubles(int doubles) {this.doubles = doubles;}
  public void setTriples(int triples) {this.triples = triples;}
  public void setHomeRuns(int homeRuns) {this.homeRuns = homeRuns;}

  public void initializeBaseballStats() {
    hits = -1;
    atBats = -1;
    singles = -1;
    doubles = -1;
    triples = -1;
    homeRuns = -1;
  }

  public void setBaseballStats(int hits, int atBats, int singles, int doubles, int triples, int homeRuns) {
    this.hits = hits;
    this.atBats = atBats;
    this.singles = singles;
    this.doubles = doubles;
    this.triples = triples;
    this.homeRuns = homeRuns;
  }

  public double calculateBattingAverage() {return ((double)getHits()/getAtBats());}

  public Boolean checkStats() {
    if (getHits() == getSingles()+getDoubles()+getTriples()+getHomeRuns())
      return true;
    else
      return false;
  }

  public int correctStats() {return getSingles()+getDoubles()+getTriples()+getHomeRuns();}
}

class FinalMainPrgLevel4Hamdan {
  ArrayList <PlayerClassHamdan> data;
  FinalMainPrgLevel4Hamdan() {data = new ArrayList<PlayerClassHamdan>();}

  public void mainMenu() {
    Scanner in = new Scanner(System.in);
    int opt = -1;
    System.out.println("1. Load stats info from a file");
    System.out.println("9. Exit the program");
    do {
      while(!in.hasNextInt())
        in.next();
      opt = in.nextInt();
    } while(opt!=1 && opt!=9);
    if (opt == 1) {
      try{
        loadInformation();
      }catch(Exception a) {System.out.println(a.getMessage());}
      do {
        System.out.println();
        System.out.println("2. Display all players");
        System.out.println("3. Enter Players Height");
        System.out.println("4. Sort all players alphabetically by Surname");
        System.out.println("5. Sort all players by Batting Average");
        System.out.println("6. Delete a player by selecting the player's surname from the list");
        System.out.println("7. Add a player to the stats");
        System.out.println("8. Save stats to a file");
        System.out.println("9. Exit the program");
        while(!in.hasNextInt())
          in.next();
        opt = in.nextInt();
        switch(opt) {
          case 2:
            try{
            displayPlayerInfo();
          } catch(Exception b) {System.out.println(b.getMessage());}
            break;
          case 3:
            try{
            addDataHeight();
          }catch(Exception c) {System.out.println(c.getMessage());}
            break;
          case 4:
            try{
            sortDataAlpha();
          }catch(Exception d) {System.out.println(d.getMessage());}
            break;
          case 5:
            try{
            sortDataBattingAverage();
          }catch(Exception e) {System.out.println(e.getMessage());}
            break;
          case 6:
            try{
            deleteAPlayer();
          }catch(Exception f) {System.out.println(f.getMessage());}
            break;
          case 7:
            try{
            addAPlayer();
          }catch(Exception g) {System.out.println(g.getMessage());}
            break;
          case 8:
            try{
            saveInformation();
          }catch(Exception h) {System.out.println(h.getMessage());}
            break;
          case 9:
            System.out.println("Good-bye.");
            break;
        }
      } while (opt!=9);
    }
     else {
        opt = 9;
        System.out.println("Good-bye.");
     }
  }

  public void displayPlayerInfo() throws Exception{
    System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s","Surname", "GivenName", "Position", 
                      "Height(cm)", "Hits", "AtBAts", "Singles", "Doubles", "Triples", "HomeRuns", "Batting Average");
    for(int i = 0; i<data.size(); i++) {
      System.out.printf("%n%-13s%-13s%-13s%-13d%-13d%-13d%-13d%-13d%-13d%-13d%-13.3f",data.get(i).getSurname(),data.get(i).getGivenName(),
                        data.get(i).getPosition(),data.get(i).getHeight(),((BaseballStatsHamdan)data.get(i)).getHits(),
                        ((BaseballStatsHamdan)data.get(i)).getAtBats(),((BaseballStatsHamdan)data.get(i)).getSingles(),
                        ((BaseballStatsHamdan)data.get(i)).getDoubles(),((BaseballStatsHamdan)data.get(i)).getTriples(),
                        ((BaseballStatsHamdan)data.get(i)).getHomeRuns(),((BaseballStatsHamdan)data.get(i)).calculateBattingAverage());
    }
    System.out.println();
  }

  public void addDataHeight() throws Exception{
    Scanner in = new Scanner(System.in);
    int height = -1;
    System.out.println("Please enter the heights for the players(125-240cm):");
    for(int i = 0; i<data.size(); i++) {
      System.out.printf("%s %s's height is ",data.get(i).getGivenName(),data.get(i).getSurname());
      do {
        while(!in.hasNextInt())
          in.next();
        height = in.nextInt();
      } while (height<125||height>240);
      data.get(i).setHeight(height);
    }
  }

      public void sortDataAlpha() throws Exception{
        PlayerClassHamdan temp = new PlayerClassHamdan();
        for(int i = 0; i<data.size(); i++) {
          for(int j = 1; j<data.size()-i; j++) {
            if(data.get(j-1).getSurname().compareTo(data.get(j).getSurname())>0) {
              temp = data.get(j);
              data.set(j,data.get(j-1));
              data.set((j-1),temp);
            }
          }
        }
        System.out.println("Sorting Complete - select Display to view.");
      }

      public void sortDataBattingAverage() throws Exception{
        PlayerClassHamdan key = new PlayerClassHamdan();
        int j = -1;
        for(int i = 1; i<data.size(); i++) {
          j = i;
          key = ((BaseballStatsHamdan)data.get(i));
          while(j>0 && ((BaseballStatsHamdan)data.get(j-1)).calculateBattingAverage()< ((BaseballStatsHamdan)key).calculateBattingAverage()) {
            data.set(j,data.get(j-1));
            j--;
          }
          data.set(j,key);
        }
        System.out.println("Sorting Complete - select Display to view.");
      }

      public void deleteAPlayer() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the surname of the player you want to delete:");
        String surname = in.next();
        for(int i = 0; i<data.size(); i++) {
          if (surname.equals(data.get(i).getSurname())) {
            data.get(i).initializePlayer();
            ((BaseballStatsHamdan)data.get(i)).initializeBaseballStats();
            i = data.size();
            System.out.printf("%s has been deleted from the list and the record has been re-initialized.%n",surname);
          }
        }
      }

      public void addAPlayer() throws Exception{
        int height = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the player's:");
        System.out.println("surname:");
        String surname = in.next();
        System.out.println("given name:");
        String givenName = in.next();
        System.out.println("position:");
        String position = in.next();
        System.out.println("height:");
        do{
          while (!in.hasNextInt())
          in.next();
        height = in.nextInt();
        } while (height>240||height<125);
        System.out.println("hits:");
        while (!in.hasNextInt())
          in.next();
        int hits = in.nextInt();
        System.out.println("at bats:");
        while (!in.hasNextInt())
      in.next();
    int atBats = in.nextInt();
    System.out.println("singles:");
    while (!in.hasNextInt())
      in.next();
    int singles = in.nextInt();
    System.out.println("doubles:");
    while (!in.hasNextInt())
      in.next();
    int doubles = in.nextInt();
    System.out.println("triples:");
    while (!in.hasNextInt())
      in.next();
    int triples = in.nextInt();
    System.out.println("home runs:");
    while (!in.hasNextInt())
      in.next();
    int homeRuns = in.nextInt();
    data.add(0,new BaseballStatsHamdan());
    data.get(0).assignValuePlayer(surname,givenName,position,height);
    ((BaseballStatsHamdan)data.get(0)).setBaseballStats(hits,atBats,singles,doubles,triples,homeRuns);
    if (!((BaseballStatsHamdan)data.get(0)).checkStats()) {
      System.out.printf("The number of hits has been corrected, which is equal to %d.%n",((BaseballStatsHamdan)data.get(0)).correctStats());
      ((BaseballStatsHamdan)data.get(0)).setHits(((BaseballStatsHamdan)data.get(0)).correctStats());
    }
  }

  public void saveInformation() throws Exception{
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter a file name:");
    String fname = in.next() + ".txt";
    PrintWriter infile = new PrintWriter(fname);
    for(int i = 0; i<data.size(); i++) {
      infile.printf("%n%-13s%-13s%-13s%-13d%-13d%-13d%-13d%-13d%-13d%-13d",data.get(i).getSurname(),data.get(i).getGivenName(),
                        data.get(i).getPosition(),data.get(i).getHeight(),((BaseballStatsHamdan)data.get(i)).getHits(),
                        ((BaseballStatsHamdan)data.get(i)).getAtBats(),((BaseballStatsHamdan)data.get(i)).getSingles(),
                        ((BaseballStatsHamdan)data.get(i)).getDoubles(),((BaseballStatsHamdan)data.get(i)).getTriples(),
                        ((BaseballStatsHamdan)data.get(i)).getHomeRuns());
    }
    infile.close();
    System.out.println("Saving Complete.");
  }

  public void loadInformation() throws Exception{
    System.out.println("Loading...");
    File file = new File("PlayerInfo.txt");
    Scanner in = new Scanner(file);
    int i = 0;
    while(in.hasNext()){
      data.add(new BaseballStatsHamdan());
      data.get(i).assignValuePlayer(in.next(),in.next(),in.next(),in.nextInt());
      ((BaseballStatsHamdan)data.get(i)).setBaseballStats(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
      i++;
    }
    System.out.println("Complete.");
  }
} 

