package zyanken;

public class Main {

	static final int GU = 1;
	static final int TYOKI = 2;
	static final int PA = 3;


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	    String cpu = "";
		String user = "";

		int ans = 0;
		int num = 0;

		//ユーザー
		System.out.println("じゃんけんゲームを起動します");

		while(true) {
		try {
			//CPU
			 num = new java.util.Random().nextInt(3);
			num++;

			switch(num) {

			case GU: cpu = "グー"; break;
			case TYOKI: cpu = "チョキ"; break;
			case PA: cpu = "パー"; break;

			}
		System.out.println("1：グー 2:チョキ 3:パー");
	    System.out.println("数字で出す手を選んでください");

	    ans = new java.util.Scanner(System.in).nextInt();

	    switch(ans) {

	    case GU: user = "グー"; break;
		case TYOKI: user = "チョキ"; break;
		case PA: user = "パー"; break;

	    }

		}catch(Exception e) {
			System.out.println("適切な数字を入力してください");
		}

	     if(user == cpu) {
	    	 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    	 System.out.println("あいこ\n");
	     }
	     else if(ans==GU) {
	    	 if(num==TYOKI) {
	    	 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    	 System.out.println("あなたの勝ちです\n");
	    	 }
	    	 else if(num==PA){
	    		 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    		 System.out.println("あなたの負けです\n");

	    	 }


	     }
	     else if(ans==TYOKI) {
	    	 if(num == PA) {
	    	 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    	 System.out.println("あなたのかちです\n");
	    	 }
	    	 else if(num==GU){
	    		 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    		 System.out.println("あなたの負けです\n");

	    	 }
	     }
	     else if(ans==PA) {
	    	 if(num==GU) {
	    	 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    	 System.out.println("あなたの勝ちです\n");
	    	 }
	    	 else if(num==TYOKI){
	    		 System.out.println("USER:"+user+"　"+"CPU:"+cpu);
	    		 System.out.println("あなたの負けです\n");

	    	 }

	     }
		}


	}

}
