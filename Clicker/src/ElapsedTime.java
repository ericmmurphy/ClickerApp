import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;

public class ElapsedTime implements ActionListener, Runnable {
	private boolean isRunning;
	private JButton button;

	ElapsedTime(JButton button) {
		this.isRunning = false;
		this.button = button;
    }

	public void start() {
		this.isRunning = true;
		Thread thread = new Thread(this);
		thread.start();
    }

	public void stop() {
		this.isRunning = false;
    }

	public void run() {
		long prevTime = new Date().getTime();
		long elapsedTime;

		while (this.isRunning) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		elapsedTime = new Date().getTime() - prevTime;

		System.out.println("Days: " + ((elapsedTime / (1000 * 60 * 60 * 24)) % 365)
				+ " | Hours: " + ((elapsedTime / (1000 * 60 * 60)) % 24)
				+ " | Minutes: " + ((elapsedTime / (1000 * 60)) % 60)
				+ " | Seconds: " + ((elapsedTime / 1000) % 60)
				+ " | Milliseconds: " + elapsedTime % 1000);
	}

    public void actionPerformed(ActionEvent event) {
    	if (event.getSource() == this.button) {
    		if (!this.isRunning) {
    			this.start();
    		} else {
    			this.stop();
    		}
    	}
    }
}