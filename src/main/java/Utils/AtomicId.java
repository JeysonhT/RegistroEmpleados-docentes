/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author jason
 */
public class AtomicId {
    
    public AtomicId(Long _id){
        AtomicId.idCounter = new AtomicLong(_id);
    }
    private static AtomicLong idCounter ;
    
    public static Long IdUnicoGenerado(){
        return idCounter.incrementAndGet();
    }
}
