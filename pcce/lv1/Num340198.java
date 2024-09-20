package pcce.lv1;

public class Num340198 {

    public static void main(String[] args) {

        int[] mats = new int[]{5, 3, 2};
        String[][] park = new String[][]
                {{"A",  "A", "-1", "-1", "-1", "-1", "-1", "-1"},
                 {"A",  "A", "-1", "-1", "-1", "-1", "-1", "-1"},
                 {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                 {"D", "-1", "A", "-1", "-1", "A", "-1", "-1"},
                 {"D", "-1", "-1", "-1", "-1", "-1", "-1", "F"},
                 {"D", "-1", "-1", "-1", "-1", "-1", "-1", "F"}};

        int maxMat = -1;

        int[][] dp = new int[park.length][park[0].length];

        for(int i = 0; i < park.length; i++) {
            if("-1".equals(park[i][0])){
                dp[i][0] = 1;
            } else{
                dp[i][0] = 0;
            }
        }

        for(int j=0; j < park[0].length; j++) {
            if("-1".equals(park[0][j])){
                dp[0][j] = 1;
            } else{
                dp[0][j] = 0;
            }
        }

        for(int i=1; i < park.length; i++) {
            for(int j=1; j < park[i].length; j++) {
                if("-1".equals(park[i][j])) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    if(dp[i][j] > maxMat) maxMat = dp[i][j];
                }
            }
        }


        int answer = -1;
        for (int mat : mats) {
            if (mat <= maxMat && mat > answer) {
                answer = mat;
            }
        }


        System.out.println(answer);

    }

}
