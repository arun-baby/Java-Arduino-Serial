/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicaton;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

/**
 *
 * @author Arun
 */
public class ArduinoSerial {
    
    private SerialPort comPorts[], selectedPort;

    public ArduinoSerial() {
        comPorts = SerialPort.getCommPorts();
    }

    public SerialPort[] getComPorts() {
        return comPorts;
    }

    public void setComPorts(SerialPort[] comPorts) {
        this.comPorts = comPorts;
    }

    public SerialPort getSelectedPort() {
        return selectedPort;
    }

    public void setSelectedPort(SerialPort selectedPort) {
        this.selectedPort = selectedPort;
    }
    
    
    
}
