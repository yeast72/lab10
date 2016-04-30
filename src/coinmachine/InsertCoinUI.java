package coinmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Wisarut Boonnumma
 *
 */
public class InsertCoinUI extends JFrame implements Observer {
	private CoinMachine coinMachine;
	private JProgressBar bar;
	private JLabel valueLb;
	private CoinMachineApp demo = new CoinMachineApp();

	/**
	 * 
	 * @param coinMachine
	 */
	public InsertCoinUI(CoinMachine coinMachine) {
		this.coinMachine = coinMachine;
		this.setTitle("Machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, this.getWidth(), this.getHeight());
		initComponent();
	}

	/**
	 * run this user interface
	 */
	public void run() {
		this.setVisible(true);
	}

	/**
	 * initialize components in the window
	 */
	private void initComponent() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new FlowLayout());

		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new FlowLayout());
		contentPanel.add(statusPanel);

		JLabel balanceLabel = new JLabel("Balance : ");
		statusPanel.add(balanceLabel);

		valueLb = new JLabel(String.valueOf(coinMachine.getBalance()));
		statusPanel.add(valueLb);

		JLabel statusLabel = new JLabel("Status : ");
		statusPanel.add(statusLabel);

		bar = new JProgressBar(0, coinMachine.getCapacity());
		bar.setValue(coinMachine.getCount());
		bar.setStringPainted(true);
		contentPanel.add(bar);

		JPanel contentSount = new JPanel();
		contentSount.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentSount.setLayout(new FlowLayout());

		JButton oneBahtBt = new JButton();
		oneBahtBt.setIcon(new ImageIcon(InsertCoinUI.class
				.getResource("/images/1baht.png")));
		oneBahtBt.addActionListener(new oneButtonListener());
		contentSount.add(oneBahtBt);

		JButton fiveBahtBt = new JButton();
		fiveBahtBt.setIcon(new ImageIcon(InsertCoinUI.class
				.getResource("/images/5baht.png")));
		fiveBahtBt.addActionListener(new fiveButtonListener());
		contentSount.add(fiveBahtBt);

		JButton tenBahtBt = new JButton();
		tenBahtBt.setIcon(new ImageIcon(InsertCoinUI.class
				.getResource("/images/10baht.png")));
		tenBahtBt.addActionListener(new tenButtonListener());
		contentSount.add(tenBahtBt);

		this.add(contentPanel, BorderLayout.CENTER);
		this.add(contentSount, BorderLayout.SOUTH);
		this.pack();
	}

	/**
	 * oneButtonListener is an ActionListener that performs an action when the
	 * button one baht is pressed. It insert coin one baht in coin machine
	 * 
	 */
	class oneButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			demo.insertDialogUI(coinMachine, new Coin(1, "Baht"));
		}
	}

	/**
	 * fiveButtonListener is an ActionListener that performs an action when the
	 * button five baht is pressed. It insert coin five baht in coin machine
	 *
	 */
	class fiveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			demo.insertDialogUI(coinMachine, new Coin(5, "Baht"));
		}
	}

	/**
	 * tenButtonListener is an ActionListener that performs an action when the
	 * button coin ten baht is pressed. It insert coin the baht in coin machine
	 *
	 */
	class tenButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			demo.insertDialogUI(coinMachine, new Coin(10, "Baht"));
		}
	}

	/**
	 * update is Observer that update when coin machine insert coin. It update
	 * value of balance, update count of coin in coin machine and set fore
	 * ground color of bar is green when count of coin full.
	 */
	public void update(Observable arg0, Object arg1) {
		this.valueLb.setText(String.valueOf(coinMachine.getBalance()));
		this.bar.setValue(coinMachine.getCount());
		if (coinMachine.isFull()) {
			bar.setForeground(new Color(0, 200, 0));
		}
	}

}
