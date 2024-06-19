import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class Scrambler extends JFrame implements ActionListener, KeyListener {

//	declarations
	ImageIcon icon = new ImageIcon("C:\\Users\\ypanq\\IdeaProjects\\rubiks-scrambler\\src\\cube.png");

	JPanel header = new JPanel();
		JLabel scramblerTittleLabel = new JLabel("3x3x3 Rubik's Cube Scrambler");
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
			JLabel tittleLabel = new JLabel("Choose a scramble size:");
			Font underTittle = new Font("Times New Roman", Font.ITALIC, 14);

	Scrambler() {

//		framing
		this.setTitle("Rubik's Cube Scrambler");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
		this.setSize(466,189);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

//		panels
//		main three
		header.setBounds(0,0,450,50);
		header.setLayout(null);

		finalScrambel.setBounds(0,50,450,50);
		finalScrambel.setLayout(null);

		scrambleOptions.setBounds(0,100,450,50);
		scrambleOptions.setLayout(null);

//		opion panels

		tittlePanel.setBounds(0,0,210,50);
		tittlePanel.setLayout(null);

		textFieldPanel.setBounds(210,0,70,50);
		textFieldPanel.setLayout(null);

		buttonPanel.setBounds(280,0,120,50);
		buttonPanel.setLayout(null);

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
//		tittle
		tittleLabel.setBounds(0,0,210,50);
		tittleLabel.setFont(underTittle);
		tittleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tittleLabel.setVerticalAlignment(SwingConstants.CENTER);
		tittlePanel.add(tittleLabel);

//		textfield
		scrambleSizeField.setBounds(10,13,50,24);
		scrambleSizeField.setText("25");
		scrambleSizeField.setCaretPosition(2);
		scrambleSizeField.setEditable(true);
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
		ScrambleCode scrambleCode = new ScrambleCode(scrambleSizeField, finalScrambelLabel);
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
			ScrambleCode scrambleCode = new ScrambleCode(scrambleSizeField, finalScrambelLabel);
		}
	}

}
