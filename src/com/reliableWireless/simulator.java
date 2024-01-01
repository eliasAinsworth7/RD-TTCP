package com.reliableWireless;

import java.util.List;

public class simulator {
    public static void main(String[] args) {
        // Creating a network with 10 nodes and simulating for 5 intervals
        int num_nodes = 10;
        int simulation_time = 5; // Reduced simulation time for demonstration purposes
        Network network = new Network(num_nodes, simulation_time);

        // Creating a sink node and activating the connected cover
        SinkNode1 sink_node = new SinkNode1();
        List<SensorNode1> connected_cover = network.getNodes().subList(0, 3); // Example: Using first 3 nodes as the connected cover
        sink_node.activateCover(connected_cover);

        // Executing the main protocol
        sink_node.mainProtocol(network);
    }
    
}
