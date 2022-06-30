import java.util.Random;

public class Board {
    // A 2-D Matrix to store the positions chosen by players
    public int[][] board = new int[3][3];
    // 1 means X and -1 means O here and 0 means empty position

    // This function prints the board with positions mentioned in it
    /*
     * -----------
     * | 1 | 2 | 3 |
     * -----------
     * | 4 | 5 | 6 |
     * -----------
     * | 7 | 8 | 9 |
     * -----------
     */
    public void Print() {
        System.out.println("");
        int x = 1;
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(x + " | ");
                x++;
            }
            System.out.println("");
            System.out.println(" -----------");
        }
    }

    // This functions Prints the board's current position
    public void Display() {
        System.out.println("");
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    System.out.print(" ");
                    // If value is 0 that means no move has been made at that position
                } else {
                    if (board[i][j] == 1) {
                        System.out.print("X");
                        // If value is 1 that means X is present there
                    } else {
                        System.out.print("O");
                        // If value is -1 that means O is present there
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println(" -----------");
        }
    }

    // This function checks whether the given position is empty or occupied in the
    // board
    public int Check(int pos) {
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        if (board[i][j] == 0) {
            return 1; // If unoccupied return 1
        } else {
            return 0; // If occupied return 0
        }
    }

    // This function checks whether in the current state of board any player is
    // winning
    public int Win() {
        int sum;

        // If X wins then we return 1, if O wins we return -1

        // First we check if any row is fully filled by X or O
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[i][j];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        // If no row is fully filled with 1 or -1 then we check the columns
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[j][i];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        sum = 0;

        // If neither row nor column then we check diagonals if they're filled with only
        // 1 or -1
        for (int i = 0; i < 3; i++) {
            sum += board[i][i];
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }

        sum = 0;

        // Here we check for the another diagonal
        for (int i = 0; i < 3; i++) {
            sum += board[i][2 - i];
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }

        // If no player wins then we return 0
        return 0;
    }

    // This function updates the move made in the board at position pos
    public void Update(int pos, int val) {
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        board[i][j] = val;
    }

    // This function clears the board after a game is over and set everything to 0
    // in board
    public void Clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    // This function finds the move that computer should make
    // This is not the most optimal because in some cases Player also wins
    public int Computer() {
        int pos;

        // If there is more than 1 'O' then we check whether it is possible to make the
        // computer win
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = -1;
                    // If at this unoccupied position we fill 'O' and computer wins we make this
                    // move
                    if (Win() == -1) {
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

        // If the computer can't win then it try to resist the player from winning
        // It will check if it is possible to reduce players chance of winning in next
        // move by putting O there
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = 1;
                    if (Win() == 1) {
                        // If at this unoccupied position we fill 'X' and player wins we make this
                        // move and fill X here
                        board[i][j] = -1;
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

        // If no above conditions can be met then the computer randomly makes a move in
        // an unoccupied position
        Random random = new Random();
        pos = random.nextInt(9) + 1;
        while (Check(pos) == 0) {
            pos = random.nextInt(9) + 1;
        }
        Update(pos, -1);
        return pos;
    }
}