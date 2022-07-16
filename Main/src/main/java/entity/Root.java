package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Root {
    private static Logger logger = LoggerFactory.getLogger(Root.class);
    private final Double x1;
    private final Double x2;
    public Root(Double x1, Double x2){
        this.x1 = x1;
        this.x2 = x2;
    }
    public Root(Double x1){
        this.x1 = x1;
        this.x2 = null;
    }
    public Root(){
        this.x1 = null;
        this.x2 = null;
    }
    public Double getX1(){
        return x1;
    }
    public Double getX2(){
        return x2;
    }

    public void outputInLog(){
        if (x1 != null && x2 != null ) {
            logger.debug("x1 = " + x1);
            logger.debug("x2 = " + x2);
        } else if (x1 != null) {
            logger.debug("x = " + x1);
        } else {
            logger.debug("The equation has no real roots");
        }
    }

}
