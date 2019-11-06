
public class Block {

	public int x1 = 0;
	public int y1 = 0;
	public int x2 = 0;
	public int y2 = 0;
	
	public Block(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public int[] getBlock() {
		int[] b = new int[4];
		b[0] = x1;
		b[1] = y1;
		b[2] = x2;
		b[3] = y2;
		return b;
	}
	
	
}
