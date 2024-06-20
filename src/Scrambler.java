import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class Scrambler extends JFrame implements ActionListener, KeyListener {

//	declaration of independency
	ImageIcon icon = new ImageIcon("C:\\Users\\ypanq\\IdeaProjects\\rubiks-scrambler\\src\\cube.png");

	JPanel header = new JPanel();
		JLabel scramblerTittleLabel = new JLabel("Rubik's Cube Scrambler");
		Font tittleSection = new Font("Times New Roman", Font.BOLD, 20);


	JPanel finalScrambel = new JPanel();
		JLabel finalScrambelLabel = new JLabel();
		Font scrambleTittle = new Font("Lato", Font.PLAIN, 14);


	JPanel scrambleOptions = new JPanel();

		JPanel buttonPanel = new JPanel();
			JButton scrambleButton = new JButton("Scramble!");

		JPanel textFieldPanel = new JPanel();
			TextField scrambleSizeField = new TextField();

		JPanel tittlePanel = new JPanel();
			JLabel tittleLabel = new JLabel("Scramble size:");
			Font underTittle = new Font("Times New Roman", Font.ITALIC, 14);

		JPanel cubeChoicePanel = new JPanel();
			JLabel cubeChoiceLabel = new JLabel("Choose a cube:");
			JComboBox cubeComboBox = new JComboBox();

	Scrambler() {

//		framing
		this.setTitle("Rubik's Cube Scrambler");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
		this.setSize(462,189);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);


//		panels
//		main three
		header.setBounds(0,0,452,50);
		header.setLayout(null);

		finalScrambel.setBounds(0,50,452,50);
		finalScrambel.setLayout(null);

		scrambleOptions.setBounds(0,100,452,50);
		scrambleOptions.setLayout(null);


//		opion panels

		cubeChoicePanel.setBounds(0,0,131,50);
		cubeChoicePanel.setLayout(null);
//		cubeChoicePanel.setBackground(Color.GREEN);

		tittlePanel.setBounds(131,0,131,50);
		tittlePanel.setLayout(null);
//		tittlePanel.setBackground(Color.BLUE);

		textFieldPanel.setBounds(262,0,70,50);
		textFieldPanel.setLayout(null);
//		textFieldPanel.setBackground(Color.RED);

		buttonPanel.setBounds(332,0,120,50);
		buttonPanel.setLayout(null);
//		buttonPanel.setBackground(Color.YELLOW);

		scrambleOptions.add(cubeChoicePanel);
		scrambleOptions.add(tittlePanel);
		scrambleOptions.add(textFieldPanel);
		scrambleOptions.add(buttonPanel);

//		header: tittle label 1
		scramblerTittleLabel.setBounds(0,0,450,50);
		scramblerTittleLabel.setFont(tittleSection);
		scramblerTittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scramblerTittleLabel.setVerticalAlignment(SwingConstants.CENTER);
		header.add(scramblerTittleLabel);

//		FINAL SCRAMBLE: the scramble itself
		finalScrambelLabel.setBounds(0,0,450,50);
		finalScrambelLabel.setFont(scrambleTittle);
		finalScrambelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalScrambelLabel.setVerticalAlignment(SwingConstants.CENTER);

		finalScrambel.add(finalScrambelLabel);

//		SCRAMBLE OPTIONS: button , textfield and its tittle
//		radio cube choices
		cubeChoiceLabel.setBounds(0,0,131,50);
		cubeChoiceLabel.setFont(underTittle);
		cubeChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cubeChoiceLabel.setVerticalAlignment(SwingConstants.TOP);
		cubeChoicePanel.add(cubeChoiceLabel);


		cubeComboBox.setBounds(20,20,85,20);
		cubeComboBox.addItem("3x3x3");
		cubeComboBox.addItem("2x2x2");
		cubeComboBox.setBackground(new Color(0xEEEEEE));
		cubeChoiceLabel.add(cubeComboBox);

		cubeComboBox.addActionListener(this);
		cubeComboBox.addKeyListener(this);
		
//		tittle
		tittleLabel.setBounds(0,0,131,50);
		tittleLabel.setFont(underTittle);
		tittleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tittleLabel.setVerticalAlignment(SwingConstants.CENTER);
		tittlePanel.add(tittleLabel);

//		textfield
		scrambleSizeField.setBounds(10,13,50,24);
		scrambleSizeField.setCaretPosition(2);
		scrambleSizeField.setText("25");
		scrambleSizeField.setEditable(true);
		scrambleSizeField.setBackground(new Color(0xEEEEEE));
		textFieldPanel.add(scrambleSizeField);
		scrambleSizeField.addKeyListener(this);

//		button
		scrambleButton.setBounds(10,13,100,24);
		scrambleButton.setBackground(Color.RED);
		scrambleButton.setForeground(Color.WHITE);
		scrambleButton.setFocusable(false);
		buttonPanel.add(scrambleButton);

		scrambleButton.addActionListener(this);

//		adding stuff
		this.add(header);
		this.add(finalScrambel);
		this.add(scrambleOptions);

//		opacity
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cube = String.valueOf(cubeComboBox.getSelectedItem());
		if (cube.matches("3x3x3")) {
			scrambleSizeField.setText("25");
			ThreeCubeScramble scrambleCode = new ThreeCubeScramble(scrambleSizeField, finalScrambelLabel);
		}
		if (cube.matches("2x2x2")) {
			scrambleSizeField.setText("10");
			TwoCubeScramble scrambleCode = new TwoCubeScramble(scrambleSizeField, finalScrambelLabel);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
//		preventing letters from being typed -> errors
		char digit = e.getKeyChar();
		if (!Character.isDigit(digit)) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
//		action performed when enter key released
		if (e.getKeyCode()==KeyEvent.VK_ENTER){

			String cube = String.valueOf(cubeComboBox.getSelectedItem());
			if (cube.matches("3x3x3")) {
				scrambleSizeField.setText("25");
				ThreeCubeScramble scrambleCode = new ThreeCubeScramble(scrambleSizeField, finalScrambelLabel);
			}
			if (cube.matches("2x2x2")) {
				scrambleSizeField.setText("10");
				TwoCubeScramble scrambleCode = new TwoCubeScramble(scrambleSizeField, finalScrambelLabel);
			}
		}

	}

}
