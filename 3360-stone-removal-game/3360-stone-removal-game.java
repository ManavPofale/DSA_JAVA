class Solution {
    public boolean canAliceWin(int n) {
        if (n < 10) {
            return false;
        }
        int a = n - 10;
        if (a < 9) {
            return true;
        }
        int b = a - 9;
        if (b < 8) {
            return false;
        }
        int c = b - 8;
        if (c < 7) {
            return true;
        }
        int d = c - 7;
        if (d < 6) {
            return false;
        }
        int e = d - 6;
        if (e < 5) {
            return true;
        }
        int f = e - 5;
        if (f < 4) {
            return false;
        }
        int g = f - 4;
        if (g < 3) {
            return true;
        }
        int h = g - 3;
        if (h < 2) {
            return false;
        }
        int i = h - 2;
        if (i < 1) {
            return true;
        }
        return false;
    }
}