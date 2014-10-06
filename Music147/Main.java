import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Jared Leung
// UC Irvine, CompSci 190

public class Main extends JFrame {

	private int amp = 75;
	double frq = 440;
	
	private JSlider frqSlider;
	private JPanel pane;
	private int width;
	private int height;
	
	final int PADDING = 20;
	
	public static void main(String[] args) 
	{
		new Main().setVisible(true);
	}

	private Main()
	{
		super("Sinusoid");

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		width = Frame.getWindows()[0].getWidth();
		height = Frame.getWindows()[0].getHeight();
		
		pane = new JPanel();
		pane.setLayout(null);
		
		final JLabel label = new JLabel("Frq = " + (int) frq + " hz");
		
		// direction , min , max , current
		frqSlider = new JSlider(JSlider.HORIZONTAL,1,1000, (int) frq);
		frqSlider.setMajorTickSpacing(100);
		frqSlider.setMinorTickSpacing(25);
		frqSlider.setPaintLabels(true);
		frqSlider.setPaintTicks(true);
		frqSlider.setPaintTrack(true);
		frqSlider.setAutoscrolls(true);
		
		frqSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				frq = frqSlider.getValue();
				label.setText("Frq = " + (int)frq + " hz");
				repaint();
			}
		});
		
		JButton sound = new JButton("Play");
		
		sound.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					playSound();
				} catch (InterruptedException | LineUnavailableException err) {
					err.printStackTrace();
				}
			}
		});
		
		pane.add(frqSlider);
		frqSlider.setBounds(0, 0, width - PADDING, 50);
		pane.add(label);
		label.setBounds(PADDING,15,100,100);
		pane.add(sound);
		sound.setBounds(width - PADDING - 100, 50, 100, 50);
		add(pane);
	}

	// Courtesy of Wolin Labs
	public void playSound() throws InterruptedException, LineUnavailableException
	{
        // Audio sampling rate
		final int SAMPLING_RATE = 44100;
        // Audio sample size in bytes
		final int SAMPLE_SIZE = 2;

		SourceDataLine line;
        // Frequency of sine wave in hz
		double fFreq = frq;

		//Position through the sine wave as a percentage (i.e. 0 to 1 is 0 to 2*PI)
		double fCyclePosition = 0;        

		//Open up audio output, using 44100hz sampling rate, 16 bit samples, mono, and big 
		// endian byte ordering
		AudioFormat format = new AudioFormat(SAMPLING_RATE, 16, 1, true, true);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		if (!AudioSystem.isLineSupported(info)){
			System.out.println("Line matching " + info + " is not supported.");
			throw new LineUnavailableException();
		}

		line = (SourceDataLine)AudioSystem.getLine(info);
		line.open(format);  
		line.start();

		// Make our buffer size match audio system's buffer
		ByteBuffer cBuf = ByteBuffer.allocate(line.getBufferSize());   

		int ctSamplesTotal = SAMPLING_RATE * 2;        

		//On each pass main loop fills the available free space in the audio buffer
		//Main loop creates audio samples for sine wave, runs until we tell the thread to exit
		//Each sample is spaced 1/SAMPLING_RATE apart in time
		while (ctSamplesTotal>0) {
			double fCycleInc = fFreq/SAMPLING_RATE;  // Fraction of cycle between samples

			cBuf.clear();                            // Discard samples from previous pass

			// Figure out how many samples we can add
			int ctSamplesThisPass = line.available()/SAMPLE_SIZE;   
			for (int i=0; i < ctSamplesThisPass; i++) {
				cBuf.putShort((short)(Short.MAX_VALUE * Math.sin(2*Math.PI * fCyclePosition)));

				fCyclePosition += fCycleInc;
				if (fCyclePosition > 1)
					fCyclePosition -= 1;
			}

			//Write sine samples to the line buffer.  If the audio buffer is full, this will 
			// block until there is room (we never write more samples than buffer will hold)
			line.write(cBuf.array(), 0, cBuf.position());            
			ctSamplesTotal -= ctSamplesThisPass;     // Update total number of samples written 

			//Wait until the buffer is at least half empty  before we add more
			while (line.getBufferSize()/2 < line.available())   
				Thread.sleep(1);                                             
		}


		//Done playing the whole waveform, now wait until the queued samples finish 
		//playing, then clean up and exit
		line.drain();                                         
		line.close();
	}

	public void paint(Graphics g) 
	{
		super.paintComponents(g);
		
		// int period = width / 100;
		
		g.setColor(Color.RED);
		// X axis
		g.drawLine(0, height / 2, width, height / 2);
		// Y axis
		g.drawLine(width / 2, 100, width / 2, height);

		// Draw y intervals
		g.drawString(String.valueOf(amp), width / 2, height / 2 + 75);
		g.drawString(String.valueOf(amp), width / 2, height / 2 - 75);

		g.setColor(Color.BLACK);

		// Sine
		Polygon p = new Polygon();
		
		for (int x = 0; x < width; x++) 
		{
			// Draw a sine wave that spans the whole screen width
			int y = (int) (amp *  Math.sin(((x * frq)/width) * 2 * Math.PI));

			// height/2 to center on the x-axis			
			p.addPoint(x, height / 2 + y);

			// Draw intervals
//			if(y == 0)
//			{
//				if(previousMark + 1 >= x)
//				{
//					System.out.println(x +" " +  previousMark + " CLOSE");
//					previousMark = x;
//					continue;
//				}
//
//				System.out.println(x);
//				
//				g.setColor(Color.RED);
//				if(period == 0)
//				{
//					period++;
//					continue;
//				}
//				else if(x < width / 2)
//				{
//					g.drawString("-" + period + "\u03c0", x, height / 2);
//					period--;
//					previousMark = x;
//				}
//				else
//				{
//					g.drawString(period + "\u03c0", x, height / 2);
//					period++;
//					previousMark = x;
//				}
//				g.setColor(Color.BLACK);
//			}
		}

		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);	
	}
}