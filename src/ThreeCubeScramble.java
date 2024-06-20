import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class ThreeCubeScramble  {

	ThreeCubeScramble(TextField scrambleSizeField, JLabel finalScrambelLabel) {

//		available movements for a 3x3x3 cube
		String[] moves = {"F", "'F", "2F",
						  "B", "'B", "2B",
						  "L", "'L", "2L",
						  "R", "'R", "2R",
						  "U", "'U", "2U",
						  "D", "'D", "2D",
		};

//		checking scramble max size
		String sizeString = scrambleSizeField.getText();
		int size = 0;
		//checking null textfield
		if(sizeString.matches("")) {
			size = 0;
		} else {
			size = Integer.parseInt(sizeString);
		}
		//checking edges
		if (size <= 0 || size > 25) {
			size = 25;
		}

//		declaration of independency
		Random rand = new Random();
		String[] scramble = new String[size];
		int previous = -1;

		for (int i = 0; i < size; i++) {
			//generating random numbers
			int random = rand.nextInt(moves.length);

			try {
				//exception trys
				Exceptions.validateSameMovementException(previous, random);
				Exceptions.validateParallelMovementException(previous, random);

				//generating scramble array
				//getting random movements
				scramble[i] = moves[random];
				previous = random;
			} catch (Exception e) {
				//if any exception is catch
				i--;
			}
		}

//		arranging scramble for printing command
		String finalScramble = Arrays.toString(scramble);
		finalScramble = finalScramble.replace(",", "");
		finalScramble = finalScramble.replace("]", "");
		finalScramble = finalScramble.replace("[", "");
		//printing scramble
		finalScrambelLabel.setText(finalScramble);

	}
}

