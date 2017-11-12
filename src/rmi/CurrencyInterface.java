package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CurrencyInterface extends Remote {
	public double convert(String from, String to, double amount) throws RemoteException;
	public List<String> getAvailableCurrencies() throws RemoteException;
}
