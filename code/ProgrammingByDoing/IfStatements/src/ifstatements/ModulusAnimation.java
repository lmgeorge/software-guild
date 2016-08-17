/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

/**
 *
 * @author apprentice
 */
public class ModulusAnimation {

  public static void main(String[] args) throws Exception {
    int repeats = 5;
		int steps_per_second = 10;

		for ( int i=0; i<repeats*11 ; i++ )
		{
			if ( i%11 == 0 ){
				System.out.print(" .oOo..... \n");
      }else if ( i%11 == 1 ){
				System.out.print(" ..oOo.... \n");
			}else if ( i%11 == 2 ){
				System.out.print(" ...oOo... \n");
      }else if ( i%11 == 3 ){
				System.out.print(" ....oOo.. \n");
      }else if ( i%11 == 4 ){
				System.out.print(" .....oOo. \n");
      }else if ( i%11 == 5 ){
				System.out.print(" ......oOo \n");
      }else if ( i%11 == 6 ){
				System.out.print(" .......oO \n");
      }else if ( i%11 == 7 ){
				System.out.print(" o.......o \n");
      }else if ( i%11 == 8 ){
				System.out.print(" Oo....... \n");
      }else if ( i%11 == 9 ){
				System.out.print(" oOo...... \n");
      }else if ( i%11 == 10 ){
				System.out.print(" .oOo..... \n");
      }
			Thread.sleep(1000/steps_per_second);
		}
		
    
  }

}
