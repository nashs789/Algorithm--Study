package Book.AlgorithmicProblemSolvingStrategies.Chapter6.Ex1;

public class Ex1_BoggleGame {

    private static int[][] move = {
            {-1, 0},     // 상
            {1, 0},      // 하
            {0, -1},     // 좌
            {0, 1},      // 우
            {-1, -1},    // 좌상
            {-1, 1},     // 우상
            {1, -1},     // 좌하
            {1, 1},      // 우하
    };

    public static void main(String[] args) {
        String[][] map1 = {
                {"U", "R", "L", "P", "M"},
                {"X", "P", "R", "E", "T"},
                {"G", "I", "A", "E", "T"},
                {"X", "T", "N", "Z", "Y"},
                {"X", "O", "Q41_Spicier", "R", "S"}
        };
        String[][] map2 = {
                {"N", "N", "N", "N", "S"},
                {"N", "E", "E", "E", "N"},
                {"N", "E", "Y", "E", "N"},
                {"N", "E", "E", "E", "N"},
                {"N", "N", "N", "N", "N"}
        };
        String[] words = {"PRETTY", "GIRL", "REPEAT", "YES", "NOTICE", "GIANT", "PERL", "NO"};

        System.out.println(hasWord(1, 1, 1, words[0], map1));
        System.out.println(hasWord(2, 0, 1, words[1], map1));
        System.out.println(hasWord(1, 2, 1, words[2], map1));
        System.out.println(hasWord(2, 2, 1, words[3], map2));
        System.out.println(hasWord(2, 2, 1, words[4], map2));
        System.out.println(hasWord(2, 0, 1, words[5], map1));
        System.out.println(hasWord(0, 4, 1, words[6], map1));
        System.out.println(hasWord(2, 2, 1, words[7], map2));
    }

    // 배제 && 선행 조건
    // 1. 시작 좌표가 주어질 것 (첫 글자가 일치함)
    // 2. 주어진 좌표가 유효한 좌표일것
    static boolean hasWord(int x, int y, int letterIdx, String str, String[][] map){
        for(int idx = 0; idx < 8; idx++){
            int newX = x + move[idx][0];
            int newY = y + move[idx][1];

            if(newX < 0 || newY < 0 || newX > 4 || newY > 4){
                continue;
            }

            if(!map[x][y].equals(Character.toString(str.charAt(letterIdx - 1)))){
                return false;
            }

            if(str.length() - 1 == letterIdx){
                return true;
            }

            // 현재 글자 위치에서 8방향 글자중 일치한 글자가 있는지 확인
            if(Character.toString(str.charAt(letterIdx)).equals(map[newX][newY])){
                if(hasWord(newX, newY, letterIdx + 1, str, map)){
                    return true;
                }
            }
        }

        return false;
    }
}