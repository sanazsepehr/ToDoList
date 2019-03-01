public class Nour
{
    public static void main(String[] args)
    {
        String s = "sdfsef";
        try {
            int x = Integer.parseInt(s);
            System.out.println(x);
            System.out.println("suceeful");
        } catch (Exception e )
        {
            System.out.println("please try again");
        }

    }
}
