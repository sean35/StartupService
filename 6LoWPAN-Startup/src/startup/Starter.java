package startup;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author Engin Leloglu - 2016
 *
 * Starter is used only start the application!
 */
public class Starter {

	public static void main(String[] args) throws MqttException {
		
		new StartupManager();
	}

}
