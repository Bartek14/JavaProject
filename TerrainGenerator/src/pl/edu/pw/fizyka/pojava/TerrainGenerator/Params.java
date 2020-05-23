package pl.edu.pw.fizyka.pojava.TerrainGenerator;

public class Params {
	
	   private long seed;
	   private float smoothness=2f;
	   private float roughness=0.3f;
	   private float maxHeight=320;
	   private int octaves=4;
	   private float relativness = 4f;
	   
	   public Params(long seed, float roughness, float maxHeight, int octaves, float relativness ) {
		// TODO Auto-generated constructor stub
		   
		   this.seed = seed;
		   this.roughness = roughness;
		   this.smoothness = smoothness;
		   this.maxHeight = maxHeight;
		   this.octaves = octaves;
		   this.relativness = relativness;
	   
	   }
	public long getSeed() {
		return seed;
	}
	public void setSeed(long seed) {
		this.seed = seed;
	}
	public float getSmoothness() {
		return smoothness;
	}
	public void setSmoothness(float smoothness) {
		this.smoothness = smoothness;
	}
	public float getRoughness() {
		return roughness;
	}
	public void setRoughness(float roughness) {
		this.roughness = roughness;
	}
	public float getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(float maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getOctaves() {
		return octaves;
	}
	public void setOctaves(int octaves) {
		this.octaves = octaves;
	}
	public float getRelativness() {
		return relativness;
	}
	public void setRelativness(float relativness) {
		this.relativness = relativness;
	}
	   
}
