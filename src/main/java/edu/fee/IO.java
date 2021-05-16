package edu.fee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {
    List<JobDetails> ReadCSVFile(String fileName) {
        var jobDetailsList = new ArrayList<JobDetails>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // read the first line from the text file which will be head column
            String line = br.readLine();
            // loop until all lines are read
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                //System.out.println("the line " + line);
                // use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                JobDetails jobDetails = createJobDetails(attributes);
                // adding jobDetails into ArrayList
                jobDetailsList.add(jobDetails);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return jobDetailsList;
    }
    public JobDetails createJobDetails(String[] metadata) {

        String title = metadata[0];
        String country = metadata[6];
        String level = metadata[4];
        String yearsOfExperience = metadata[5];

        // create and return Pyramid of this metadata
        return new JobDetails(title, country, level, yearsOfExperience);
    }
}
