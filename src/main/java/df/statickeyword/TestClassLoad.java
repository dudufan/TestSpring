package df.statickeyword;

public class TestClassLoad {
    public static void main(String[] args) {
        //输出结果
        //第一个
        System.out.println(Test.A);
        //第二个
        System.out.println(SubClass.value);
        //第三个
        Test[] testArr = new Test[10];
        //第四个
        Test t = new Test();
        //第五个
        SubClass sub = new SubClass();
        SupClass su1 = new SubClass();
    }
}