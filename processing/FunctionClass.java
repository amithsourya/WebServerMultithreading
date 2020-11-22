package processing;
import java.util.*;
public interface FunctionClass {
	void start();
	String getresult();
}
class prime implements FunctionClass{
	String ou = "";
	int n;
	prime (int n)
	{
		this.n = n;
		this.start();
	}
	public void start()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		int t = 2;
		while(t<=n)
		{
			int i = 1;
			Iterator<Integer> it = a.iterator();
			while(it.hasNext())
			{
				int am =  (int)it.next();
				if(t%am==0)
				{
					i=0;
					t++;
					break;
				}
			}
			if(i==1)
			{
				a.add(t);
				ou = ou + t + " ";
				t++;
			}
		}
	}
	public String getresult()
	{
		return ou;
	}
}
class fibonacci implements FunctionClass{
	String ou = "";
	int n;
	fibonacci (int n)
	{
		this.n = n;
		this.start();
	}
	public void start()
	{
		int p = 1, now = 1;
		while(now<=n)
		{
			int t = now;
			now = now +p;
			p = t;
			ou = ou + p +" ";
		}
	}
	public String getresult()
	{
		return ou;
	}
}
