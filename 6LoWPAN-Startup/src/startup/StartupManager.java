package startup;

import java.sql.SQLException;

import org.eclipse.paho.client.mqttv3.MqttException;

import mqtt.MqttManager;

/**
 * @author Engin Leloglu - 2016
 * 
 * Startup Manager is a mediator class to control all the system.
 */
public class StartupManager {

	public StartupManager() throws MqttException {		
		new MqttManager(this);
	}

	public int notifyInsertion(String defaultId) throws SQLException {
		return DBManager.getInstance().insertIntoDB(defaultId);
	}
}
