/**
 * Created by phamm on 26.10.2016.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Bot bot = new Bot("Hans");
        bot.setVerbose(true);
        bot.connect("192.168.0.107", 6667);
        bot.joinChannel("#test");
    }
}
