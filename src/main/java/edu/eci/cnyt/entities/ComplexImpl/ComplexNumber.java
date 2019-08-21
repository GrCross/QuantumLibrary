/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.entities.ComplexImpl;

import java.util.Objects;

import edu.eci.cnyt.entities.Complex;
import edu.eci.cnyt.entities.*;

/**
 *
 * @author daniel
 */
public class ComplexNumber implements Complex{

    private double realP;
    private double imagiP;
    private Polar polar;

    public ComplexNumber(double realP,double imagiP){
        this.realP = realP;
        this.imagiP = imagiP;
        this.polar = polar();
    }

    public ComplexNumber(){

    }

    public double phase(){
        return polar.getAngle();
    }
    public double module(){
        double module = Math.sqrt(Math.pow(realP, 2)+Math.pow(imagiP, 2));
        return module;
    }

    public Complex conjugate(){
        ComplexNumber conjugate = new ComplexNumber(realP, imagiP * -1);
        return conjugate;
    }    

    public double getRealP() {
        return this.realP;
    }

    public void setRealP(double realP) {
        this.realP = realP;
    }

    public double getImagiP() {
        return this.imagiP;
    }

    public void setImagiP(double imagiP) {
        this.imagiP = imagiP;
    }

    public Polar getPolar() {
        if(polar == null)this.polar = polar();
        return this.polar;
    }

    public void setPolar(Polar polar) {
        this.polar = polar;
    }


    public Polar polar(){
        double module = this.module(); 
        double angle = Math.atan(imagiP/realP);
        
        Polar polar = new Polar(angle, module);
        return polar;
    }


    @Override
    public String toString() {
        return "{" +
            " realP='" + getRealP() + "'" +
            ", imagiP='" + getImagiP() + "'" +
            ", polar='" + getPolar().toString() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
         
        if (o == this)
            return true;
        if (!(o instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber ComplexNumber = (ComplexNumber) o;
        return realP == ComplexNumber.realP && imagiP == ComplexNumber.imagiP && Objects.equals(this.getPolar(), ComplexNumber.getPolar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(realP, imagiP, polar);
    }

   

    
}
