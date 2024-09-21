/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ModeloConexion.Conexion;
import Utils.AtomicId;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author jason
 */
public class DaoDocente {
    private Conexion conex = Conexion.getInstance();
    
    private Firestore db = conex.getDb();
    
    public List<Docente> getDocentes(){
        ApiFuture<QuerySnapshot> future = db.collection("Docentes").get();
        
        List<Docente> docentes = new ArrayList<>();
        
        try{
            
            
            List<QueryDocumentSnapshot> document = future.get().getDocuments();
            
            for(QueryDocumentSnapshot d : document){
                docentes.add(new Docente(d.getLong("id"), 
                        d.getLong("id_depto"),
                        d.getString("nombre"),
                        d.getString("apellido"),
                        d.getString("cedula")));
            }
            AtomicId id = new AtomicId(Long.parseLong(String.valueOf(docentes.size())));
            
            return docentes;
        } catch (InterruptedException | ExecutionException ex){
            System.out.println("Error al obtener los docentes: "
            + ex.getMessage());
        }
        return docentes;
    }
    
    public String saveDocente(Docente docente) throws InterruptedException, ExecutionException{
        Long id = AtomicId.IdUnicoGenerado();
        
        docente.setId(id);
        
        DocumentReference docRef = db.collection("Docentes")
                .document(String.valueOf(id));
        ApiFuture<WriteResult> result = docRef.set(docente);
        
        return "Docente agregado Correctamente: " + 
                result.get().getUpdateTime().toString();
    }
}
