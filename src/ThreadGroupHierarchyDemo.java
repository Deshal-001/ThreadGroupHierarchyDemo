public class ThreadGroupHierarchyDemo {
    public static void main(String[] args) {

         ThreadGroup[] threadGroups = new ThreadGroup[6];
         Thread[] threads = new Thread[7];

         threads[0]= Thread.currentThread();
         threads[0].setName("Thread 1");
         threadGroups[0]= threads[0].getThreadGroup();

        threadGroups[1]= new ThreadGroup("ThreadGroup A");
        threadGroups[2]= new ThreadGroup("ThreadGroup B");
        threadGroups[3]= new ThreadGroup("ThreadGroup C");
        threadGroups[4]= new ThreadGroup(threadGroups[2],"ThreadGroup B1");
        threadGroups[5]= new ThreadGroup(threadGroups[2],"ThreadGroup B2");

        threads[1]= new Thread(threadGroups[1],new MyTask(),"Thread 2");
        threads[2]= new Thread(threadGroups[1],new MyTask(),"Thread 3");

        threads[3]= new Thread(threadGroups[3],new MyTask(),"Thread 4");
        threads[4]= new Thread(threadGroups[4],new MyTask(),"Thread 5");

        threads[5]= new Thread(threadGroups[4],new MyTask(),"Thread 6");
        threads[6]= new Thread(threadGroups[5],new MyTask(),"Thread 7");

        /*for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName()+" belongs to "+threads[i].getThreadGroup().getName()+" Parent Thread Group "+threads[i].getThreadGroup().getParent().getName());

        }*/


        System.out.println("Active  count before start : "+Thread.currentThread().getThreadGroup().activeCount());//estimated
        System.out.println("Active group count before start : "+Thread.currentThread().getThreadGroup().activeGroupCount());//estimated


        for (int i = 1; i < threads.length; i++) {
            if(i%2==0)
                threads[i].setPriority(Thread.MAX_PRIORITY);
            System.out.println(threads[i].getName()+" belongs to "+threads[i].getThreadGroup().getName()+" Priority to "+threads[i].getPriority());
            threads[i].start();
        }

        threadGroups[2].setMaxPriority(Thread.NORM_PRIORITY);

        for (int i = 0; i <threads.length ; i++) {
            threads[i].setPriority(Thread.MAX_PRIORITY);
            System.out.println(threads[i].getName()+" belongs to "+threads[i].getThreadGroup().getName()+" Priority to "+threads[i].getPriority());

        }

        System.out.println("Active  count after start : "+Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active group count after start : "+Thread.currentThread().getThreadGroup().activeGroupCount());

        Thread[] threads1 = new Thread[Thread.currentThread().getThreadGroup().activeCount()*2];
        Thread.currentThread().getThreadGroup().enumerate(threads1);

        ThreadGroup[] threadGroups1 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()*2];
        Thread.currentThread().getThreadGroup().enumerate(threadGroups1);

        for (Thread thread:threads1
             ) {
            if (thread!=null){
                System.out.println(thread.getName()+" belongs to "+thread.getThreadGroup().getName()+" Parent Thread Group "+thread.getThreadGroup().getParent().getName());
            }
        }

        for (ThreadGroup threadGroup:threadGroups1
             ) {
            if(threadGroup!=null){
                System.out.println(threadGroup.getName()+" belongs to "+threadGroup.getParent().getName());
            }

        }







    }
}
