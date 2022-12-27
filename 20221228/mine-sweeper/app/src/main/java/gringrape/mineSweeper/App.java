/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gringrape.mineSweeper;

import java.awt.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- 지뢰찾기 게임 ---");

        Board board = new Board();

        while (board.isSearching()) {
            // Input
            System.out.println("행 번호를 입력하세요.");
            int row = scanner.nextInt();
            System.out.println("열 번호를 입력하세요.");
            int column = scanner.nextInt();

            // Process
            board.select(row, column);
        }

        // Output
        if (board.isDestroyed()) {
            System.out.println("지뢰 폭파!");
            return;
        }

        System.out.println("게임 클리어!");
    }
}