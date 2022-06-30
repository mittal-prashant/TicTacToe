There are 5 files : TicTacToe.java, TicTacToe.class, Board.java, Board.class and README.md

Please run the program only when TicTacToe.java and Board.java are present.

The Following Instructions Should Be Followed While Playing TIC TAC TOE (Running The Program) :

    A. Enter the command javac TicTaeToe.java in the terminal after that enter the command java TicTacToe to run the program.
    B. When it is asked by the program how you wish to play you should only enter an integer value.
    C. When asked for Position which you want to make a move to input a single integer and not index for 2-D array (two integers).
    D. Carefully read all the messages displayed by the program and input according to it.
    E. When asked for another game in same mode enter y/Y for another game and any other character for exiting it.
    F. When asked for again how you wish to play please enter an integer type only.

The board is a 2-D Matrix of Dimensions 3x3, and it is an integer type.

Value 0 means empty, 1 represents X and -1 represents O.

The Unoccupied position is checked by the value stored a position in board : 

    - If the value is 0 that means it is Unoccupied
    - If the value is 1 that means it is filled with X
    - If the value is -1 that means it is filled with O

After every move it is checked whether a player has won :

    - If the sum in any of rows, or any of columns or any of diagonals is 3 that means X has won
    - If the sum in any of rows, or any of columns or any of diagonals is -3 that means O has won
    - Otherwise no one has won and game moves on

Count in TicTacToe keeps track of no of moves, if it 9 and no one has won that means the gram has drawn.

When Computer has to make a move in Computer vs Player Mode then the Following steps are followed :

    A. First we check if computer can win, if it can then computer goes for that move.
    B. It checks if a place is Unoccupied such that if it is filled then sum in any of the rows, or columns or diagonals become -3, then it makes that move.
    C. If above doesn't happen it goes for a move in which it can resist Player from winning if in next move Player can win.
    D. If no above condition occurs then it make a random move in an Unoccupied position.
