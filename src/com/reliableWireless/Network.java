package com.reliableWireless;

import java.util.ArrayList;
import java.util.List;

public class Network {
     private List<SensorNode1> nodes;
	    private int simulation_time;

	    public Network(int num_nodes, int simulation_time) {
	        this.nodes = new ArrayList<>();
	        for (int node_id = 0; node_id < num_nodes; node_id++) {
	            this.nodes.add(new SensorNode1(node_id));
	        }
	        this.simulation_time = simulation_time;
	    }

	    public List<SensorNode1> getNodes() {
	        return nodes;
	    }

	    public int getSimulationTime() {
	        return simulation_time;
	    }

}
