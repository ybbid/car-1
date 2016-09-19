package com.robot.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  汽车远程操作  
 *@author panlunyou
 *@date 2016年9月10日下午4:13:47
 *@version 1.0
 */
public class CarSoket {
	
	
private int port=4466;
private ServerSocket ss;  
private InputStreamReader inputStreamReader;   
private BufferedReader bufferedReader;  
	
  public CarSoket(){};
  public CarSoket(int port){this.port=port;}

	 public void server(){  
		  
	        try {  
	            if (ss==null) {  
	                 ss = new ServerSocket(port);  
	                 System.out.println(".......................服务器启动.............监听端口"+port);  
	            }  
	              
	            //服务器无穷的循环等待客户端的请求  
	            while(true){      
	            Socket s = ss.accept();  
	            inputStreamReader = new InputStreamReader(s.getInputStream());  
	            bufferedReader = new BufferedReader(inputStreamReader);  
	            String request = bufferedReader.readLine();  
	            System.out.println("接收到了客户端的请求:"+request);  
	           /* PrintWriter printWriter = new PrintWriter(s.getOutputStream());  
	            String advice = "I am Server";  
	            printWriter.println(advice);  
	            printWriter.close();  */
	              
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  

}
	 
	 public void go() throws UnknownHostException, IOException{
         
	        //向服务器端发送请求，服务器IP地址和服务器监听的端口号  
	        Socket client = new Socket("127.0.0.1", port);  
	          
	       //通过printWriter 来向服务器发送消息  
	        PrintWriter printWriter = new PrintWriter(client.getOutputStream());  
	        System.out.println("连接已建立...");  
	        printWriter.println("112233");  
	        printWriter.flush();  
	        /* InputStreamReader streamReader = new InputStreamReader(client.getInputStream());  
	       //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder  
	        BufferedReader reader = new BufferedReader(streamReader);  
	        String advice =reader.readLine();  
	        System.out.println("接收到服务器的消息 ："+advice);  
	        reader.close();  */
	    }  
	 
	 
	 public static void main(String[] args) throws UnknownHostException, IOException {
		
		        CarSoket server = new CarSoket();  
		       // server.server();  
		        server.go();
		        
	}
}
