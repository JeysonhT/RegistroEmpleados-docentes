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
    private static AtomicLong idCounter = new AtomicLong(0);
    
    public static Long IdUnicoGenerado(){
        return idCounter.incrementAndGet();
    }
}
