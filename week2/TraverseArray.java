public class TraverseArray {

    public static void main(String[] args) {
        char[][] grid = {{'x', 'x'},
                         {'x', 'x'},
                         {'x', 'x'},
                         {'x', 'x'}};
        // this is for row major traversal
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col){
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
            
            System.out.println();
            // this is for col major traversal
        for (int col = 0; col < grid[0].length; ++col){
            for (int row = 0; row < grid.length; ++row) {
                    System.out.print(grid[row][col]);
            }
            System.out.println();
        }   
    }
}