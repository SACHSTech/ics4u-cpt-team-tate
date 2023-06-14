package basic;

public class CancerData {

    // Class variables for each type of cancer
    private String country;
    private int liver;
    private int kidney;
    private int oral;
    private int lungs;
    private int larynx;
    private int galbladder;
    private int skin;
    private int leukemia;
    private int total; 

    /**
     * Constructor method that takes in the amount of each type of cancer case and country name
     * @param country name of country
     * @param liver number of liver cancer cases
     * @param kidney number of kidney cancer cases
     * @param oral number of oral cancer cases
     * @param lungs number of lungs cancer cases
     * @param larynx number of larynx cancer cases
     * @param galbladder number of galbladder cancer cases
     * @param skin number of skin cancer cases
     * @param leukemia number of leukemia cancer cases
     * @param total total number of cancer cases in each column
     * @author @Ajuaman
     */
    public CancerData(String country, int liver, int kidney, int oral, int lungs, int larynx, int galbladder, int skin, int leukemia, int total){
        this.country = country;
        this.liver = liver;
        this.kidney = kidney;
        this.oral = oral;
        this.lungs = lungs;
        this.larynx = larynx;
        this.galbladder = galbladder;
        this.skin = skin;
        this.leukemia = leukemia;
        this.total = total;
    }
    
    /**
     * Getter method for country
     * @return country name
     * @author @Ajuaman
     */

    public String getCountry() {
      return country;
    }
    
    /**
     * Getter method for liver cases
     * @return number of liver cases
     * @author @Ajuaman
     */
    public int getLiver() {
       return liver;
    }
    
    /**
     * Getter method for kidney cases
     * @return number of kidney cases
     * @author @Ajuaman
     */
    public int getKidney() {
       return kidney;
    }
    
    /**
     * Getter method for  oral cases
     * @return number of oral cases
     * @author @Ajuaman
     */
    public int getOral() {
      return oral;
    }
    
    /**
     * Getter method for lungs cases
     * @return number of lungs cases
     * @author @Ajuaman
     */
    public int getLungs() {
       return lungs;
    }
    
    /**
     * Getter method for larynx cases
     * @return number of larynx cases
     * @author @Ajuaman
     */
    public int getLarynx() {
       return larynx;
    }
    
    /**
     * Getter method for galbladder cases
     * @return number of galbladder cases
     * @author @Ajuaman
     */
    public int getGalbladder() {
       return galbladder;
     }
    
     /**
     * Getter method for skin cases
     * @return number of skin cases
     * @author @Ajuaman
     */
    public int getSkin() {
       return skin;
    }
    
    /**
     * Getter method for leukemia cases
     * @return number of leukemia cases
     * @author @Ajuaman
     */
    public int getLeukemia() {
       return leukemia;
    }

     /**
     * Getter method for total number of cases
     * @return total number of cases by column
     * @author @Ajuaman
     */
    public int getTotal() {
      return total;
    }
    
    /**
     * Convert data to String
     * @return the String
     */
    public String toCommaDelimitedString() {
      return new StringBuffer().append(this.country).append(",").append(this.liver).append(",")
           .append(this.kidney).append(",").append(this.oral).append(",").append(this.lungs)
           .append(",").append(this.larynx).append(",").append(this.galbladder).append(",")
          .append(this.skin).append(",").append(this.leukemia).append(",").append(this.total).toString();
    }
    
    @Override
    /**
     * Convert data into a string
     */
    public String toString() {
      return toCommaDelimitedString();
     }
}
