import java.util.LinkedList;

public class MazeSolver {
    // static can be simple instantiated
    static int[][] maze = {
            {2, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
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
        maze[path.peek().x][path.peek().y] = 0;
    }
}
