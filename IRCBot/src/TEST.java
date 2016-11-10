import java.util.Random;

/**
 * Created by phamm on 26.10.2016.
 */
public class TEST extends HostnameResolver
{
    @Override
    public String resolve(String host) throws Exception
    {
        return super.resolve(host);
    }



    public static void main(String[] args) throws Exception
    {
        //UDPFlood p = new UDPFlood("192.168.0.107", 5);
        //UDPFlood o = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood n = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood m = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood l = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood k = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood j = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood i = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood h = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood g = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood f = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood e = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood d = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood c = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood b = new UDPFlood("192.168.0.107", 50000);
        //UDPFlood a = new UDPFlood("192.168.0.107", 50000);

        //HTTPFlood http = new HTTPFlood("192.168.0.107", 1, 500, 60);
        SlowLoris sl = new SlowLoris("192.168.0.107", 500, 50);
        //System.out.println("finisehd");

        //SLtest test = new SLtest();
        //System.out.println(test.resolve("http://www.it-kolleg-imst.at"));
        //System.out.println(test.resolve("www.it-kolleg-imst.at"));
       //System.out.println(test.resolve("http://it-kolleg-imst.at"));
        //System.out.println(test.resolve("google.at"));
        //ystem.out.println(test.resolve("193.170.198.92"));
    }
}
