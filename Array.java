package Game;

import java.awt.Color;
import java.util.*;

/**
 * @author ThomasTheis
 * 2015, October 12th
 * Array Class for my use only. All other use is forbidden
 *
 */
public class Array {
	/*
    private static final MapArray INSTANCE = new MapArray();

    private MapArray(){}

    public static MapArray getInstance() {
        return INSTANCE;
    }
	*/
//######
//	Array Variables
//###### 
    
	private int[][] Array;
	public int length;
	public int height;
	
	
//######
//	Array initialization
//######
	public Array()
	{
	}
	
	public Array(int sizeX,int sizeY)
	{
		Array = new int[sizeX][sizeY];
	}
	
	public void setArray(int sizeX,int sizeY)
	{
		Array = new int[sizeX][sizeY];
	}

	public void setArray()
	{
		Array = new int[0][0];
	}

//######
//	Array Getters
//######
	
	public int[] getSize()
	{
		int[] A = new int[] {Array.length, Array[0].length};
		return A;
	}
	
	public int[][] getArray()
	{
		return Array;
	}
	
	public int getElement(int x, int y)
	{
		if(((x >= 0) && (x < Array.length)) &&  ((y >= 0) && (y < Array[0].length)))
			return Array[x][y]; 
		else
			return -1;
	}

//######
//	Array Print.
//######
	
	public void printArray(int LinesBeforeArray,String beforeLine, String space, String AfterLine,int LinesAfterArray)
	{
		int count = 0;
		while(count > LinesBeforeArray){System.out.println("");count++;}
		for(int x = 0; x < (Array.length);x++)
		{
			System.out.print(beforeLine);
			for(int y = 0; y < (Array[0].length);y++)
			{
				System.out.print(Array[x][y]+space);
			}
			System.out.print(AfterLine);
		}
		count = 0;
		while(count > LinesAfterArray){System.out.println("");count++;}
	}
	
	public void printArray()
	{
		System.out.println();
		for(int x = 0; x < (Array.length);x++)
		{
			System.out.print(" ");
			for(int y = 0; y < (Array[0].length);y++)
			{
				System.out.print((Array[x][y])+" ");
			}
			System.out.print("\n");
		}
		
	}
	
	
//######
//	Array to set an element.
//######
	
	public void setElementHard(int x, int y, int val)
	{
		if( ((x >= 0) && (x < Array.length)) &&  ((y >= 0) && (y < Array[0].length))  )
		{
			Array[x][y] = val; 
		}else
		{
			if((x >= 0) && (x < Array.length))
			{
				setArraySize(Array.length,y+1);
				Array[x][y] = val; 
			}
			else if((y >= 0) && (y < Array[0].length))
			{
				setArraySize(x+1,Array[0].length);
				Array[x][y] = val; 
			}
			else
			{
				setArraySize(x+1,y+1);
				
				Array[x][y] = val; 
			}
		}
	}
	
	public void setElement(int x, int y, int val)
	{
		if( ((x >= 0) && (x < Array.length)) &&  ((y >= 0) && (y < Array[0].length))  )
		{
		Array[x][y] = val; 
		}else
		{
			System.out.printf("%-10s%40s\n","MapArray.setElement: ","Eorror: Cannot set Element, out of bounds");
		}
	}
	
//######
//	Array entire data changing.
//######
	
	public void setArray(int[][] array)
	{
		if(Array == null)
		{
			setArray(array.length,array[0].length);
		}
		else if(Array.length != array.length || Array[0].length != array[0].length)
		{
			setArraySize(array.length,array[0].length);
		}
		
		for(int x = 0; x < (array.length);x++)
		{
			for(int y = 0; y < (array[0].length);y++)
			{
				Array[x][y] = array[x][y];
			}
		}
		System.out.printf("%-10s%40s\n","MapArray.setArray: ","MapArray has been changed.");
	}
	
	public void wipeArray(int num)
	{
		for(int x = 0; x < (Array.length);x++)
		{
			for(int y = 0; y < (Array[0].length);y++)
			{
				Array[x][y] = num;
			}
		}
		System.out.printf("%-10s%40s\n","MapArray.wipeArray: ","MapArray wiped to: "+ num);
	}
	
//######
//	Array depose.
//######	
	public void ArrayDepose()
	{
		setArraySize(1,1);
		wipeArray(0);
	}
	
//######
//	Array ReSizing functions
//######
	
	//math behide resizeArray.
	private Object resizeArray (Object oldArray, int newSize) 
	{
		// This class was taken directly from "http://www.source-code.biz/snippets/java/3.htm"
		//You try to dynamically resizing an array, than come talk to me about coping code.
	   int oldSize = java.lang.reflect.Array.getLength(oldArray);
	   
	   Class elementType = oldArray.getClass().getComponentType();
	   
	   Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
	   
	   int preserveLength = Math.min(oldSize, newSize);
	   
	   if (preserveLength > 0)
	   {
		   System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
	   }
	   return newArray; 
	}
	
	//Todo: handle "0" inputs for Lx or Ly, test for exceptions first.
	public void setArraySize(int Lx, int Ly)
	{
		if(Array != null && Array[0] != null){
			if(Array.length != Lx || Array[0].length !=Ly)
			{
				length = Lx;
				height = Ly;
				Array = (int[][])resizeArray(Array, Lx);
			    // new array is [20][3]
			  
				for (int i=0; i<Array.length; i++) 
				{
					if (Array[i] == null)
					{
						Array[i] = new int[Ly];
					}					
					else
					{
						Array[i] = (int[])resizeArray(Array[i], Ly); 
					}
				}
			}
		}else
		{
			System.out.printf("%-10s%40s\n","MapArray.setArraySize: ","MapArray is null, map was not a set.");
		}
	}
}

