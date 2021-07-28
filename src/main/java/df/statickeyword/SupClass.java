package df.statickeyword;

class SupClass{
    static {
        System.out.println("Sup static is Running ...");
    }
    {
        System.out.println("sup source block is running ...");
    }

    public SupClass(){
        System.out.println("sup constructor is running...");
    }

    public static int value = 1;
}