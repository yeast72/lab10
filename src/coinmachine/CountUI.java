package coinmachine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Wisarut Boonumma
 *
 */
public class CountUI extends JFrame implements Runnable, Observer {
	private CoinMachine machine;
	private JTextField count;
	private JLabel accept;

	public CountUI(CoinMachine machine) {
		this.machine = machine;
		this.setBounds(0,300, WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	/**
	 * initialize components in the window
	 */

	public void initComponents() {
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());

		JLabel coin = new JLabel("#Coin: ");
		contentPane.add(coin);

		count = new JTextField(10);
		count.setText("0");
		count.setEditable(false);
		count.setSize(50, 50);
		contentPane.add(count);

		accept = new JLabel("Accepting Coins");
		accept.setBorder(new EmptyBorder(5, 5, 5, 5));
		accept.setLayout(new FlowLayout());

		this.add(contentPane, BorderLayout.CENTER);
		this.add(accept, BorderLayout.SOUTH);
		this.pack();

	}

	/**
	 * run this user interface
	 */
	public void run() {
		this.setVisible(true);

	}

	/**
	 * Update is Observer that update when machine insert coin this update coin
	 * count and status of machine
	 */
	public void update(Observable arg0, Object arg1) {
		count.setText(String.valueOf(machine.getCount()));
		if (machine.isFull())
			accept.setText("Full");

	}

}
