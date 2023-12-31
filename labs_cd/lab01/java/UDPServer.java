import java.io.*; 
import java.net.*; 
  
class UDPServer { 
  public static void main(String args[]) throws Exception 
    { 
     try
     { 
      DatagramSocket serverSocket = new DatagramSocket(9876); 
  
      byte[] receiveData = new byte[1024]; 
      byte[] sendData  = new byte[1024]; 
      
      while(true) 
        { 
  
          receiveData = new byte[1024]; 

          DatagramPacket receivePacket = 
             new DatagramPacket(receiveData, receiveData.length); 

          System.out.println ("Waiting for datagram packet");

          serverSocket.receive(receivePacket); 

          String sentence = new String(receivePacket.getData()); 
  
          InetAddress IPAddress = receivePacket.getAddress(); 
  
          int port = receivePacket.getPort(); 
  
          System.out.println ("From: " + IPAddress + ":" + port);
          System.out.println ("Message: " + sentence);

          String capitalizedSentence = sentence.toUpperCase(); 

          sendData = capitalizedSentence.getBytes(); 
  
	  DatagramPacket sendPacket = null;
	 
	  if (sentence.trim().equals("Ola")){
	      byte[] sendData2  = new byte[1024];
	      String s = "ADEUS";
	      sendData2 = s.getBytes();
	      
	      sendPacket =  new DatagramPacket(sendData2, sendData2.length, IPAddress, port); 
	  }
	  else{
	      sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); 

	  }
	  serverSocket.send(sendPacket); 
        } 

     }
      catch (SocketException ex) {
        System.out.println("UDP Port 9876 is occupied.");
        System.exit(1);
      }

    } 
}  

