package arrays;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExperimentJava {
    public static void main(String[] args) {
        printDirContent("/Users/emix/go/src/practicalalgo", true);
    }

    static void printDirContent(String dir, boolean ignoreHidden) {
        System.out.println("directory structure of " + dir);
        printDirContent(new File(dir), 0, ignoreHidden);
    }

    static void printDirContent(File dir, int tabsCount, boolean ignoreHidden) {

        if (!dir.exists()) throw new IllegalArgumentException(dir + " does not exist");
        if (!dir.isDirectory()) throw new IllegalArgumentException(dir + " is not directory");

        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < tabsCount; i++) {
            tabs.append("\t");
        }

        StringBuilder dirOutput = new StringBuilder();
        dirOutput
                .append(tabs)
                .append(dir.getName())
                .append("/");
        System.out.println(dirOutput.toString());

        for (File file : dir.listFiles()) {
            if (ignoreHidden && file.getName().startsWith(".")) continue;

            if (file.isDirectory()) {
                printDirContent(file, tabsCount + 1, ignoreHidden);
            } else {
                StringBuilder fileOutput = new StringBuilder();
                fileOutput
                        .append("\t")
                        .append(tabs)
                        .append(file.getName());
                System.out.println(fileOutput.toString());
            }
        }
    }


    public static void testIslands() {
        int[][] matrix = new int[5][5];

//        matrix[0][0] = 1;
//        matrix[0][4] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
//        matrix[2][3] = 1;
        matrix[3][1] = 1;
        matrix[3][2] = 1;
        matrix[3][3] = 1;
        matrix[4][4] = 1;

        Islands.Result result = new Islands().islands(matrix);
        System.out.println(result);
    }

    static class Islands {
        class Result {
            int islands;
            int ones;

            Result(int islands, int ones) {
                this.islands = islands;
                this.ones = ones;
            }

            @Override
            public String toString() {
                return "island count: " + islands + ", total ones: " + ones;
            }
        }

        Result islands(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return new Result(0, 0);
            int n = matrix[0].length;
            int islands = 0;
            int ones = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int onesForPoint = islandSearch(matrix, i, j, 0, m, n);
                    if (onesForPoint > 0) {
                        ones += onesForPoint;
                        islands++;
                    }
                }
            }
            return new Result(islands, ones);
        }

        private int islandSearch(int[][] matrix, int i, int j, int count, int m, int n) {
            if (!inRange(i, j, m, n) || matrix[i][j] == 0) {
                return count;
            }
            int newCount = count + 1;
            matrix[i][j] = 0;
            return Math.max(
                    Math.max(islandSearch(matrix, i + 1, j, newCount, m, n),
                            islandSearch(matrix, i - 1, j, newCount, m, n)),
                    Math.max(islandSearch(matrix, i, j + 1, newCount, m, n),
                            islandSearch(matrix, i, j - 1, newCount, m, n)));
        }

        private boolean inRange(int i, int j, int m, int n) {
            return i >= 0 && j >= 0 && i < m && j < n;
        }
    }
}

