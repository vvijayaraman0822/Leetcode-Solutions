// 1041. Robot Bounded In Circle


class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] directionVector = new int[] {0,1}; // directional vector
        int[] startingVector = new int[] {0,0}; // starting vector 
        
        // G, add 1 to y axis -> starting Vector
        // L, interchange x and y and make X minus -> direction vector
        // R, interchange x and y and make Y minus -> direction vector
        
  for (int i = 0; i < 4; i++) {
        for (char instruction : instructions.toCharArray()) {
            if ('G' == instruction) {
                startingVector[0] += directionVector[0];
                startingVector[1] += directionVector[1];
            } else if ('L' == instruction) {
                int temp = directionVector[0];
                directionVector[0] = -1 * directionVector[1];
                directionVector[1] = temp;
            }  else if ('R' == instruction) {
                int temp = directionVector[1];
                directionVector[1] = -1 * directionVector[0];
                directionVector[0] = temp;
            }
        }
  }
        // first condition means it's back to starting point. Second means it's just going up up and upward. 
        return (startingVector[0] == 0 && startingVector[1] == 0) || (directionVector[0] != 0 && directionVector[1] != 1);
    }
}