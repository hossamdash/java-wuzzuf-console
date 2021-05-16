package edu.fee;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class JobsDataService {

    public static void filterJobsByTitle(List<JobDetails> jobs) {
        // countFrequencies(jobs, new Function<JobDetails, String>(){

        // @Override
        // public String apply(JobDetails t) {
        // return t.getTitle();
        // }
        // });

        // countFrequencies(jobs, (JobDetails job) -> {
        //     return job.getTitle();
        // });

        // countFrequencies(jobs, job -> job.getTitle());

        countFrequencies(jobs, JobDetails::getTitle);
    }

    public static void filterJobsByCountry(List<JobDetails> jobs) {
        countFrequencies(jobs, JobDetails::getCountry);
    }

    public static void filterJobsByLevel(List<JobDetails> jobs) {
        countFrequencies(jobs, JobDetails::getLevel);
    }

    public static void filterJobsByYearsExp(List<JobDetails> jobs) {
        countFrequencies(jobs, JobDetails::getYearsOfExperience);
    }
    public static void countFrequencies(List<JobDetails> jobs, Function<JobDetails, String> getter) {
        // hashmap to store the frequency of element
        Map<String, Long> hm = new HashMap<String, Long>();

        for (JobDetails job : jobs) {
            String string = getter.apply(job);
            Long i = hm.get(string);
            hm.put(string, (i == null) ? 1 : i + 1);
        }
        hm = sortMap(hm);
        
        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Long> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " " + "occurs" + ": " + val.getValue() + " times");
        }
        System.out.println("==========================================================");
    }

    private static LinkedHashMap<String, Long> sortMap(Map<String, Long> map) {
        List<Map.Entry<String, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        LinkedHashMap<String, Long> orderedMap = new LinkedHashMap<>(map.size());
        for (Map.Entry<String, Long> entry : entryList) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }
        return orderedMap;
    }

}
