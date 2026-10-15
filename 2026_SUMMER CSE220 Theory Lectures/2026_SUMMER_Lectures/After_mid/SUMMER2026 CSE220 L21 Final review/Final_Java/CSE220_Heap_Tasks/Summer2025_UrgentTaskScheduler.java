public class Summer2025_UrgentTaskScheduler {

        static void urgent_task(int[] tasks, int deadline) {
        MaxHeap maxHeap = new MaxHeap(tasks.length);

        // Insert tasks using regular for loop
        for (int i = 0; i < tasks.length; i++) {
            maxHeap.insert(tasks[i]);
        }

        int completed = 0;

        // Process tasks up to deadline
        for (int day = 1; day <= deadline; day++) {
            int val = maxHeap.extractMax();

            System.out.println("Day " + day + " - Urgency " + val);
            completed++;
        }

        int ignored = maxHeap.getSize();
        System.out.println("Tasks completed: " + completed);
        System.out.println("Tasks ignored: " + ignored);
    }

    // ================== DRIVER ==================
    public static void main(String[] args) {
        int[] tasks = {30, 95, 80, 25, 50};
        int deadline = 3;

        urgent_task(tasks, deadline);
    }
}