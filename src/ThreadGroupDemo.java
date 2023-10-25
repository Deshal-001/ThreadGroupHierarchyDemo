public class ThreadGroupDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread Name : "+Thread.currentThread().getName());
        System.out.println("Main Thread Group Name : "+Thread.currentThread().getThreadGroup().getName());
        System.out.println("Main Thread Group Parent Name : "+Thread.currentThread().getThreadGroup().getParent().getName());


        //ThreadGroup1

        ThreadGroup threadGroup1 = new ThreadGroup("myThreadGroup1");
        System.out.println("Thread Group 1 Parent Name : "+threadGroup1.getName()); //This thread group is created by main thread, so it will be the parent of this thread group
        System.out.println("Thread Group 1 Parent Name : "+threadGroup1.getParent().getName());


        //Thread 1
        Thread t1 = new Thread(threadGroup1,new MyTask(),"Thread-1"); // to which tread group this thread belongs to? and why ?
        t1.start();
        System.out.println("Thread 1 Group Name : "+ t1.getThreadGroup().getName());
        System.out.println("Thread 1 Group Parent Name : "+t1.getThreadGroup().getParent().getName());

        //ThreadGroup3
        ThreadGroup myThreadGroup3 = new ThreadGroup(threadGroup1,"myThreadGroup3"); //My thread group belongs to mythraedgroup3
        System.out.println("Thread Group 3 Name : "+ myThreadGroup3.getName());
        System.out.println("Thread Group 3 Parent Name : "+myThreadGroup3.getParent().getName());


        //Thread 2
        Thread t2 = new Thread(myThreadGroup3,new MyTask(),"Thread 2");
        t2.start();
        System.out.println("Thread 2 Group Name : "+ t2.getThreadGroup().getName());
        System.out.println("Thread 2 Group Parent Name : "+t2.getThreadGroup().getParent().getName());


    }
}
