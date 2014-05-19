/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sweetBank;


/**
 *
 * @author arash
 */
public class SweetBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBcon con = new DBcon();
        Frmlogin frm= new Frmlogin(con);
        frm.setVisible(true);
      
    }
    
}
