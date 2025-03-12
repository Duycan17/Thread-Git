package org.example.racecondition;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        Thread thread1 = new Thread1(container);
        Thread thread2 = new Thread(new Thread2(container));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
//        Trying to add synchronized keyword in Container and see the result again
        System.out.println("Value of a: " + container.getA());
    }
}