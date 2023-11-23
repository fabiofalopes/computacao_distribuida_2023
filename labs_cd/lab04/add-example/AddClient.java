import java.rmi.*;
public class AddClient {
  public static void main(String args[]) {
    try {
      String addServerURL = "rmi://" + args[0] + "/AddServer";
      AddServerIntf addServerIntf =
                    (AddServerIntf)Naming.lookup(addServerURL);
      System.out.println("The first number is: " + args[1]);
      int d1 = Integer.valueOf(args[1]);
      System.out.println("The second number is: " + args[2]);

      int d2 = Integer.valueOf(args[2]);
      
      System.out.println("The sum is: " + addServerIntf.add(d1, d2));

      System.out.println("The sub is: " + addServerIntf.sub(d1, d2));

      System.out.println("The multiplication is: " + addServerIntf.mult(d1, d2));

      System.out.println("The division is: " + addServerIntf.divi(d1, d2));

    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}
