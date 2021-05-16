package edu.fee;

import java.util.List;

public class TestWuzzufJobs {
    public static void test() throws Exception {
        List<JobDetails> jobs = IO.ReadCSVFile("./Wuzzuf_Jobs.csv");
        JobsDataService.filterJobsByCountry(jobs);
        JobsDataService.filterJobsByLevel(jobs);
        JobsDataService.filterJobsByTitle(jobs);
        JobsDataService.filterJobsByYearsExp(jobs);
    }
}
