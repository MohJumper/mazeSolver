import java.util.ArrayList;
import java.util.LinkedList;

public class MazeSolver {

    // static can be simple instantiated

    // 0 = wall
    // 1 = m.path
    // 2 = destination
    // x = row
    // y = column
    public static void main(String[] args){
        // multiple mazes
        ArrayList<Maze> mazes = new ArrayList<Maze>();

        Maze m = new Maze();

        int[][] maze = {
                {0, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 2, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 0}
        };
        m.maze = maze;
        m.start = new StartingPosition(2, 6);
        m.path = new LinkedList<StartingPosition>();

        Maze n = new Maze();
        int[][] n_maze = {
                {0, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 2, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 0}
        };

        n.maze = n_maze;
        n.start = new StartingPosition(2, 6);
        n.path = new LinkedList<StartingPosition>();
        //
        mazes.add(m);
        mazes.add(n);

        int i = 0;
        while(i < mazes.size()){
            if (solveMaze(mazes.get(i))){
                System.out.println("You Won !!");
            }else{
                System.out.println("No path found!");
            };
            i++;
        }
        // push to the start so we can create a stack
    }

    private static boolean solveMaze(Maze m) {

        StartingPosition sp = m.start;
        m.path.push(sp);
        // [row][column]
        while(true){
            int x = m.path.peek().x;
            int y = m.path.peek().y;
            m.maze[y][x] = 0;
            // moving down
            if(isValid(y+1, x, m)){
                if(m.maze[y+1][x] == 2){
                    System.out.println("Moved down.");
                    return true;
                } else if(m.maze[y+1][x] == 1){
                    System.out.println("Move down!");
                    m.path.push(new StartingPosition(y+1, x));
                    continue;
                }
            }

            // move left
            if(isValid(y, x-1, m)){
                if(m.maze[y][x-1] == 2){
                    System.out.println("Moved left.");
                    return true;
                } else if(m.maze[y][x-1] == 1){
                    System.out.println("Move left!");
                    m.path.push(new StartingPosition(y, x-1));
                    continue;
                }
            }

            // move up
            if(isValid(y-1, x, m)){
                if(m.maze[y-1][x] == 2){
                    System.out.println("Moved up.");
                    return true;
                } else if(m.maze[y-1][x] == 1){
                    System.out.println("Move up!");
                    m.path.push(new StartingPosition(y-1, x));
                    continue;
                }
            }

            // move right
            if(isValid(y, x+1, m)){
                if(m.maze[y][x+1] == 2){
                    System.out.println("Moved right.");
                    return true;
                } else if(m.maze[y][x+1] == 1){
                    System.out.println("Move right!");
                    m.path.push(new StartingPosition(y, x+1));
                    continue;
                }
            }

            m.path.pop();
            System.out.println("Move back");
            if(m.path.size() <= 0){
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x, Maze m){
        if(y < 0 ||
                y >= m.maze.length ||
                x < 0 ||
                x >= m.maze[y].length
        ){
            return false;
        }
        return true;
    }
}
