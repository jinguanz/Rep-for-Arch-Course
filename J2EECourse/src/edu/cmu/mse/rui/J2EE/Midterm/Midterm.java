package edu.cmu.mse.rui.J2EE.Midterm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class Midterm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	private final String obama = "Obama";
	private final String romney = "Romney";

	private int totalForObama = 0;
	private int totalForRomeny = 0;
	private NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.US);

	private ArrayList<Record> allRecord = new ArrayList<Record>();
	private ArrayList<Record> obamaRecord = new ArrayList<Record>();
	
	private ArrayList<Record> romenyRecord = new ArrayList<Record>();

	// the key should be the lastname +first name+ Candidate name, the value is
	// the Record with the total value;
	private HashMap<String, Record> TotalForOneContributorToOneCandiateMap = new HashMap<String, Record>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Midterm window = new Midterm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Midterm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 699, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 687, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(156, 6, 134, 28);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblContributorLastName = new JLabel("Contributor Last Name");
		lblContributorLastName.setBounds(6, 12, 150, 16);
		panel.add(lblContributorLastName);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(313, 12, 84, 16);
		panel.add(lblFirstName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(393, 6, 134, 28);
		panel.add(textField_1);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(550, 12, 61, 16);
		panel.add(lblAmount);

		textField_2 = new JTextField();
		textField_2.setBounds(606, 6, 75, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Contribute To Obama");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lstName = textField.getText();
				String firstName = textField_1.getText();
				String amount = textField_2.getText();

				if (Util.checkoutEmptyDescription(lstName)
						&& Util.checkoutEmptyDescription(firstName)) {
					if (Util.checkIntAmount(amount)) {

						if (Util.checkMax(amount)) {
							if (Util.checkMin(amount)) {
								if(checkMaxForIndividual(firstName+lstName+obama,Integer.parseInt(amount))){
								Record r = new Record();
								r.setAmount(Integer.parseInt(amount));

								r.setFirstName(firstName);
								r.setLastName(lstName);
								r.setCandidate(obama);
								allRecord.add(r);
								obamaRecord.add(r);
								representDataInTextArea(allRecord);
								totalForObama = totalForObama
										+ Integer.parseInt(amount);
								cleaninput();
								}
								else {
									textArea.append("\n");
									textArea.append("your contribution to Obama is too large");
								}
							} else {
								textArea.append("\n");
								textArea.append("please input positive number");
							}

						} else {
							textArea.append("\n");
							textArea.append("Contribution is too large");
						}

					} else {
						textArea.append("\n");
						textArea.append("please input a int number");
					}
				}

				else {
					textArea.append("\n");
					textArea.append("please input your name: both last name and first name");
				}

			}
		});
		btnNewButton.setBounds(107, 48, 172, 29);
		panel.add(btnNewButton);

		JButton button = new JButton("Contribute To Romney");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String lstName = textField.getText();
				if(lstName.length()>15){
					lstName=lstName.substring(0, 14);
				}
				String firstName = textField_1.getText();
				if(firstName.length()>15){
					firstName=firstName.substring(0, 14);
				}
				String amount = textField_2.getText();

				if (Util.checkoutEmptyDescription(lstName)
						&& Util.checkoutEmptyDescription(firstName)) {
					if (Util.checkIntAmount(amount)) {

						if (Util.checkMax(amount)) {
							if (Util.checkMin(amount)) {
								if(checkMaxForIndividual(firstName+lstName+romney,Integer.parseInt(amount))){
								Record r = new Record();
								r.setAmount(Integer.parseInt(amount));

								r.setFirstName(firstName);
								r.setLastName(lstName);
								r.setCandidate(romney);
								allRecord.add(r);
								romenyRecord.add(r);
								representDataInTextArea(allRecord);
								totalForRomeny = totalForRomeny
										+ Integer.parseInt(amount);
								cleaninput();
								}
								else {
									textArea.append("\n");
									textArea.append("your contribution to romney is too large");
								}
							} else {
								textArea.append("\n");
								textArea.append("please input positive number");
							}

						} else {
							textArea.append("\n");
							textArea.append("Contribution is too large");
						}

					} else {
						textArea.append("\n");
						textArea.append("please input a int number");
					}
				}

				else {
					textArea.append("\n");
					textArea.append("please input your name: both last name and first name");
				}

			
			}
		});
		button.setBounds(347, 48, 172, 29);
		panel.add(button);

		JButton btnListObamaContributors = new JButton(
				"List Obama Contributors");
		btnListObamaContributors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				representDataInTextArea(sort(obamaRecord));
				textArea.append("\n");
				textArea.append("Total Contributions for Obama is:"
						+ cur.format(totalForObama));

			}
		});
		btnListObamaContributors.setBounds(82, 89, 199, 29);
		panel.add(btnListObamaContributors);

		JButton btnListRomneyContributors = new JButton(
				"List Romney Contributors");
		btnListRomneyContributors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				representDataInTextArea(sort(romenyRecord));
				textArea.append("\n");
				textArea.append("Total Contributions for Romeny is:"
						+cur.format( totalForRomeny));

			}
		});
		btnListRomneyContributors.setBounds(357, 89, 199, 29);
		panel.add(btnListRomneyContributors);

		textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setAutoscrolls(true);
		textArea.setBounds(20, 145, 643, 235);
		panel.add(textArea);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(36, 183, 568, 207);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
	}

	private void representDataInTextArea(ArrayList<Record> arr) {
		textArea.setText("");
		for (Record row : arr) {
			textArea.append(formatOneOperation(row));
		}
	}

	// to format one operation
	private String formatOneOperation(Record data) {
		StringBuffer answer = new StringBuffer();
		String fullName = data.getLastName() + ", " + data.getFirstName();
		padAndAppend(answer, fullName, 30);
		appendAndPad(answer,  cur.format(data.getAmount()) + "",20);
		appendAndPad(answer, data.getCandidate(), 20);

		answer.append('\n');
		return answer.toString();
	}

	private void padAndAppend(StringBuffer b, String s, int width) {

		b.append(s);
		for (int i = s.length(); i < width; i++) {
			b.append(' ');
		}
	}

	private void appendAndPad(StringBuffer b, String s, int width) {
		for (int i = s.length(); i < width; i++) {
			b.append(' ');
		}
		b.append(s);

	}

	private ArrayList<Record> sort(ArrayList<Record> arr) {
		Collections.sort(arr);

		return arr;

	}

	private void cleaninput() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}

	private boolean checkMaxForIndividual(String name, int amount){
		if(TotalForOneContributorToOneCandiateMap.containsKey(name)){
			Record tmp=TotalForOneContributorToOneCandiateMap.get(name);
			int totalAfterDon=tmp.getAmount()+amount;
			if(totalAfterDon>10000000){
				return false;
			}
			else{
				TotalForOneContributorToOneCandiateMap.get(name).setAmount(totalAfterDon);
				return true;
			}
		}
		else
			return true;
		
	}
	
	private class Record implements Comparable<Record> {
		private String LastName;
		private String firstName;
		private int amount;
		private String candidate;

		@Override
		public int compareTo(Record o) {
			// TODO Auto-generated method stub
			// return this.getAmount().compareTo(o.getAmount());
			if (this.getAmount() > o.getAmount())
				return -1;
			else if (this.getAmount() < o.getAmount())
				return 1;
			else
				return 0;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getCandidate() {
			return candidate;
		}

		public void setCandidate(String candidate) {
			this.candidate = candidate;
		}
	}
}
