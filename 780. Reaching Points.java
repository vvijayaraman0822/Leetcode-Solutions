// 780. Reaching Points

// Top Down Approach
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) { // Keep reducing the Integer until this condition
            if (tx < ty) {
                ty = ty % tx;
            } else {
                tx = tx % ty;
            }
        }
     
/* 
Since sy will translate to ty only by (sx+sy), if they translate then(sx, sy+k*sx) = ty for some k
sy+k*sx = ty => (ty-sy) / sx = k. Since sx,sy,tx,ty are all integer, then k has to be a integer which means, there must be a integer k that help us to reach ty. Which makes reminder to be 0. Hence, (ty-sy) % sx == 0

*/
     return sx == tx && sy <= ty && (ty - sy) % sx == 0 || sy == ty && sx <= tx && (tx - sx) % sy == 0;
        
    }
}