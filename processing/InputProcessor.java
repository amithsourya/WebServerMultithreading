package processing;
import java.util.*;
public class InputProcessor {
	private static String s, re[];
	public InputProcessor(String st)
	{
		String temp = st;
		s = temp;
	}
	public static String Output()
	{
		StringTokenizer st1 = new StringTokenizer(s, " ");
		st1.nextElement();
		StringTokenizer st2 = new StringTokenizer(st1.nextElement().toString(), "-");
		re = new String[2];
		re[0] = st2.nextElement().toString();
		if(re[0].equals("/"))
		{
			return "Welcome to Home page";
		}
		if(!st2.hasMoreElements())
		{
			return "No correct Input try again!";
		}
		re[1] = st2.nextElement().toString();
		int q = Integer.parseInt(re[1]);
		if(re[0].equals("/prime"))
		{
			prime p = new prime(q);
			return p.getresult();
		}
		if(re[0].equals("/fibonacci"))
		{
			fibonacci f = new fibonacci(q);
			return f.getresult();
		}
		return "No correct Input";
	}
}
