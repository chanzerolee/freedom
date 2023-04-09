package game.view;

import java.io.IOException;
import java.util.Scanner;

import gmae.controller.GameController;

public class StartView {
	public static void main(String[] args) {
		// 유저 아이디를 입력후 없는 아이디면 새로운 아이디를 존재하는 아이디면 데이터 가져오기.
		Scanner input = new Scanner(System.in);
		GameController gc = new GameController();
		System.out.print("ID를 입력해 주세요 : ");
		String id = input.next();
		gc.gameStart(id);
		while(true) {
				System.out.println();
				System.out.println("***광장***");
				System.out.println("0. 유저 정보 확인");
				System.out.println("1. 상점");
				System.out.println("2. 던전");
				System.out.println("3. 종료하기");
				System.out.print("입력 : ");				
//				gc.plazaActioin(input);
			}
		}
		
}
