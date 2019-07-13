package info.ziang.java;

public interface InterfaceA {

    /**
     * 接口里面只能定义静态常量，所以默认是 final static
     */
    String name="NONE";
    int age=18;

    void updateInfo(String name, int age);
}
