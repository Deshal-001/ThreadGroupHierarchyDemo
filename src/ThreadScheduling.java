public class ThreadScheduling {
    public static void main(String[] args) {
        // Create a thread group
        // Create two threads with tasks
        Thread thread1 = new Thread(new MyTask(), "Thread1");
        Thread thread2 = new Thread(new MyTask(), "Thread2");

        // Print the initial state of the threads
        System.out.println("Before start:Thread1- " + thread1.getState());
        System.out.println("Before start:Thread2- " + thread2.getState());
        System.out.println("Before start:Main- " + Thread.currentThread().getState());

        // Set thread priorities and daemon status
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.setDaemon(true);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.setDaemon(true);

        // Start the threads
        thread1.start();
        thread2.start();

        // Print the state of the threads after starting
        System.out.println("After start:Thread1- " + thread1.getState());
        System.out.println("After start:Thread2- " + thread2.getState());
        System.out.println("After start:Main- " + Thread.currentThread().getState());

        /* Uncomment the code below to introduce a delay using Thread.sleep()
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        // Print the state of the threads after a potential sleep
        System.out.println("After sleep:Thread1- " + thread1.getState());
        System.out.println("After sleep:Thread2- " + thread2.getState());
    }
}
