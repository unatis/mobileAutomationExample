package utils;

import org.testng.IExecutionListener;

import java.io.IOException;
import java.io.PrintStream;

import static tests.TestSetup.*;

public class Listener implements IExecutionListener
{
    
    @Override
	public void onExecutionStart()
	{
	}
	
	
	@Override
	public void onExecutionFinish()
	{
		if (!isIos)
		{
			ProcessBuilder pb;
			System.out.println("In the Listener onExecutionFinish() trying to kill emulator " + CommandLineHelpers.getAvd(emulator));
			pb = new ProcessBuilder("adb", "-s", CommandLineHelpers.getAvd(emulator), "emu", "kill");
			try
			{
				pb.start();
//                CommandLineHelpers.stopServer(port);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
