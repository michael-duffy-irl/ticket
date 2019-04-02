package ie.bittercoffee.ticket.entity;

/*
 * POJO Line for storing the information of a line
 * with added methods popLine() and calcResult
 */

public class Line
{
	private int[] line;
	private int result;
	
	public Line()
	{
		line = new int[3];
		popLine();
		calcResult();		
	}
	
	public int[] getLine()
	{
		return line;
	}
	public void setLine(int[] line)
	{
		this.line = line;
	}
	
	
	public int getResult()
	{
		return result;
	}	
	
	private void popLine()
	{
		for(int i = 0; i < line.length; i++)
		{
			line[i] = (int) (Math.random() * 3);
		}		
	}
	
	//method to calculate the result of the line and stor it in the variable result
	private void calcResult()
	{
		int sum = 0;
		
		for(int i = 0; i < line.length; i++)
		{
			sum = sum + line[i];
		}
		
		if(sum == 2)
		{
			result = 10;
		}
		else if((line[0]==line[1])&&(line[1]==line[2]))
		{
			result = 5;
		}
		else if((line[0]!=line[1])&&(line[0]!=line[2]))
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
	}
}
