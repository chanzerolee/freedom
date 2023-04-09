package game.model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import freedomgame.Action;
import freedomgame.Monster;
import freedomgame.User;

public class GameModel {
	ArrayList<User> user = new ArrayList<>();
	Action action = new Action();
	public void gameStart(String id) {
		user.add(new User(id));
		System.out.println("id가 생성 되었습니다.");
	}
	public void plazaAction(int num) {
		
	}
	public void playGame() {
		boolean power = true;
		Scanner input = new Scanner(System.in);
		System.out.println("게임을 시작합니다.");
		// 액션 클래스에서 행동 텍스트 출력과 선택 번호에 따른 행동 하기.
		
		while(power) {
			boolean outStage = true;
			int num;
			try {
				num = action.playList();
				
				if (num == 0) {
					user.getImfomation();
				}
				else if(num == 1) {
					System.out.println();
					System.out.println("보유금액 : "+user.getMoney());
					while(outStage) {
						switch(action.goShop()) {
							case 0:
								user.getImfomation();
								break;
							case 1:
								action.buyWeapon(user);
								break;
							case 2:
								if(action.enforceWeapon(user) == 0) {
									System.out.println("돈이 부족합니다.");
								}
								else if(action.enforceWeapon(user) == 1) {
									System.out.println("강화 성공");
								}
								else if(action.enforceWeapon(user) == 2) {
									System.out.println("강화 실패");
								}else if(action.enforceWeapon(user) == 3) {
									System.out.println("강화 불가능");
								}
								break;
							case 3:
								outStage = false;
								break;
						}	
					}
				}else if(num == 2) {
					// 10초안에 죽이면 성공 아니면 실패
					while(true) { 
						int level =action.goDongoen();
						if(level == 0) {
							break;
						}
						Monster monster = new Monster(level);
						long startTime = System.currentTimeMillis();
						long endTime = System.currentTimeMillis();
						boolean clear = false;
						while((endTime-startTime)/1000<10){
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								if (monster.getHp() <= 0) {
									clear = true;
									break;
								}
								monster.attack(user.getDamege());
								endTime =  System.currentTimeMillis();
							}
						if(clear == true) {
							System.out.println("사냥 성공 + " + monster.die(user)+"G 획득");
							System.out.println("현재 잔액 : "+user.getMoney());
							}
						else {
							System.out.println("사냥 실패 돈 10퍼센트 차감");
							user.setMoney(-(user.getMoney()/10));
							System.out.println("보유금액 : "+user.getMoney());
							}
						}
				}else if(num == 3) {
					power = action.endGame();
						}
			}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
}
