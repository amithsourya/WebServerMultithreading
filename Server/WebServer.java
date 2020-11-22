package Server;
import processing.* ;
import java.io.* ;
import java.net.* ;
import java.util.* ;
public class WebServer {
	public static void main(String argv[]) throws Exception
    {
		int port = 6254;
		ServerSocket serverSocket = new ServerSocket(port);
		while (true)
		{
			Socket socket = serverSocket.accept();
			HttpRequest request = new HttpRequest(socket);
			Thread thread = new Thread(request);
			thread.start();
		}
    }
}
final class HttpRequest implements Runnable
{
	final static String CRLF = "\r\n";
    Socket socket;
    public HttpRequest(Socket socket) throws Exception 
    {
    	this.socket = socket;
    }
    public void run()
    {
    	try
    	{
            processRequest();
    	}
    	catch(Exception e)
    	{
            System.out.println(e);
    	}
    }
    private void processRequest() throws Exception
    {
    	InputStream is = this.socket.getInputStream();
		DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());
		// Set up input stream filters.
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// Get the request line of the HTTP request message.
		String requestLine = br.readLine();
		// Display the request line and send it to Input Processor.
		System.out.println();
		System.out.println(requestLine);
		InputProcessor ip = new InputProcessor(requestLine);
		String re1 = ip.Output();
		String statusLine = null;
		String contentTypeLine = null;
		String entityBody = null;
		statusLine = "HTTP/1.1";
		contentTypeLine = "Content-type: text/html" + CRLF;
		entityBody = "<HTML>" + 
			"<HEAD><TITLE>OOPS PROJECT</TITLE></HEAD>" +
			"<BODY>"+re1+"</BODY></HTML>";
		os.writeBytes(statusLine);
		// Send the content type line.
		os.writeBytes(contentTypeLine);
		// Send a blank line to indicate the end of the header lines.
		os.writeBytes(CRLF);
		os.writeBytes(entityBody);
		os.close();
		br.close();
		socket.close();
    }
}