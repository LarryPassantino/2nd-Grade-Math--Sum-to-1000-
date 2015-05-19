package sum1000;

import java.util.Random;

/**
 * @author Larry
 *
 */
public class SumCards {
	
	public String numberString;
	public String [] numbers = 
		{"0","1","2","3","4","5","6","7","8","9"};
	public static int userScore;
	public static int computerScore;
	public String add1;
	public String add2;
	public int closest;
	public int bestSum;
	public static int count;
	public static int maxRounds;
	public static String name;
	
	public SumCards()
	{
		userScore = 0;
		computerScore = 0;
		closest = 1000;
		count = 0;
		name = "";
	}
	
	
	/**
	 * Gets a random 6 numbers
	 * @param choice
	 * @return
	 */
	public String getNumberString()
	{
		int r = new Random().nextInt(10);
		numberString = numbers[r];
		return numberString;
	}	
		
	/**
	 * Manipulates the string of 6 numbers to allow for permutations
	 * @param input
	 * @param i
	 * @param j
	 */
	public void exchange(StringBuilder input, int i, int j)
	{
		        String temp;
		        temp = input.substring(i, i + 1);
		        input.replace(i, i + 1, input.substring(j, j + 1));
		        input.replace(j, j + 1, temp);
	}
	
	/**
	 * Creates all permutations of the string
	 * @param input
	 * @param i
	 * @param length
	 */
	public void permute(StringBuilder input, int i, int length)
	{
		if (i == length - 1)
		{
			String a1 = input.substring(0,3);
			String a2 = input.substring(3,6);
			//System.out.println(a1 + " " + a2);
			int sum = sumNumbers(a1, a2);
			int diff = Math.abs(1000 - sum);
			if (diff < closest)
			{
				closest = diff;
				add1 = a1;
				add2 = a2;
				bestSum = sum;
			}
		}
		else
		{
			for (int j = i; j < length; ++j)
		    {
		    	exchange(input, i, j);
		    	permute(input, i + 1, length);
		    	exchange(input, i, j);
		    }
		}
	}  
	
	/**
	 * Sums the numbers
	 * @param add1
	 * @param add2
	 * @return
	 */
	public int sumNumbers(String add1, String add2)
	{
		int sum = Integer.parseInt(add1) + Integer.parseInt(add2);
		return sum;
	}
	
	/**
	 * Gets the correct first addend
	 * @return
	 */
	public String getAdd1()
	{
		return add1;
	}
	
	public void resetAdd1()
	{
		add1 = "";
	}

	/**
	 * Gets the correct second addend
	 * @return
	 */
	public String getAdd2()
	{
		return add2;
	}
	
	public void resetAdd2()
	{
		add2 = "";
	}
	
	public int getClosest()
	{
		return closest;
	}
	
	public void resetClosest()
	{
		closest = 1000;
	}
	
	/**
	 * Gets the user's score
	 * @return
	 */
	public int getUserScore()
	{
		return userScore;
	}
	
	/**
	 * Gets the user's score
	 * @return
	 */
	public void setUserScore(int score)
	{
		userScore = userScore + score;
	}
	
	public void resetUserScore()
	{
		userScore = 0;
	}
	
	/**
	 * Gets the computer's score
	 * @return
	 */
	public int getComputerScore()
	{
		return computerScore;
	}
	
	public void setComputerScore()
	{
		computerScore = computerScore + closest;
	}
	
	public void resetComputerScore()
	{
		computerScore = 0;
	}
	
	public int getBestSum()
	{
		return bestSum;
	}
	
	public void increaseCount()
	{
		count++;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void resetCount()
	{
		count = 0;
	}
	
	public void setMaxRounds(int mr)
	{
		maxRounds = mr;
	}
	
	public int getMaxRounds()
	{
		return maxRounds;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void resetName()
	{
		name = "";
	}

}
