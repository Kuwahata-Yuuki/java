



import java.io.IOException;

public class Main {

	static final int[] DIRECTION_UP = {0,-1};
	static final int[] DIRECTION_UP_LEFT = {-1,-1};
	static final int[] DIRECTION_LEFT = {-1,0};
	static final int[] DIRECTION_DOWN_LEFT = {-1,1};
	static final int[] DIRECTION_DOWN = {0,1};
	static final int[] DIRECTION_DOWN_RIGHT = {1,1};
	static final int[] DIRECTION_RIGHT = {1,0};
	static final int[] DIRECTION_UP_RIGHT = {1,-1};

	//フィールドの設定
	  static final int wide = 10;
	  static final int height = 10;

	  //操作の設定
	  static int cursorX,cursorY;

	  //モジュールの設定
	  static final int bomb = 1;
	  static final int mine = 2;
	  static final int flag = 3;
	  static final int NONE = 0;
	  static final int WAKU =	-1;

	  static final int BombCount = 10;

	  static int bomc = 7;


	  //モジュールの情報を持たせる設定
	  static int[][] cells = new int[height][wide];


	static int[][] directions = {	DIRECTION_UP,DIRECTION_UP_LEFT,DIRECTION_LEFT,DIRECTION_DOWN_LEFT,
			DIRECTION_DOWN,DIRECTION_DOWN_RIGHT,DIRECTION_RIGHT,DIRECTION_UP_RIGHT};
	//番号を出す処理
	 int getAdjacentBombsCount(int x,int y) {

		 	int n = 0;

		 	for(int y2=-1; y2<=1; y2++) {
			 	for(int x2=-1; x2<=1; x2++) {
			 		if((x2==0)&&(y2==0))
			 			continue;
			 		 int x3 =( wide+ x + x2)%wide;
			 		 int y3 = (height+ y + y2)%height;
			 		 if(cells[y3][x3]==bomb)
			 		 n += cells[y3][x3];
			 	}
		 	}




			/*for(int i=0; i<directions.length; i++) {

				int x2 = x;
				int y2 = y;

				x2 += directions[i][0];
				y2 += directions[i][1];
				if((x==cursorX)&&(y==cursorY))
					continue;
				while(true) {
					x2 += directions[i][0];
					y2 += directions[i][1];
					if((x2<0)||(x2>=wide)||(y2<0)||(y2>=height))
						break;
					if(cells[y2][x2]==NONE)
						break;
					if(cells[y2][x2]==bomb) {
						n++;


					}
				}*/




  /*int n = 0;
	for(int y=-1; y<=1; y++) {
		for(int x=-1; x<=1; x++) {
			if((x==0)&&(y==0)) {
				continue;
			}
			int x2 = _x + x;
			int y2 = _y + y;

			if(cells[y2][x2]==bomb) {
			n++;
			}
		}
	}*/


	return n;
}

	 public static void autoEraseMine(int x,int y) {
	 		if((cells[y][x]==bomb)||(!(cells[y][x]==mine))||(x<0)||(x>=wide)||(y<0)||(y>=height)) {
	 			return;
	 		}
	 		cells[y][x] = NONE;
	 	}

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO 自動生成されたメソッド・スタブ
		int n = 0;

		cells[9][8]=WAKU;
		cells[9][0]=WAKU;
		cells[9][1] = WAKU;
		cells[9][2] = WAKU;
		cells[9][3] = WAKU;
		cells[9][4]=WAKU;
		cells[9][5]=WAKU;
		cells[9][6] = WAKU;
		cells[9][7] = WAKU;
		cells[0][9] = WAKU;
		cells[1][9] = WAKU;
		cells[2][9]=WAKU;
		cells[3][9] = WAKU;
		cells[4][9] = WAKU;
		cells[5][9] = WAKU;
		cells[6][9]=WAKU;
		cells[7][9]=WAKU;
		cells[8][9] = WAKU;
		cells[9][9] = WAKU;
		cells[0][0] = WAKU;
		cells[0][1]=WAKU;
		cells[0][2] = WAKU;
		cells[0][3] = WAKU;
		cells[0][4] = WAKU;
		cells[0][5]=WAKU;
		cells[0][6] = WAKU;
		cells[0][7] = WAKU;
		cells[0][8] = WAKU;

		cells[1][0] = WAKU;
		cells[2][0]=WAKU;
		cells[3][0] = WAKU;
		cells[4][0] = WAKU;
		cells[5][0] = WAKU;
		cells[6][0]=WAKU;
		cells[7][0] = WAKU;
		cells[8][0] = WAKU;
		cells[9][0] = WAKU;


		for(int y=0; y<height; y++) {
			for(int x=0; x<wide; x++) {
		if(!(cells[y][x]==WAKU)) {
			cells[y][x] = mine;
		}
			}
		}




		for(int i=0; i<7; i++) {
		int num2 = new java.util.Random().nextInt(7);
		int num3 = new java.util.Random().nextInt(7);



		int x2 = num2 ;
		int y2 = num3 ;

		x2 += 1;
		y2 += 1;




		if(!(cells[y2][x2] == bomb)) {
			if((y2>0)||(x2<10))
		cells[y2][x2] = bomb;
		}
		}
		//n++;





		//コンソール画面のクリアのクラスインスタンス化
		ConsoleControl cl = new ConsoleControl();
		//番号を出すクラスのインスタンス化
		Main m = new Main();




	out: while(true) {


	//コンソール画面クリア
	cl.clearScreen();
	//フィールドの設定

	for(int y=0; y<height; y++) {
		for(int x=0; x<wide; x++) {





			if((x==cursorX)&&(y==cursorY))
				System.out.print("◎"+"\t");
			else if(cells[y][x]==WAKU) {
				System.out.print("★"+"\t");
			}
			else if(cells[y][x]==flag) {
				System.out.print("▲"+"\t");
			}
			else if(cells[y][x]==mine) {
				System.out.print("■"+"\t");
			}
			else if(cells[y][x]==bomb)
			 System.out.print("■"+"\t");
			else {
			 n = m.getAdjacentBombsCount(x,y);
			if(n==0)
		System.out.print("・"+"\t");

			else
				System.out.print(n+"\t");


			}
			}
		System.out.println("\n");
	}
	//操作の設定
	System.out.println("残りボム数"+bomc);
	String cont = new java.util.Scanner(System.in).nextLine();

	switch(cont){
	case "w": cursorY--; break;
	case "s": cursorY++; break;
	case "a": cursorX--; break;
	case "d": cursorX++; break;
	case "b": if(cells[cursorY][cursorX] == bomb) {
		cells[cursorY][cursorX] = NONE; break;
	}
	else if(cells[cursorY][cursorX] == WAKU) {
		System.out.println("ここにはおけません");break;
	}


	else {
		cells[cursorY][cursorX] = bomb; break;
	}
	case "m": if(cells[cursorY][cursorX] == mine ) {//ここを変える
		//cells[cursorY][cursorX] = NONE;
		for(int y2=-1; y2<=1; y2++) {
		 	for(int x2=-1; x2<=1; x2++) {
		 	 if((x2==0)&&(y2==0))
		 		 continue;
		 	int x3 = cursorX + x2;
		 	int y3 = cursorY + y2;
		 	autoEraseMine(x3,y3);
		 	}
		 	}
		break;
	}
	else if(cells[cursorY][cursorX] == WAKU) {
		System.out.println("ここにはおけません");break;
	}
	else if(cells[cursorY][cursorX]==bomb) {
		System.out.println("GAME OVER!!");
		break out;

	}
	else {
		cells[cursorY][cursorX] = mine;break;
	}
	case "f":  if(cells[cursorY][cursorX] == flag) {
		cells[cursorY][cursorX] = NONE; break;
	}

	else if(cells[cursorY][cursorX] == WAKU) {
		System.out.println("ここにはおけません");break;
	}

	else if(cells[cursorY][cursorX]==bomb){
		cells[cursorY][cursorX] = flag;


		bomc -= 1;
		if(bomc==0) {
			System.out.println("ゲームクリア！");
			break out;
		}
		}
		else if(!(cells[cursorY][cursorX]==bomb)){
			System.out.println("残念、そこはボムじゃないよ");
			break out;
		}
		}


		}

	}




	}





