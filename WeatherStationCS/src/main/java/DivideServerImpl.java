import java.rmi.*;
import java.rmi.server.*;

public class DivideServerImpl extends UnicastRemoteObject implements DivideServer {

    protected DivideServerImpl() throws RemoteException {
    }

    public double divide(double d1, double d2) throws RemoteException {
        return d1 / d2;
    }
}