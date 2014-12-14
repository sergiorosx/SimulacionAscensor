package proyectoascensor;

import java.util.ArrayList;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia
 */
public class GuiAscensor extends javax.swing.JFrame {

    Lef LEF = new Lef();

    /**
     * Creates new form GuiAscensor
     */
    public GuiAscensor() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPgraficas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAresultados = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jCBescenario = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTFcapacidad = new javax.swing.JTextField();
        jTFtiempoarranque = new javax.swing.JTextField();
        jTFdesplentrepisos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFtiemposimulacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBiniciarsimulacion = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCBpisoascensor = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIMULACION ASCENSOR - PROYECTO SIMULACION COMPUTACIONAL");

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel1.setText("SIMULACION ASCENSOR");

        jPgraficas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPgraficasLayout = new javax.swing.GroupLayout(jPgraficas);
        jPgraficas.setLayout(jPgraficasLayout);
        jPgraficasLayout.setHorizontalGroup(
            jPgraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        jPgraficasLayout.setVerticalGroup(
            jPgraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jTAresultados.setColumns(20);
        jTAresultados.setRows(5);
        jScrollPane1.setViewportView(jTAresultados);

        jLabel2.setText("ESCENARIOS DEL ASCENSOR");

        jCBescenario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escenario 1", "Escenario 2", "Escenario 3", "Escenario 4" }));
        jCBescenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBescenarioActionPerformed(evt);
            }
        });

        jLabel3.setText("DETALLES DEL ESCENARIO");

        jTFcapacidad.setEditable(false);
        jTFcapacidad.setText("4");

        jTFtiempoarranque.setEditable(false);
        jTFtiempoarranque.setText("20");

        jTFdesplentrepisos.setEditable(false);
        jTFdesplentrepisos.setText("100");

        jLabel4.setText("TIEMPO DE SIMULACION");

        jTFtiemposimulacion.setText("10000");

        jLabel5.setText("Capacidad");

        jLabel6.setText("Tiempo de Arranque");

        jLabel7.setText("Desplazamiento entre dos pisos");

        jBiniciarsimulacion.setText("Iniciar Simulacion");
        jBiniciarsimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBiniciarsimulacionActionPerformed(evt);
            }
        });

        jLabel8.setText("CONSOLA DE LISTA DE EVENTOS FUTUROS (LEF)");

        jLabel9.setText("PISO DE INICIO DEL ASCENSOR");

        jCBpisoascensor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPgraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jBiniciarsimulacion)
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCBpisoascensor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTFtiemposimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jCBescenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFdesplentrepisos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFtiempoarranque, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPgraficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCBescenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFtiemposimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jCBpisoascensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTFcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTFtiempoarranque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTFdesplentrepisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jBiniciarsimulacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBiniciarsimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBiniciarsimulacionActionPerformed
        // TODO add your handling code here:
        int tiempoSimulacion = Integer.parseInt(jTFtiemposimulacion.getText());

        LEF.iniciarSimulacion(jCBescenario.getSelectedItem().toString(), Integer.parseInt(jCBpisoascensor.getSelectedItem().toString()), tiempoSimulacion);

    }//GEN-LAST:event_jBiniciarsimulacionActionPerformed

    private static ArrayList<ArrayList> ordenarLefMergeSort(ArrayList<ArrayList> lef) {
        // Caso base. Un arreglo de cero o un elemento ya esta ordenado,
        // asi que lo regresamos.
        if (lef.size() <= 1) {
            return lef;
        }
        int puntoMedio = lef.size() / 2;
        // Creamos subarreglo izquierdo
        ArrayList<ArrayList> izquierdo = new ArrayList<ArrayList>();
        
        for (int i = 0; i < puntoMedio; i++) {
            izquierdo.add(lef.get(i));
        }
        // Creamos el subarreglo derecho
        ArrayList<ArrayList> derecho = new ArrayList<ArrayList>();
        
        for (int i = 0; i < lef.size() - puntoMedio; i++) {
            derecho.add(lef.get(puntoMedio + i));
        }
        // Ordenamos las dos mitades recursivamente
        ArrayList<ArrayList> izquierdoOrdenado = ordenarLefMergeSort(izquierdo);
        ArrayList<ArrayList> derechoOrdenado = ordenarLefMergeSort(derecho);
        //Mezclamos la solucion---
        // El indice i es para recorrer el subarreglo izquierdo
        int i = 0;
        // El indice j es para recorrer el subarreglo derecho
        int j = 0;
        // En 'resultado' guardamos el resultado de la mezcla de los dos
        // subarreglos
        ArrayList<ArrayList> resultado = new ArrayList<ArrayList>();
        /**
         * Terminamos de mezclar cuando i + j ya recorrieron todos los elementos
         * de los dos subarreglos
         */
        while (i + j < izquierdoOrdenado.size() + derechoOrdenado.size()) {
            // a) Si i ya llego al ultimo elemento del subarreglo izquierdo
            // copiamos el valor del siguiente elemento del subarreglo
            // derecho e incrementamos el indice j para, en el siguiente,
            // ciclo copiar el elemento de subarreglo derecho que sigue
            if (i == izquierdoOrdenado.size()) {
                //resultado
                resultado.add(i + j, derechoOrdenado.get(j));
                j++;
                continue;
            }
            // Lo mismo que a) pero para el subarreglo derecho
            if (j == derechoOrdenado.size()) {
                resultado.add(i + j, izquierdoOrdenado.get(i));
                // resultado[i + j] = izquierdoOrdenado[i];
                i++;
                continue;
            }
            double elementoIzquierdo = (int) izquierdoOrdenado.get(i).get(1);
            double elementoDerecho = (int) derechoOrdenado.get(j).get(1);
            // Comparamos cual de los elementos que siguen es menor y ese
            // lo copiamos en resultado
            if (elementoIzquierdo <= elementoDerecho) {
                resultado.add(i + j, izquierdoOrdenado.get(i));
                //resultado[i + j] = elementoIzquierdo;
                i++;
            } else {
                resultado.add(i + j, derechoOrdenado.get(j));
                j++;
            }
        }
        return resultado;
    }
    
    private void jCBescenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBescenarioActionPerformed
        // TODO add your handling code here:
        modificarParamtrosEscenario();
    }//GEN-LAST:event_jCBescenarioActionPerformed

    public void modificarParamtrosEscenario() {
        if (jCBescenario.getSelectedItem().equals("Escenario 1")) {
            jTFcapacidad.setText(4 + "");
            jTFtiempoarranque.setText(20 + "");
            jTFdesplentrepisos.setText(100 + "");
        } else if (jCBescenario.getSelectedItem().equals("Escenario 2")) {
            jTFcapacidad.setText(6 + "");
            jTFtiempoarranque.setText(20 + "");
            jTFdesplentrepisos.setText(100 + "");
        } else if (jCBescenario.getSelectedItem().equals("Escenario 3")) {
            jTFcapacidad.setText(4 + "");
            jTFtiempoarranque.setText(5 + "");
            jTFdesplentrepisos.setText(30 + "");
        } else {
            jTFcapacidad.setText(6 + "");
            jTFtiempoarranque.setText(5 + "");
            jTFdesplentrepisos.setText(30 + "");
        }
    }

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
            java.util.logging.Logger.getLogger(GuiAscensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiAscensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiAscensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiAscensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiAscensor().setVisible(true);
            }
        });
        
        ArrayList<ArrayList> LEFPrueba = new ArrayList<ArrayList>();
        ArrayList persona1 = new ArrayList<>();
        ArrayList persona2 = new ArrayList<>();
        
        persona1.add("LlegadaPersona");
        persona2.add("LlegadaPersona");
        
        persona1.add(25);
        persona2.add(12);
        
        LEFPrueba.add(persona1);
        LEFPrueba.add(persona2);
        
        for(int i = 0 ; i < LEFPrueba.size() ; i++){
            System.out.println("Elemento: " + i + " Desordenado: " + LEFPrueba.get(i));
        }
        
        LEFPrueba = ordenarLefMergeSort(LEFPrueba);
        
        for(int i = 0 ; i < LEFPrueba.size() ; i++){
            System.out.println("Elemento: " + i + " Ordenado: " + LEFPrueba.get(i));
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBiniciarsimulacion;
    private javax.swing.JComboBox jCBescenario;
    private javax.swing.JComboBox jCBpisoascensor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPgraficas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAresultados;
    private javax.swing.JTextField jTFcapacidad;
    private javax.swing.JTextField jTFdesplentrepisos;
    private javax.swing.JTextField jTFtiempoarranque;
    private javax.swing.JTextField jTFtiemposimulacion;
    // End of variables declaration//GEN-END:variables
}
