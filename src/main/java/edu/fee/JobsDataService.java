package edu.fee;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JobsDataService {

    private interface AtterSupplier {
        String getAtter(JobDetails from);
    }

    public static void filterJobsByTitle(List<JobDetails> jobs) {
        // countFrequencies(jobs, new Function<JobDetails,String>(){

        // @Override
        // public String apply(JobDetails t) {
        // return t.getTitle();
        // }

        // });
        countFrequencies(jobs, (JobDetails job) -> {
            return job.getTitle();
        });
    }

    public static void filterJobsByCountry(List<JobDetails> jobs) {

    }

    public static void filterJobsByLevel(List<JobDetails> jobs) {

    }

    public static void countFrequencies(List<JobDetails> jobs, Function<JobDetails, String> getter) {
        // hashmap to store the frequency of element
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (JobDetails job : jobs) {
            String string = getter.apply(job);
            Integer i = hm.get(string);
            hm.put(string, (i == null) ? 1 : i + 1);
        }

        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " " + "occurs" + ": " + val.getValue() + " times");
        }
    }
}
