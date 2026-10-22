package Assignment2.Question1;

public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("Trading Engine Starting...");

        // Polymorphic Reference for FIX Order
        TradeEvent fixEvent = new FIXOrderEvent("SENDER_01", System.currentTimeMillis(), 1500.0, "ORD_9912");
        fixEvent.dispatch();
    }
}