package Q8_10_Paint_Fill;

public class Question {

	public enum Color {
		Black, White, Red, Yellow, Green
	}
	
	public static String PrintColor(Color c) {
		switch(c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}
	
	public static void PrintScreen(Color[][] screen) {
		for (int r = 0; r < screen.length; r++) {
			for (int c = 0; c < screen[0].length; c++) {
				System.out.print(PrintColor(screen[r][c]));
			}
			System.out.println();
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
		if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
			return false;
		}
		if (screen[r][c] == ocolor) {
			screen[r][c] = ncolor;
			PaintFill(screen, r - 1, c, ocolor, ncolor); // up
			PaintFill(screen, r + 1, c, ocolor, ncolor); // down
			PaintFill(screen, r, c - 1, ocolor, ncolor); // left
			PaintFill(screen, r, c + 1, ocolor, ncolor); // right
		}
		return true;
	}
	
	public static boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {
		if (screen[r][c] == ncolor) return false;
		return PaintFill(screen, r, c, screen[r][c], ncolor);
	}
	
	public static void main(String[] args) {
		int N = 10;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		PaintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}

}
