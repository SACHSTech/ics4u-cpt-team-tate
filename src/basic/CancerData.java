package basic;

public class CancerData {
    private String country;
    private int liver;
    private int kidney;
    private int oral;
    private int lungs;
    private int larynx;
    private int galbladder;
    private int skin;
    private int leukemia;
    
    public CancerData(String country, int liver, int kidney, int oral, int lungs, int larynx, int galbladder, int skin, int leukemia){
        this.country = country;
        this.liver = liver;
        this.kidney = kidney;
        this.oral = oral;
        this.lungs = lungs;
        this.larynx = larynx;
        this.galbladder = galbladder;
        this.skin = skin;
        this.leukemia = leukemia;
    }
    public String getCountry() {
        return country;
      }
    
      public int getLiver() {
        return liver;
      }
    
      public int getKidney() {
        return kidney;
      }
    
      public int getOral() {
        return oral;
      }
    
      public int getLungs() {
        return lungs;
      }
    
      public int getLarynx() {
        return larynx;
      }
    
      public int getGalbladder() {
        return galbladder;
      }
    
      public int getSkin() {
        return skin;
      }
    
      public int getLeukemia() {
        return leukemia;
      }
    
      public String toCommaDelimitedString() {
        return new StringBuffer().append(this.country).append(",").append(this.liver).append(",")
            .append(this.kidney).append(",").append(this.oral).append(",").append(this.lungs)
            .append(",").append(this.larynx).append(",").append(this.galbladder).append(",")
            .append(this.skin).append(",").append(this.leukemia).toString();
      }
    
      @Override
      public String toString() {
        return toCommaDelimitedString();
      }
}
