/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.*;


import java.util.ArrayList;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub
    	
    	AbstractVoyageur voyageurSimule = new VoyageurSimuler();
		voyageurSimule.setPosBody(this.getSimulatedvoyageur().getPosBody());
		voyageurSimule.setPosTete(this.getSimulatedvoyageur().getPosTete());
		voyageurSimule.setDirection("E");
		
		
    	ArrayList<Planete> cheminoptimum = CalculMeilleurChemin();
    	
    	for (int j=0 ;j<cheminoptimum.size();j++) {
    		
    		Position PosTete = voyageurSimule.getPosTete();
    		Position PosBody = voyageurSimule.getPosBody();
    		int Xtete = PosTete.getX();
    		int XBody = PosBody.getX();
    		int YBody = PosBody.getY();
    		int Ytete = PosTete.getY();
    		String direction = voyageurSimule.getDirection();
    		
    		Position Posplanete = cheminoptimum.get(j).getPos();
    		int XposPlanete = Posplanete.getX();
    		int YposPlanete = Posplanete.getY();
    		
    		int deltaX = Xtete - XposPlanete ;
    		int deltaY = Ytete - YposPlanete ;
    		
    		if (direction =="N") {
    			
    			if (deltaX >0) {
    				
    				for (int i =0 ; i< deltaX; i++){
    					voyageurSimule.goForward();
    				}
    				if (deltaY<0) {
    					voyageurSimule.turnRight();
    				}
    				else if (deltaY>0) {
    					voyageurSimule.turnLeft();
    				}
    				else if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
					
    					}
    				}
    			}
    			if (deltaX ==0) {
    				if (deltaY >0) {
    					voyageurSimule.turnLeft();
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    					}
    					
    				}
    				else if (deltaY <0) {
    					voyageurSimule.turnRight();
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    					}
    					
    				}
    				
    			}
    			else if (deltaX<0) {
    				
    				for (int i =0 ; i< Math.abs(deltaX); i++){
    					voyageurSimule.goBackward();
    				}
    				if (deltaY<0) {
    					voyageurSimule.turnRight();
    				}
    				else if (deltaY>0) {
    					voyageurSimule.turnLeft();
    				}
    				else if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
					
    					}
    				}
    			}
    				
    		}
    		else if (direction =="S") {
    			if (deltaX<0) {
    				for (int i=0; i< Math.abs( deltaX) ; i++){
    					voyageurSimule.goForward (); 
    				}	
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    					}
    			}
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}

    			}
    			if (deltaX>0) {
    				for (int i=0; i< Math.abs(deltaX) ; i++){
    					voyageurSimule.goBackward (); 
    					}
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    					}
    				}
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    					}
    				}
    				
    			}
    			if (deltaX==0) {
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    					}
    				}	
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaY); i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    			}
    			}
    		else if (direction =="W") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurSimule.goBackward () ;
    				}
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward (); 
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurSimule.goForward () ;
    				}
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    			}
    		}
    		
    		else if (direction =="E") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurSimule.goForward () ;
    				}
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward (); 
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurSimule.goBackward () ;
    				}
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurSimule.goForward () ;
    					}
    				}
    			}
    		}
    		//récupérer les échantillons et prendre photo
    		
    		}
    	
        afficheEcran();
    }
    
 
    
    
    
    
   
    
    
    public Planete PlanetePlusProche(ArrayList<Planete> L,Position tete, Position body, String direction ) {
    	
    	Planete res = L.get(0);
    	
    	int Xtete = tete.getX();
    	int Ytete = tete.getY();
    	
    	
    	
    	Position posPlanete = L.get(0).getPos();
		int XposPlanete = posPlanete.getX();
		int YposPlanete = posPlanete.getY();
		
		int deltaX = Xtete - XposPlanete ;
		int deltaY = Ytete - YposPlanete ;
		
		int energyMin = 0;
		int energy = 0;
		
		if (deltaX == 0) {
			
			if (direction == "E" || direction == "W") {
				
				energyMin = 2 * Math.abs(deltaY);
				
			}
			else if (direction == "N" || direction =="S"){
				
				energyMin = 2 * Math.abs(deltaY) + 1;
				
			}
		}
		else if (deltaY ==0) {
			
			if (direction == "E" || direction == "W") {
				
				energyMin = 2 * Math.abs(deltaX) + 1;
				
			}
			
			else if (direction == "N" || direction =="S"){
				
				energyMin = 2 * Math.abs(deltaX);
				
			}
			
		}
		else {
			
			energyMin = 2 * (Math.abs(deltaY) + Math.abs(deltaX)) + 1;
			
		}
			 
	
    	for (int i=1 ;i<L.size(); i++) {
    		
    		posPlanete = L.get(i).getPos();
    		XposPlanete = posPlanete.getX();
    		YposPlanete = posPlanete.getY();
    		
    		deltaX = Xtete - XposPlanete ;
    		deltaY = Ytete - YposPlanete ;
    		 
    		
    		if (deltaX == 0) {
    			
    			if (direction == "E" || direction == "W") {
    				
    				energy = 2 * Math.abs(deltaY);
    				
    			}
    			else if (direction == "N" || direction =="S"){
    				
    				energy = 2 * Math.abs(deltaY) + 1;
    				
    			}
    		}
    		else if (deltaY ==0) {
    			
    			if (direction == "E" || direction == "W") {
    				
    				energy = 2 * Math.abs(deltaX) + 1;
    				
    			}
    			
    			else if (direction == "N" || direction =="S"){
    				
    				energy = 2 * Math.abs(deltaX);
    				
    			}
    			
    		}
    		
    		else if (deltaX != 0 && deltaY!=0){
    			
    			energy = 2 * (Math.abs(deltaY) + Math.abs(deltaX)) + 1;
    			
    		}
    		
    		else if (energy < energyMin) {  
    			
    			res = L.get(i);
    			energyMin = energy;
    			
    		}
    	}
    	return res;
    }
    	
    	
    	
    	
    	
  
    

    
    public ArrayList<Planete> CalculMeilleurChemin(){
    	
    	ArrayList<Planete> meilleurChemin = new ArrayList<Planete>();
    	ArrayList<Planete> planeteVisite = getListPlanete();
    	
    	AbstractVoyageur voyageurCalcul = new VoyageurSimuler();
		voyageurCalcul.setPosBody(this.getSimulatedvoyageur().getPosBody());
		voyageurCalcul.setPosTete(this.getSimulatedvoyageur().getPosTete());
		voyageurCalcul.setDirection("E");
		
		
		
		while (!planeteVisite.isEmpty()) {
			
			Planete PlaneteProche = PlanetePlusProche(planeteVisite, voyageurCalcul.getPosTete(),voyageurCalcul.getPosBody(), voyageurCalcul.getDirection());
			meilleurChemin.add(PlaneteProche);
    		planeteVisite.remove(PlaneteProche);
    		
    		Position PosTete = voyageurCalcul.getPosTete();
    		//Position PosBody = voyageurCalcul.getPosBody();
    		int Xtete = PosTete.getX();
    		//int XBody = PosBody.getX();
    		//int YBody = PosBody.getY();
    		int Ytete = PosTete.getY();
    		String direction = voyageurCalcul.getDirection();
    		
    		Position Posplanete = PlaneteProche.getPos();
    		int XposPlanete = Posplanete.getX();
    		int YposPlanete = Posplanete.getY();
    		
    		int deltaX = Xtete - XposPlanete ;
    		int deltaY = Ytete - YposPlanete ;
    		
    		if (direction =="N") {
    			
    			if (deltaX >0) {
    				
    				for (int i =0 ; i< deltaX; i++){
    					voyageurCalcul.goForward();
    				}
    				if (deltaY<0) {
    					voyageurCalcul.turnRight();
    				}
    				else if (deltaY>0) {
    					voyageurCalcul.turnLeft();
    				}
    				else if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurCalcul.goForward();
					
    					}
    				}
    			}
    			if (deltaX ==0) {
    				if (deltaY >0) {
    					voyageurCalcul.turnLeft();
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurCalcul.goForward();
    					}
    					
    				}
    				else if (deltaY <0) {
    					voyageurCalcul.turnRight();
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurCalcul.goForward();
    					}
    					
    				}
    				
    			}
    			else if (deltaX<0) {
    				
    				for (int i =0 ; i< Math.abs(deltaX); i++){
    					voyageurCalcul.goBackward();
    				}
    				if (deltaY<0) {
    					voyageurCalcul.turnRight();
    				}
    				else if (deltaY>0) {
    					voyageurCalcul.turnLeft();
    				}
    				else if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurCalcul.goForward();
					
    					}
    				}
    			}
    				
    		}
    		else if (direction =="S") {
    			if (deltaX<0) {
    				for (int i=0; i< Math.abs( deltaX) ; i++){
    					voyageurCalcul.goForward (); 
    				}	
    				if(deltaY<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    			}
    				if(deltaY>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}

    			}
    			if (deltaX>0) {
    				for (int i=0; i< Math.abs(deltaX) ; i++){
    					voyageurCalcul.goBackward (); 
    					}
    				if(deltaY<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    				}
    				if(deltaY>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    				}
    				
    			}
    			if (deltaX==0) {
    				if(deltaY<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    				}	
    				if(deltaY>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaY); i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    			}
    			}
    		else if (direction =="W") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurCalcul.goBackward () ;
    				}
    				if(deltaX<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurCalcul.goForward () ;
    				}
    				if(deltaX<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    			}
    		}
    		
    		else if (direction =="E") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurCalcul.goForward () ;
    				}
    				if(deltaX<0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward (); 
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurCalcul.goBackward () ;
    				}
    				if(deltaX<0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurCalcul.turnRight();
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    				if(deltaX>0){
    					voyageurCalcul.turnLeft();
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurCalcul.goForward () ;
    					}
    				}
    			}
    		}
    		}
    	return meilleurChemin;
    	
    }
    
    
}
