
public class Main 
{
	 
	public static final int SIZE = 100;
	public static Voice mouth;
	public static Memories brain;
	 
	public static void main(String[] args) 
	{
	 int Timer = (int) System.currentTimeMillis();
	 UserInterface face = new UserInterface();
	 mouth = new Voice();
	 brain = new Memories(mouth.name);
	 face.smile();
	 //face.wink();
	 
	// mouth.say("Your favorite color is " + brain.getMemory(1));
	 
	// System.out.println(brain);
	}
	
}
