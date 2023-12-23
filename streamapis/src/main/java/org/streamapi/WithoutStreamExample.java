package org.streamapi;

import java.util.ArrayList;
import java.util.List;

public class WithoutStreamExample {
    public static void main(String[] args) {
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);

        int count=0;
        for(Integer salary : salaryList) {
            if (salary > 3000) {
                count++;
            }
        }

        System.out.println("Total employee with salary > 3000: " + count);
    }
}
