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
    	
    	
    	
    	
    	AbstractVoyageur voyageurSimule = getSimulatedvoyageur();
    	
		
		ArrayList<Planete> cheminoptimum = CalculMeilleurChemin();
		
		voyageurSimule.getPosTete().setX(listPlanete.get(0).getPos().getX());
		voyageurSimule.getPosTete().setY(listPlanete.get(0).getPos().getY());
		voyageurSimule.getPosBody().setX(listPlanete.get(0).getPos().getX());
		voyageurSimule.getPosBody().setY(listPlanete.get(0).getPos().getY()-1);
		voyageurSimule.setDirection("E");
		afficheEcran();
		wait(1000);
    	
    	for (int j=0 ;j<cheminoptimum.size();j++) {
    		
    		
    		
    		//Position PosTete = voyageurSimule.getPosTete();
    		Position PosBody = voyageurSimule.getPosBody();
    		//int Xtete = PosTete.getX();
    		int XBody = PosBody.getX();
    		int YBody = PosBody.getY();
    		//int Ytete = PosTete.getY();
    		String direction = voyageurSimule.getDirection();
    		
    		Position Posplanete = cheminoptimum.get(j).getPos();
    		int XposPlanete = Posplanete.getX();
    		int YposPlanete = Posplanete.getY();
    		
    		int deltaX = XBody - XposPlanete ;
    		int deltaY = YBody - YposPlanete ;
    		
    		
    		if (direction =="N") {
    			
    			if (deltaX >0) {
    				
    				for (int i =0 ; i< deltaX; i++){
    					voyageurSimule.goForward();
    					afficheEcran();
    		    		wait(1000);
    					
    				}
    				if (deltaY<0) {
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    				}
    				else if (deltaY>0) {
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    				}
    				if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    						afficheEcran();
    			    		wait(1000);
					
    					}
    				}
    			}
    			if (deltaX ==0) {
    				if (deltaY >0) {
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    						afficheEcran();
    			    		wait(1000);
    					}
    					
    				}
    				else if (deltaY <0) {
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    						afficheEcran();
    			    		wait(1000);
    					}
    					
    				}
    				
    			}
    			else if (deltaX<0) {
    				
    				for (int i =0 ; i< Math.abs(deltaX); i++){
    					voyageurSimule.goBackward();
    					afficheEcran();
    		    		wait(1000);
    				}
    				if (deltaY<0) {
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    				}
    				else if (deltaY>0) {
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    				}
    				else if (deltaY !=0) {
    					for (int i=0 ; i< Math.abs(deltaY); i++) {
    						voyageurSimule.goForward();
    						afficheEcran();
    			    		wait(1000);
					
    					}
    				}
    			}
    				
    		}
    		else if (direction =="S") {
    			if (deltaX<0) {
    				for (int i=0; i< Math.abs( deltaX) ; i++){
    					voyageurSimule.goForward ();
    					afficheEcran();
    		    		wait(1000);
    				}	
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    						afficheEcran();
    			    		wait(1000);
    					}
    			}
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}

    			}
    			if (deltaX>0) {
    				for (int i=0; i< Math.abs(deltaX) ; i++){
    					voyageurSimule.goBackward (); 
    					afficheEcran();
    		    		wait(1000);
    					}
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward (); 
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward ();
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				
    			}
    			if (deltaX==0) {
    				if(deltaY<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY) ; i++){
    						voyageurSimule.goForward ();
    						afficheEcran();
    			    		wait(1000);
    					}
    				}	
    				if(deltaY>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaY); i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    			}
    			}
    		else if (direction =="W") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurSimule.goBackward () ;
    					afficheEcran();
    		    		wait(1000);
    				}
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward (); 
    						afficheEcran();
    			    		wait(1000);
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurSimule.goForward () ;
    					afficheEcran();
    		    		wait(1000);
    				}
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    			}
    		}
    		
    		else if (direction =="E") {
    			if (deltaY<0) {
    				for (int i=0; i< Math.abs( deltaY) ; i++){
    					voyageurSimule.goForward () ;
    					
    					afficheEcran();
    		    		wait(1000);
    				}
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward (); 
    						afficheEcran();
    			    		wait(1000);
    					}
    				}

    				
    			}

    			if (deltaY>0) {
    				for (int i=0; i< Math.abs(deltaY) ; i++){
    					voyageurSimule.goBackward () ;
    					afficheEcran();
    		    		wait(1000);
    				}
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    			}

    			if (deltaY==0) {
    				if(deltaX<0){
    					voyageurSimule.turnRight();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( Math.abs(deltaX)) ; i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    				if(deltaX>0){
    					voyageurSimule.turnLeft();
    					afficheEcran();
    		    		wait(1000);
    					for (int i=0; i< Math.abs( deltaX); i++){
    						voyageurSimule.goForward () ;
    						afficheEcran();
    			    		wait(1000);
    					}
    				}
    			}
    		}
    		
    		//récupérer les échantillons et prendre photo 
    		
    		voyageurSimule.takePicture(cheminoptimum.get(j));
    		voyageurSimule.takeEchantillonSol(cheminoptimum.get(j));
    		voyageurSimule.takeEchantillonRoche(cheminoptimum.get(j));
    		voyageurSimule.getListPhotographie();
    		System.out.println(cheminoptimum.get(j));
    		
    		
    		
    	
    	}
   
    	
    	
        
    }
    
 
    
    
    
    
   
    
    
    public Planete PlanetePlusProche(ArrayList<Planete> L,Position tete, Position body, String direction ) {
    	
    	Planete res = L.get(0);
    	int XBody = body.getX();
    	int YBody = body.getY();
    	
    	
    	
    	Position posPlanete = L.get(0).getPos();
		int XposPlanete = posPlanete.getX();
		int YposPlanete = posPlanete.getY();
		
		int deltaX = XBody - XposPlanete ;
		int deltaY = YBody - YposPlanete ;
		
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
		if (deltaY ==0) {
			
			if (direction == "E" || direction == "W") {
				
				energyMin = 2 * Math.abs(deltaX) + 1;
				
			}
			
			else if (direction == "N" || direction =="S"){
				
				energyMin = 2 * Math.abs(deltaX);
				
			}
			
		}
		if (deltaX != 0 && deltaY != 0){
			
			energyMin = 2 * (Math.abs(deltaY) + Math.abs(deltaX)) + 1;
			
		}
		
    	for (int i=1 ; i < L.size() ; i++) {
    		
    		posPlanete = L.get(i).getPos();
    		XposPlanete = posPlanete.getX();
    		YposPlanete = posPlanete.getY();
    		
    		deltaX = XBody - XposPlanete ;
    		deltaY = YBody - YposPlanete ;
    		 
    		
    		if (deltaX == 0) {
    			
    			if (direction == "E" || direction == "W") {
    				
    				energy = 2 * Math.abs(deltaY);
    				
    			}
    			else if (direction == "N" || direction =="S"){
    				
    				energy = 2 * Math.abs(deltaY) + 1;
    				
    			}
    		}
    		if (deltaY ==0) {
    			
    			if (direction == "E" || direction == "W") {
    				
    				energy = 2 * Math.abs(deltaX) + 1;
    				
    			}
    			
    			else if (direction == "N" || direction =="S"){
    				
    				energy = 2 * Math.abs(deltaX);
    				
    			}
    			
    		}
    		
			
    		if (deltaX != 0 && deltaY!=0){
    			
    			energy = 2 * (Math.abs(deltaY) + Math.abs(deltaX)) + 1;
    			
    		}
    		
			
    		if (energy < energyMin) {  
    		
    			
    			res = L.get(i);
    			energyMin = energy;
    		}
    		
    	}
    	return res;
    }
    	
    	
    	
    	
    	
  
    

    
/*    public ArrayList<Planete> CalculMeilleurChemin(){
    	
    	ArrayList<Planete> meilleurChemin = new ArrayList<Planete>();
    	ArrayList<Planete> planeteVisite = new ArrayList<Planete>();
    	planeteVisite.addAll(getListPlanete());
    	
    	AbstractVoyageur voyageurCalcul = new VoyageurSimuler();
		voyageurCalcul.setPosBody(this.getSimulatedvoyageur().getPosBody());
		voyageurCalcul.setPosTete(this.getSimulatedvoyageur().getPosTete());
		voyageurCalcul.setDirection("E");
		
		
		
		
		
		while (!planeteVisite.isEmpty()) {
			
			Planete PlaneteProche = PlanetePlusProche(planeteVisite, voyageurCalcul.getPosTete(),voyageurCalcul.getPosBody(), voyageurCalcul.getDirection());
			meilleurChemin.add(PlaneteProche);
			
    		planeteVisite.remove(PlaneteProche);
    		
    		//Position PosTete = voyageurCalcul.getPosTete();
    		Position PosBody = voyageurCalcul.getPosBody();
    		//int Xtete = PosTete.getX();
    		int XBody = PosBody.getX();
    		int YBody = PosBody.getY();
    		//int Ytete = PosTete.getY();
    		String direction = voyageurCalcul.getDirection();
    		
    		Position Posplanete = PlaneteProche.getPos();
    		int XposPlanete = Posplanete.getX();
    		int YposPlanete = Posplanete.getY();
    		
    		int deltaX = XBody - XposPlanete ;
    		int deltaY = YBody - YposPlanete ;
    		
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
    
}*/


    public ArrayList<Planete> CalculMeilleurChemin(){
    	
    		ArrayList<Planete> meilleurChemin = new ArrayList<Planete>();
    		ArrayList<Planete> planeteVisite = new ArrayList<Planete>();
    		planeteVisite.addAll(getListPlanete());
    	
    		AbstractVoyageur voyageurCalcul = new VoyageurSimuler();
    		voyageurCalcul.setPosBody(this.getSimulatedvoyageur().getPosBody());
    		voyageurCalcul.setPosTete(this.getSimulatedvoyageur().getPosTete());
    		voyageurCalcul.setDirection("E");
    		
    		meilleurChemin.add(planeteVisite.get(0));
			planeteVisite.remove(planeteVisite.get(0));
			
			int compt = 1;
			
    		while (!planeteVisite.isEmpty()) {
		
    			int a = 0;
    			ArrayList<Planete> listeIntermédiaire = new ArrayList<Planete>() ;
    			Planete PlaneteProche = PlanetePlusProche(planeteVisite,voyageurCalcul.getPosTete(),voyageurCalcul.getPosBody(), voyageurCalcul.getDirection());
    			listeIntermédiaire.addAll(planeteVisite) ;
    			
    			
    			while ( !listeIntermédiaire.isEmpty() && a != 1){
    				
    				
    				System.out.println(meilleurChemin);
    				
    				if (meilleurChemin.get(meilleurChemin.size()-1).getListAccessibilite().contains(PlaneteProche)){

    					a = 1;
    					
    					
    				}

    				else {

    					listeIntermédiaire.remove(PlaneteProche);
    					
    					if (listeIntermédiaire.size() != 0) {
    						PlaneteProche = PlanetePlusProche(listeIntermédiaire,voyageurCalcul.getPosTete(),voyageurCalcul.getPosBody(), voyageurCalcul.getDirection());
    					}	
    				}
    			}

    			if (a == 1){

    				meilleurChemin.add(PlaneteProche);
    				planeteVisite.remove(PlaneteProche);
    				compt = meilleurChemin.size();
    				
    			}
    			
    			else {
    				
    				
    				meilleurChemin.add(meilleurChemin.get(compt-1));
    				PlaneteProche = meilleurChemin.get(meilleurChemin.size()-1);
    				compt = compt-1;
    				
    			}
    			
    			//Position PosTete = voyageurCalcul.getPosTete();
        		Position PosBody = voyageurCalcul.getPosBody();
        		//int Xtete = PosTete.getX();
        		int XBody = PosBody.getX();
        		int YBody = PosBody.getY();
        		//int Ytete = PosTete.getY();
        		String direction = voyageurCalcul.getDirection();
        		
        		Position Posplanete = PlaneteProche.getPos();
        		int XposPlanete = Posplanete.getX();
        		int YposPlanete = Posplanete.getY();
        		
        		int deltaX = XBody - XposPlanete ;
        		int deltaY = YBody - YposPlanete ;
    			
 
    			
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

	



