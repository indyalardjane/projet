/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.ecran.ListScreen;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractAnimation aa = new AnimationFlash();
		aa.setEcranDeb(ListScreen.stormtrooper());
		aa.setEcranFin(ListScreen.dog());
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationFlash();
		ab.setEcranDeb(ListScreen.stormtrooper());
		ab.setEcranFin(ListScreen.dog());
		
		ab.runAnimation();
		
		ab.wait(1000);
        
        AbstractAnimation ac = new AnimationByColumn();
        ac.setEcranDeb(ListScreen.stormtrooper());
        ac.setEcranFin(ListScreen.dog());
        ac.runAnimation();
        

	}

}
