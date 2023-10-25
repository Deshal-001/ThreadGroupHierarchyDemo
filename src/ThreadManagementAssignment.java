public class ThreadManagementAssignment {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");

        Thread thread1 = new Thread(myThreadGroup, new MyTask(), "Thread1");
        Thread thread2 = new Thread(myThreadGroup, new MyTask(), "Thread2");
        // Create more threads and assign different priorities.

        thread1.setPriority(5); // Set thread1's priority to 5.
        // Set priorities for other threads.

        //thread1.setPriority(5);

        thread1.start();
        thread2.start();
        // Start other threads.

        // Observe thread scheduling behavior here.
    }
}
