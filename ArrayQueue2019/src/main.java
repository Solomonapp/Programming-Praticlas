/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author x0v20
 */
public class main {
  public static void main(String[] args) {
      IntQueueMasking queue = new IntQueueMasking(7);
      queue.enQueue(1);
      queue.enQueue(2);
      queue.enQueue(3);
      queue.enQueue(4);
      queue.enQueue(5);
      queue.enQueue(6);
      System.out.println(queue.displayArray());
  }
}
