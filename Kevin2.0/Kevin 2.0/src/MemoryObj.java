
public class MemoryObj 
{
	public String name;
	public int spot;
							  // 0       1        2       3          4        5       6
	public String[] thought = {"Name", "Color", "Age", "Gender", "Animal", "Food", "Hobby", 
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
	//public String[] thought = {"Name", "Age", "Gender", "", "", ""};
	
	public MemoryObj(String str, int num)
	{
	 name = str;
	 spot = num;
	}
	
    @Override
	public String toString()
	{
     if (name != null)
    	 return spot +" "+ thought[spot] +" "+ Memories.unscramble(name);
     return spot + " Missing" + " " + name;
	}
    
	public String toStringFile()
	{
     if (name != null)
    	 return spot +" "+ thought[spot] +" "+ name;
     return spot + " Missing" + " " + name;
	}
}
