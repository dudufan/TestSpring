package df.jvm;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
        ThreadLocal<Integer> local = new ThreadLocal<>();
        ThreadLocal<Integer> local1 = new ThreadLocal<>();
        local.set(3);
        System.out.println(local.get());
        local.set(5);
        System.out.println(local.get());
    }
}