package Programmers.Lv1.Q38;

public class Q38_MinimumRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int widthMax = 0; // inded: 0
        int columnMax = 0; // inded: 1

        for(int[] businessCard : sizes){
            int width = businessCard[0];
            int column = businessCard[1];

            if(width < column){
                businessCard[0] = column;
                businessCard[1] = width;
            }

            if(widthMax < businessCard[0]){
                widthMax = businessCard[0];
            }

            if(columnMax < businessCard[1]){
                columnMax = businessCard[1];
            }
        }

        // return widthMax * columnMax;
    }
}
