/*
Sudoku Solver in Java
Jonas Wong Zhi Shuen
Feel free to use and edit the code. Not the most optimal to complete puzzle
Perform with Intelli J
* */

package com.company;

class Main {

    public static void main(String[] args) {

        int [][] grid = {{3, 1, 9, 5, 0, 8, 4, 0, 0},
                         {5, 2, 0, 0, 0, 0, 0, 0, 0},
                         {0, 8, 7, 0, 2, 0, 0, 3, 1},
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},
                         {0, 5, 0, 0, 9, 0, 6, 0, 0},
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        sudoku solve = new sudoku(grid);
        solve.solve(grid);
        solve.print_grid(grid);
    }
}
