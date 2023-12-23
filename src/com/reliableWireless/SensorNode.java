package com.reliableWireless;

public class SensorNode {
	private int node_id;
	private String state;
	private int heartbeat_index;
	private int numberOfHeartbeatMsgRecieved;
	
	public SensorNode(int id, String stat, int heartbeatIndex) {
		node_id = id;
		state = stat;
		heartbeat_index=heartbeatIndex;
	}
	
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public int getnumberOfHeartbeatMsgRecieved() {
		return numberOfHeartbeatMsgRecieved;
	}
	public void setnumberOfHeartbeatMsgRecieved(int numberOfHeartbeatMsgRecieved) {
		this.numberOfHeartbeatMsgRecieved = numberOfHeartbeatMsgRecieved;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getHearthbeat_index() {
		return heartbeat_index;
	}
	public void setHearthbeat_index(int hearthbeat_index) {
		this.heartbeat_index = hearthbeat_index;
	}
	

}
