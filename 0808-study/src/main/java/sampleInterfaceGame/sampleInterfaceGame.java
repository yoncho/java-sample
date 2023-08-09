package sampleInterfaceGame;

import java.util.Scanner;

public class sampleInterfaceGame {

	interface ConsoleGame{
		abstract void keyA();
		abstract void keyD();
		abstract void keyW();
		abstract void keyS();
		
		abstract void ShowMap();
		abstract boolean CheckPosition(int x, int y);
	}
	
	static class MyGame implements ConsoleGame{
		public int positionX = 4;
		public int positionY = 4;
		public int n;
		public int m;
		
		public MyGame(int mapWidht, int mapHeight)
		{
			this.m = mapWidht;
			this.n = mapHeight;
		}
		@Override
		public void keyA() {
			// TODO Auto-generated method stub
			if(CheckPosition(positionX - 1, positionY))
			{
				positionX -= 1;
			}
			ShowMap();
		}


		@Override
		public void keyD() {
			// TODO Auto-generated method stub
			if(CheckPosition(positionX + 1, positionY))
			{
				positionX += 1;
			}
			ShowMap();
		}


		@Override
		public void keyW() {
			// TODO Auto-generated method stub
			if(CheckPosition(positionX, positionY - 1))
			{
				positionY -= 1;
			}
			ShowMap();
		}


		@Override
		public void keyS() {
			// TODO Auto-generated method stub
			if(CheckPosition(positionX, positionY + 1))
			{
				positionY += 1;
			}
			ShowMap();
		}
		
		public void ShowMap() {
			clearConsole();
			// TODO Auto-generated method stub
			for(int i = 0 ; i < n; i ++)
			{
				for(int j = 0; j < m; j++)
				{
					if (j == positionX && i == positionY)
					{
						System.out.print("■");
						continue;
					}
					
					if((i == 0 || i == n-1) && (j == 0 || j == m-1))
					{
						System.out.print("*");
					}
					else if(i == 0 || i == n-1)
					{
						System.out.print("*");
					}
					else if (j == 0 || j == m-1) {
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");
					}
					
					
				}
				System.out.print("\n");
			}
		}
		@Override
		public boolean CheckPosition(int x, int y) {
			// TODO Auto-generated method stub
			if(x <= 0 || x >= n - 1 || y <= 0 || y >= m - 1)
			{
				return false;
			}
			return true;
		}
	}
	
	static void startGame()
	{
		Scanner scanner = new Scanner(System.in);
		MyGame game = new MyGame(10,10);
		game.ShowMap();
		while(true)
		{
			switch (scanner.next().charAt(0)){
				case 'a':
					game.keyA();
					break;
				case 'w':
					game.keyW();
					break;
				case 's':
					game.keyS();
					break;
				case 'd':
					game.keyD();
					break;
				case 'q':
					System.out.println("게임 종료");
					break;
			}
		}
	}
	
	public static void clearConsole() {
	    for (int i = 0; i < 50; ++i) {
	        System.out.println();
	    }
	}
	public static void main(String[] args) {
		startGame();
	}

}
