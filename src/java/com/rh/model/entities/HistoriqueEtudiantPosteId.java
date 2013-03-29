package com.rh.model.entities;
// Generated 29 mars 2013 11:16:42 by Hibernate Tools 3.2.1.GA



/**
 * HistoriqueEtudiantPosteId generated by hbm2java
 */
public class HistoriqueEtudiantPosteId  implements java.io.Serializable {


     private int idetudiant;
     private int idposte;

    public HistoriqueEtudiantPosteId() {
    }

    public HistoriqueEtudiantPosteId(int idetudiant, int idposte) {
       this.idetudiant = idetudiant;
       this.idposte = idposte;
    }
   
    public int getIdetudiant() {
        return this.idetudiant;
    }
    
    public void setIdetudiant(int idetudiant) {
        this.idetudiant = idetudiant;
    }
    public int getIdposte() {
        return this.idposte;
    }
    
    public void setIdposte(int idposte) {
        this.idposte = idposte;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HistoriqueEtudiantPosteId) ) return false;
		 HistoriqueEtudiantPosteId castOther = ( HistoriqueEtudiantPosteId ) other; 
         
		 return (this.getIdetudiant()==castOther.getIdetudiant())
 && (this.getIdposte()==castOther.getIdposte());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdetudiant();
         result = 37 * result + this.getIdposte();
         return result;
   }   


}


