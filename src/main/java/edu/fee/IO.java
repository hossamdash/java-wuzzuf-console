package edu.fee;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public static List<JobDetails> ReadCSVFile(String fileName) throws Exception {
        var jobDetailsList = new ArrayList<JobDetails>();
        CSVReader reader = new CSVReader(new BufferedReader(new FileReader("./Wuzzuf_Jobs.csv")));
        String[] attributes;
        // read the first line then continue
        if (reader.readNext() != null){

            while ((attributes = reader.readNext()) != null) {
                JobDetails jobDetails = createJobDetails(attributes);
                jobDetailsList.add(jobDetails);
            }
        }
        return jobDetailsList;
    }

    public static JobDetails createJobDetails(String[] metadata) {

        String title = metadata[0];
        String country = metadata[6];
        String level = metadata[4];
        String yearsOfExperience = metadata[5];

        // create and return job of this metadata
        return new JobDetails(title, country, level, yearsOfExperience);
    }
}
