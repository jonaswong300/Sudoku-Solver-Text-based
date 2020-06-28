package com.company;

class sudoku {
    private final int BOARD_SIZE = 9;

    private int[][] grid;

    sudoku(int[][] grid) {
        this.grid = grid;
    }

    //Print and display grid
    public void print_grid(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            if (x % 3 == 0 && x != 0) {
                System.out.print("- - - - - - - - - - - - - -" + "\n");
            }

            for (int y = 0; y < grid[x].length; y++) {
                if (y % 3 == 0)
                    System.out.print(" | ");
                if (y == 8)
                    System.out.print(grid[x][y] + "\n");
                else
                    System.out.print(grid[x][y] + " ");
            }
        }
    }

    //Check if it is possible to insert based on 3 conditions(1. Row 2. Column 3.3x3 inner square)
    private boolean possible(int[][] grid, int row, int col, int number) {
        System.out.println("Currently at row: " + row + ", Currently at col: " + col);

        //Check rows
        for(int i = 0; i < BOARD_SIZE; i++){
            if(grid[row][i] == number){
                return false;
            }
        }

        //Check columns
        for(int i = 0; i < BOARD_SIZE; i++){
            if(grid[i][col] == number){
                return false;
            }
        }

        //Check 3x3 inner square
        int row_floor = (int) (Math.floor(row / 3.0) * 3);
        int col_floor = (int) (Math.floor(col / 3.0) * 3);

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(grid[row_floor + x][col_floor + y] == number){
                    return false;
                }
            }
        }

        //If all conditions are met
        return true;
    }

    //Time Complexity of N cube if im not wrong. (3 loops. )
    //Solve sudoku using recursive and backtracking.
    public boolean solve(int[][] grid) {
        for(int row = 0; row < BOARD_SIZE; row++){
            for(int col = 0; col < BOARD_SIZE; col++){
                //Check if board is empty.
                if(grid[row][col] == 0){
                    for(int number = 1; number <= BOARD_SIZE; number++){
                        if(possible(grid, row, col,number)){
                            grid[row][col] = number;
                            System.out.println("Inserting number: " + number + " ,at row: " + row +
                                    " ,col: " + col + "\n");

                            //Solve sudoku recursively to see if it matches
                            if(solve(grid)){
                                return true;
                            }
                        }
                        //If unable to insert within the loop, reset the grid back to 0.
                        System.out.println("Unable to insert number: " + number + " ,at row: " + row +
                                " ,col: " + col + " ,Resetting to 0\n");
                        grid[row][col] = 0;
                    }
                    //Backtracking occurs here
                    return false;
                }
            }
        }
        return true;
    }
}