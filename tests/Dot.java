import java.security.cert.PKIXCertPathBuilderResult;

class Dot {  // model
	private int xpos;
	private int ypos;
	private int radius;
	private int colorCode;  // 0 - black 1 - red
	public Dot() {
		xpos = 0;
		ypos = 0;
		radius = 5;
		colorCode = 0;
	}
	public Dot(int x, int y, int r, int cc) {
		setXPos(x);
		setYPos(y);
		setRadius(r);
		setColorCode(cc);
	}
	public int getColorCode() {
		return colorCode;
	}
	public void setColorCode(int cc) {
		if (cc < 0) {
			colorCode = 0;
		} else if (colorCode > 1) {
			colorCode = 1;
		} else {
			colorCode = cc;
		}
	}
	public int getXPos() {
		return xpos;
	}
	public int getYPos() {
		return ypos;
	}
	public int getRadius() {
		return radius;
	}
	public void setXPos(int x) {
		if (x < 0) {
			xpos = 0;
		} else {
			xpos = x;
		}
	}
	public void setYPos(int y) {
		if (y < 0) {
			ypos = 0;
		} else {
			ypos = y;
		}
	}
	public void setRadius(int r) {
		if (r < 0) {
			radius = 5;
		} else {
			radius = r;
		}
	}
	@Override
	public String toString() {
		return String.format("%d %d %d %d",xpos,ypos,radius,colorCode);
	}
}
