package main;
import java.io.*;
import java.util.*;
import utility.*;

public class Main_DataAggresiveCV {

	public static void main(String[] args) throws Exception {
				
		// Parameter
		String type = args[0];
		int fold = Integer.parseInt(args[1]);

    	// Dataset
		String dataset = "plurk";

		// Timer start
		long startTime = (new Date()).getTime();
		System.out.println("Timer start ... ");

		// File names
    	String listFileName = "list/cv" + fold + "_" + type + ".txt";

    	// Split data
    	int[] concepts = Utility.loadIntegerArray(listFileName);
    	TreeSet<String> allSeeds = new TreeSet<String>();
    	for(int concept : concepts) {
    		System.out.print("Identifying concept " + concept + " ... ");
    		TreeSet<String> seeds = new TreeSet<String>();
    		String[] dn = Utility.loadStringArray("data/" + dataset + "_iii/cv" + fold + "/" + type + "/dn_" + concept + "_" + type + ".txt");
    		for(String d : dn) {
    			String[] t = d.split("\t");
    			seeds.add(t[0]);
    			allSeeds.add(t[0]);
    		}
    		PrintWriter pw = new PrintWriter("data/" + dataset + "_iii/cv" + fold + "/" + type + "/aggresive_" + concept + "_" + type + ".txt");
    		for(String s : seeds) {
    			pw.println(s);
    		}
    		pw.flush();
    		pw.close();
    		System.out.println("done.");
    	}
		PrintWriter pw = new PrintWriter("data/" + dataset + "_iii/cv" + fold + "/" + type + "/aggresive_all_" + type + ".txt");
		for(String s : allSeeds) {
			pw.println(s);
		}
		pw.flush();
		pw.close();

		// Timer stop
		long stopTime = (new Date()).getTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("Timer stop, elapsed seconds = " + elapsedTime/1000);
	}
}
