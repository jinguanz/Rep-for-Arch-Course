package edu.cmu.mse.rui.J2EE.HW5;

/*
 * 
 * 08-600 
 * Homework #5
 * Rui Li <ruili@andrew.cmu.edu> 
 * OCT 13, 2012 
 * 
 * README FOR THE GAME: BE HAPPY
 * rule: 
 * 1. when you meet :）, you should say hi to him by click the :) button, so you gain one point
 * 2. when you meet :(, you should encourage him to be happy by click the "be happy" button, so you gain one point
 * 3. when you meet :), you should not click the "be happy button", because he is already a happy guy.
 * 4. when you meet :(, please do not say hi to him, however you need to encourage him to be happy. 
 * 
 * This game is from a good wish: everyone should be happy!!
 * 
 * 
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class HW5 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<JButton> buttonGroups = new ArrayList<JButton>();
	// the game play model: 0 is easy, 1 is hard
	private int model;
	private static int changeInterval = 2000;

	private boolean timeflag = true;
	private int timeleft = 60;
	private int score = 0;

	private JButton currentJButton;
	private JButton previousButton = null;
	private JTextField textField_2;

	private int numberofMeetingHappy = 0;
	private int numberofMakeSadToHappy = 0;
	private int numberOfMisMeetHappy = 0;
	private int numberofMisMeetSad = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW5 window = new HW5();
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
	public HW5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Be Happy");
		frame.setBounds(100, 100, 688, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 95, 663, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(6, 6, 69, 29);
		panel.add(btnNewButton);

		JButton button = new JButton("");
		button.setBounds(73, 6, 69, 29);
		panel.add(button);

		JButton button_1 = new JButton("");
		button_1.setBounds(146, 6, 69, 29);
		panel.add(button_1);

		JButton button_2 = new JButton("");
		button_2.setBounds(217, 6, 69, 29);
		panel.add(button_2);

		JButton button_3 = new JButton("");
		button_3.setBounds(289, 6, 69, 29);
		panel.add(button_3);

		JButton button_4 = new JButton("");
		button_4.setBounds(362, 6, 69, 29);
		panel.add(button_4);

		JButton button_5 = new JButton("");
		button_5.setBounds(433, 6, 69, 29);
		panel.add(button_5);

		JButton button_6 = new JButton("");
		button_6.setBounds(503, 6, 69, 29);
		panel.add(button_6);

		JButton button_7 = new JButton("");
		button_7.setBounds(577, 6, 69, 29);
		panel.add(button_7);

		JButton button_8 = new JButton("");
		button_8.setBounds(6, 43, 69, 29);
		panel.add(button_8);

		JButton button_9 = new JButton("");
		button_9.setBounds(73, 43, 69, 29);
		panel.add(button_9);

		JButton button_10 = new JButton("");
		button_10.setBounds(146, 43, 69, 29);
		panel.add(button_10);

		JButton button_11 = new JButton("");
		button_11.setBounds(217, 43, 69, 29);
		panel.add(button_11);

		JButton button_12 = new JButton("");
		button_12.setBounds(289, 43, 69, 29);
		panel.add(button_12);

		JButton button_13 = new JButton("");
		button_13.setBounds(362, 43, 69, 29);
		panel.add(button_13);

		JButton button_14 = new JButton("");
		button_14.setBounds(433, 43, 69, 29);
		panel.add(button_14);

		JButton button_15 = new JButton("");
		button_15.setBounds(503, 43, 69, 29);
		panel.add(button_15);

		JButton button_16 = new JButton("");
		button_16.setBounds(577, 43, 69, 29);
		panel.add(button_16);

		JButton button_17 = new JButton("");
		button_17.setBounds(6, 83, 69, 29);
		panel.add(button_17);

		JButton button_18 = new JButton("");
		button_18.setBounds(73, 83, 69, 29);
		panel.add(button_18);

		JButton button_19 = new JButton("");
		button_19.setBounds(146, 83, 69, 29);
		panel.add(button_19);

		JButton button_20 = new JButton("");
		button_20.setBounds(217, 83, 69, 29);
		panel.add(button_20);

		JButton button_21 = new JButton("");
		button_21.setBounds(289, 83, 69, 29);
		panel.add(button_21);

		JButton button_22 = new JButton("");
		button_22.setBounds(362, 83, 69, 29);
		panel.add(button_22);

		JButton button_23 = new JButton("");
		button_23.setBounds(433, 83, 69, 29);
		panel.add(button_23);

		JButton button_24 = new JButton("");
		button_24.setBounds(503, 83, 69, 29);
		panel.add(button_24);

		JButton button_25 = new JButton("");
		button_25.setBounds(577, 83, 69, 29);
		panel.add(button_25);

		JButton button_26 = new JButton("");
		button_26.setBounds(6, 122, 69, 29);
		panel.add(button_26);

		JButton button_27 = new JButton("");
		button_27.setBounds(73, 122, 69, 29);
		panel.add(button_27);

		JButton button_28 = new JButton("");
		button_28.setBounds(146, 122, 69, 29);
		panel.add(button_28);

		JButton button_29 = new JButton("");
		button_29.setBounds(217, 122, 69, 29);
		panel.add(button_29);

		JButton button_30 = new JButton("");
		button_30.setBounds(289, 122, 69, 29);
		panel.add(button_30);

		JButton button_31 = new JButton("");
		button_31.setBounds(362, 122, 69, 29);
		panel.add(button_31);

		JButton button_32 = new JButton("");
		button_32.setBounds(433, 122, 69, 29);
		panel.add(button_32);

		JButton button_33 = new JButton("");
		button_33.setBounds(503, 122, 69, 29);
		panel.add(button_33);

		JButton button_34 = new JButton("");
		button_34.setBounds(577, 122, 69, 29);
		panel.add(button_34);

		JButton button_35 = new JButton("");
		button_35.setBounds(6, 163, 69, 29);
		panel.add(button_35);

		JButton button_36 = new JButton("");
		button_36.setBounds(73, 163, 69, 29);
		panel.add(button_36);

		JButton button_37 = new JButton("");
		button_37.setBounds(146, 163, 69, 29);
		panel.add(button_37);

		JButton button_38 = new JButton("");
		button_38.setBounds(217, 163, 69, 29);
		panel.add(button_38);

		JButton button_39 = new JButton("");
		button_39.setBounds(289, 163, 69, 29);
		panel.add(button_39);

		JButton button_40 = new JButton("");
		button_40.setBounds(362, 163, 69, 29);
		panel.add(button_40);

		JButton button_41 = new JButton("");
		button_41.setBounds(433, 163, 69, 29);
		panel.add(button_41);

		JButton button_42 = new JButton("");
		button_42.setBounds(503, 163, 69, 29);
		panel.add(button_42);

		JButton button_43 = new JButton("");
		button_43.setBounds(577, 163, 69, 29);
		panel.add(button_43);

		JButton button_44 = new JButton("");
		button_44.setBounds(6, 203, 69, 29);
		panel.add(button_44);

		JButton button_45 = new JButton("");
		button_45.setBounds(73, 203, 69, 29);
		panel.add(button_45);

		JButton button_46 = new JButton("");
		button_46.setBounds(146, 203, 69, 29);
		panel.add(button_46);

		JButton button_47 = new JButton("");
		button_47.setBounds(217, 203, 69, 29);
		panel.add(button_47);

		JButton button_48 = new JButton("");
		button_48.setBounds(289, 203, 69, 29);
		panel.add(button_48);

		JButton button_49 = new JButton("");
		button_49.setBounds(362, 203, 69, 29);
		panel.add(button_49);

		JButton button_50 = new JButton("");
		button_50.setBounds(433, 203, 69, 29);
		panel.add(button_50);

		JButton button_51 = new JButton("");
		button_51.setBounds(503, 203, 69, 29);
		panel.add(button_51);

		JButton button_52 = new JButton("");
		button_52.setBounds(577, 203, 69, 29);
		panel.add(button_52);

		JButton button_53 = new JButton("");
		button_53.setBounds(6, 244, 69, 29);
		panel.add(button_53);

		JButton button_54 = new JButton("");
		button_54.setBounds(73, 244, 69, 29);
		panel.add(button_54);

		JButton button_55 = new JButton("");
		button_55.setBounds(146, 244, 69, 29);
		panel.add(button_55);

		JButton button_56 = new JButton("");
		button_56.setBounds(217, 244, 69, 29);
		panel.add(button_56);

		JButton button_57 = new JButton("");
		button_57.setBounds(289, 244, 69, 29);
		panel.add(button_57);

		JButton button_58 = new JButton("");
		button_58.setBounds(362, 244, 69, 29);
		panel.add(button_58);

		JButton button_59 = new JButton("");
		button_59.setBounds(433, 244, 69, 29);
		panel.add(button_59);

		JButton button_60 = new JButton("");
		button_60.setBounds(503, 244, 69, 29);
		panel.add(button_60);

		JButton button_61 = new JButton("");
		button_61.setBounds(577, 244, 69, 29);
		panel.add(button_61);

		JButton button_62 = new JButton("");
		button_62.setBounds(6, 285, 69, 29);
		panel.add(button_62);

		JButton button_63 = new JButton("");
		button_63.setBounds(73, 285, 69, 29);
		panel.add(button_63);

		JButton button_64 = new JButton("");
		button_64.setBounds(146, 285, 69, 29);
		panel.add(button_64);

		JButton button_65 = new JButton("");
		button_65.setBounds(217, 285, 69, 29);
		panel.add(button_65);

		JButton button_66 = new JButton("");
		button_66.setBounds(289, 285, 69, 29);
		panel.add(button_66);

		JButton button_67 = new JButton("");
		button_67.setBounds(362, 285, 69, 29);
		panel.add(button_67);

		JButton button_68 = new JButton("");
		button_68.setBounds(433, 285, 69, 29);
		panel.add(button_68);

		JButton button_69 = new JButton("");
		button_69.setBounds(503, 285, 69, 29);
		panel.add(button_69);

		JButton button_70 = new JButton("");
		button_70.setBounds(577, 285, 69, 29);
		panel.add(button_70);

		JButton button_71 = new JButton("");
		button_71.setBounds(6, 326, 69, 29);
		panel.add(button_71);

		JButton button_72 = new JButton("");
		button_72.setBounds(73, 326, 69, 29);
		panel.add(button_72);

		JButton button_73 = new JButton("");
		button_73.setBounds(146, 326, 69, 29);
		panel.add(button_73);

		JButton button_74 = new JButton("");
		button_74.setBounds(217, 326, 69, 29);
		panel.add(button_74);

		JButton button_75 = new JButton("");
		button_75.setBounds(289, 326, 69, 29);
		panel.add(button_75);

		JButton button_76 = new JButton("");
		button_76.setBounds(362, 326, 69, 29);
		panel.add(button_76);

		JButton button_77 = new JButton("");
		button_77.setBounds(433, 326, 69, 29);
		panel.add(button_77);

		JButton button_78 = new JButton("");
		button_78.setBounds(503, 326, 69, 29);
		panel.add(button_78);

		JButton button_79 = new JButton("");
		button_79.setBounds(577, 326, 69, 29);
		panel.add(button_79);

		JButton btnStart = new JButton("Start!!!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread timer = new Thread(new TimerKeeper());
				timer.start();
				Thread questions = new Thread(new GenerateQuestions());
				questions.start();
				Thread score = new Thread(new ScoreUpdater());
				score.start();
			}
		});
		btnStart.setBounds(6, 27, 117, 29);
		frame.getContentPane().add(btnStart);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(194, 26, 72, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("score");
		lblNewLabel.setBounds(146, 32, 52, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblTimeLeft = new JLabel("Time left");
		lblTimeLeft.setBounds(288, 32, 65, 16);
		frame.getContentPane().add(lblTimeLeft);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(351, 26, 72, 28);
		frame.getContentPane().add(textField_1);

		ButtonGroup bg = new ButtonGroup();

		JRadioButton rdbtnEasy = new JRadioButton("easy");
		rdbtnEasy.setSelected(true);
		rdbtnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = 0;
				changeInterval = 4000;
			}
		});
		rdbtnEasy.setBounds(454, 28, 65, 23);

		frame.getContentPane().add(rdbtnEasy);

		JRadioButton rdbtnHard = new JRadioButton("hard");
		rdbtnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = 1;
				changeInterval = 2000;
			}
		});
		rdbtnHard.setBounds(530, 28, 65, 23);
		frame.getContentPane().add(rdbtnHard);

		bg.add(rdbtnEasy);
		bg.add(rdbtnHard);

		buttonGroups.add(button);
		buttonGroups.add(button_1);
		buttonGroups.add(button_2);
		buttonGroups.add(button_3);
		buttonGroups.add(button_4);
		buttonGroups.add(button_5);
		buttonGroups.add(button_6);
		buttonGroups.add(button_7);
		buttonGroups.add(button_8);
		buttonGroups.add(button_9);
		buttonGroups.add(button_10);
		buttonGroups.add(button_11);
		buttonGroups.add(button_12);
		buttonGroups.add(button_13);
		buttonGroups.add(button_14);
		buttonGroups.add(button_15);
		buttonGroups.add(button_16);
		buttonGroups.add(button_17);
		buttonGroups.add(button_18);
		buttonGroups.add(button_19);
		buttonGroups.add(button_20);
		buttonGroups.add(button_21);
		buttonGroups.add(button_22);
		buttonGroups.add(button_23);
		buttonGroups.add(button_24);
		buttonGroups.add(button_25);
		buttonGroups.add(button_26);
		buttonGroups.add(button_27);
		buttonGroups.add(button_28);
		buttonGroups.add(button_29);
		buttonGroups.add(button_30);
		buttonGroups.add(button_31);
		buttonGroups.add(button_32);
		buttonGroups.add(button_33);
		buttonGroups.add(button_34);
		buttonGroups.add(button_35);
		buttonGroups.add(button_36);
		buttonGroups.add(button_37);
		buttonGroups.add(button_38);
		buttonGroups.add(button_39);
		buttonGroups.add(button_40);
		buttonGroups.add(button_41);
		buttonGroups.add(button_42);
		buttonGroups.add(button_43);
		buttonGroups.add(button_44);
		buttonGroups.add(button_45);
		buttonGroups.add(button_46);
		buttonGroups.add(button_47);
		buttonGroups.add(button_48);
		buttonGroups.add(button_49);
		buttonGroups.add(button_50);
		buttonGroups.add(button_51);
		buttonGroups.add(button_52);
		buttonGroups.add(button_53);
		buttonGroups.add(button_54);
		buttonGroups.add(button_55);
		buttonGroups.add(button_56);
		buttonGroups.add(button_57);
		buttonGroups.add(button_58);
		buttonGroups.add(button_59);
		buttonGroups.add(button_60);
		buttonGroups.add(button_61);
		buttonGroups.add(button_62);
		buttonGroups.add(button_63);
		buttonGroups.add(button_64);
		buttonGroups.add(button_65);
		buttonGroups.add(button_66);
		buttonGroups.add(button_67);
		buttonGroups.add(button_68);
		buttonGroups.add(button_69);
		buttonGroups.add(button_70);
		buttonGroups.add(button_71);
		buttonGroups.add(button_72);
		buttonGroups.add(button_73);
		buttonGroups.add(button_74);
		buttonGroups.add(button_75);
		buttonGroups.add(button_76);
		buttonGroups.add(button_77);
		buttonGroups.add(button_78);
		buttonGroups.add(button_79);

		for (final JButton each : buttonGroups) {
			each.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (timeflag) {
						textField_2.setText("");
						if (each.equals(currentJButton)) {
							if (currentJButton.getText().equals(":)")) {
								score = score + 1;
								textField_2.setForeground(Color.GREEN);
								textField_2.setText("great,you say hi to :)");
								numberofMeetingHappy++;
							} else {
								score = score - 1;
								textField_2.setForeground(Color.RED);
								textField_2
										.setText("should encourage him to be happy by click the button left");
								numberofMisMeetSad++;
							}
						}
						currentJButton.setText("");
					}
				}
			});
		}

		JButton btnSkip = new JButton("Be Happy");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (timeflag) {
					textField_2.setText("");
					if (currentJButton.getText().equals(":(")) {
						score = score + 1;
						textField_2.setForeground(Color.GREEN);
						textField_2.setText("made sad to be happy");
						// textField_2.set
						numberofMakeSadToHappy++;

					} else {
						score = score - 1;
						textField_2.setForeground(Color.RED);
						textField_2.setText("should say hi to :) by click :)");
						numberOfMisMeetHappy++;
					}
					currentJButton.setText("");

				}
			}
		});
		btnSkip.setBounds(478, 54, 170, 29);
		frame.getContentPane().add(btnSkip);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(16, 55, 425, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

	}

	private class GenerateQuestions implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while (timeflag) {
				for(JButton each:buttonGroups){
					each.setText("");
				}
				Random rd = new Random();
				int number = rd.nextInt(80);
				if (number % 2 == 0) {
					currentJButton = buttonGroups.get(rd.nextInt(buttonGroups
							.size()));
					currentJButton.setText(":(");
					//System.out.println("currentJbutton is ;(");
				} else {
					currentJButton = buttonGroups.get(rd.nextInt(buttonGroups
							.size()));
					currentJButton.setText(":)");
					// System.out.println("currentJbutton is ;)");
				}
				// previousButton = currentJButton;
				try {
					Thread.sleep(changeInterval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	private class ScoreUpdater implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("start update the score");
			while (timeflag) {
				textField.setText(score + "");
			}

		}

	}

	private class TimerKeeper implements Runnable {

		@Override
		public void run() {

			// TODO Auto-generated method stub
			try {
				for (int i = 0; i < 60; i++) {
					Thread.sleep(1000);
					timeleft--;
					textField_1.setText(timeleft + "");
					// System.out.println("1 second passed.");
				}
				timeflag = false;
				textField_2.setText("time is over");
				

				
				System.out.println("you met "+numberofMeetingHappy+" happy face(s) and said hi to them");
				System.out.println("you met "+numberofMakeSadToHappy +" sad face(s) and encourage them to be happy");
				System.out.println("you failed in these:");
				System.out.println("ask "+numberOfMisMeetHappy+"happy person to be happy");
				System.out.println("say hi to " +numberofMisMeetSad+" sad people");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
