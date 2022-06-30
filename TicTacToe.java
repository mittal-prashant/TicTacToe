import java.util.Scanner;

public class TicTacToe {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n***** TIC TAC TOE *****");

        // Printing the various modes for playing game
        System.out.println("\nEnter 1 For MultiPlayer");
        System.out.println("Enter 2 To Play With Computer");
        System.out.println("Enter 0 To Quit\n");
        System.out.print("How Do You Wish To Play : ");

        // Tells the mode in which player wish to play
        int mode = scan.nextInt();

        // New board initialized
        Board board = new Board();
        // 1 means X and -1 means O here and 0 means empty position

        while (mode != 0) {
            if (mode == 1) {
                // If mode is 1 then we go for PLayer vs Player Mode
                System.out.println("\nPlayer 1 Is X And Player 2 is O");
                board.Print();

                int pos;
                int count = 0;

                while (board.Win() == 0) {
                    // While Nobody wins game goes on unless no places left
                    if (count % 2 == 0) {
                        // If even then Player 1 makes a move
                        System.out.print("\nPlayer 1 Choose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid positions error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied Postion error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }
                        // Updating the board with the move made by Player 1
                        board.Update(pos, 1);
                    } else {
                        // If odd then Player 2 makes a move
                        System.out.print("\nPlayer 2 Choose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid positions error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied Postion error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }
                        // Updating the board with the move made by Player 2
                        board.Update(pos, -1);
                    }

                    board.Display();
                    // Printing the current board situation after every move

                    count++;

                    if (board.Win() == 1) {
                        // If Output of Win is 1 that means Player 1 has won the game
                        System.out.println("\nHurray, Player 1 Won The Game !!");
                        break;
                    } else if (board.Win() == -1) {
                        // If Output of Win is -1 that means Player 2 has won the game
                        System.out.println("\nHurray, Player 2 Won The Game !!");
                        break;
                    }

                    // If count is 9 that means no more place left to make a move in the board
                    if (count == 9) {
                        // Game Draws when count becomes 9 and no body has won in this turn
                        System.out.println("\nOops, The Game Ends With A Draw !!");
                        break;
                    }
                }

                // Clearing the board's positions after the game has ended
                board.Clear();

                // Asking for another Player vs Player game
                System.out.print("\nWant Another Multiplayer Game Then Press y/Y Else Press Anything : ");
                char another = scan.next().charAt(0);

                // If Y that means play same mode again
                if (another == 'Y' || another == 'y') {
                    continue;
                }
            } else if (mode == 2) {
                // If mode is 1 then we go for PLayer vs Player Mode
                System.out.println("\nPlayer Is X And Computer is O");
                board.Print();

                int pos;
                int count = 0;

                while (board.Win() == 0) {
                    // While Nobody wins game goes on unless no places left
                    if (count % 2 == 0) {
                        // If even then Player makes a move
                        System.out.print("\nChoose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid Position error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied position error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }
                        // Updating the board with the move made by Player
                        board.Update(pos, 1);
                    } else {
                        // Generating a move for Computer by Computer() function
                        pos = board.Computer();
                        System.out.println("\nComputer Chose Position : " + pos);
                    }

                    // Clearing the board's positions after the game has ended
                    board.Display();

                    count++;

                    if (board.Win() == 1) {
                        // If Output of Win is 1 that means Player has won the game
                        System.out.println("\nHurray, You Defeated The Computer !!");
                        break;
                    } else if (board.Win() == -1) {
                        // If Output of Win is -1 that means Computer has won the game
                        System.out.println("\nHell, AI Took Over And Won The Game !!");
                        break;
                    }

                    // If count is 9 that means no more place left to make a move in the board
                    if (count == 9) {
                        // Game Draws when count becomes 9 and no body has won in this turn
                        System.out.println("\nOops, The Game Ends With A Draw !!");
                        break;
                    }
                }

                // Clearing the board's positions after the game has ended
                board.Clear();

                // Asking for another Player vs Computer game
                System.out.print("\nWant Another Game With Computer Then Press y/Y Else Press Anything : ");
                char another = scan.next().charAt(0);

                // If Y that means play same mode again
                if (another == 'Y' || another == 'y') {
                    continue;
                }
            } else {
                // Invalid mode error
                System.out.println("Sorry, Unknown Command !!");
                System.out.print("Please Select The Mode Again : ");
            }

            // Asking the mode again
            System.out.println("\nEnter 1 For MultiPlayer");
            System.out.println("Enter 2 To Play With Computer");
            System.out.println("Enter 0 To Quit\n");
            System.out.print("How Do You Wish To Play : ");
            mode = scan.nextInt();
        }

        System.out.println("");
        scan.close();
    }
}