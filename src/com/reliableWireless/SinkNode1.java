package com.reliableWireless;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SinkNode1 {
    private List<SensorNode1> connected_cover;
    private int heartbeat_threshold;

    public SinkNode1() {
        this.connected_cover = new ArrayList<>();
        this.heartbeat_threshold = 3;
    }

    public void activateCover(List<SensorNode1> cover) {
        this.connected_cover = cover;
    }

    public void checkHeartbeats() {
        for (SensorNode1 node : this.connected_cover) {
            String heartbeatMsg = node.sendHeartbeat();
            System.out.println("Sink Node received: " + heartbeatMsg);
            // Process heartbeat message and check for failures
            // (This part can be implemented based on specific failure conditions)
        }
    }

    public void mainProtocol(Network network) {
        for (int interval = 0; interval < network.getSimulationTime(); interval++) {
            System.out.println("Interval: " + (interval + 1));
            for (SensorNode1 node : network.getNodes()) {
                System.out.println("Activating Node " + node.getNode_id());
                node.activate();

                // Simulate communication and wait for ACK
                int communicationDelay = new Random().nextInt(6);
                System.out.println("Communication delay for Node " + node.getNode_id() + ": " + communicationDelay + " seconds");
                try {
                    Thread.sleep(communicationDelay * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Receive ACK and send heartbeat
                if (new Random().nextBoolean()) {
                    this.checkHeartbeats();
                    String heartbeatSent = node.sendHeartbeat();
                    System.out.println("Heartbeat sent from Node " + node.getNode_id() + ": " + heartbeatSent);
                } else {
                    node.deactivate();
                    System.out.println("Node " + node.getNode_id() + " deactivated");
                }
            }
            System.out.println("-------------");
        }
    }

}
