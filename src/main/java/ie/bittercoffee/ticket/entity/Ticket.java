package ie.bittercoffee.ticket.entity;

import java.util.ArrayList;
import java.util.Collections;

/*
 * POJO Ticket for storing information of the ticket
 * with the added method sort lines 
 */
public class Ticket
{
	private int id;
	private boolean checked;
	private ArrayList<Line> lines;	

	public Ticket()
	{
		
	}

	public ArrayList<Line> getLines()
	{
		return lines;
	}

	public void setLines(ArrayList<Line> lines)
	{
		this.lines = lines;		
	}	

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public boolean isChecked()
	{
		return checked;
	}

	public void setChecked(boolean status)
	{
		this.checked = status;
	}

	public void addLine(Line line)
	{
		if(lines == null)
		{
			lines = new ArrayList<Line>();
		}
		
		lines.add(line);
	}
	
	public void sortLines()
	{
		Collections.sort(lines, new SortByResult());
	}
	
}