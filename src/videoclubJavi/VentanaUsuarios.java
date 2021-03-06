/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubJavi;

//import videoclubjorge.Login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.imageio.ImageIO;
import VideoclubGuillermoFernandez.Peliculas;

/**
 *
 * @author xp
 */
public class VentanaUsuarios extends javax.swing.JFrame {
    int dni=0;
    private Image foto;
    
    private Statement estado;
    private ResultSet resultadoConsulta;
    private Connection conexion;
    
    private Usuarios u;
    
    HashMap <String,Usuarios>listaUsuarios=new HashMap();
    /**
     * Creates new form VentanaUsuarios
     */
    
    @Override
    public void paint (Graphics g){
        super.paintComponents(g);
        g = jPanel1.getGraphics();
        
        //cargamos una imagen
        
        foto = null;
        
        try {
            
            //foto = ImageIO.read(getClass().getResource("../ImagenesUsuario/"+Login.+".jpg"));
                   foto = ImageIO.read(getClass().getResource("/5036787.jpg"));     
            
        
        } catch (IOException ex) {
            
        }
        
        g.drawImage(foto, 0, 0, jPanel1.getWidth(), jPanel1.getHeight(),null);
        
    }
    
    public VentanaUsuarios() {
        initComponents();
        this.getContentPane().setBackground(Color.BLUE);
        //foto=new Image(getClass().getResource(""));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/videoclub", "root", "");
            estado=conexion.createStatement();
            resultadoConsulta=estado.executeQuery("Select * from usuarios");
            //cargo el resultado de mi query en un hashmap
            while(resultadoConsulta.next()){
                Usuarios u = new Usuarios();
                u.nombre=resultadoConsulta.getString(2);
                u.apellidos=resultadoConsulta.getString(3);
                u.dni=resultadoConsulta.getInt(1);
                u.email=resultadoConsulta.getString(5);
                u.penalizacion=resultadoConsulta.getInt(4);
                
                
                listaUsuarios.put(resultadoConsulta.getString(1), u);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public VentanaUsuarios(videoclubjorge.Login usuario) {
        initComponents();
        //jLabel1.setText(usuario.dni);
        dni=Integer.parseInt(usuario.dni);
        
        //u=listaUsuarios.get(Integer.parseInt(usuario.dni));
        this.getContentPane().setBackground(Color.BLUE);
        //foto=new Image(getClass().getResource(""));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/videoclub", "root", "");
            estado=conexion.createStatement();
            resultadoConsulta=estado.executeQuery("Select * from usuarios");
            //cargo el resultado de mi query en un hashmap
            while(resultadoConsulta.next()){
                Usuarios u = new Usuarios();
                u.nombre=resultadoConsulta.getString(2);
                u.apellidos=resultadoConsulta.getString(3);
                u.dni=resultadoConsulta.getInt(1);
                u.email=resultadoConsulta.getString(5);
                u.penalizacion=resultadoConsulta.getInt(4);
                
                
                listaUsuarios.put(resultadoConsulta.getString(1), u);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        escribeDatos();
    }
    
    
    
    private void escribeDatos(){
        u=listaUsuarios.get(Integer.toString(dni));
        //Usuarios u=listaUsuarios.get("5036787");
        //Usuarios u=listaUsuarios.get(videoclubjorge.Login );
        //System.out.println(u.nombre);
        if(u!=null){
            jLabel1.setText("Nombre: "+u.nombre+" "+u.apellidos);
            jLabel2.setText("Email: "+u.email);
            jLabel3.setText("DNI: "+String.valueOf(u.dni));
            jLabel4.setText("Penalizaciones: "+String.valueOf(u.penalizacion));
            
        }else{
            jLabel1.setText("ERROR");
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("jLabel1");

        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("jLabel2");

        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("jLabel4");

        jButton2.setText("Ver Catalogo");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)))))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        u=listaUsuarios.get(Integer.toString(dni));
        //Usuarios u=listaUsuarios.get("5036787");
        //Usuarios u=listaUsuarios.get(videoclubjorge.Login );
        //System.out.println(u.nombre);
        if(u!=null){
            jLabel1.setText("Nombre: "+u.nombre+" "+u.apellidos);
            jLabel2.setText("Email: "+u.email);
            jLabel3.setText("DNI: "+String.valueOf(u.dni));
            jLabel4.setText("Penalizaciones: "+String.valueOf(u.penalizacion));
            
        }else{
            jLabel1.setText("ERROR");
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        new Peliculas().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
