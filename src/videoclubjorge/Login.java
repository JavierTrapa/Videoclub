
package videoclubjorge;

/**
 *
 * @author Jorge
 */
public class Login {
    public String email="";
    public String dni="";
    
    
    public Login(){
        
    }
    
    
    public Login(String email, String dni){
        this.email = email;
        this.dni = dni;
    }



        public String getEmail(){
            return email;
        }
    
        public void setEmail(String email){
            this.email = email;
        }

        public String getDni(){
            return dni;
        }
    
        public void setDni(String dni){
            this.dni = dni;
        }
}