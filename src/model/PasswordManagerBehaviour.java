package model;

public interface PasswordManagerBehaviour {

    /**
     * return the hash stored in the passwordManager
     * @return
     */
    public String getHashStored();

    /**
     * set the hash of the password to be found
     * @param password
     */
    public void setHashStored(String password);

    /**
     * test if the provided hash of the user is wrong or not
     * @param hashProvided
     * @return boolean
     */
    public boolean testHashUser(String hashProvided);
}
