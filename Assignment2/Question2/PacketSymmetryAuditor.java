package Assignment2.Question2;

public class PacketSymmetryAuditor {

    public static boolean auditSymmetry(String[] incomingPackets, String[] outgoingPackets) {
        if (incomingPackets.length != outgoingPackets.length) {
            return false;
        }

        TransactionStack stack = new TransactionStack(incomingPackets.length);
        RequestQueue queue = new RequestQueue(outgoingPackets.length);

        for (int i = 0; i < incomingPackets.length; i++) {
            stack.push(incomingPackets[i]);
            queue.enqueue(outgoingPackets[i]);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            String stackPacket = stack.pop();
            String queuePacket = queue.dequeue();

            if (!stackPacket.equals(queuePacket)) {
                return false;
            }
        }

        return true;
    }
}