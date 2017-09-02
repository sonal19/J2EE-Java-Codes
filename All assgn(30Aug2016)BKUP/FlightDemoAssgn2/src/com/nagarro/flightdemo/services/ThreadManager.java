package com.nagarro.flightdemo.services;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.flightdemo.threads.DirectoryWatcher;

public class ThreadManager {
	
	public static void threadManager(){
		TimerTask task = new DirectoryWatcher(".", "csv" ) {
		      protected void onChange( File file, String action ) {
		        // here we code the action on a change
		        System.out.println
		           ( "File "+ file.getName() +" action: " + action );
		      }
		    };

		    Timer timer = new Timer();
		    timer.schedule( task , new Date(), 1000 );
	}

}
