/**
 *
 *  author  :   Chia Yuan Lin (林家源)
 *
 *  email   :   lo919201@gmail.com
 *
 * **/
import java.io.*;
import java.net.*;

public class JavaServer
{
    public static void main(String[] args)
    {
        try {
            int port = 8888;

            ServerSocket ServerSocket = new ServerSocket(port);
            while (true)
            {
                Socket ClientSocket = ServerSocket.accept();
                String fileName = "C:\\Users\\User\\Desktop\\" + new BufferedReader(new InputStreamReader(ClientSocket.getInputStream())).readLine();
                BufferedInputStream inputStream = new BufferedInputStream(ClientSocket.getInputStream());
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
                int readin;
                int readinx = 0;
                while ((readin = inputStream.read()) != -1)
                {
                    outputStream.write(readin);
                    readinx = readinx + readin;
                    Thread.yield();
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                ClientSocket.close();

                System.out.println("接收完！\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
