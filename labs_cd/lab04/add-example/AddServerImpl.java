import java.rmi.*;
import java.rmi.server.*;
public class AddServerImpl extends UnicastRemoteObject
  implements AddServerIntf {

  public AddServerImpl() throws RemoteException {
  }
  public int add(int d1, int d2) throws RemoteException {
    return d1 + d2;
  }
  public double sub(double d1, double d2) throws RemoteException {
    return d1 - d2;
  }
  public double mult(double d1, double d2) throws RemoteException {
    return d1 * d2;
  }
  public double divi(double d1, double d2) throws RemoteException {
    return d1 / d2;
  }
}
