/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloConexion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author jason
 */
public class Conexion {
    public static Conexion instance = null;
    private Firestore db;
    private GoogleCredentials credentials;

    private Conexion() {
        conectarDB();
    }
    
    public static synchronized Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }
    
    private void conectarDB() {
        FileInputStream serviceAccount = null;
        try {
            File file = new File("path/to/credentials");
            if (!file.exists()) {
                System.out.println("El archivo no existe");
                return;
            }
            serviceAccount = new FileInputStream(file);

            if (FirebaseApp.getApps().isEmpty()) {
                credentials = GoogleCredentials.fromStream(serviceAccount);
                @SuppressWarnings("deprecation")
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(credentials)
                        .setDatabaseUrl("Url_database")
                        .build();

                FirebaseApp.initializeApp(options);
            }

            db = FirestoreOptions.getDefaultInstance().toBuilder()
                    .setCredentials(credentials).build().getService();
            
        } catch (IOException e) {
            System.out.println("las credenciales fallaron: "+ e.getMessage());
        } finally {
            if (serviceAccount != null) {
                try {
                    serviceAccount.close();
                } catch (IOException e) {
                    System.out.println("El servicio no se pudo iniciar");
                }
            }
        }
    }
    
    public Firestore getDb() {
        if (db == null) {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return db;
    }
}
