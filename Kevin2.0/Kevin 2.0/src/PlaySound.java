import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound
{
  public static void play(File Sound)
  {
   try {
	   Clip clip = AudioSystem.getClip();
	   clip.open(AudioSystem.getAudioInputStream(Sound));
	   //if(GameScreen.GameOver == false)
	   //clip.start();
	   //Thread.sleep(clip.getMicrosecondLength()/1000);
   } catch(Exception e)
   {
	System.out.println(e);
   }
  }
  
  public static void allPlay(File Sound)
  {
   try {
	   Clip clip = AudioSystem.getClip();
	   clip.open(AudioSystem.getAudioInputStream(Sound));
	   clip.start();
	   //Thread.sleep(clip.getMicrosecondLength()/1000);
   } catch(Exception e)
   {
	System.out.println(e);
   }
  }
}