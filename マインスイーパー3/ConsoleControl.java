

import java.io.IOException;
public class ConsoleControl {

	public void clearScreen() throws IOException, InterruptedException {
  new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
}
}