import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TripPlanner extends JFrame {

	private JPanel contentPane;
	private JPanel picturePanel;
	private JPanel transportationPanel;
	private JPanel screenPanel;
	private JPanel yesnoPanel;
	private JPanel buttonPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	
	public TripPlanner() {
		setTitle("Trip Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		picturePanel = new JPanel();
		contentPane.add(picturePanel, BorderLayout.NORTH);
		
		transportationPanel = new JPanel();
		contentPane.add(transportationPanel, BorderLayout.WEST);
		
		screenPanel = new JPanel();
		contentPane.add(screenPanel, BorderLayout.CENTER);
		
		yesnoPanel = new JPanel();
		contentPane.add(yesnoPanel, BorderLayout.EAST);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("New button");
		buttonPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		buttonPanel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		buttonPanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		buttonPanel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New button");
		buttonPanel.add(btnNewButton_4);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripPlanner frame = new TripPlanner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
