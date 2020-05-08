package displayWindow;



import java.awt.DisplayMode;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import javax.swing.JFrame;


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;



public class MeshPanel extends GLJPanel implements GLEventListener {

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
   private float rquad = 0.0f;
   
   int columns = 500;
   int rows = 500;
    int scale =15;
   Random heightRandom = new Random();
   float[][] height= new float[columns][rows];
   
   public long seed;
   public float smoothness=2f;
   public float roughness=0.3f;
   public float maxHeight=70;
   public int octaves=3;


	public MeshPanel() {

		seed=7347248;
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				height[x][y]=finalHeight(x/smoothness, y/smoothness);
			}
		}
	}
      
   @Override
   public void display( GLAutoDrawable drawable ) {
	 
	   
	      final GL2 gl = drawable.getGL().getGL2();
	      
	      gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_LINE);
	      
	      
	     gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );
	     gl.glMatrixMode(GL2.GL_MODELVIEW);
	      gl.glLoadIdentity();
	      gl.glTranslatef( 20f, 190f, -320.5f );
	   
	     gl.glRotatef( rquad, 0.0f, 1.0f, 1.0f );
	     gl.glRotatef( -45, 1.0f, 0.0f, 0.0f );

	      gl.glTranslatef( -(columns*scale/2f), (rows*scale/2f), -320.5f );
	      
	      for(int y=0; y>-rows+1; y--){ 

	    	  gl.glBegin( GL2.GL_TRIANGLE_STRIP);
	    	  
				for (int x = 0; x < columns; x++) {
					gl.glVertex3f(x*scale, y*scale, height[x][-y]);
					gl.glVertex3f(x*scale, (y-1)*scale,height[x][-y+1]);
				}
				
				gl.glEnd();
				gl.glFlush();
				
	      }
	      gl.glBegin( GL2.GL_TRIANGLE_STRIP);
    	  
			for (int x = 0; x < columns; x++) {
				gl.glVertex3f(x*scale, (-rows+1)*scale, height[x][rows-1]);
				gl.glVertex3f(x*scale, -rows*scale,height[x][rows-1]);
			}
			
			gl.glEnd();
			gl.glFlush();
	      
	  
	      rquad+=0.5f;
	    }
   
   @Override
   public void dispose( GLAutoDrawable drawable ) {
    
   }
   
   @Override
   public void init( GLAutoDrawable drawable ) {
	
   }
      
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	 
	   
	   GL2 gl = drawable.getGL().getGL2();
	      
	      if( height <= 0 )
	         height = 1;
				
	      final float h = ( float ) width / ( float ) height;
	      gl.glViewport( 0, 0, width, height );
	      gl.glMatrixMode( GL2.GL_PROJECTION );
	      gl.glLoadIdentity();
	  
			
	      glu.gluPerspective( 95.0f, h, 1.0, 2000.0 );
	      gl.glMatrixMode( GL2.GL_MODELVIEW );
	      gl.glLoadIdentity();
	      
   }
      
   private float randomHeight(int x, int y) {
	  
	   float height=0;
	   height = randomValue(x,y)/2f+(randomValue(x,y+1)+randomValue(x,y-1)+randomValue(x-1,y)+randomValue(x+1,y))+
			   (randomValue(x+1,y+1)+randomValue(x+1,y-1)+randomValue(x-1,y+1)+randomValue(x-1,y-1))/2f;
	   return height;
	   
	   }
   private float randomValue(int x, int y) {
	   
	   heightRandom.setSeed(x*12345+y*4321+seed*54321);
	   return heightRandom.nextFloat()*2-1;
    }
   private float cosineFading(float startInterpolation, float endInterpolation, float factor ) {
	   
	   factor = (float)(1f-Math.cos(factor*Math.PI))/2f;
	   return startInterpolation*(1f-factor) +endInterpolation * factor;
	   
	   
   }
   private float interpolatedHeight(float x, float y) {

	   float downLeft = randomHeight(((int) x), ((int) y));
	   float upLeft = randomHeight(((int) x), ((int) y)+1);
	   float upRight = randomHeight(((int) x)+1, ((int) y)+1);
	   float downRight = randomHeight(((int) x)+1, ((int) y));
	   
	   
	   float bottomInterpolation = cosineFading(downLeft, downRight,  x-((int) x));
	   float topInterpolation = cosineFading(upLeft, upRight,  x-((int) x));
	 
	   return cosineFading(bottomInterpolation, topInterpolation,  y-((int) y));
   }
	
   private float finalHeight(float x, float y) {
	   float height=0;
	   
	   
	   for(int i=0; i<octaves; i++) {
		   
		   float frequency = (float) (Math.pow(2,i)/((float) Math.pow(2, octaves-1)));
		   height+=interpolatedHeight(x*frequency, y*frequency)*maxHeight*(float)(Math.pow(roughness, i));
		   
	   }
	   return height;
   }
}
