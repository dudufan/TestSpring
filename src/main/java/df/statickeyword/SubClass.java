package df.statickeyword;

class SubClass extends SupClass{
    static {
        System.out.println("Sub static is running ...");
    }

    {
        System.out.println("sub source block is running ...");
    }

    public SubClass(){
        System.out.println("sub constructor is running...");
    }
}