

import java.io.IOException;

public class Main{

	static int height = 10;
	static int wide = 10;
	
	static int cursorX,cursorY;
	
	static final int BLACK = 0;
	static final int WHITE = 1;
	static final int NONE = -1;
	static final int WAKU = -2;
	
	static final int[] DIRECTION_UP = {0,-1};
	static final int[] DIRECTION_UP_LEFT = {-1,-1};
	static final int[] DIRECTION_LEFT = {-1,0};
	static final int[] DIRECTION_DOWN_LEFT = {-1,1};
	static final int[] DIRECTION_DOWN = {0,1};
	static final int[] DIRECTION_DOWN_RIGHT = {1,1};
	static final int[] DIRECTION_RIGHT = {1,0};
	static final int[] DIRECTION_UP_RIGHT = {1,-1};
	
	static int[][] directions = {	DIRECTION_UP,DIRECTION_UP_LEFT,DIRECTION_LEFT,DIRECTION_DOWN_LEFT,
			DIRECTION_DOWN,DIRECTION_DOWN_RIGHT,DIRECTION_RIGHT,DIRECTION_UP_RIGHT};
	
	
	
	static String[] colorNames = {
	"Black","White"
	};
	
	
	static int cells[][] = new int[height][wide];
	
	static int turn = 0;
	
	static boolean checkCanPut(int color,int x,int y,boolean turnOver) {
		if(cells[y][x]!=NONE)
			return false;
		
		for(int i=0; i<directions.length; i++) {
			int x2 = x;
			int y2 = y;
			
			x2 += directions[i][0];
			y2 += directions[i][1];
			if(cells[y2][x2]!=(color^1))
				continue;
			while(true) {
				x2 += directions[i][0];
				y2 += directions[i][1];
				if((x2<0)||(x2>=wide)||(y2<0)||(y2>=height))
					break;
				if(cells[y2][x2]==NONE)
					break;
				if(cells[y2][x2]==color) {
					if(!turnOver)
					return true;
					
					int x3 = x;
					int y3 = y;
					
					while(true) {
						cells[y3][x3] = color;
						x3 += directions[i][0];
						y3 += directions[i][1];
						
						if((x3==x2)&&(y3==y2))
							break;
					}
				}
			}
		}
		return false;
	}
	
static	boolean checkCanPutAll(int color) {
	for(int y=0; y<height; y++) {
	 for(int x=0; x<wide; x++) {
	 if(checkCanPut(color,x,y,false))
			return true;
	 }
	}
	 return false;
	 }
	 
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO 自動生成されたメソッド・スタブ
		ConsoleControl cl = new ConsoleControl();
		//盤の作成
		for(int y=0; y<height; y++) {		
		 for(int x=0; x<wide; x++) {
		 	cells[y][x] = NONE;
		 	cells[0][x] = WAKU;
		 	cells[9][x] = WAKU;
		 	cells[y][0] = WAKU;
		 	cells[y][9] = WAKU;
		 	cells[4][4]=cells[5][5] = WHITE;
		 	cells[5][4]=cells[4][5] = BLACK;
		 	
		 }
		 }
		boolean canPut = false;
		while(true) {
			cl.clearScreen();
		for(int y=0; y<height; y++) {		
		 for(int x=0; x<wide; x++) {
		 	if((x==cursorX)&&(y==cursorY))
		 		System.out.print("◎");
		 	else {
		 		switch(cells[y][x]) {
		 		case NONE: System.out.print("・");break;
		 		case BLACK: System.out.print("○");break;
		 		case WHITE: System.out.print("●");break;
		 		case WAKU: System.out.print("★"); break;
		 		}
		 	}
		 	
			}
		 System.out.print("\n");
			}
		if(canPut) {
			System.out.println("Can't put!");
		}
		else {
		System.out.println(colorNames[turn]+"　turn　1:パス");
		}
		try {
		canPut = false;
		String num = new java.util.Scanner(System.in).nextLine();
		switch(num) {
		case "w": cursorY--; break;
		case "s": cursorY++; break;
		case "a": cursorX--; break;
		case "d": cursorX++; break;
		case "1": turn ^=1; break;
		default :
			if(!checkCanPut(turn,cursorX,cursorY,false)) {
				canPut = true;
				break;
			}
			checkCanPut(turn,cursorX,cursorY,true);
			
			cells[cursorY][cursorX] = turn;
			turn ^= 1;
			
			break;
			
			}
		}catch(Exception e) {
			System.out.println("そこにはおけません！");
		}
		}
}
}
