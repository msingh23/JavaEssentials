package ctci.chap8;

public class ColorFill {

	public enum Color {
		green, blue, orange, red, white
	}

	public boolean colorFill(Color ncolor, Color[][] screen, int r, int c) {

		if (screen[r][c] == ncolor) {
			return false;
		}
		return colorFillHelper(ncolor, screen[r][c], screen, r, c);
	}

	private boolean colorFillHelper(Color ncolor, Color ocolor, Color[][] screen, int r, int c) {

		if(r<0 || c < 0 || r>screen.length || c > screen[0].length )
		{
			return false;
		}
		
		if(screen[r][c]==ocolor){
			screen[r][c] = ncolor;
			colorFillHelper(ncolor, ocolor, screen, r+1, c); //forward
			colorFillHelper(ncolor, ocolor, screen, r-1, c); //backward
			colorFillHelper(ncolor, ocolor, screen, r, c+1); //upward
			colorFillHelper(ncolor, ocolor, screen, r, c-1); //downward
		}
		return true;
	}

}
