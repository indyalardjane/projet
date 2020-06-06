/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.voyage.Planete;
import fr.emac.gipsi.gsi.voyage.Voyage;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchVoyage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Planete> listPlanete = new ArrayList<>();
		
		Planete p1 = new Planete();
		//p1.setColorName("DarkSalmon"); TODO
		//p1.setImage(ListScreen.first());
		//p1.setEchantillonRoche(ListScreen.second()); TODO
		//p1.setEchantillonSol(ListScreen.first());  TODO
		p1.setRayon(1);
		p1.getPos().setX(2);
		p1.getPos().setY(2);
		
		listPlanete.add(p1);
		
		Planete p2 = new Planete();
		// p2.setColorName("DeepPink"); TODO
		//p2.setImage(ListScreen.first()); TODO
		//p2.setEchantillonRoche(ListScreen.second()); TODO
		//p2.setEchantillonSol(ListScreen.first());  TODO
		p2.setRayon(1);
		p2.getPos().setX(3);
		p2.getPos().setY(9);
		
		p2.getListAccessibilite().add(p1);
		p1.getListAccessibilite().add(p2);
		
	
		listPlanete.add(p2);
		
		Planete p3 = new Planete();
		p3.setColorName(" ");
		//p3.setImage(ListScreen.first()); TODO
		//p3.setEchantillonRoche(ListScreen.second()); TODO
		//p3.setEchantillonSol(ListScreen.first()); TODO
		p3.setRayon(1);
		p3.getPos().setX(8);
		p3.getPos().setY(5);  //positon de la planete 
		
		p3.getListAccessibilite().add(p1);
		p1.getListAccessibilite().add(p3);
		
		p2.getListAccessibilite().add(p3);
		p3.getListAccessibilite().add(p2);
		
		
		
		listPlanete.add(p3);
		
		
		
		Planete p4 = new Planete();
		//p4.setColorName(" "); TODO
		//p4.setImage(ListScreen.first());  TODO
		//p4.setEchantillonRoche(ListScreen.second());  TODO
		//p4.setEchantillonSol(ListScreen.first());  TODO
		p4.setRayon(1);
		p4.getPos().setX(8);
		p4.getPos().setY(15);  //positon de la planete 
		
		p4.getListVisibilite().add(p2);
		p2.getListVisibilite().add(p4);
		
		
		
		
		
		listPlanete.add(p4);
		
		
		Planete p5 = new Planete();
		//p5.setColorName(" "); TODO
		//p5.setImage(ListScreen.first()); TODO
		//p5.setEchantillonRoche(ListScreen.second()); TODO
		//p5.setEchantillonSol(ListScreen.first()); TODO
		p5.setRayon(1);
		p5.getPos().setX(3);
		p5.getPos().setY(18); //positon de la planete 
		
		
		p5.getListVisibilite().add(p2);
		p2.getListVisibilite().add(p5);
		
		p5.getListAccessibilite().add(p4);
		p4.getListAccessibilite().add(p5);
		
		
		listPlanete.add(p5);
		
		
		Planete p6 = new Planete();
		//p6.setColorName(" ");  TODO
		//p6.setImage(ListScreen.first()); TODO
		//p6.setEchantillonRoche(ListScreen.second()); TODO
		//p6.setEchantillonSol(ListScreen.first()); TODO
		p6.setRayon(1);
		p6.getPos().setX(15);
		p6.getPos().setY(10);  //positon de la planete 
		
		p6.getListAccessibilite().add(p3);
		p3.getListAccessibilite().add(p6);
		
		p6.getListAccessibilite().add(p4);
		p4.getListAccessibilite().add(p6);
		
		
		
		listPlanete.add(p6);
		
		AbstractVoyageur simulatedVoyageur = new VoyageurSimuler();
		
		simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY());
		simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY()-1);
		simulatedVoyageur.setDirection("E");
		
		Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);

		voyage.lancementSimuler();
	}

}













