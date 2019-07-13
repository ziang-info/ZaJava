package info.ziang.java;

public class ClassA implements InterfaceA{

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

    @Override
    public void updateInfo(String name, int age) {
        System.out.println(ClassA.name + ":" + ClassA.age);
    }
}
