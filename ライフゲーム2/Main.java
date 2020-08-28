import java.io.IOException;

public class Main {
	
 static int wide = 24;
 static int height = 24;
 
 static int cursorX,cursorY;
 
 static int[][][] cells = new int[2][height][wide];
 static int current;
 
 static int getAdjacentLiveCount(int x,int y) {
  int count = 0;
 	for(int y2=-1; y2<=1; y2++) {
 	for(int x2=-1; x2<=1; x2++) {
 		if((x2==0)&&(y2==0))
 			continue;
 		 int x3 =( wide+ x + x2)%wide;
 		 int y3 = (height+ y + y2)%height;
 		 count += cells[current][y3][x3];
 	}
 	}
 	return count;
 }
 
	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO 自動生成されたメソッド・スタブ
		ConsoleControl cl = new ConsoleControl();
		
		while(true) {
			cl.clearScreen();
 for(int y=0; y<height; y++) {
  for(int x=0; x<wide; x++) {
  if((x==cursorX)&&(y==cursorY)) {
  		System.out.print("◎");
  	}
  	else {
  	if(cells[current][y][x] == 0) {
  		System.out.print("・");
  		
  	}
  	else {
  		System.out.print("■");
  	}
  
  	}
  }
	/*
  	if((x==cursorX)&&(y==cursorY)) {
 		System.out.print("＠");
 	}
 	else {
 	int arive = getAdjacentLiveCount(x,y);
 	
 	System.out.print(arive);
 
 	}
}*/
  System.out.print("\n");
	}
 String con = new java.util.Scanner(System.in).nextLine();
 switch(con) {
 case "w": cursorY--; break;
 case "s": cursorY++; break;
 case "a": cursorX--; break;
 case "d": cursorX++; break;
 case "x": cells[current][cursorY][cursorX] ^=1; break;
 case "c": for(int y=0; y<height; y++)
 											for(int x=0; x<wide; x++)
 												cells[current][y][x] = 0;
 case "z": 
 	for(int y=0; y<height; y++) 
   for(int x=0; x<wide; x++) {
   	int n = getAdjacentLiveCount(x,y);
   	int next = cells[current][y][x];
   	if(cells[current][y][x]==1) {
   		if((n <= 1)||(n >= 4)) 
   			next = 0;
   		
   	}
   	else {
   		if(n==3) 
   			next = 1;
   		}
   		cells[current ^ 1][y][x] = next;
   	}
   	current ^= 1;
 
 	break;
 
 }
	}
		}
}

	
