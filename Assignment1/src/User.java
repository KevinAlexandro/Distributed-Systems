import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class User 
{
	
	BlockingQueue outMessages1;
	BlockingQueue outMessages2;
	
	Socket clockwiseNeighbor;
	Socket counterClockwistNeighbor;
	
	HashSet messages;
	
	String myHost;
	int myPort;
	

	public static void main(String[] args, int argc) 
	{
		//main start all threads needed
		
		//after finishing set up
		System.out.println("Node started. -help for help");
		Scanner myReader = new Scanner(System.in);
		while (true) {
		    String userInput = myReader.nextLine();
		    String[] userInputArr = userInput.split(" "); //1st word before a space is the command

		    //possible commands: "-help" "-quit" "-send"
		    if (userInputArr[0].equalsIgnoreCase("-help")) {
			System.out.println("Possible commands: \n-help for help \n -send to send a message to everyone in the network \n -quit to leave the network");
		    }
		    if (userInputArr[0].equalsIgnoreCase("-send"))
		    {
			//1st system checks if the message is not empty.
			if (userInputArr.length <= 1)
			{
			    System.out.println("Error empty messages cannot be sent");
			}
			else
			{
			    //System starts thread and send message to both neighbors.

			    //message sent
			}
		    }

		    if (userInputArr[0].equalsIgnoreCase("-quit"))
		    {
			//all connections are closed and then program terminates

			//end of program. Node "dies"
			break;
		    }
        }

		

	}
	
	/*
	 * 0: MY user host name
	 * 1: MY user port number
	 * 2: CONNECTING NODES host name
	 * 3: CONNECTING NODES port number
	 */
	public void run(String[] args, int argc) throws IOException
	{
		this.outMessages1 = new ArrayBlockingQueue(1024);
		this.outMessages2 = new ArrayBlockingQueue(1024);
		
		this.clockwiseNeighbor = new Socket();
		this.counterClockwistNeighbor = new Socket();
		
		
		this.messages = new HashSet();
		
		this.myHost = args[0];
		this.myPort= Integer.parseInt(args[1]);
		
		ServerSocket listener = new ServerSocket(this.myPort);
		
		// If more than 2 arguments is passed in, it means this 
		//	user want't to connect to an existing network.
		if(argc == 4)
		{
			if(addMyselfToNetwork(args[2], Integer.parseInt(args[3]), listener))
			{
				System.err.println("Failed to add myself to the network");
			}
			else
			{
				// Both nodes have been connected and now the classes can be instantiated.
				
			}
		}
		
		
	}
	
	private boolean addMyselfToNetwork(String connectingHost, int connectingPort, ServerSocket listener)
	{
		try{
			// Establish a socket with the node we want to enter into the network 
			this.clockwiseNeighbor = new Socket(connectingHost, connectingPort);
			
			// Start listening for the connecting node to make the moves to connect
			this.counterClockwistNeighbor = listener.accept();

			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	private class Sender implements Runnable
	{

		@Override
		public void run() 
		{
			
		}
		
	}
	
	private class Receiver implements Runnable
	{

		@Override
		public void run() 
		{
			
		}
		
	}

}
