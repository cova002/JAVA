/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import Interfaces.Login;


public class Consultorio {

    public Consultorio() {
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setResizable(false);
        login.setVisible(true);
    }

    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
    }

}
