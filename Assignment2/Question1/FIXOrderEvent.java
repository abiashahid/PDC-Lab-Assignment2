package Assignment2.Question1;

public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp,
                         double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        double totalPrice = basePrice + fee;

        System.out.println("FIX Stock Purchase Order");
        System.out.println("Sender ID: " + senderId);
        System.out.println("Client Order ID: " + clOrdId);
        System.out.printf("Base Price: %.2f%n", basePrice);
        System.out.printf("Transaction Fee: %.2f%n", fee);
        System.out.printf("Total Price: %.2f%n", totalPrice);
    }
}