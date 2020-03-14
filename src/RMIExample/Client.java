package RMIExample;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;
import java.util.Locale;

public class Client {
    public static void main(String[] args) throws NamingException, RemoteException {
        Registry registry = LocateRegistry.getRegistry(1099);
       try {
           //IMath iMath = (IMath) registry.lookup("rmi://localhost:1099/imath");
          IMath remote = (IMath)registry.lookup("chat");
           int result = remote.add(1, 2);
            System.out.println(result);


       } catch (NotBoundException e) {
           e.printStackTrace();
//            IMath imath = (IMath) context.lookup("rmi://localhost/");
//            int result = imath.add(1, 2);
//            System.out.println(result);

        }
        // Context context = new InitialContext();

//        Enumeration<NameClassPair> e = context.list("rmi://localhost/");
//        while (e.hasMoreElements())
//        {
//            System.out.println(e.nextElement().getName());
//            IMath imath = (IMath) context.lookup("rmi://localhost/");
//            int result = imath.add(1, 2);
//            System.out.println(result);
//        }
    }
}