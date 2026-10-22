package Assignment2.Question1;

public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp,
                             double basePrice, double bidPrice,
                             double askPrice) {
        super(senderId, timestamp, basePrice);
            if (bidPrice <= 0 || askPrice <= 0 || bidPrice > askPrice) {
            throw new IllegalArgumentException("Invalid market quote");
        }
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;

        System.out.println("Reuters Market Quote");
        System.out.println("Sender ID: " + senderId);
        System.out.println("Bid Price: " + bidPrice);
        System.out.println("Ask Price: " + askPrice);
        System.out.printf("Bid-Ask Spread: %.2f%n", spread);
    }
}