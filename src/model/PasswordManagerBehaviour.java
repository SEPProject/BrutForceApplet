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

}
