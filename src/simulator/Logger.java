package src.simulator;

import java.io.*;

public class Logger {
	private static Logger logger = new Logger();
    private static File file;
    private static PrintWriter writer;

    public Logger() {
    	try {
	    	file = new File("./src/simulator/simulation.txt");
	    	writer = new PrintWriter(file);
    	} catch (IOException e) {
            e.printStackTrace();
    	}
    }

    public static void writeOutput(String message) {
    	System.out.println(message);
    	writer.println(message);
    }
    
    public static void closeWriter() {
    	writer.close();
    }
}
