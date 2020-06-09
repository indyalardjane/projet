/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.voyage.Position;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {

    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    	goForward();
    	
    	
    	
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {
    	
        // TODO Auto-generated method stub
    	String direction = getDirection();
    	Position PosTete = getPosTete();
    	Position PosBody = getPosBody();
    	
    	int XintTete = PosTete.getX(); //position de la tete selon X
		int XintBody= PosBody.getX();  //position du corps selon X
		
		int YintTete = PosTete.getY(); //position de la tete selon Y
		int YintBody= PosBody.getY();  //position du corps selon Y
    	
    	if (direction=="N") {
    		
    		PosTete.setX(XintTete - 1);
    		PosBody.setX(XintBody - 1);
    	}
    	else if (direction=="E") {
    		
    		PosTete.setY(YintTete + 1);
    		PosBody.setY(YintBody + 1);
    		
    	}
    	else if (direction=="S") {
    		
    		PosTete.setX(XintTete + 1);
    		PosBody.setX(XintBody + 1);
    		
    	}
    	else if (direction=="W") {
    		
    		PosTete.setY(YintTete - 1);
    		PosBody.setY(YintBody - 1);
    		
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
        // TODO Auto-generated method stub
    	String direction = getDirection();
    	Position PosTete = getPosTete();
    	Position PosBody = getPosBody();
    	
    	int XintTete = PosTete.getX(); //position de la tete selon X
		int XintBody= PosBody.getX();  //position du corps selon X
		
		int YintTete = PosTete.getY(); //position de la tete selon Y
		int YintBody= PosBody.getY();  //position du corps selon Y
    	
		
		if (direction=="N") {
			
			PosTete.setX(XintTete + 1);
    		PosBody.setX(XintBody + 1);
    		
		}
		else if (direction=="E") {
			
			PosTete.setY(YintTete - 1);
    		PosBody.setY(YintBody - 1);
			
		}
		else if (direction=="S") {
			
			PosTete.setX(XintTete - 1);
    		PosBody.setX(XintBody - 1);
			
		}
		else if (direction=="W") {
			
			PosTete.setY(YintTete - 1);
    		PosBody.setY(YintBody - 1);
			
		}

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
        // TODO Auto-generated method stub
    	String direction = getDirection();
    	Position PosTete = getPosTete();
    	
    	
    	int XintTete = PosTete.getX(); //position de la tete selon X
		int YintTete = PosTete.getY(); //position de la tete selon Y
		
		
		if (direction=="N") {
			
			PosTete.setX(XintTete + 1 );
			PosTete.setY(YintTete - 1 );
			
		}
		
		if (direction=="E") {
			
			PosTete.setX(XintTete - 1 );
			PosTete.setY(YintTete - 1 );
			
		}
		
		if (direction=="S") {
			
			PosTete.setX(XintTete - 1 );
			PosTete.setY(YintTete + 1 );
			
		}
		if (direction=="W") {
			
			PosTete.setX(XintTete + 1 );
			PosTete.setY(YintTete + 1 );
			
		}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
        // TODO Auto-generated method stub
    	String direction = getDirection();
    	Position PosTete = getPosTete();
    	
    	int XintTete = PosTete.getX(); //position de la tete selon X
		int YintTete = PosTete.getY(); //position de la tete selon Y
		
		if (direction=="N") {
			
			PosTete.setX(XintTete + 1 );
			PosTete.setY(YintTete + 1 );
			
		}
		
		if (direction=="E") {
			
			PosTete.setX(XintTete + 1 );
			PosTete.setY(YintTete - 1 );
			
		}
		
		if (direction=="S") {
			
			PosTete.setX(XintTete - 1 );
			PosTete.setY(YintTete - 1 );
			
		}
		if (direction=="W") {
			
			PosTete.setX(XintTete - 1 );
			PosTete.setY(YintTete + 1 );
			
		}
	
    }
}
