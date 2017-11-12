package rmi;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.InvalidParameterException;
import java.util.List;
 
public class Server extends UnicastRemoteObject implements CurrencyInterface {
 
    private static final long serialVersionUID = 1L;
    private static CurrencyManager currencyManager;
 
    protected Server() throws RemoteException {
        super();
        currencyManager = new CurrencyManager();
    }
 
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Server server = new Server();
            Naming.rebind("//0.0.0.0/currency", server);
            System.out.println("Server started...");
 
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

	@Override
	public double convert(String from, String to, double amount) throws RemoteException, InvalidParameterException {
		return currencyManager.convert(from, to, amount);
	}

	@Override
	public List<String> getAvailableCurrencies() throws RemoteException {
		return currencyManager.getAvailableCurrencies();
	}
 
}