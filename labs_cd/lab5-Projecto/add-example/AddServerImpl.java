import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class AddServerImpl extends UnicastRemoteObject
        implements AddServerIntf {




    public AddServerImpl() throws RemoteException {
    }

    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

    /*
      Reservarsombrinha
      A reserva é feita através da escolha da praia (A, B ou C),
      data e horário
      e do número de pessoas
      estando o utilizador autenticado.
      As reservas decorrem das 8:00 até às 20:00 por períodos de 1 hora.
    */
    public boolean Reservarsombrinha(PedidoClient p) throws RemoteException {
        if (p.nPessoas > 4)
            return false;
        return true;
    }
}
