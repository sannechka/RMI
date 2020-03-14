package RMIExample;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws NamingException, RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        // Context context = new InitialContext();
        //context.bind("rmi://localhost:1099/imath", new IMathImpl());
        try {
            registry.bind("chat", new IMathImpl());
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

interface IMath extends Remote {
    int add(int a, int b) throws RemoteException;
}

class IMathImpl extends UnicastRemoteObject implements IMath {
    protected IMathImpl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
