class Solution {

    double maxVolume(double perimeter, double area) {
        double part1 = (perimeter - Math.sqrt(Math.pow(perimeter, 2) - (24 * area))) / 12;
        double part2 = (perimeter / 4) - (2 * part1);
        double ans = Math.pow(part1, 2) * part2;
        
        return ans;
    }}
