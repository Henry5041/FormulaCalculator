package org.chinaarchitect.calculator.point24;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.chinaarchitect.calculator.pattern.Pattern;

/* a GUI for henry hu's 24 point program
 * developed by @author lzx3778
 * 20:03  30.25.2016
 * @version 1.0*/
/**
 * 
 * @author lzx3778
 *
 */
public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8864215849047297213L;
	// this is the number array for 24 point program to initialize
	public int[] arr = new int[4];
	// output the answer by this array,it will be printed
	public HashSet<String> output = new HashSet<String>();

	private boolean error = true;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	@SuppressWarnings("unused")
	private final JTextPane textPane = new JTextPane();
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("24\u70B9\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 10, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 41, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 72, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 103, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		final JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setEditable(false);
		textPane.setBounds(200, 10, 234, 251);
		contentPane.add(textPane);

		JButton btnGo = new JButton("GO!");
		btnGo.setBackground(SystemColor.textHighlight);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(" ");
				String list[] = new String[4];
				list[0] = textField.getText();
				list[1] = textField_1.getText();
				list[2] = textField_2.getText();
				list[3] = textField_3.getText();
				for (int i = 0; i < list.length; i++) {
					if (list[i].matches("[1-9]") | list[i].matches("[1]+[0-3]")) {
						arr[i] = Integer.parseInt(list[i]);
						// input here
						System.out.println("right!");
						error = false;
					} else {
						textPane.setText("Error at block " + (i + 1) + "\n" + textPane.getText());
						System.out.println("wrong!");
						error = true;
					}
				}
				if (!error) {

					Integer[] num = new Integer[4];
					for (int i = 0; i < 4; i++) {
						num[i] = Integer.parseInt(list[i]);
					}

					for (Integer[] pattern : new Pattern<Integer>(num).Iterate()) {

						PointMatcher matcher = new PointMatcher(pattern, 24);

						for (String eachFormula : matcher.getSuccessive()) {
							output.add(eachFormula);

						}
					}
					String str = "";

					for (String eachOutput : output) {
						// output
						str += (eachOutput + "\n");

					}
					textPane.setText(str);
				}
			}
		});
		btnGo.setBounds(97, 9, 93, 23);
		contentPane.add(btnGo);

		button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(
						"Enter numbers in the three boxes\n then press go\n the solution will shows in the big box\n the numbers should be 1-13");
			}
		});
		button.setBackground(Color.ORANGE);
		button.setBounds(10, 217, 45, 44);
		contentPane.add(button);
	}
}
