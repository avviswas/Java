package jmv;

public class Maze {

    static int game = -1;
    static char[][] a = new char[12][12];

    private static void mazeTraversal(int i, int j) {
        game++;

        //LEFT move
        if (j > 0 && a[i][j - 1] == '.') {
            a[i][j] = 'X';
            mazeTraversal(i, j - 1);
        } else if (j < 11 && a[i][j + 1] == '.') {////RIGHT move
            a[i][j] = 'X';
            mazeTraversal(i, j + 1);
        } else if (i > 0 && a[i - 1][j] == '.') {////UP move
            a[i][j] = 'X';
            mazeTraversal(i - 1, j);
        } else if (i < 11 && a[i + 1][j] == '.') {////DOWN move
            a[i][j] = 'X';
            mazeTraversal(i + 1, j);
        } else if (i == 0 || j == 0 || i == 11 || j == 11) {
            a[i][j] = 'X';
        } else {
            a[i][j] = '0';//Wrong Path
            /////////////////////////TRACING BACK//////////////////////
            if (j > 0 && a[i][j - 1] == 'X') {//LEFT
                a[i][j] = '0';
                mazeTraversal(i, j - 1);
            } else if (j < 11 && a[i][j + 1] == 'X') {//RIGHT
                a[i][j] = '0';
                mazeTraversal(i, j + 1);
            } else if (i > 0 && a[i - 1][j] == 'X') {//UP
                a[i][j] = '0';
                mazeTraversal(i - 1, j);
            }
            else if (i < 11 && a[i + 1][j] == 'X') {//DOWN
                a[i][j] = '0';
                mazeTraversal(i + 1, j);
            }
        }
    }

    public static void main(String... args) {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                a[i][j] = '#';
            }
        }
        a[1][1] = a[1][2] = a[1][3] = a[1][5] = a[1][6] = a[1][7] = a[1][8] = a[1][9] = a[1][10] = '.';
        a[2][0] = a[2][1] = a[2][3] = a[2][5] = a[2][10] = '.';
        a[3][3] = a[3][5] = a[3][6] = a[3][7] = a[3][8] = a[3][10] = '.';
        a[4][1] = a[4][2] = a[4][3] = a[4][4] = a[4][8] = a[4][10] = a[4][11] = '.';
        a[5][4] = a[5][6] = a[5][8] = a[5][10] = '.';
        a[6][1] = a[6][2] = a[6][4] = a[6][6] = a[6][8] = a[6][10] = '.';
        a[7][2] = a[7][4] = a[7][6] = a[7][8] = a[7][2] = a[7][10] = '.';
        a[8][1] = a[8][2] = a[8][3] = a[8][4] = a[8][5] = a[8][6] = a[8][7] = a[8][8] = a[8][10] = '.';
        a[9][6] = a[9][10] = '.';
        a[10][1] = a[10][2] = a[10][3] = a[10][4] = a[10][5] = a[10][6] = a[10][8] = a[10][9] = a[10][10] = '.';


        //Inputting to the maze
        mazeTraversal(2, 0);
        System.out.println("Final Move Number-" + game);
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 12; l++) {
                System.out.print(a[k][l] + "  ");
            }
            System.out.println();
        }
    }
}