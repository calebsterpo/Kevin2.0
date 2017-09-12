import java.util.Locale;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Voice 
{
	public String name;
	private Synthesizer synth;
	
	public Voice()
	{
	 setVoice();
	 name = greet();
	}
	
	public MemoryObj ask(String question, int spot)
	{
	 say(question);
	 JFrame frame = new JFrame("InputDialog");
	 String answer = JOptionPane.showInputDialog(frame,question,"Tell me",JOptionPane.PLAIN_MESSAGE);
	 return new MemoryObj(Memories.scramble(answer), spot);
	}
	
	public String greet()
	{
	     String[] Greet1 = {"Hello", "Greetings", "Howdy", "Good day", "Hi"};
	     String[] Greet2 = {"What is your name?", "I am Kevin, what is your name?", "With whom am I speaking?", "Would you please tell me your name?", "Please tell me your name", "Who are you?"};
	     
		 String said1 = Greet1[(int) (Math.random()*5)];
		 String said2 = Greet2[(int) (Math.random()*6)];
		 say(said1 + ", " + said2);
		 
		 JFrame frame = new JFrame("InputDialog");
	     String name = JOptionPane.showInputDialog(frame,
	      said2,said1,JOptionPane.PLAIN_MESSAGE);

	 return name;	
	}
	
	public void setVoice()
	{
	try { System.setProperty("freetts.voices",
			"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
			 Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			synth = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		   	synth.allocate();
	 } catch (Exception e) {e.printStackTrace();}
	}
	
	public String say(String str)
	{
	 try
		{
		 System.out.print(str + "\n");
		 synth.resume();
		 synth.speakPlainText(str, null);
		 synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
		}
		catch(Exception e) { e.printStackTrace(); }
	 return str;
	}
}
