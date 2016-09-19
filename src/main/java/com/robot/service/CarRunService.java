package com.robot.service;

import org.springframework.stereotype.Service;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.robot.util.GpioHelper;


/**
 * 汽车实现类
 *@author panlunyou
 *@date 2016年9月9日下午3:52:18
 *@version 1.0
 */
@Service
public class CarRunService {

	private GpioPinDigitalOutput pin1, pin2, pin3, pin4;
	private int speed = 3;
	public static final int MAX_SPEED = 5, MIN_SPEED = 0;

	public CarRunService() {
	};

	public CarRunService(int pin1, int pin2, int pin3, int pin4) {
		this(GpioHelper.getDigitalOutputPin(pin1), GpioHelper.getDigitalOutputPin(pin2),
				GpioHelper.getDigitalOutputPin(pin3), GpioHelper.getDigitalOutputPin(pin4)

		);
	}

	public CarRunService(GpioPinDigitalOutput pin1, GpioPinDigitalOutput pin2, GpioPinDigitalOutput pin3,
			GpioPinDigitalOutput pin4) {
		this.pin1 = pin1;
		this.pin2 = pin2;
		this.pin3 = pin3;
		this.pin4 = pin4;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < MIN_SPEED)
			speed = MIN_SPEED;
		if (speed > MAX_SPEED)
			speed = MAX_SPEED;
		this.speed = speed;

	}

	public void forward() {
		pin1.high();
		pin2.low();
		pin4.high();
		pin3.low();
	}

	public void backward() {
		pin1.low();
		pin2.high();
		pin4.low();
		pin3.high();
	}

	public void stop() {
		pin1.low();
		pin2.low();
		pin3.low();
		pin4.low();
	}
	
	/*
	 * 左转弯
	 */

	public   void left() {
		/*pin0.low();
		pin1.low();*/
		pin1.setShutdownOptions(false);
		pin2.setShutdownOptions(false);
		pin3.low();
		pin4.low();
	}
	
	
	
	
	/*
	 * 右转弯
	 */

	public   void right() {
		pin1.high();
		pin2.high();
		/*pin2.low();
		pin3.low();*/
		pin3.setShutdownOptions(false);
		pin4.setShutdownOptions(false);
	}
	
	
	
	
	

	public void dispose() {
		pin1.low();
		pin2.low();
		pin3.low();
		pin4.low();
	}

}
