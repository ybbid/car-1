package com.robot.web;

import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * 
 * @author panlunyou
 * @date 2016年9月9日下午4:01:36
 * @version 1.0
 */
public class StartCar {

	private static GpioPinDigitalOutput pin0, pin1, pin2, pin3;

	static final GpioController gpio = GpioFactory.getInstance();

	public static void main(String[] args) {

		pin0 = getDigitalOutputPin(11);
		pin1 = getDigitalOutputPin(12);
		pin2 = getDigitalOutputPin(13);
		pin3 = getDigitalOutputPin(14);

		while (true) {
			Scanner x = new Scanner(System.in);// 构造一个Scanner对象，其传入参数为System.in
			System.out.print("请输入 前进A 后退 D");
			String key = x.next();
			if (key.equals("w")) {
				forward();
				
			}
			
			if (key.equals("a")) {
				left();
				
			}
			if (key.equals("d")) {
				right();
				
			}
			

			if (key.equals("s")) {
				backward();
				
			}

			if (key.equals("q")) {
				stop();
			}

		}

	}

	/**
	 * 获取 gpid
	 */
	public static GpioPinDigitalOutput getDigitalOutputPin(int index) {
		try {
			String name = String.format("GPIO_%02d", index);
			Pin pin = (Pin) RaspiPin.class.getField(name).get(null);
			return gpio.provisionDigitalOutputPin(pin, name, PinState.LOW);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 前进
	 */
	public static void forward() {
		pin0.high();
		pin1.low();
		pin3.high();
		pin2.low();

	}

	/*
	 * 后退
	 */
	public static void backward() {
		pin0.low();
		pin1.high();

		pin3.low();
		pin2.high();
	}
	/*
	 * 停止
	 */

	public static void stop() {
		pin0.low();
		pin1.low();
		pin2.low();
		pin3.low();
	}

	/*
	 * 左转弯
	 */

	public static void left() {
		pin0.low();
		pin1.low();
		pin2.high();
		pin3.low();
	}

	/*
	 * 右转弯
	 */

	public static void right() {
		pin0.high();
		pin1.low();
		pin2.low();
		pin3.low();

	}

}
