/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {  
    Set<String> visitedCell = new HashSet<>();
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}}; // up, right, down, left
    public void  cleanRoom(Robot robot) {
        int row = 1;
        int col = 3;
        int direction = 0;
        robot.clean();
        StringBuilder res = new StringBuilder();
        res.append(row);
        res.append("-");
        res.append(col);
        visitedCell.add(res.toString());
        findNewCell(robot, direction, row, col);
        return;
    }
    public void findNewCell(Robot robot, int direction, int row, int col){
        for(int i = 0; i < 4; i++){
            int newDirection = (i+direction>3)? i+direction-4: i+direction; // I made a mistake here, previously I put i+direction-3, should be i+direction-4
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];
            StringBuilder res = new StringBuilder();
            res.append(newRow);
            res.append("-");
            res.append(newCol);
            String resString = res.toString();
            if(!visitedCell.contains(resString)&& robot.move()){
                visitedCell.add(resString);
                robot.clean();
                findNewCell(robot, newDirection,  newRow, newCol);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
        }
    }
}
