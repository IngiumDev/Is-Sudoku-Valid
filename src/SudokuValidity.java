import java.util.ArrayList;

public class SudokuValidity {
    public static void main(String[] args) {
        // Source: LeetCode.com
        char[][] board1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is the board (#1) valid? " + isValidSudoku(board1)); // true
        // Source 2: LeetCode.com
        char[][] board2 = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("Is the board (#2) valid? " + isValidSudoku(board2)); // false
        // Source3: GeeksForGeeks.com
        char[][] board3 = new char[][]{{'7', '9', '2', '1', '5', '4', '3', '8', '6'},
                {'6', '4', '3', '8', '2', '7', '1', '5', '9'},
                {'8', '5', '1', '3', '9', '6', '7', '2', '4'},
                {'2', '6', '5', '9', '7', '3', '8', '4', '1'},
                {'4', '8', '9', '5', '6', '1', '2', '7', '3'},
                {'3', '1', '7', '4', '8', '2', '9', '6', '5'},
                {'1', '3', '6', '7', '4', '8', '5', '9', '2'},
                {'9', '7', '4', '2', '1', '5', '6', '3', '8'},
                {'5', '2', '8', '6', '3', '9', '4', '1', '7'}};
        System.out.println("Is the board (#3) valid? " + isValidSudoku(board3)); // true
    }

    /**
     * @param board a 9x9 2D array
     * @return true if the board is valid according to sudoku rules, false otherwise
     */
    public static boolean isValidSudoku(char[][] board) {
        // Check if rows are valid
        // iterate through each row and passes it to the isValidRow method
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }
        }
        // Check if columns are valid
        // iterate through each column and passes it to the isValidColumn method
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
        }
        // Check if 3x3 sub-grids are valid
        // iterate through each sub-grid and passes it to the isValidSubGrid method
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubGrid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @param row a 1D array of 9 elements
     * @return true if the row is valid according to sudoku rules, false otherwise
     */
    public static boolean isValidRow(char[] row) {
        // Create an ArrayList to store the numbers that have already been seen
        ArrayList<Character> seenBefore = new ArrayList<Character>();
        for (int i = 0; i < row.length; i++) {
            // Exception for empty cells (represented by '.')
            if (row[i] != '.') {
                // If the number has already been seen, return false
                if (seenBefore.contains(row[i])) {
                    return false;
                } else {
                    // Otherwise, add the number to the ArrayList
                    seenBefore.add(row[i]);
                }
            }
        }
        return true;
    }

    /**
     * @param board a 9x9 2D array
     * @param column the column to check
     * @return true if the column is valid according to sudoku rules, false otherwise
     */
    public static boolean isValidColumn(char[][] board, int column) {
        // Create an ArrayList to store the numbers that have already been seen
        ArrayList<Character> seenBefore = new ArrayList<Character>();
        for (int i = 0; i < board.length; i++) {
            // Exception for empty cells (represented by '.')
            if (board[i][column] != '.') {
                // If the number has already been seen, return false
                if (seenBefore.contains(board[i][column])) {
                    return false;
                } else {
                    // Otherwise, add the number to the ArrayList
                    seenBefore.add(board[i][column]);
                }
            }
        }
        return true;
    }

    /**
     * @param board a 9x9 2D array
     * @param rowOfSub the row of the top-left corner of the sub-grid
     * @param columnOfSub the column of the top-left corner of the sub-grid
     * @return true if the sub-grid is valid according to sudoku rules, false otherwise
     */
    public static boolean isValidSubGrid(char[][] board, int rowOfSub, int columnOfSub) {
        // Create an ArrayList to store the numbers that have already been seen
        ArrayList<Character> seenBefore = new ArrayList<Character>();
        // Iterate through the sub-grid
        for (int i = rowOfSub; i < rowOfSub + 3; i++) {
            for (int j = columnOfSub; j < columnOfSub + 3; j++) {
                // Exception for empty cells (represented by '.')
                if (board[i][j] != '.') {
                    // If the number has already been seen, return false
                    if (seenBefore.contains(board[i][j])) {
                        return false;
                    } else {
                        // Otherwise, add the number to the ArrayList
                        seenBefore.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
