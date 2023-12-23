package com.reliableWireless;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
	static String heartbeat_msg;
	SinkNode conected_cover;
	static Random rand = new Random();
	static ArrayList<SensorNode> nodes = new ArrayList<>();
	

	public static void main(String[] args) throws InterruptedException {
		
		// Example network with 10 nodes and simulation time of 100 intervals
		
		for (int i = 0; i < 10; i++) {
			SensorNode sensor = new SensorNode(i,"off",100);
			nodes.add(sensor);
			System.out.println(sensor.getNode_id()+", "+sensor.getState()+", "+sensor.getHearthbeat_index());
			
		}
	    SinkNode sink = new SinkNode();
	    for (int i = 0; i < sink.getSensors().length; i++) {
			sink.getSensors()[i]=nodes.get(i);
		}

	    // Simulate the RD-TTCP protocol
	    main_protocol(sink, nodes, nodes.size(), 1);
		
          

	}
	
	public static void activate(SensorNode sensore) {
		sensore.setState("on");
		
	}
	public static void deactivate(SensorNode sensore) {
		sensore.setState("off");
		
	}
	public static String send_heartbeat(SensorNode sensor) {
		String msg = "Heartbeat from Node "+sensor.getNode_id()+ "- Index "+sensor.getHearthbeat_index();
		heartbeat_msg = msg;
		
		return heartbeat_msg;
	}
	public void activate_cover(SinkNode sink,SensorNode[] sensor) {
		for (int i = 0; i < sensor.length; ++i) {
	        activate(sensor[i]);
	    }
	    // Copy activated cover to sink node's connected_cover
		for (int i = 0; i < sensor.length; ++i) {
	        sink.getSensors()[i] = sensor[i];
	    }

	}
	public static void check_heartbeats(SinkNode sink) {
	    for (int i = 0; i < sink.getSensors().length; ++i) {
	        SensorNode node = sink.getSensors()[i];
	        String heartbeat_msg = send_heartbeat(node);
	        System.out.println(heartbeat_msg);
	        // Process heartbeat message and check for failures
	        // ...
	    }
	}
	public static void main_protocol(SinkNode sink, ArrayList<SensorNode> nodes, int num_nodes, int simulation_time) throws InterruptedException {
		int currentDelay=0;
		int totalDelay=0;
		int totalCheckbeats =0;
		for (int interval = 0; interval < simulation_time; ++interval) {
	        for (int i = 0; i < num_nodes; ++i) {
	            // Activate nodes at the beginning of each interval
	            activate(nodes.get(i));
	            currentDelay=rand.nextInt()%6;
	            //To solve time issue
	            if(currentDelay <0) {
	            	currentDelay*=-1;
	            }
	            totalDelay+=currentDelay;
	            System.out.println("Delay time= "+currentDelay);
	            // Simulate communication and wait for ACK
	            TimeUnit.SECONDS.sleep(currentDelay);
	            // Receive ACK and send heartbeat
	            if (rand.nextInt() % 2 == 1) {
	                check_heartbeats(sink);
	                send_heartbeat(nodes.get(i));
	                totalCheckbeats++;
	                nodes.get(i).setHearthbeat_index(nodes.get(i).getHearthbeat_index()+1);
	            } else {
	                deactivate(nodes.get(i));
	            }
	        }
	        
	    }
		System.out.println("Total Check = "+totalCheckbeats+", Total Delay = "+totalDelay);
        for (int i = 0; i < num_nodes; i++) {
			System.out.println("Node"+i+", "+"ID = "+nodes.get(i).getNode_id()+", "+"State = "+nodes.get(i).getState().toString()+", "+"HearthBeat Index = "+nodes.get(i).getHearthbeat_index());
		}
	}
}
