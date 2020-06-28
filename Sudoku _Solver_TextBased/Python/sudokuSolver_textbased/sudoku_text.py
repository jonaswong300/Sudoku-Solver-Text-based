# Jonas Wong Zhi Shuen
# Sudoku  solver using backtracking algorithm
# Adapted and studied @ https://www.youtube.com/watch?v=G_UYXzGuqvM&t=546s


# Print out solved Sudoku in formatted grids and lines
def print_grid(grid):
    for x in range(len(grid)):
        if x % 3 == 0 and x != 0:
            print("- - - - - - - - - - - - - -")
        for y in range(len(grid[0])):
            if y % 3 == 0:
                print(" | ", end="")
            if y == 8:
                print(grid[x][y], end="\n")
            else:
                print(grid[x][y], end=" ")


# Check if it is possible to insert a value inside an index (x, y)
# Check if it is possible to insert index at row level (x, y++)
# Check if it is possible to insert index at column level (x++, y)
# Check if it is possible to insert index within a 3 by 3 square box ((x//3) * 3, (y//3) * 3)
def possible(grid, row, col, number):
    # check col
    for i in range(0, len(grid)):
        if grid[row][i] == number:
            return False
    # Check row
    for i in range(0, len(grid)):
        if grid[i][col] == number:
            return False

    # Check square
    row_floor = (row // 3) * 3
    col_floor = (col // 3) * 3

    for i in range(3):
        for j in range(3):
            if grid[row_floor + i][col_floor + j] == number:
                return False

    return True


# Solve the sudoku puzzle
def solve(grid):
    # Loop through to find an empty index(empty is marked as 0)
    # If empty perform, possible to insert check.
    # If possible insert, apply recursion to find all possible values
    # If index is not able to find a value, reset it to 0.
    for x in range(9):
        for y in range(9):
            if grid[x][y] == 0:
                for num in range(1, 10):
                    if possible(grid, x, y, num):
                        grid[x][y] = num
                        solve(grid)
                        grid[x][y] = 0  # Backtrack happens here, if no solution for the index can be found.

                return

    print_grid(grid)
    print("\n")


# Main function
def main():
    #  grid = [[0 for x in range(9)] for y in range(9)]

    # assigning values to the grid
    # Feel free to change grid to values u like
    grid = [[3, 1, 9, 5, 0, 8, 4, 0, 0],
            [5, 2, 0, 0, 0, 0, 0, 0, 0],
            [0, 8, 7, 0, 2, 0, 0, 3, 1],
            [0, 0, 3, 0, 1, 0, 0, 8, 0],
            [9, 0, 0, 8, 6, 3, 0, 0, 5],
            [0, 5, 0, 0, 9, 0, 6, 0, 0],
            [1, 3, 0, 0, 0, 0, 2, 5, 0],
            [0, 0, 0, 0, 0, 0, 0, 7, 4],
            [0, 0, 5, 2, 0, 6, 3, 0, 0]]

    solve(grid)


# Driver function
if __name__ == '__main__':
    main()
