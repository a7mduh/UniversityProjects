import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class Company_Account {
	private static int balance=100; //initial balance
	private static int users_num=10; //number of users
	private static int user_counter=0; //this to keep a track of number of all the writers who wrote
	private static int readers=0; //active number of readers
	private static int writers=0; //active number of writers
	private static ReentrantLock mutex = new ReentrantLock(); //mutex to control the critical section
    private static Scanner s=new Scanner(System.in); //Scanner object to take number of readers
    private static int thread_counter=0; //counting number of all the finished threads to make sure we dont print the balance until we finished all the threads
    private static int deposits=7;//this variable indicates number of deposits to split the loops for deposits and withdraws
    public static void deposit(int amount) throws InterruptedException //deposit function 
	{
    	mutex.lock();
    	writers++; //increasing number of active writers
		balance+=amount; //updating the balance
		System.out.println("User "+(++user_counter)+" deposited "+ amount+", Writiers: "+writers+", Readers: "+readers); 
		thread_counter++;//printing data
		writers--; //decrementing number of active writers
		mutex.unlock();
	}
	public static void withdraw(int amount) throws InterruptedException //withdraw function
	{
		mutex.lock();
		writers++;//increasing number of active writers
		if (amount > balance) //checking if the bank account has enough balance
			System.out.println("User "+(++user_counter)+" Insufficient amount!");
		
		else
		{
			balance-=amount; //updating the balance
			System.out.println("User "+(++user_counter)+" withdrawed "+ amount+", Writiers: "+writers+", Readers: "+readers);
		}
		writers--; //decrementing number of active writers
		thread_counter++;
		mutex.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread[] users=new Thread[users_num]; //threads for users
		
		for (int i=0; i<deposits; i++) 
		{
			users[i]=new Thread(new Runnable() { //initializing each thread for deposits
				public void run()
				{
					try
					{
	                	deposit(5);
					}
					catch (InterruptedException e)
					{
						System.out.println(e.toString());
					}
				}
			});
		}
			
		
		
		  for (int i=deposits; i<users_num; i++) { 
			  users[i]=new Thread(new Runnable() { 
				  public void run() { //initializing each thread for withdraws
					  try { 
						  withdraw(30);  } 
					  catch (InterruptedException e) { 
						  System.out.println(e.toString()); 
					  } } });
		  }
		do //asking for number of readers (task 2)
		{
			System.out.println("Please enter the number of readers, enter 0 if you want no readers:");
			readers=s.nextInt();
			if (readers>0)
			{
				System.out.println("The balace is: "+ balance+", Number of readers: "+readers+", Number of writers: "+writers);
				System.out.println("Cannot execute the writing processes, please change the number of readers to 0 if you want to write");
				System.out.println();
				System.out.println();
				System.out.println("-------------------------------------------------------");
				System.out.println();
				System.out.println();
			}
			else
			{
				System.out.println("No Readers, executing writing processes..");
				System.out.println();
				System.out.println();
				System.out.println("-------------------------------------------------------");
				System.out.println();
				System.out.println();
			}
				
		}while(readers>0);
		
		for (int i=0; i<deposits; i++) //executing all the deposit threads
		{
			users[i].start(); //executing the threads
		}
		
		while(thread_counter!=deposits); //making sure that all the deposits executed successfully 
		
		for (int i=deposits; i<users_num; i++) //executing all the withdraws threads
		{
			users[i].start(); //executing the threads
		}
		
		while(thread_counter!=users_num); //making sure that all the threads exectued successfully
		System.out.println("Final balance: "+balance); //printing the final balance
		
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.println("Please enter the number of readers, or 0 to exit:"); //asking for the readers after writing
		readers=s.nextInt();
		if (readers>0)
		{
			System.out.println("The balace is: "+ balance+", Number of readers: "+readers+", Number of writers: "+writers);
						System.out.println();
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
		}
		else
		{
			System.out.println("No Readers, Goodbye!!!");
			System.out.println();
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
		}
	}
}
