package info.ziang.java;

public class ClassB extends ClassA {

    static {
        System.out.println("Static B");
    }

    {
        System.out.println("NON-Static B");
    }

    public ClassB() {
        System.out.println("I am class B");
    }

    public ClassB(int data) {
        System.out.println("I am class B with data " + data);
    }

    public static void main(String[] args) {
        ClassB cb = new ClassB(100);
    }

}
