package ctr;

import java.util.concurrent.Semaphore;

public class Philosoph extends Thread{

	    private int number;
	    private SemaphoreGroup sems;
	    private int leftFork;
	    private int rightFork;

	    public Philosoph(int number, SemaphoreGroup sems){
	        this.number = number;
	        this.sems = sems;
	        this.leftFork = number;
	        if(number >= 4) {
	            this.rightFork = 0;
	        }else {
	            this.rightFork = number+1;
	        }
	    }

	    public void run(){
	        int[] deltas = new int[sems.getNumberOfMembers()];

	        for(int i = 0; i < deltas.length; i++) {
	            deltas[i] = 0;
	        }

	        while(true) {
	            try{
	                think(number);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            deltas[leftFork] = -1;
	            deltas[rightFork] = -1;

	            sems.changeValues(deltas);

	            try{

	                eat(number);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            deltas[leftFork] = 1;
	            deltas[rightFork] = 1;

	            sems.changeValues(deltas);

	            System.out.println(number + ": has eaten");
	        }
	    }


	    private void eat(int number) throws InterruptedException {

	        System.out.println("Philosoph eating: " + number );
	        //Thread.sleep(((int) (Math.random() *  1000)));
	        Thread.sleep(1000);
	    }

	    private void think(int number) throws InterruptedException {

	        System.out.println("Philosoph Thinking " + number);
	       //Thread.sleep(((int) (Math.random() *  1000)));
	        Thread.sleep(1000);
	    }


	}
