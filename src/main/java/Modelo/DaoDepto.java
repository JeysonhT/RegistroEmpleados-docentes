/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ModeloConexion.Conexion;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author jason
 */
public class DaoDepto {
    private Conexion conex = Conexion.getInstance();
    
    private Firestore db = conex.getDb();
    
    public List<Depto> getDepto(){
        ApiFuture<QuerySnapshot> future = db.collection("Departamento").get();
        
        List<Depto> departamentos = new ArrayList<>();
        
        try{
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            
            for(QueryDocumentSnapshot d : documents){
                departamentos.add(d.toObject(Depto.class));
            }
            
            return departamentos;
        } catch(InterruptedException | ExecutionException e){
            System.out.println("Error al obtener los departamentos: " + 
                    e.getMessage());
        }
        
        return departamentos;
    }
}
