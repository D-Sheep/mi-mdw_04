package rmi;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CurrencyManager {
	private static final List<String> currencies = (List<String>) Arrays.asList("EUR", "GBP", "USD");
	private HashMap<String, Double> rates = new HashMap<>();
	
	public CurrencyManager() {
		rates.put("EUR", 1.56);
		rates.put("GBP", 2.31);
		rates.put("USD", 1.0);
	}
	
	public double convert (String from, String to, double amount) throws InvalidParameterException {
		if (!currencies.contains(from)) {
			throw new InvalidParameterException("Unknown currency " + from);
		}
		if (!currencies.contains(to)) {
			throw new InvalidParameterException("Unknown currency " + to);
		}
		return amount * rates.get(from) / rates.get(to);
	}
	
	public List<String> getAvailableCurrencies() {
		return currencies;
	}
}
