package Game;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Draw extends JComponent
{

		   public static final int TILE_SIZE_X = 20;
		   public static final int TILE_SIZE_Y = 20;
		   
		   public static int GridLength;
		   public static int GridHeight;
		   
		   public static int GridLengthBuffer;
		   public static int GridHeightBuffer;
		   
		   public static int WinWidth;
		   public static int WinHeight;
		   
		   public static boolean ShowInfo = true;
		   public static boolean ShowArray = true;
		   
		   private static int fps = 0;
		   private int fpsc = 0;
		   private int wait = 0;
		   //private long Second_Tick = System.currentTimeMillis();
		   
		   public static Array GameBoard = new Array(40,40);
		   
		     
		   
		   
		 //declare new MapSqaure object.
		   public Tile box = new Tile();
		 
		   //public Game game = new Game();
		   	
		   
		   public void paint(Graphics g)
		   {
			  
		      Graphics2D g2 = (Graphics2D) g; // Recover Graphics2D so we can draw on it
		      setFPS();// do Math to calculate amount of redraws per second.
		      
		      //change to only draw array on window resize, for huge fps increase.
		      if(ShowArray)
		    	  DrawArray(g2); //draw the array to the screen,
		      
		      DrawText(g2); //draw text to the screen, aka fps counter.
		      DrawPlayer(g2);
		   }
		   
		   
		   /*
		    * FPS Controls.
		    */
		   public void DrawText(Graphics2D g2)
		   {
			   if(ShowInfo)
			   {
				   int lines = 1;
				   int linesW = 20;
			      //draw text to screen, to display a few messages.
				  g2.setColor(Color.black);
				  g2.fillRect(8, 10, 100, 120);
				  g2.setColor(Color.YELLOW);
				  
			      g2.drawString("FPS: "+fps,10, lines++*linesW);
			      g2.drawString("CPU: "+Compute.cpu,10,lines++*linesW);
			      g2.drawString("CPU_Ticks: "+Compute.cpu_tick,10,lines++*linesW);
			      g2.drawString("Seconds: "+Compute.GameSeconds,10,lines++*linesW);
			      g2.drawString("Tiles: "+GridLength+"x"+GridHeight,10,lines++*linesW);
			      g2.drawString("pTicks: "+NPCList.player.ptick,10,lines++*linesW);
			   }
		   }
		   
		   public void setFPS()
		   {
			   fpsc++;
			   if(Compute.Seconds > wait)
			   {
				   wait++;
				   this.fps = fpsc;
				   fpsc = 0;
			   }
			   
		   }   

		   
		   public void DrawArray(Graphics2D g2)
		   {

			   	  WinWidth = getWidth();
			   	  WinHeight = getHeight();	   	

				  GridLength = (WinWidth/TILE_SIZE_X);
				  GridHeight = (WinHeight/TILE_SIZE_Y);
				  
				  ResizeArraysDependedOnScreenSize();
				  
				  GridLengthBuffer = (WinWidth - (GridLength*TILE_SIZE_X))/2;
				  GridHeightBuffer = (WinHeight - (GridHeight*TILE_SIZE_Y))/2;   		  
				  	  
				  
			      box.setSize(TILE_SIZE_X, TILE_SIZE_Y);
			      box.setColor(Color.GRAY);
			      
			      
			      
			      for(int x = 0;x<GridLength;x++)
			      {
			         for(int y = 0;y<GridHeight;y++)
			         {
			        	 if(GameBoard.getElement(x, y) == 0)
			        	 {
			        		 box.setColor(Color.GRAY);
			        		 
			        	 }
			        	 else if (GameBoard.getElement(x, y) == 1)
			        	 {
			        		 box.setColor(Color.YELLOW);
			        	 }
			        	 else if (GameBoard.getElement(x, y) == 2)
			        	 {
			        		 box.setColor(Color.YELLOW);
			        	 }
			            //draw the sqaure object, with Graphics2D
			            box.setLocation(GridLengthBuffer + x*TILE_SIZE_X,GridHeightBuffer + y*TILE_SIZE_Y);
			            box.draw(g2);
			         }
			      }
			   
		   }
		   
		   public void ResizeArraysDependedOnScreenSize()
		   {
			   GameBoard.setArraySize(GridLength, GridHeight);
			   //Map.GameBoard.setElement(20,20,1);
			   
			   //GameBoard.printArray();
			   //go through Mouse array, find mouse clicks outof bounds and set them to 0,0 and move them to end of array,
			   //or move end of array to spots of 0,0 and get rid of end of array, to get rid of seed that are not in bounds, 
			   //Game.MouseArray.setArraySize(0,0);
		   }
		   
		   public void DrawPlayer(Graphics2D g2)
		   { 
			   NPCList.player.draw(g2);
		   }

}
