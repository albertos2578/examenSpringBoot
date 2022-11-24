/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginfxml;

import models.Alumno;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class SessionData {
    
    private static Alumno alumno;

    public static Alumno getAlumno() {
        return alumno;
    }

    public static void setAlumno(Alumno alumno) {
        SessionData.alumno = alumno;
    }


    
}
