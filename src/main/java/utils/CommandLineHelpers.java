package utils;

import tests.TestSetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static tests.TestSetup.*;
import static tests.TestSetup.emulator;


public class CommandLineHelpers
{
	public void startServerSessionProgrammatically(String port)
	{
		try
		{
			startServer(port);
		}
		catch (IOException e)
		{
			System.out.println("There was exception trying to run the startServer method that start appium server ");
			e.printStackTrace();
		}
	}
	
	public static String getAvd(String emulator)
	{
		if (emulator.equals(CapabilitiesHelper.pixel3a))
		{
			return "emulator-5554";
		}
		else if (emulator.equals(CapabilitiesHelper.pixel3a_1))
		{
			return "emulator-5556";
		}
		else if (emulator.equals(CapabilitiesHelper.pixel3a_2))
		{
			return "emulator-5558";
		}
		else
			return null;
	}
	
	public static String emulatorPortsRange(String emulator)
	{
		String portsRange = null;
		if (emulator.equals(CapabilitiesHelper.pixel3a))
		{
			portsRange = "5554,5555";
		}
		else if (emulator.equals(CapabilitiesHelper.pixel3a_1))
		{
			portsRange = "5556,5557";
		}
		else if (emulator.equals(CapabilitiesHelper.pixel3a_2))
		{
			portsRange = "5558,5559";
		}
		return portsRange;
	}
	
	
	public static void startEmulator(String emulator)
	{
		try
		{
			ProcessBuilder pb = new ProcessBuilder("emulator", "-ports", emulatorPortsRange(emulator), "@" + emulator);
			Process proccess = pb.start();
			Scanner scan = new Scanner(proccess.getInputStream());
			scan.hasNext();
			scan.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void stopEmulator() throws IOException
	{
		if (!isIos)
		{
			switch (emulator)
			{
				case "emulator-5554":
					Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
					break;
				case "emulator-5556":
					Runtime.getRuntime().exec("adb -s emulator-5556 emu kill");
					break;
				case "emulator-5558":
					Runtime.getRuntime().exec("adb -s emulator-5558 emu kill");
					break;
			}
		}
	}
	
	
	public static void startIosSimulator(String emulatorName)
	{
		try
		{
			String udid = getUDID(emulatorName);
			new ProcessBuilder("xcrun", "instruments", "-w", udid).start().waitFor(60, TimeUnit.SECONDS);
//			Thread.sleep(10000); //Cannot check device launch
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void uninstallAppOnIos(String emulatorName, String appBundle) {
		try {
			String udid = getUDID(emulatorName);
			new ProcessBuilder("xcrun", "simctl", "uninstall", udid, appBundle).start().waitFor();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getUDID(String simName)
	{
		String t;
		try
		{
			Process proc = new ProcessBuilder("xcrun", "simctl", "list").start();
			BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			
			while ((t = input.readLine()) != null)
			{
				if (t.contains(simName + " (") && (t.contains("Shutdown") || t.contains("Booted")))
				{
					//                    if (t.split(" \\| ")[1].trim().equals(simName))
					String curr = t.split("\\(")[1].split("\\)")[0];
					return curr;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void startServer(String port) throws IOException
	{
//		killAppiumServerIfAlive(port);
		String bootstrapPort = Integer.toString(Integer.valueOf(port) + 1);
		if (!serverListening(Integer.parseInt(port)))
		{
			if (TestSetup.isIos)
			{
				System.out.println("before call proccess for starting appium for ios");
				try
				{
					new ProcessBuilder("appium", "-p", port).start();
				}
				catch (IOException e)
				{
					System.out.println("There was exception trying to start appium server for iOS ");
					e.printStackTrace();
				}
				System.out.println("after call proccess for starting appium for ios");
			}
			else
			{
				System.out.println("before call proccess for starting appium for android");
				try
				{
					new ProcessBuilder("appium", "-p", port, "--bootstrap-port", bootstrapPort).start();
				}
				catch (IOException e)
				{
					System.out.println("There was exception trying to start appium server for android ");
					e.printStackTrace();
				}
				System.out.println("after call proccess for starting appium for android");
			}
		}
		
		while (!serverListening(Integer.parseInt(port)))
		{
			System.out.println("Waiting for the server to listen");
			try
			{
				TimeUnit.MILLISECONDS.sleep(500);
			}
			catch (InterruptedException e)
			{
				System.out.println("There was exception on: Waiting for the server to listen ");
				e.printStackTrace();
			}
		}
		System.out.print("Appium Server Started on port: " + port + "\n");
	}
	
	public static void killAppiumServerIfAlive(String port) throws IOException
	{
		if (serverListening(Integer.parseInt(port)))
		{
			System.out.println("The server port: " + port + " is taken and should be killed !!!");
			//Kill proccess ( node - appium server) that is listening on the port
			Process p = Runtime.getRuntime().exec("lsof -t -i:" + port);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String pid;
			while ((pid = stdInput.readLine()) != null)
			{
				System.out.println("appium pid to kill: " + pid);
				try
				{
					System.out.println("trying to kill pid: " + pid);
					Runtime.getRuntime().exec("kill -9 " + pid).waitFor();
				}
				catch (InterruptedException e)
				{
					System.out.println("There was exception trying to kill pid: " + pid + " for holding port: " + port);
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Killed appium server on port: " + port);
		}
		// Wait for server to die
		while (serverListening(Integer.parseInt(port)))
		{
			System.out.println("Waiting for the server on port: " + port + " to die");
			try
			{
				TimeUnit.MILLISECONDS.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void stopServer(String port) throws IOException
	{
		killAppiumServerIfAlive(port);
	}
	
	public static boolean serverListening(int port)
	{
		Socket socket = null;
		try
		{
			socket = new Socket("127.0.0.1", port);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		finally
		{
			if (socket != null)
			{
				try
				{
					socket.close();
				}
				catch (Exception e)
				{
				}
			}
		}
	}
}

