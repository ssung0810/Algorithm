package TreadTest;

public class ExtendThread extends Thread {

    public ExtendThread() {}

    public ExtendThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String name = getName();
        System.out.println(name + " : Thread실행");
    }
}