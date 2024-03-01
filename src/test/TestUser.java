package edu.softwareeng.sample;

import java.io.File;


public class TestUser {
	
	private final CoordinatorImpl coordinator;

	public TestUser(CoordinatorImpl coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		String outputPath = "test1" + File.separatorChar + "testOutputFile.test";
		
		CoordinatorImpl coordinator = new CoordinatorImpl();
		coordinator.setSource(inputPath);
		boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);
		if (isSuccess) {
      			System.out.println("Computation completed successfully and results are written to " + destinationFilePath);
   		 } else {
      			System.err.println("Computation failed.");
   	 }
		
	}

}
