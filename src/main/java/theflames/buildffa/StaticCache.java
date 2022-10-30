package theflames.buildffa;
public class StaticCache {

    private StaticCache() {} //Prevent Instantiation
    public static String prefix = Buildffa.getInstance().getConfig().getString("prefix");

    public static boolean testmode = false;

    public static boolean buildmode = false;

}

