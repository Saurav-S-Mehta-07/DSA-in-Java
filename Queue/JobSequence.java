import java.util.*;
import java.util.LinkedList;
public class JobSequence{
    static class Job{
        char id;
        int deadline;
        int profit;
        Job(char id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline; 
            this.profit  = profit;
        }
    }

    //brute force approach 
    public static void profitSeq(Job[] jobs){

        Arrays.sort(jobs, (j1,j2) -> j2.profit - j1.profit);
        System.out.println();
        Queue<Character> result = new LinkedList<>();
        int maxDeadline = 0;
        for(Job job: jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int totalProfit = 0;
        boolean[] arr = new boolean[maxDeadline+1];
        
        for(Job job : jobs){
            if(arr[job.deadline]==false){
                arr[job.deadline] = true;
                result.add(job.id);
                totalProfit+=job.profit;
            }
            else{
                for(int i = job.deadline-1; i>=1; i--){
                   if(arr[i]==false){
                     arr[i] = true;
                     result.add(job.id);
                     totalProfit+=job.profit;
                     break;
                   }
                }
            }
        }

        while(!result.isEmpty()){
            System.out.println(result.poll());
        }

        System.out.println(totalProfit);

       
    }


     // Function to schedule jobs for maximum profit
    static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();

        // Step 1: Sort jobs by deadline
        Collections.sort(arr, (a, b) -> a.deadline - b.deadline);

        ArrayList<Job> result = new ArrayList<>();

        // MaxHeap (priority queue) to select job with highest profit
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        // Step 2: Iterate jobs from last to first
        for (int i = n - 1; i >= 0; i--) {
            int slots;

            if (i == 0) {
                slots = arr.get(i).deadline; 
            } else {
                slots = arr.get(i).deadline - arr.get(i - 1).deadline;
            }

            // Add current job to heap
            maxHeap.add(arr.get(i));

            // Fill available slots with highest profit jobs
            while (slots > 0 && !maxHeap.isEmpty()) {
                Job job = maxHeap.poll(); 
                result.add(job);
                slots--;
            }
        }

        // Step 3: Sort selected jobs by deadline before printing
        Collections.sort(result, (a, b) -> a.deadline - b.deadline);

        // Print result
        for (Job job : result) {
            System.out.print(job.id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
         Job jobs[] ={
            // new Job('a', 4, 20),
            // new Job('b', 1, 10),
            // new Job('c', 1, 40),
            // new Job('d', 1, 30)
         };
        //  profitSeq(jobs);


        ArrayList<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 4, 20));
        arr.add(new Job('b', 2, 10));
        arr.add(new Job('c', 1, 40));
        arr.add(new Job('d', 1, 30));
        printJobScheduling(arr); 

    }
}