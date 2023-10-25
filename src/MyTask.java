class MyTask implements Runnable {
    private static int sharedCounter = 0;

    @Override
    public void run() {

       /* ThreadGroup myThreadGroup2 = new ThreadGroup("myThreadGroup2");
        System.out.println("Inside Thread group name : "+myThreadGroup2.getName());
        System.out.println("Inside Thread Parent group name : "+myThreadGroup2.getParent().getName()); */
        for (int i = 0; i < 5; i++) {
            synchronized (MyTask.class) {
                sharedCounter++;
                System.out.println(Thread.currentThread().getName() + " - Counter: " + sharedCounter);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}