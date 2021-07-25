import java.util.LinkedList;

public class MazeSolver {
    // static can be simple instantiated
    static int[][] maze = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 1, 2},
            {0, 1, 0, 0}
    };
    // 0 = wall
    // 1 = path
    // 2 = destination
    // x = row
    // y = column
    static LinkedList<StartingPosition> path = new LinkedList<StartingPosition>();
    public static void main(String[] args){
        StartingPosition sp = new StartingPosition(0, 3);
        // push to the start so we can create a stack
        path.push(sp);
        // [row][column]



        while(true){
            int x = path.peek().x;
            int y = path.peek().y;
            maze[y][x] = 0;
            // moving down
            if(maze[y+1][x] == 2){
                System.out.println("Moved down. you Won!");
                return;
            } else if(maze[y+1][x] == 1){
                System.out.println("Move down!");
                path.push(new StartingPosition(y+1, x));
                continue;
            }
            // move left
            if(maze[y][x-1] == 2){
                System.out.println("Moved left. you Won!");
                return;
            } else if(maze[y][x-1] == 1){
                System.out.println("Move left!");
                path.push(new StartingPosition(y, x-1));
                continue;
            }
            // move up
            if(maze[y-1][x] == 2){
                System.out.println("Moved up. you Won!");
                return;
            } else if(maze[y-1][x] == 1){
                System.out.println("Move up!");
                path.push(new StartingPosition(y-1, x));
                continue;
            }
            // move right
            if(maze[y][x+1] == 2){
                System.out.println("Moved right. you Won!");
                return;
            } else if(maze[y][x+1] == 1){
                System.out.println("Move right!");
                path.push(new StartingPosition(y, x+1));
                continue;
            }



        }
    }
}
