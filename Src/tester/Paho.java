package tester;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class Paho {

	static MqttClient client;
	static MqttConnectOptions options;

	public Paho() {
	}

	public static void doPub(String msg, String host, String topic) {
		try {
			client = new MqttClient(host, "pahomqttpublish1");
			options = new MqttConnectOptions();
			options.setCleanSession(true);
			client.connect(options);
			MqttMessage message = new MqttMessage();
			message.setPayload(msg.getBytes());
			message.setQos(0);
			client.publish(topic, message);
			client.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}