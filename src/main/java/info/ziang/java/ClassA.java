package info.ziang.java;

public class ClassA {

    static {
        System.out.println("Static A");
    }

    {
        System.out.println("NON-Static A");
    }

    public ClassA() {
        System.out.println("I am class A");
    }

    public ClassA(int data) {
        System.out.println("I am class A with data " + data);
    }

}
