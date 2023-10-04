package com.hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
  static Hippodrome game;
  private List<Horse> horses;

  public Hippodrome(List<Horse> horses) {
    this.horses = horses;
  }

  public List<Horse> getHorses() {
    return horses;
  }

  public void run() {
    for (int i = 1; i <= 100; i++) {
      move();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      print();
    }
  }

  public void move() {
    for (Horse horse : horses) {
      horse.move();
    }
  }

  public void print() {
    for (Horse horse : horses) {
      horse.print();
    }
    for (int i = 0; i < 10; i++) {
      System.out.println();
    }
  }

  public Horse getWinner() {
    Horse winner = horses.get(0);
    for (Horse horse : horses) {
      if (winner.getDistance() < horse.getDistance()) {
        winner = horse;
      }
    }
    return winner;
  }

  public void printWinner() {
    System.out.println("The winner is " + getWinner().getName() + "!");
  }

  public static void main(String[] args) {
    Horse horse1 = new Horse("Slevin", 3, 0);
    Horse horse2 = new Horse("Lucky", 3, 0);
    Horse horse3 = new Horse("Homer", 3, 0);
    List<Horse> horseList = new ArrayList<>();
    horseList.add(horse1);
    horseList.add(horse2);
    horseList.add(horse3);
    game = new Hippodrome(horseList);
    game.run();
    game.printWinner();
  }
}
