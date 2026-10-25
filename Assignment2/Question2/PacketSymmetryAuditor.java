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

    public static void main(String[] args) {
        System.out.println("=== Network Packet Symmetry Auditor ===");

        String[] incoming = {"PKT_A", "PKT_B", "PKT_C"};
        String[] outgoing = {"PKT_C", "PKT_B", "PKT_A"};

        System.out.println("Auditing symmetry between incoming and outgoing streams...");
        boolean isSymmetrical = auditSymmetry(incoming, outgoing);

        System.out.println("Audit Result - Packet Streams Symmetrical: " + isSymmetrical);
    }
}