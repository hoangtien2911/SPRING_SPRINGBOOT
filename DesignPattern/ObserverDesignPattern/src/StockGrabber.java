import java.util.ArrayList;

public class StockGrabber implements Subject{
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aapPrice;
	private double googPrice;
	public StockGrabber() {
		observers = new ArrayList<Observer>();
	}
	
	

	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}



	public void setAapPrice(double aapPrice) {
		this.aapPrice = aapPrice;
		notifyObserver();
	}



	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}



	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		System.out.println("Observer " + (observerIndex + 1) + " deleted");
		observers.remove(observerIndex);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(ibmPrice, aapPrice, googPrice);
		}
		
	}
	
	

}
