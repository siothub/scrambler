import exceptions.ParallelMovementException;
import exceptions.SameMovementException;

public class Exceptions {

	static void validateSameMovementException(int previous, int random) throws SameMovementException {

		String lastMove = switch (previous) {
			case 0, 1, 2 -> "F";
			case 3, 4, 5 -> "B";
			case 6, 7, 8 -> "L";
			case 9, 10, 11 -> "R";
			case 12, 13, 14 -> "U";
			case 15, 16, 17 -> "D";
			default -> "";
		};
		String currentMove = switch (random) {
			case 0, 1, 2 -> "F";
			case 3, 4, 5 -> "B";
			case 6, 7, 8 -> "L";
			case 9, 10, 11 -> "R";
			case 12, 13, 14 -> "U";
			case 15, 16, 17 -> "D";
			default -> "";
		};

		if(currentMove.matches(lastMove)) {
			throw new SameMovementException();
		}

	}

	static void validateParallelMovementException(int previous, int random) throws ParallelMovementException {

		String lastMove = switch (previous) {
			case 0, 1, 2 -> "F";
			case 3, 4, 5 -> "B";
			case 6, 7, 8 -> "L";
			case 9, 10, 11 -> "R";
			case 12, 13, 14 -> "U";
			case 15, 16, 17 -> "D";
			default -> "";
		};
		String currentMove = switch (random) {
			case 0, 1, 2 -> "F";
			case 3, 4, 5 -> "B";
			case 6, 7, 8 -> "L";
			case 9, 10, 11 -> "R";
			case 12, 13, 14 -> "U";
			case 15, 16, 17 -> "D";
			default -> "";
		};

		boolean throwsit = false;

		if (currentMove.matches("F") && lastMove.matches("B")) {
			throwsit = true;
		}
		if (currentMove.matches("B") && lastMove.matches("F")) {
			throwsit = true;
		}
		if (currentMove.matches("L") && lastMove.matches("R")) {
			throwsit = true;
		}
		if (currentMove.matches("R") && lastMove.matches("L")) {
			throwsit = true;
		}
		if (currentMove.matches("U") && lastMove.matches("D")) {
			throwsit = true;
		}
		if (currentMove.matches("D") && lastMove.matches("U")) {
			throwsit = true;
		}

		if (throwsit) {
			throw new ParallelMovementException();
		}
	}



}
