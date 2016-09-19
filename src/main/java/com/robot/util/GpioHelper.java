package com.robot.util;

import com.pi4j.io.gpio.*;

/**
 * 
 *@author panlunyou
 *@date 2016年9月8日下午2:08:42
 *@version 1.0
 */
public class GpioHelper {
    private static final GpioController gpio = GpioFactory.getInstance ();

    public static GpioPinDigitalOutput getDigitalOutputPin (int index) {
        try {
            String name = String.format ("GPIO_%02d", index);
            Pin pin = (Pin) RaspiPin.class.getField (name).get (null);
            return gpio.provisionDigitalOutputPin (pin, name, PinState.LOW);
        } catch (Exception ex) {
            throw new RuntimeException (ex);
        }
    }
    
    public static void main(String[] args) {
    	 System.out.println(String.format ("GPIO_%02d", 33));
	}
}