
public class GrabStocks {
	public static void main(String[] args) {
		StockGrabber stockGrabber = new StockGrabber();
		
		StockObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setIbmPrice(192.3);
		stockGrabber.setAapPrice(122);
		stockGrabber.setGoogPrice(212);
		
		stockGrabber.unregister(observer1);
		
		
		StockObserver observer2 = new StockObserver(stockGrabber);
		
		stockGrabber.setIbmPrice(1922.3);
		stockGrabber.setAapPrice(1222);
		stockGrabber.setGoogPrice(2122);
		
	}
}
