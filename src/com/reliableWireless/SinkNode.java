package com.reliableWireless;

public class SinkNode {
	private SensorNode[] sensors = new SensorNode[10];
	private int hearthbeat_threshold;
	
	public SensorNode[] getSensors() {
		return sensors;
	}
	public void setSensors(SensorNode[] sensors) {
		this.sensors = sensors;
	}
	
	

}
