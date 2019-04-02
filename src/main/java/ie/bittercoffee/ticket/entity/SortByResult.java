package ie.bittercoffee.ticket.entity;

import java.util.Comparator;
/*
 * Sorting class for POJO Line
 * Sorts Lines by Result in a descending fashion
 */
public class SortByResult implements Comparator<Line>
{

	@Override
	public int compare(Line a, Line b)
	{
		return b.getResult() - a.getResult();
	}

}
