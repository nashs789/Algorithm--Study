package Programmers.Lv1.Q71;

public class Q71_CardDeck {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        int cardIdx1 = 0;
        int cardIdx2 = 0;
        String answer = "";

        for(String str : goal){
            if(cards1.length > cardIdx1 && cards1[cardIdx1].equals(str)){
                cardIdx1++;
                continue;
            }

            if(cards2.length > cardIdx2 && cards2[cardIdx2].equals(str)){
                cardIdx2++;
                continue;
            }

            answer = "No";
            break;
        }

        System.out.println(answer.equals("") ? "Yes" : answer);
    }
}