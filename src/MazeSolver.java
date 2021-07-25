import java.util.LinkedList;

public class MazeSolver {
    // static can be simple instantiated
    static int[][] maze = {
            {0, 1, 1, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 2, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 0, 0, 0}
    };
    // 0 = wall
    // 1 = path
    // 2 = destination
    // x = row
    // y = column
    static LinkedList<StartingPosition> path = new LinkedList<StartingPosition>();
    public static void main(String[] args){
        StartingPosition sp = new StartingPosition(2, 6);
        // push to the start so we can create a stack
        path.push(sp);
        // [row][column]



        while(true){
            int x = path.peek().x;
            int y = path.peek().y;
            maze[y][x] = 0;
            // moving down
            if(isValid(y+1, x)){
                if(maze[y+1][x] == 2){
                    System.out.println("Moved down. you Won!");
                    return;
                } else if(maze[y+1][x] == 1){
                    System.out.println("Move down!");
                    path.push(new StartingPosition(y+1, x));
                    continue;
                }
            }

            // move left
            if(isValid(y, x-1)){
                if(maze[y][x-1] == 2){
                    System.out.println("Moved left. you Won!");
                    return;
                } else if(maze[y][x-1] == 1){
                    System.out.println("Move left!");
                    path.push(new StartingPosition(y, x-1));
                    continue;
                }
            }

            // move up
            if(isValid(y-1, x)){
                if(maze[y-1][x] == 2){
                    System.out.println("Moved up. you Won!");
                    return;
                } else if(maze[y-1][x] == 1){
                    System.out.println("Move up!");
                    path.push(new StartingPosition(y-1, x));
                    continue;
                }
            }

            // move right
            if(isValid(y, x+1)){
                if(maze[y][x+1] == 2){
                    System.out.println("Moved right. you Won!");
                    return;
                } else if(maze[y][x+1] == 1){
                    System.out.println("Move right!");
                    path.push(new StartingPosition(y, x+1));
                    continue;
                }
            }

            path.pop();
            System.out.println("Move back");
            if(path.size() <= 0){
                System.out.println("No path solution is found");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x){
        if(y < 0 ||
                y >= maze.length ||
                x < 0 ||
                x >= maze[y].length
        ){
            return false;
        }
        return true;
    }
}
