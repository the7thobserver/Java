package basicAudio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MusicPlayer implements LineListener
{
	private String name;
	private AudioInputStream audioStream;
	private AudioFormat audioFormat;
	private AudioFileFormat audioFileFormat;
	
	// For playback
	private SourceDataLine playLine;
	// For loop
	private Clip clip;
	// For recording
	private TargetDataLine recordLine;
	
	private final int BUFFER_SIZE = 100000;
	
	public MusicPlayer()
	{

	}
	
	public void load(String location)
	{
		try 
		{
			File file = new File(location);
			name = file.getName();
			audioStream = AudioSystem.getAudioInputStream(file);
			audioFormat = audioStream.getFormat();
			audioFileFormat = AudioSystem.getAudioFileFormat(file);
		}
		catch (UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void playOnce()
	{
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		
		try
		{
			playLine = (SourceDataLine) AudioSystem.getLine(info);

			playLine.open(audioFormat);		// Recieve audio
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		playLine.start();	// Send to output
		
		int	bytesRead = 0;
		byte[]	soundData = new byte[BUFFER_SIZE];
		
		while (bytesRead != -1)
		{
			try
			{
				bytesRead = audioStream.read(soundData, 0, soundData.length);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			if (bytesRead >= 0)
			{
				playLine.write(soundData, 0, bytesRead);
			}
		}
		
		playLine.close();
	}
	
	public void playLoop(int numLoops)
	{
		AudioFormat	format = audioStream.getFormat();
		DataLine.Info	info = new DataLine.Info(Clip.class, format);
		try 
		{
			clip = (Clip) AudioSystem.getLine(info);
			clip.addLineListener((LineListener) this);
			clip.open(audioStream);
		}
		catch (LineUnavailableException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		clip.loop(numLoops);

		do
		{
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		} while (clip.isActive());
	}
	
	public void printHex()
	{
		int	bytesRead = 0;
		byte[]	soundData = new byte[BUFFER_SIZE];
		
		while (bytesRead != -1)
		{
			try
			{
				bytesRead = audioStream.read(soundData, 0, soundData.length);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			if (bytesRead >= 0)
			{
				for(int i = 0; i < soundData.length; i++)
				{
					if(i % 25 == 0)
						System.out.println();
				
					System.out.printf("%02x ", soundData[i]);
				}
			}
		}	
	}

	@Override
	public void update(LineEvent event) 
	{
		if (event.getType().equals(LineEvent.Type.STOP))
		{
			clip.close();
		}
		else if (event.getType().equals(LineEvent.Type.CLOSE))
		{
			System.exit(0);
		}
	}

	public void printInfo() 
	{
		System.out.println("Filename: " + name);
		System.out.println("Type: " + audioFileFormat.getType());
		System.out.println("# Channels: " + audioFormat.getChannels());
		System.out.println("Frame Rate: " + audioFormat.getFrameRate() + " Hz");
		System.out.println("Frame Size: " + audioFormat.getFrameSize() + " bytes/frame");
		System.out.println("Encoding: " + audioFormat.getEncoding());
		System.out.println("Sample Size: " + audioFormat.getSampleSizeInBits() + " bit");
		
		if(audioFormat.isBigEndian())
			System.out.println("Endian: Big");
		else
			System.out.println("Endian: Little");
		
		if (audioFileFormat.getFrameLength() != AudioSystem.NOT_SPECIFIED)
		{
			System.out.println("Frames: " + audioFileFormat.getFrameLength());
			System.out.println("Bytes: " + audioFileFormat.getByteLength());
			System.out.println("Duration: " + (audioFileFormat.getFrameLength() / audioFormat.getFrameRate()) + " seconds");
		}
		else
		{
			System.out.println("Frames: Unknown\nBytes: Unknown\nDuration: Unknown");
		}
	}
}
