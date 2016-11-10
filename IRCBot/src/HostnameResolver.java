import com.google.common.net.InetAddresses;
import java.net.InetAddress;
import java.net.URL;

public abstract class HostnameResolver
{
    public String resolve(String host) throws Exception
    {
        if(!InetAddresses.isInetAddress(host))
        {
            URL url;
            if(host.toLowerCase().contains("http"))
            {
                url = new URL(host);
            }
            else
            {
                url = new URL("http://" + host);
            }
                return InetAddress.getByName(url.getHost()).getHostAddress();
        }
        else
        {
            return host;
        }
    }
}
