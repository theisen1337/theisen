package Game;

import javax.swing.JComponent;


public class Compute
{

	 private static final Compute INSTANCE = new Compute();
	    public Compute(){}
	    public static Compute getInstance() {
	       return INSTANCE;
	    }
		
		public static int mousex;
		public static int mousey;
		public static int mouseClicks;
		public static Array MouseArray = new Array(10,10);
		public static int seed = 1;
		
		public static int cpu_tick = 0;
		public static int cpu;
		public static int GameSeconds = 0;
		private static int cpuc;
		public static boolean spot = false;
		public static long Second_Tick = System.currentTimeMillis();
		public static int Seconds;

		public static void Compute()
		{
			   cpuc++;
			   if(System.currentTimeMillis() > Second_Tick + 1000)
			   {
				   Second_Tick+=1000;
				   Seconds++;			   
				   cpu = cpuc;
				   cpuc = 0;
				   GameSeconds++;
			   }
			
			   
			//#########################
			   
			//Count the ticks per computation.
			   cpu_tick++;
			   
			  
				   NPCList.ComputeMoves();
			   
			   if(cpu_tick >= 50)
				   	cpu_tick = 0;
		}
	
	   public static void setMouseXY(int mX, int mY,int mButton)
	   {
		   mousex = mX;
		   mousey = mY;
		   
		   if((mX - Draw.GridLengthBuffer) < 0 || (mX + Draw.GridLengthBuffer) > Draw.WinWidth || (mY - Draw.GridHeightBuffer) < 0 || (mY + Draw.GridHeightBuffer) > Draw.WinHeight)
		   {
			   //System.out.println((mX - Map.getGLB())+" || "+(mX + Map.getGLB())+">"+getWidth()+" || "+(mY - Map.getGHB())+" || "+(mY + Map.getGHB())+">"+getHeight());
			   Draw.GameBoard.wipeArray(0);
			   spot = false;
			   mouseClicks=0;
			   MouseArray.ArrayDepose();
		   }
		   else if(mButton == 1)
		   {
			   int x = ((mX-(Draw.GridLengthBuffer))/Draw.TILE_SIZE_X);
			   int y = ((mY-(Draw.GridHeightBuffer))/Draw.TILE_SIZE_Y);
			   //boolean add = false;
			   
			   Draw.GameBoard.setElement(x,y,seed);
			   spot = true;
			   /*
			   mouseClicks++;
			   MouseArray.setArraySize(3, mouseClicks);
			   
			   for(int m =0; m < mouseClicks;m++)
			   {
				   if(  (MouseArray.getElement(0, m) == x)  && (MouseArray.getElement(1, m) == y)  )
				   {
					   add = false;
					   mouseClicks--;
					   break;
				   }else
				   {
					   
				   }
				   add = true;
			   }
			   MouseArray.setArraySize(3, mouseClicks);
			   
			   if(add && (x >= 0 && x < Draw.GameBoard.length) && (y >= 0 && y < Draw.GameBoard.height))
			   {
				   MouseArray.setElement(0, mouseClicks-1, x);
				   MouseArray.setElement(1, mouseClicks-1, y);
				   MouseArray.setElement(2, mouseClicks-1, seed);
				   //System.out.println(x+"   "+y);
			   }

			   //MouseArray.printArray(); 
*/
		   }else if(mButton == 3)
		   {
			   int x = ((mX-(Draw.GridLengthBuffer))/Draw.TILE_SIZE_X);
			   int y = ((mY-(Draw.GridHeightBuffer))/Draw.TILE_SIZE_Y);
			   //boolean add = false;
			   
			   Draw.GameBoard.setElement(x,y,0);
		   }
	   }
	 

	}

