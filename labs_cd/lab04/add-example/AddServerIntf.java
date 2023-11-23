import java.rmi.*;
public interface AddServerIntf extends Remote {
  int add(int d1, int d2) throws RemoteException;
  double sub(double d1, double d2) throws RemoteException;
  double mult(double d1, double d2) throws RemoteException;
  double divi(double d1, double d2) throws RemoteException;
}
