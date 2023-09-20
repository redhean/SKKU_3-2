import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class LucasSeries extends JFrame {
	
	// All GUI variables
	private JPanel contentPane;
	private JPanel pnInput;
	private JLabel lblInput;
	private JTextField txtInput;
	private JButton btnSum;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel pnStatus;
	private JProgressBar progressBar;
	private JLabel lblSum;
	private int sum = 0;	// store sum of the Lucas series
	private int temp = 0;	// store each value of Lucas number
	private Worker worker;
	private boolean isStarted = false; // for execute worker
	private List<Integer> file = new ArrayList<Integer>(); // store Lucas series to write into txt file
	private PrintWriter writer; // for file I/O
	
	// All GUI setting
	public LucasSeries() {
		setTitle("Finding Lucas series sum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new GridLayout(0, 4, 0, 0));
		
		lblInput = new JLabel("Number of row in Lucas series:");
		lblInput.setFont(new Font("굴림", Font.BOLD, 11));
		pnInput.add(lblInput);
		
		txtInput = new JTextField();
		pnInput.add(txtInput);
		txtInput.setColumns(10);
		
		btnSum = new JButton("Get sum of Lucas serise");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Initialize
				file.clear(); // to make be empty
				sum = 0;	// clear the sum
				textArea.setText(""); // clear the textArea
				lblSum.setText(""); // clear the lblSum
				btnCancel.setEnabled(true); // in the processing time, btnCancel be enabled
				try {
					// if the input is not be in 3 <= input <= 20, raise warning
					if(Integer.parseInt(txtInput.getText()) < 3 || Integer.parseInt(txtInput.getText()) > 20 )
						throw new InputWarning();
					
					// if isStarted is false, start worker
					if(!isStarted) {
						worker = new Worker();
						worker.execute();
						isStarted = false;
					}
					
				}catch(NumberFormatException e1) {
					// wrong format(invalid) of input like alphabet 
					progressBar.setValue(0); // make progressBar 0%
					JOptionPane.showMessageDialog(null,"Enter valid input!","Warning",JOptionPane.INFORMATION_MESSAGE);
				}catch (InputWarning e2) {
					// wrong range of input
					progressBar.setValue(0); // make progressBar 0%
					JOptionPane.showMessageDialog(null,"Input should be between 3 and 20!","Warning",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnSum.setFont(new Font("굴림", Font.BOLD, 12));
		pnInput.add(btnSum);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker.setStopFlag(); // make stopFlag be true then program will stop
				btnCancel.setEnabled(false); // btnCancel be unavailable
				lblSum.setText("Sum = " + (sum - 2)); // show sum of Lucas series
			}
		});
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("굴림", Font.BOLD, 12));
		pnInput.add(btnCancel);
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pnStatus = new JPanel();
		contentPane.add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new GridLayout(0, 2, 0, 0));
		
		progressBar = new JProgressBar();
		progressBar.setToolTipText("");
		pnStatus.add(progressBar);
		progressBar.setStringPainted(true);
		
		lblSum = new JLabel("");
		pnStatus.add(lblSum);
	}
	
	//Multi-thread
	class Worker extends SwingWorker<Boolean, Integer>{
		private boolean stopFlag = false;
		
			protected Boolean doInBackground()
			throws Exception{
				
				int first = 2;  // first number
				int second = 1; // second number
				
				if(!txtInput.getText().isBlank()) {
					for(int i = 1; i <= Integer.parseInt(txtInput.getText()); i++) {
						// if stopFlag is true, then break
						if(stopFlag)
							break;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						if(i == 1)
							temp = first;
						else if(i == 2)
							temp = second;
						// update the first, second and temp 
						else {
							temp = first + second;
							first = second;
							second = temp;
						}
						sum += temp; // add sum
						
						file.add(temp); // add to file ArrayList for input txt file
						publish(temp); // send to process by publish
						
						// update the progressbar
						progressBar.setValue(i*100/(Integer.parseInt(txtInput.getText())));
						
					}
			}
				
				return false;
		}
			void setStopFlag() {
				stopFlag = true;
			}
			
			protected void process(List<Integer> chunks) {
				Integer value = chunks.get(chunks.size() - 1);
				// append to textArea
				textArea.append(value + "\n");
			}
			
			protected void done() {
				try {
					lblSum.setText("Sum = " + (sum - 2)); // show sum in lblSum
					// After end of processing btnCancel be unavailable
					btnCancel.setEnabled(false);
					
					// file Input
					writer = new PrintWriter(new FileOutputStream("data.txt",false));
					writer.print("[");
					// using for loop, write into file
					for(int i = 0; i < file.size()-1; i++)
						writer.print(file.get(i) + ", ");
					writer.print(file.get(file.size() -1) + "]");
					writer.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	};
	
	// main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LucasSeries frame = new LucasSeries();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
