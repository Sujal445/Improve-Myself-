import java.util.Scanner;

class TicTacToe {
	static char[][] board = {
		{ '1', '2', '3'},

		{ '4', '5', '6'},

		{ '7', '8', '9'}
	};

	private static char player = 'X';

	public static void main(String[] args) {
		showBoard();
		for (int i = 0; i < 9 ; i++) {
			playTurn();
			showBoard();
			if (checkForWin()) {
				System.out.println("Player " + player + " Win");
				break;
			} else if (checkForTie()) {
				System.out.println("It's a Tie");
			}
			switchPlayer();
		}

	}

	public static void showBoard() {
		for (int row = 0 ; row < 3 ; row++) {
			System.out.print("\t");
			for (int col = 0 ; col < 3 ; col++) {
				System.out.print(board[row][col]);
				if (col < 2) {
					System.out.print(" | ");
				}
			}
			if (row < 2) {
				System.out.println("\n\t----------");
			}
		}
		System.out.println();
	}

	public static void playTurn() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Player " + player + " Enter your choice : ");
			choice = sc.nextInt();
		} while (!isValidMove(choice));
		markPlace(choice);
	}

	public static boolean isValidMove(int choice) {
		if (choice < 1 || choice > 9) {
			System.out.println("Invalid Choice , Enter valid choice");
			return false;
		}
		int row = (choice - 1) / 3 ;
		int col = (choice - 1) % 3 ;
		if (board[row][col] == 'X' | board[row][col] == '0') {
			System.out.println("Already taken , Choose another ");
			return false;
		}
		return true;
	}

	public static void markPlace(int choice) {
		int row = (choice - 1) / 3 ;
		int col = (choice - 1) % 3 ;
		board[row] [col] = player;
	}

	public static void switchPlayer() {
		player = (player == 'X') ? '0' : 'X' ;
	}

	public static boolean checkForWin() {
		return (checkRow() || checkColumn() || checkDiagonal());
	}

	public static boolean checkRow() {
		for (int i = 0 ; i < 3 ; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColumn() {
		for (int i = 0 ; i < 3 ; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkDiagonal() {
		if (board[0][0] == board[1][1] && board[2][2] == board[1][1]) {
			return true;
		}
		if (board[0][2] == board[1][1] && board[2][0] == board[1][1]) {
			return true;
		}
		return false;
	}

	public static boolean checkForTie() {
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if (board[i][j] != 'X' && board[i][j] != '0') {
					return false;
				}
			}
		}
		return true;
	}
}