

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TripPlanner extends JFrame implements ActionListener { // It extends the JFrame and implements ActionListener

	private JPanel contentPane;
	private JLabel plannerLogoLabel;
	private JLabel titleLabel;
	private JTextArea screenArea;		// this will show the result and processing
	private JButton trainButton;
	private JButton busButton;
	private JButton taxiButton;
	private JButton yesButton;
	private JButton noButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton sixButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton nineButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JButton enterButton;
	private JButton zeroButton;
	
	// The type of ArrayList is PublicTransport this is for Polymorphism
	ArrayList<PublicTransport> transportation = new ArrayList<PublicTransport>();		// for listing objects of transport
	private String model;																// for storing model
	private double baseFare;															// for storing base fare	
	private double farePerStation;														// for storing fare per station(bus and train)				
	private int nStations;																// for storing number of stations(bus and train)	
	private double farePerKm;															// for storing fare per km(taxi)
	private double distance;															// for storing distance(taxi)	
	private String inputData = "";		// It will store the user inputs temporarily. It's type is String but, change it later.
	private int state = 0;				// this instance show the state of the program

	
	/*
	 * The layout of this program is Absolute Layout.
	 * The all button has the ActionListener .addActionListener(this)
	 */
	public TripPlanner() {
		setTitle("Trip Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		plannerLogoLabel = new JLabel("");
		plannerLogoLabel.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/planner_logo.png")));
		plannerLogoLabel.setBounds(69, 20, 453, 86);
		contentPane.add(plannerLogoLabel);
		
		titleLabel = new JLabel("TRIP PLANNER");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(133, 116, 220, 15);
		contentPane.add(titleLabel);
		
		screenArea = new JTextArea();
		screenArea.setBounds(111, 141, 274, 182);
		screenArea.setText("Choose Transport(from left menu):");
		contentPane.add(screenArea);
		
		trainButton = new JButton("TRAIN");
		trainButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/train.png")));
		trainButton.setFont(new Font("굴림", Font.BOLD, 11));
		trainButton.setBounds(12, 142, 91, 23);
		contentPane.add(trainButton);
		trainButton.addActionListener(this);
		
		busButton = new JButton("BUS");
		busButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/bus.png")));
		busButton.setFont(new Font("굴림", Font.BOLD, 11));
		busButton.setBounds(12, 167, 91, 23);
		contentPane.add(busButton);
		busButton.addActionListener(this);
		
		taxiButton = new JButton("TAXI");
		taxiButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/taxi.png")));
		taxiButton.setFont(new Font("굴림", Font.BOLD, 11));
		taxiButton.setBounds(12, 191, 91, 23);
		contentPane.add(taxiButton);
		taxiButton.addActionListener(this);
		
		yesButton = new JButton("Yes");
		yesButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/enterSmall.png")));
		yesButton.setFont(new Font("굴림", Font.BOLD, 12));
		yesButton.setBounds(384, 141, 150, 31);
		contentPane.add(yesButton);
		yesButton.addActionListener(this);
		
		noButton = new JButton("No");
		noButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/cancelSmall.png")));
		noButton.setFont(new Font("굴림", Font.BOLD, 12));
		noButton.setBounds(385, 174, 149, 31);
		contentPane.add(noButton);
		noButton.addActionListener(this);
		
		oneButton = new JButton("");
		oneButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/1.png")));
		oneButton.setBounds(111, 333, 91, 64);
		contentPane.add(oneButton);
		oneButton.addActionListener(this);
		
		twoButton = new JButton("");
		twoButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/2.png")));
		twoButton.setBounds(202, 333, 91, 64);
		contentPane.add(twoButton);
		twoButton.addActionListener(this);
		
		threeButton = new JButton("");
		threeButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/3.png")));
		threeButton.setBounds(294, 333, 91, 64);
		contentPane.add(threeButton);
		threeButton.addActionListener(this);
		
		sixButton = new JButton("");
		sixButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/6.png")));
		sixButton.setBounds(294, 399, 91, 64);
		contentPane.add(sixButton);
		sixButton.addActionListener(this);
		
		fourButton = new JButton("");
		fourButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/4.png")));
		fourButton.setBounds(111, 399, 91, 64);
		contentPane.add(fourButton);
		fourButton.addActionListener(this);
		
		fiveButton = new JButton("");
		fiveButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/5.png")));
		fiveButton.setBounds(202, 399, 91, 64);
		contentPane.add(fiveButton);
		fiveButton.addActionListener(this);
		
		nineButton = new JButton("");
		nineButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/9.png")));
		nineButton.setBounds(294, 464, 91, 64);
		contentPane.add(nineButton);
		nineButton.addActionListener(this);
		
		sevenButton = new JButton("");
		sevenButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/7.png")));
		sevenButton.setBounds(111, 464, 91, 64);
		contentPane.add(sevenButton);
		sevenButton.addActionListener(this);
		
		eightButton = new JButton("");
		eightButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/8.png")));
		eightButton.setBounds(202, 464, 91, 64);
		contentPane.add(eightButton);
		eightButton.addActionListener(this);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/cancel.png")));
		cancelButton.setFont(new Font("굴림", Font.BOLD, 12));
		cancelButton.setBounds(385, 333, 149, 64);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(this);
		
		clearButton = new JButton("CLEAR");
		clearButton.setFont(new Font("굴림", Font.BOLD, 12));
		clearButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/clear.png")));
		clearButton.setBounds(385, 399, 149, 64);
		contentPane.add(clearButton);
		clearButton.addActionListener(this);
		
		enterButton = new JButton("ENTER");
		enterButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/enter.png")));
		enterButton.setFont(new Font("굴림", Font.BOLD, 12));
		enterButton.setBounds(385, 464, 149, 64);
		contentPane.add(enterButton);
		enterButton.addActionListener(this);
		
		zeroButton = new JButton("");
		zeroButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/images/0.png")));
		zeroButton.setBounds(202, 530, 91, 64);
		contentPane.add(zeroButton);
		zeroButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// each transportation button select the transportation and ask about the base fare
		// trainButton
		if(e.getSource() == trainButton) {
			inputData = "";
			this.model = "TRAIN";
			screenArea.setText("You choose TRAIN\n" + "Enter base fare : ");
		}
		// busButton
		else if(e.getSource() == busButton) {
			inputData = "";
			this.model = "BUS";
			screenArea.setText("You choose BUS\n" + "Enter base fare : ");
		}
		// taxiButton
		else if(e.getSource() == taxiButton) {
			inputData = "";
			this.model = "TAXI";
			screenArea.setText("You choose TAXI\n" + "Enter base fare: ");
		}
		
		// yesButton -> when user click the yesButton, user can add new transportations
		else if(e.getSource() == yesButton) {
			if(state == 3) { // only works when the state is in 3
				screenArea.setText("Choose transport(from left menu):");
				state = 0;
			}
		}
		// noButton -> when user click the noButton, the program will show the result of the trip plan(total fare)
		else if(e.getSource() == noButton) {
			if(state == 3) { // only works when the state is in 3
				String result = "";		// for storing the all result of the trip plan
				String name;			// TRAIN = KORAIL, BUS = KORBUS, TAXI = KAKAO TAXI
				double totalTripFare = 0.00;	// for storing sum of all transporation's total fare
				
				// we need to change the integer and double value to String to show on the screen
				for(int i = 0; i < transportation.size(); i++) {
					if(transportation.get(i).getModel() == "TRAIN")
						name = "KORAIL";
					else if(transportation.get(i).getModel() == "BUS")
						name = "KORBUS";
					else 
						name = "KAKAO TAXI";
					
					result = result + "Transport " + Integer.toString(i+1) + " "+ name + "\n"
							+ "Fare:" + Double.toString(transportation.get(i).getTotalFare()) + "\n";
					
					totalTripFare += transportation.get(i).getTotalFare();
				}
				result = result + "============================================\n" + "Total Trip Fare:" + Double.toString(totalTripFare);
				screenArea.setText(result);
			}
		}
		
		// cancelButton -> when user click the button cancel the trip plan, erase all before and start new plan 
		else if(e.getSource() == cancelButton) {
			screenArea.setText("Cancelled!\n" + "New plan:\n" + "Choose transport(from left menu):");
			inputData = ""; // initialize the inputData
			state = 0;	// state move to 0 again
			
			// erase the all plan before
			for(int i = 0; i < transportation.size(); i++) {
				transportation.remove(i);
			}
		}
		
		// clearButton -> when user click the button, initialize the inputData and restart the plan according to the each state
		else if(e.getSource() == clearButton) {
			inputData = ""; // initialize the inputData
			
			// according to the state and transportation(bus+train, taxi), act differently
			if(state == 0) {
				screenArea.setText("You choose " + this.model + "\n" +"Enter base fare:");
			}
			else if(state == 1) {
				if(this.model == "BUS" || this.model == "TRAIN") {
					screenArea.setText("Enter fare per station (for extra stations):");
				}
				else {
					screenArea.setText("Enter fare per km:");
				}
			}
			else if(state == 2) {
				if(this.model == "BUS" || this.model == "TRAIN") {
					screenArea.setText("Enter number of stations:");
				}
				else {
					screenArea.setText("Enter distance (in km):");
				}
			}
		}
		
		// enterButton -> when user click the button, program stores inputData and goes to next state
		// after storing the data, the inputData should be initialized
		else if(e.getSource() == enterButton) {
			if(state == 0) {
				if(model == "BUS" || model == "TRAIN") {
					this.baseFare = Double.parseDouble(inputData);
					screenArea.setText("Enter fare per station (for extra stations):");
					inputData = "";
					state++;
				}
				else {
					this.baseFare = Double.parseDouble(inputData);
					screenArea.setText("Enter fare per km:");
					inputData="";
					state++;
				}
				
			}
			else if(state == 1) {
				if(model == "BUS" || model == "TRAIN") {
					this.farePerStation = Double.parseDouble(inputData);
					screenArea.setText("Enter number of stations:");
					inputData = "";
					state++;
				}
				else {
					this.farePerKm = Double.parseDouble(inputData);
					screenArea.setText("Enter distance (in km):");
					inputData = "";
					state++;
					
				}
			}
			// In state 2(when the state goes to 3) by using the user input data, generate the object of the transportation
			// the object will store in the ArrayList transportation
			else if(state == 2) {
				if(model == "BUS" || model == "TRAIN") {
					this.nStations = Integer.parseInt(inputData);
					screenArea.setText("Add more transport(from right menu)?");
					inputData = "";
					if(model == "BUS") {
						transportation.add(new Bus("BUS",this.baseFare, this.farePerStation, this.nStations));
					}
					else {
						transportation.add(new Train("TRAIN",this.baseFare, this.farePerStation, this.nStations));
					}
					
					state++;
				}
				else {
					this.distance = Double.parseDouble(inputData);
					screenArea.setText("Add more transport(from right menu)?");
					inputData = "";
					transportation.add(new Taxi("TAXI",this.baseFare, this.farePerKm, this.distance));
					
					state++;
				}
			}
		
			
		}
		
		// number buttons
		// when user click the buttons, it store into the inputData and show in the screenArea
		else if(e.getSource() == oneButton) {
			inputData = inputData + "1";
			screenArea.setText(screenArea.getText() + "1");
		}
		else if(e.getSource() == twoButton) {
			inputData = inputData + "2";
			screenArea.setText(screenArea.getText() + "2");
		}
		else if(e.getSource() == threeButton) {
			inputData = inputData + "3";
			screenArea.setText(screenArea.getText() + "3");
		}
		else if(e.getSource() == fourButton) {
			inputData = inputData + "4";
			screenArea.setText(screenArea.getText() + "4");
		}
		else if(e.getSource() == fiveButton) {
			inputData = inputData + "5";
			screenArea.setText(screenArea.getText() + "5");
		}
		else if(e.getSource() == sixButton) {
			inputData = inputData + "6";
			screenArea.setText(screenArea.getText() + "6");
		}
		else if(e.getSource() == sevenButton) {
			inputData = inputData + "7";
			screenArea.setText(screenArea.getText() + "7");
		}
		else if(e.getSource() == eightButton) {
			inputData = inputData + "8";
			screenArea.setText(screenArea.getText() + "8");
		}
		else if(e.getSource() == nineButton) {
			inputData = inputData + "9";
			screenArea.setText(screenArea.getText() + "9");
		}
		else if(e.getSource() == zeroButton) {
			inputData = inputData + "0";
			screenArea.setText(screenArea.getText() + "0");
		}
		
	}
	
	// main 
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
