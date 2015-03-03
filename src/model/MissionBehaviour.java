package model;

/**
 * mission interface
 */

public interface MissionBehaviour {

    /**
     * get the part at index i of the mission of this applet
     * @param i
     * @return
     */
    public String getPart(int i);

    /**
     * set the part at index i of the mission of this applet
     * @param numPart
     * @param s
     */
    public void setPart(int numPart, String s);

    /**
     *
     * @return
     */
    public String getDescription();

    /**
     * set the description of the mission of this applet
     * @param s
     */
    public void setDescription(String s);


}
