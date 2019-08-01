package application.dao;

public abstract class DAOFactory {
	
	
	 /** Membro statico per la factory MySQL */
    public static final int MYSQL = 0;  
 
    public static final int ORACLE = 1;
 
    /* Metodi statici per EcoToll DAO */
    public abstract DAOAutostrada getDAOAutostrada();
    public abstract DAOCasello getDAOCasello();
    public abstract DAOUtente getDAOUtente();
    public abstract DAORuolo getDAORuolo();
    public abstract DAOVeicolo getDAOVeicolo();
    public abstract DAONormativa getDAONormativa();
    public abstract DAOClasseEU getDAOClasseEU();
    public abstract DAOClasseIT getDAOClasseIT();
 
    /**
     * Metodo Factory
     * 
     */
    public static DAOFactory getDAOFactory(int database) {
        switch (database) {
        case MYSQL:
            return new MySQLDAOFactory();
        case ORACLE:
             return null;
        default:
            return null;
        }
    }
}


}
