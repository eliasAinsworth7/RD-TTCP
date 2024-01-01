package com.reliableWireless;

public class SensorNode1 {
    private int node_id;
    private String state;
    private int heartbeat_index;

    public SensorNode1(int node_id) {
        this.node_id = node_id;
        this.state = "off";
        this.heartbeat_index = 0;
    }

    public void activate() {
        this.state = "on";
    }

    public void deactivate() {
        this.state = "off";
    }

    public String sendHeartbeat() {
        this.heartbeat_index += 1;
        return "Heartbeat from Node " + this.node_id + " - Index " + this.heartbeat_index;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

}
